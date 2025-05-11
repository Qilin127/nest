<template>
  <el-card>
    <ProTable
      ref="proTable"
      :dataCallback="dataCallback"
      :columns="columns"
      :requestApi="getAgreementInfoList"
      :initParam="initParam"
      :stripe="true"
    >
      <template #tableHeader>
        <el-button type="primary" icon="Plus" @click="addHandle">
          Add Lease
        </el-button>
      </template>
      <template #operation="scope">
        <el-button type="success" icon="Edit" @click="editHandle(scope.row)">
          Change
        </el-button>
        <el-button type="danger" icon="Delete" @click="deleteHandle(scope.row)">
          Delete
        </el-button>
        <el-button
          type="warning"
          icon="Warning"
          v-if="scope.row.status === AgreementStatus.RENEW_TO_BE_CONFIRMED"
          @click="confirmLeaseHandle(scope.row)"
        >
          Confirm Renewal
        </el-button>
        <el-button
          type="warning"
          icon="Warning"
          v-if="scope.row.status === AgreementStatus.WAITING"
          @click="cancelLeaseHandle(scope.row)"
        >
          Cancel Lease
        </el-button>
        <el-button
          type="danger"
          icon="Warning"
          v-if="scope.row.status === AgreementStatus.TO_BE_CONFIRMED"
          @click="confirmThrowLeaseHandle(scope.row)"
        >
          Confirm Lease Termination
        </el-button>
      </template>
    </ProTable>
  </el-card>
</template>

<script setup lang="tsx">
import { onMounted, reactive, ref } from 'vue'
import { ColumnProps } from '@/components/ProTable/src/types'
import ProTable from '@/components/ProTable/src/ProTable.vue'
import { useRouter } from 'vue-router'
import { useHandleData } from '@/hooks/useHandleData'
import {
  getApartmentListByDistrictId,
  getCityList,
  getDistrictList,
  getProvinceList,
} from '@/api/apartmentManagement'
import {
  ApartmentInterface,
  RegionInterface,
} from '@/api/apartmentManagement/types'
import {
  AgreementSourceMap,
  AgreementStatus,
  AgreementStatusMap,
  getLabelByValue,
} from '@/enums/constEnums'
import {
  deleteAgreementInfoById,
  getAgreementInfoList,
  updateAgreementStatusById,
} from '@/api/rentManagement'
import { AgreementInfoInterface } from '@/api/rentManagement/types'
const router = useRouter()

const proTable = ref<InstanceType<typeof ProTable>>()
const areaInfo = reactive({
  provinceList: [] as RegionInterface[],
  provinceId: '',
  cityList: [] as RegionInterface[],
  cityId: '',
  districtList: [] as RegionInterface[],
  districtId: '',
  apartmentList: [] as ApartmentInterface[],
  apartmentId: '',
})

