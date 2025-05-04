/*
 * @Description:Global type declarations and dynamic route menu configuration
 * @Autor: Zhiheng

 */
declare type Nullable<T> = T | null
declare type NonNullable<T> = T extends null | undefined ? never : T
declare type Recordable<T = any> = Record<string, T>
declare module 'path-browserify'
// * Vite
declare interface ViteEnv {
  NODE_ENV: string
  VITE_APP_PORT: number
  VITE_APP_TITLE: string
  VITE_APP_BASE_API: string
}

/**
 * @description Overview of dynamic route parameter configuration
 * @param path ==> Menu path
 * @param name ==> Route alias
 * @param redirect ==> Redirect path
 * @param component ==> Path to the view component
 * @param meta ==> Metadata for the menu
 * @param meta.icon ==> Menu icon
 * @param meta.title ==> Menu title
 * @param meta.activeMenu ==> Menu item to highlight when the current route is a detail page
 * @param meta.isLink ==> Whether it is an external link
 * @param meta.isHide ==> Whether to hide the menu item
 * @param meta.isFull ==> Whether to display in full screen (e.g., data dashboard pages)
 * @param meta.isAffix ==> Whether to fix the tab in the navigation bar
 * @param meta.isKeepAlive ==> Whether to cache the view
 * @param meta.noAuth ==> Whether to bypass permission checks
 */


// * Menu
declare namespace Menu {
  interface MenuOptions {
    path: string
    name: string
    component?: string | (() => Promise<any>)
    redirect?: string
    meta: MetaProps
    children?: MenuOptions[]
  }
  interface MetaProps {
    icon?: string
    name?: string
    activeMenu?: string
    isLink?: string
    isHide?: boolean
    isFull?: boolean
    isAffix?: boolean
    isKeepAlive?: boolean
  }
}
