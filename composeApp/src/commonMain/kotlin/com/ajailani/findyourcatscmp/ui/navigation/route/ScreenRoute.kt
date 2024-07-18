package com.ajailani.findyourcatscmp.ui.navigation.route

sealed class ScreenRoute(val route: String) {
    data object CatList : ScreenRoute("cat_list_screen")
    data object CatDetail : ScreenRoute("cat_detail_screen")
}