<template>
  <el-card>
    <template #header>
      <div class="card-header">
        <span>{{ formData.id ? 'Modify' : 'Add' }}Lease</span>
      </div>
    </template>
    <el-form
      ref="apartmentFormRef"
      :model="formData"
      :rules="rules"
      label-width="120px"
      style="max-width: 1000px"
      status-icon
    >
      <el-form-item label="Name" prop="name">
        <el-input v-model.trim="formData.name" placeholder="Please type in Name" />
      </el-form-item>
      <el-form-item label="Phone Number" prop="phone">
        <el-input v-model.trim="formData.phone" placeholder="Please type in Phone Number" />
      </el-form-item>
      <el-form-item label="Id" prop="identificationNumber">
        <el-input
          v-model.trim="formData.identificationNumber"
          placeholder="Please type in ID"
        />
      </el-form-item>
      <el-form-item label="room" required>
        <div class="flex-center">
          <el-form-item prop="provinceId">
            <el-select
              v-model="areaInfo.provinceId"
              placeholder="Please choose Province"
              clearable
              @change="provinceChangeCallback"
              @clear="provinceClearCallback"
            >
              <el-option
                v-for="item in areaInfo.provinceList"
                :key="item.id"
                :label="item.name"
                :value="item.id"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item prop="cityId">
            <el-select
              v-model="areaInfo.cityId"
              placeholder="Please choose City"
              clearable
              @change="cityChangeCallback"
              @clear="cityClearCallback"
            >
              <el-option
                v-for="item in areaInfo.cityList"
                :key="item.id"
                :label="item.name"
                :value="item.id"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item prop="districtId">
            <el-select
              v-model="areaInfo.districtId"
              placeholder="Please choose district"
              clearable
              @change="districtChangeCallback"
              @clear="districtClearCallback"
            >
              <el-option
                v-for="item in areaInfo.districtList"
                :key="item.id"
                :label="item.name"
                :value="item.id"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item prop="apartmentId">
            <el-select
              v-model="areaInfo.apartmentId"
              placeholder="Please choose Apartment"
              clearable
              filterable
              @change="apartmentChangeCallback"
              @clear="apartmentClearCallback"
            >
              <el-option
                v-for="item in areaInfo.apartmentList"
                :key="item.id"
                :label="item.name"
                :value="item.id"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item prop="roomId">
            <el-select
              v-model="areaInfo.roomId"
              placeholder="Please choose Room"
              clearable
              filterable
              @change="roomChangeCallback"
              @clear="roomClearCallback"
            >
              <el-option
                v-for="item in areaInfo.roomList"
                :key="item.id"
                :label="item.roomNumber"
                :value="item.id"
              ></el-option>
            </el-select>
          </el-form-item>
        </div>
      </el-form-item>

      <el-form-item label="Start time" prop="leaseStartDate">
        <el-date-picker
          v-model="formData.leaseStartDate"
          type="date"
          format="YYYY-MM-DD"
          value-format="YYYY-MM-DD"
          placeholder="Start time"
          clearable
        />
      </el-form-item>
      <el-form-item label="End time" prop="leaseEndDate">
        <el-date-picker
          v-model="formData.leaseEndDate"
          type="date"
          format="YYYY-MM-DD"
          value-format="YYYY-MM-DD"
          placeholder="End time"
          clearable
        />
      </el-form-item>
      <el-form-item label="Payment Method" prop="paymentTypeIds">
        <el-select
          style="width: 100%"
          v-model="formData.paymentTypeId"
          placeholder="Please choose Payment Method"
          clearable
        >
          <el-option
            v-for="item in paymentInfoList"
            :key="item.id"
            :label="`${item.name} (${item.additionalInfo})`"
            :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="Optional Lease Term" prop="leaseTermIds">
        <el-select
          style="width: 100%"
          v-model="formData.leaseTermId"
          placeholder="Please choose Optional Lease Term"
          clearable
        >
          <el-option
            v-for="item in leaseTermInfoList"
            :key="item.id"
            :label="`${item.monthCount}${item.unit}`"
            :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="Rent (AUD/Month)" prop="rent">
        <el-input-number v-model="formData.rent" :step="1" step-strictly />
      </el-form-item>
      <el-form-item label="Deposit (AUD)" prop="deposit">
        <el-input-number v-model="formData.deposit" :step="1" step-strictly />
      </el-form-item>
      <el-form-item label="Remarks" prop="additionalInfo">
        <el-input
          v-model.trim="formData.additionalInfo"
          type="textarea"
          placeholder="Please type in Remarks"
        />
      </el-form-item>
    </el-form>
    <div class="flex-center m-t-20">
      <el-button style="width: 150px" type="info" @click="router.back()">
        Cancel
      </el-button>
      <el-button style="width: 150px" type="primary" @click="submitHandle">
        {{ formData.id ? 'Save' : 'New' }}
      </el-button>
    </div>
  </el-card>
