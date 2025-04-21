/*
 * @Author: 朽木白
 * @Date: 2023-03-03 16:41:20
 * @Description: 重置用户信息
 */
import { useUserStore } from '@/store/modules/user'

export function RESEETSTORE() {
  const userStore = useUserStore()
  userStore.$reset()
  // 清除用户信息缓存
  localStorage.removeItem('app-user')
}