const columns: ColumnProps[] = [
  {
    prop: 'name',
    label: 'Name',
    search: { el: 'input', props: { placeholder: 'Please type in Name' } },
  },
  {
    prop: 'phone',
    label: 'Phone Number',
    search: { el: 'input', props: { placeholder: 'Please type in Phone Number' } },
  },
  {
    prop: 'roomNumber',
    label: 'room',
    search: { el: 'input', props: { placeholder: 'Please choose Room' } },
    render: ({ row }: { row: AgreementInfoInterface }) => {
      return row.roomInfo.roomNumber
    },
  },
  {
    prop: 'provinceId',
    label: 'Province',
    isShow: false,
    fieldNames: { label: 'name', value: 'id' },
    search: {
      el: 'select',
      render: () => {
        return (
          <el-select
            v-model={areaInfo.provinceId}
            placeholder="Please choose Province"
            clearable
            key="provinceId"
            onChange={provinceChangeCallback}
            onClear={provinceClearCallback}
          >
            {areaInfo.provinceList.map((item) => (
              <el-option
                key={item.id}
                label={item.name}
                value={item.id}
              ></el-option>
            ))}
          </el-select>
        )
      },
    },
  },
  {
    prop: 'cityId',
    label: 'City',
    isShow: false,
    fieldNames: { label: 'name', value: 'id' },
    search: {
      el: 'select',
      key: 'cityId',
      render: () => {
        return (
          <el-select
            v-model={areaInfo.cityId}
            placeholder="Please choose City"
            clearable
            key="cityId"
            onChange={cityChangeCallback}
            onClear={cityClearCallback}
          >
            {areaInfo.cityList.map((item) => (
              <el-option
                key={item.id}
                label={item.name}
                value={item.id}
              ></el-option>
            ))}
          </el-select>
        )
      },
    },
  },
  {
    prop: 'districtId',
    label: 'Districe',
    isShow: false,
    fieldNames: { label: 'name', value: 'id' },
    search: {
      el: 'select',
      key: 'districtId',
      render: () => {
        return (
          <el-select
            v-model={areaInfo.districtId}
            placeholder="Please Choose District"
            clearable
            onChange={districtChangeCallback}
            onClear={districtClearCallback}
          >
            {areaInfo.districtList.map((item) => (
              <el-option
                key={item.id}
                label={item.name}
                value={item.id}
              ></el-option>
            ))}
          </el-select>
        )
      },
    },
  },
  {
    prop: 'apartmentId',
    label: 'Apartment',
    isShow: false,
    fieldNames: { label: 'name', value: 'id' },
    search: {
      el: 'select',
      key: 'apartmentId',
      render: () => {
        return (
          <el-select
            v-model={areaInfo.apartmentId}
            placeholder="Please choose Apartment"
            clearable
            onChange={apartmentChangeCallback}
            onClear={apartmentClearCallback}
          >
            {areaInfo.apartmentList.map((item) => (
              <el-option
                key={item.id}
                label={item.name}
                value={item.id}
              ></el-option>
            ))}
          </el-select>
        )
      },
    },
  },
  { prop: 'apartmentInfo.name', label: 'Sign Apartment Lease' },
  { prop: 'apartmentInfo.provinceName', label: 'Province' },
  { prop: 'apartmentInfo.cityName', label: 'City' },
  { prop: 'apartmentInfo.districtName', label: 'District' },
  {
    prop: 'leaseStartDate',
    label: 'Lease Term',
    width: 200,
    render: ({ row }: { row: AgreementInfoInterface }) => {
      return row.leaseStartDate + ' ～ ' + row.leaseEndDate
    },
  },
  { prop: 'rent', label: 'Rent (AUD/Month)' },
  { prop: 'deposit', label: 'Deposit (AUD)' },
  {
    prop: 'paymentType.name',
    label: 'Paymeny Method',
  },
  { prop: 'leaseTerm.monthCount', label: 'Lease Duration (Months)' },
  {
    prop: 'sourceType',
    label: 'Lease Source',
    render: ({ row }: { row: AgreementInfoInterface }) => {
      return getLabelByValue(AgreementSourceMap, row.sourceType)
    },
  },
  {
    prop: 'status',
    label: 'Lease Status',
    render: ({ row }: { row: AgreementInfoInterface }) => {
      switch (row.status) {
        case AgreementStatus.WAITING:
          return (
            <el-tag type="warning">
              {getLabelByValue(AgreementStatusMap, row.status)}
            </el-tag>
          )
        case AgreementStatus.RENEW_TO_BE_CONFIRMED:
          return (
            <el-tag type="warning">
              {getLabelByValue(AgreementStatusMap, row.status)}
            </el-tag>
          )
        case AgreementStatus.SIGNED:
          return (
            <el-tag type="success">
              {getLabelByValue(AgreementStatusMap, row.status)}
            </el-tag>
          )
        case AgreementStatus.TO_BE_CONFIRMED:
          return (
            <el-tag type="danger">
              {getLabelByValue(AgreementStatusMap, row.status)}
            </el-tag>
          )
        default:
          return (
            <el-tag type="info">
              {getLabelByValue(AgreementStatusMap, row.status)}
            </el-tag>
          )
      }
    },
  },
  { prop: 'operation', label: 'operation', fixed: 'right', width: 320 },
]


const initParam = reactive({})

//#region <Province, City, and District Query>
async function getProvinceListHandle() {
  try {
    const { data } = await getProvinceList()
    areaInfo.provinceList = data
    proTable.value?.enumMap.set('provinceId', areaInfo.provinceList)
  } catch (error) {
    console.log(error)
  }
}

async function getCityListHandle(provinceId: number) {
  try {
    const { data } = await getCityList(provinceId)
    areaInfo.cityList = data
    proTable.value?.enumMap.set('cityId', areaInfo.cityList)
  } catch (error) {
    console.log(error)
  }
}