</template>
<script setup lang="ts">
import { onMounted, reactive, ref, watch } from 'vue'
import { ElMessage, FormInstance } from 'element-plus'
import {
  ApartmentInterface,
  PaymentInfoInterface,
  RegionInterface,
  TermInfoInterface,
} from '@/api/apartmentManagement/types'
import {
  getApartmentListByDistrictId,
  getCityList,
  getDistrictList,
  getPaymentList,
  getProvinceList,
  getTermList,
} from '@/api/apartmentManagement'
import { useRoute, useRouter } from 'vue-router'
import { AgreementSource, AgreementStatus } from '@/enums/constEnums'
import {
  AgreementInterface,
  RoomInfoInterface,
} from '@/api/rentManagement/types'
import {
  getAgreementInfoById,
  getRoomListByApartmentId,
  saveOrUpdateAgreementInfo,
} from '@/api/rentManagement'
const route = useRoute()
const router = useRouter()
//#region
// data
const apartmentFormRef = ref<FormInstance>()
const formData = ref<AgreementInterface>({
  id: '',
  name: '',
  phone: '',
  identificationNumber: '',
  apartmentId: '',
  roomId: '',
  leaseStartDate: '',
  leaseEndDate: '',
  leaseTermId: '',
  rent: 0,
  deposit: 0,
  paymentTypeId: '',
  status: AgreementStatus.WAITING,
  sourceType: AgreementSource.NEW,
  additionalInfo: '',
})
// checking rule
const rules = reactive({
  roomNumber: [{ required: true, message: 'Please type in Room Number', trigger: 'blur' }],
})
//#endregion
//#region
const areaInfo = reactive({
  provinceList: [] as RegionInterface[],
  provinceId: '',
  cityList: [] as RegionInterface[],
  cityId: '',
  districtList: [] as RegionInterface[],
  districtId: '',
  apartmentList: [] as ApartmentInterface[],
  apartmentId: '',
  roomList: [] as RoomInfoInterface[],
  roomId: '',
})
// check region information change
watch(
  () => areaInfo,
  (newVal) => {
    formData.value.apartmentId = newVal.apartmentId
    formData.value.roomId = newVal.roomId
  },
  { immediate: true, deep: true },
)
// get state
async function getProvinceListHandle() {
  try {
    const { data } = await getProvinceList()
    areaInfo.provinceList = data
  } catch (error) {
    console.log(error)
  }
}
// get city
async function getCityListHandle(
  provinceId: number | string = areaInfo.provinceId,
) {
  try {
    const { data } = await getCityList(provinceId)
    areaInfo.cityList = data
  } catch (error) {
    console.log(error)
  }
}
// get district
async function getDistrictListHandle(
  cityId: number | string = areaInfo.cityId,
) {
  try {
    const { data } = await getDistrictList(cityId)
    areaInfo.districtList = data
  } catch (error) {
    console.log(error)
  }
}
// get apartment
async function getApartmentListHandle(
  districtId: number | string = areaInfo.districtId,
) {
  try {
    const { data } = await getApartmentListByDistrictId(districtId)
    areaInfo.apartmentList = data
  } catch (error) {
    console.log(error)
  }
}
// get room
async function getRoomListHandle(
  apartmentId: number | string = areaInfo.apartmentId,
) {
  try {
    const { data } = await getRoomListByApartmentId(apartmentId)
    areaInfo.roomList = data
  } catch (error) {
    console.log(error)
  }
}
// reset city data
function resetCity() {
  areaInfo.cityId = ''
  areaInfo.cityList = []
}
// reset district data
function resetDistrict() {
  areaInfo.districtId = ''
  areaInfo.districtList = []
}
// reset apartment data
function resetApartment() {
  areaInfo.apartmentId = ''
  areaInfo.apartmentList = []
}
// reset room data
function resetRoom() {
  areaInfo.roomId = ''
  areaInfo.roomList = []
}
// Province Change Callback
const provinceChangeCallback = async () => {
  let provinceId = areaInfo.provinceId
  if (provinceId) {
    resetCity()
    resetDistrict()
    resetApartment()
    resetRoom()
    await getCityListHandle(provinceId)
  }
}
// Province Cancel Callback
const provinceClearCallback = () => {
  areaInfo.provinceId = ''
  resetCity()
  resetDistrict()
  resetApartment()
  resetRoom()
}
// City Change Callback
const cityChangeCallback = async () => {
  let cityId = areaInfo.cityId
  if (cityId) {
    resetDistrict()
    resetApartment()
    resetRoom()
    await getDistrictListHandle(cityId)
  }
}
// City Cancel Callback
const cityClearCallback = () => {
  console.log('Clear City')
  areaInfo.cityId = ''
  resetDistrict()
  resetApartment()
  resetRoom()
}
// District Change Callback
const districtChangeCallback = async () => {
  let districtId = areaInfo.districtId
  if (districtId) {
    resetApartment()
    resetRoom()
    await getApartmentListHandle(districtId)
  }
}
// District Cancel Callback
const districtClearCallback = () => {
  console.log('Clear District')
  areaInfo.districtId = ''
  resetApartment()
  resetRoom()
}
// Apartment Change Callback
const apartmentChangeCallback = async () => {
  console.log('Change Apartment')
  let apartmentId = areaInfo.apartmentId
  if (apartmentId) {
    resetRoom()
    await getRoomListHandle(apartmentId)
  }
}
// Apartment Cancel Callback
const apartmentClearCallback = () => {
  console.log('Clear Apartment')
  areaInfo.apartmentId = ''
  resetRoom()
}
// Room Change Callback
const roomChangeCallback = async () => {
  console.log('Change Room')
}
// Room Cancel Callback
const roomClearCallback = () => {
  console.log('Clear Room')
  areaInfo.roomId = ''
}
//#endregion
//#region <payment info、lease term info >
const paymentInfoList = ref<PaymentInfoInterface[]>([])
const leaseTermInfoList = ref<TermInfoInterface[]>([])

