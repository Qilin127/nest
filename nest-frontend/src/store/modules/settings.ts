/*
 * @Author: 朽木白
 * @Date: 2023-02-24 11:28:38
 * @Description: 系统设置
 */

import { defineStore } from 'pinia'
import { DEFAULT_PRIMARY } from '@/config/config'
import type { SettingsState, ThemeConfigProps } from './model/settingsModel'
export const useSettingsStore = defineStore({
  id: 'app-settings',
  state: (): SettingsState => ({
    collapse: false,
    refresh: false, // 刷新页面
    themeConfig: {
      primary: DEFAULT_PRIMARY,
      isDark: false,
    },
  }),

  actions: {
    changeCollapse() {
      this.collapse = !this.collapse
    },
    setRefresh() {
      this.refresh = !this.refresh
    },
    setThemeConfig(themeConfig: ThemeConfigProps) {
      this.themeConfig = themeConfig
    },
  },
  persist: true,
})