async function getDistrictListHandle(cityId: number) {
  try {
    const { data } = await getDistrictList(cityId)
    areaInfo.districtList = data
    proTable.value?.enumMap.set('districtId', areaInfo.districtList)
  } catch (error) {
    console.log(error)
  }
}

async function getApartmentListHandle(districtId: number) {
  try {
    const { data } = await getApartmentListByDistrictId(districtId)
    areaInfo.apartmentList = data
    proTable.value?.enumMap.set('apartmentId', areaInfo.apartmentList)
  } catch (error) {
    console.log(error)
  }
}

function resetCity() {
  areaInfo.cityId = ''
  areaInfo.cityList = []
  proTable.value?.enumMap.set('cityId', [])
  proTable.value!.searchParam.cityId = ''
}

function resetDistrict() {
  areaInfo.districtId = ''
  areaInfo.districtList = []
  proTable.value?.enumMap.set('districtId', [])
  proTable.value!.searchParam.districtId = ''
}

function resetApartment() {
  areaInfo.apartmentId = ''
  areaInfo.apartmentList = []
  proTable.value?.enumMap.set('apartmentId', [])
  proTable.value!.searchParam.apartmentId = ''
}

const provinceChangeCallback = async () => {
  let provinceId = proTable.value!.searchParam.provinceId
  if (provinceId) {
    resetCity()
    resetDistrict()
    resetApartment()
    await getCityListHandle(provinceId)
  }
}

const provinceClearCallback = () => {
  areaInfo.provinceId = ''
  proTable.value!.searchParam.provinceId = ''
  resetCity()
  resetDistrict()
  resetApartment()
}

const cityChangeCallback = async () => {
  let cityId = proTable.value!.searchParam.cityId
  if (cityId) {
    resetDistrict()
    resetApartment()
    await getDistrictListHandle(cityId)
  }
}

const cityClearCallback = () => {
  console.log('Clear City')
  areaInfo.cityId = ''
  proTable.value!.searchParam.cityId = ''
  resetDistrict()
  resetApartment()
}

const districtChangeCallback = async () => {
  let districtId = proTable.value!.searchParam.districtId
  if (districtId) {
    resetApartment()
    await getApartmentListHandle(districtId)
  }
}

const districtClearCallback = () => {
  console.log('Clear Distirct')
  areaInfo.districtId = ''
  proTable.value!.searchParam.districtId = ''
  resetApartment()
}

const apartmentChangeCallback = async () => {
  console.log('Change Apartment')
}

const apartmentClearCallback = () => {
  console.log('Clear Apartment')
  areaInfo.apartmentId = ''
  proTable.value!.searchParam.apartmentId = ''
}
//#endregion

const dataCallback = (data: any) => {
  return {
    list: data?.records,
    total: data?.total,
  }
}

const editHandle = (row: AgreementInfoInterface) => {
  router.push({
    path: '/rentManagement/agreement/addOrEditAgreement',
    query: {
      id: row.id,
    },
  })
}

const addHandle = () => {
  router.push({
    path: '/rentManagement/agreement/addOrEditAgreement',
  })
}

const deleteHandle = async (row: AgreementInfoInterface) => {
  await useHandleData(
    deleteAgreementInfoById,
    row.id,
    `delete${row.name + row.apartmentInfo.name + row.roomInfo.roomNumber}room`,
  )

  proTable.value?.getTableList()
}

const cancelLeaseHandle = async (row: AgreementInfoInterface) => {
  await useHandleData(
    updateAgreementStatusById,
    { id: row.id, status: AgreementStatus.CANCELLED },
    `Cancel Lease`,
  )
  proTable.value?.getTableList()
}

const confirmLeaseHandle = async (row: AgreementInfoInterface) => {
  await useHandleData(
    updateAgreementStatusById,
    { id: row.id, status: AgreementStatus.SIGNED },
    `Confirm Renewal`,
  )
  proTable.value?.getTableList()
}

const confirmThrowLeaseHandle = async (row: AgreementInfoInterface) => {
  await useHandleData(
    updateAgreementStatusById,
    { id: row.id, status: AgreementStatus.CONFIRMED },
    `Confirm Lease Termination`,
  )
  proTable.value?.getTableList()
}

onMounted(() => {
  getProvinceListHandle()
})
</script>