async function getPaymentInfoListHandle() {
  try {
    const { data } = await getPaymentList()
    paymentInfoList.value = data
  } catch (error) {
    console.log(error)
  }
}

async function getLeaseTermInfoListHandle() {
  try {
    const { data } = await getTermList()
    leaseTermInfoList.value = data
  } catch (error) {
    console.log(error)
  }
}

//#endregion

// get room number info by id
async function getAgreementInfoByIdHandle(id: number | string) {
  try {
    const { data } = await getAgreementInfoById(id)
    formData.value = data
    areaInfo.provinceId = data.apartmentInfo.provinceId as string
    areaInfo.cityId = data.apartmentInfo.cityId as string
    areaInfo.districtId = data.apartmentInfo.districtId as string
    areaInfo.apartmentId = data.apartmentId as string
    areaInfo.roomId = data.roomId as string
    data.apartmentInfo.provinceId &&
      (await getCityListHandle(data.apartmentInfo.provinceId))
    data.apartmentInfo.cityId &&
      (await getDistrictListHandle(data.apartmentInfo.cityId))
    data.apartmentInfo.districtId &&
      (await getApartmentListHandle(data.apartmentInfo.districtId))
    data.apartmentId && (await getRoomListHandle(data.apartmentId))
  } catch (error) {
    console.log(error)
  }
}
async function addOrUpdateAgreementInfoHandle() {
  try {
    await saveOrUpdateAgreementInfo(formData.value)
    ElMessage.success('Successful')
    router.back()
  } catch (error) {
    console.log(error)
  }
}

function submitHandle() {
  apartmentFormRef.value?.validate(async (valid) => {
    if (valid) {
      await addOrUpdateAgreementInfoHandle()
    } else {
      ElMessage.error('Form contains errors, please check.')
      return false
    }
  })
}
onMounted(() => {
  getProvinceListHandle()
  getPaymentInfoListHandle()
  getLeaseTermInfoListHandle()
  if (route.query?.id) {
    getAgreementInfoByIdHandle(route.query.id as string)
  }
})
</script>

<style scoped lang="scss">
.card-header {
  font-size: 18px;
  font-weight: bold;
}
</style>
