package com.ajailani.findyourcatscmp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ajailani.findyourcatscmp.ui.screen.cat_detail.CatDetailScreen
import com.ajailani.findyourcatscmp.ui.navigation.route.ScreenRoute
import com.ajailani.findyourcatscmp.ui.screen.cat_detail.CatDetailViewModel
import com.ajailani.findyourcatscmp.ui.screen.cat_list.CatListScreen
import com.ajailani.findyourcatscmp.ui.screen.cat_list.CatListViewModel
import org.koin.compose.currentKoinScope
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.ParametersHolder
import org.koin.core.parameter.parametersOf

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.CatList.route
    ) {
        composable(ScreenRoute.CatList.route) {
            val viewModel = koinViewModel<CatListViewModel>()

            CatListScreen(
                uiState = viewModel.uiState,
                onNavigateToCatDetail = { id ->
                    navController.navigate(ScreenRoute.CatDetail.route + "?id=$id")
                }
            )
        }

        composable(
            route = ScreenRoute.CatDetail.route + "?id={id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            val viewModel = koinViewModel<CatDetailViewModel>(
                parametersOf(SavedStateHandle.createHandle(null, it.arguments))
            )

            CatDetailScreen(
                uiState = viewModel.uiState,
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}

@Composable
inline fun <reified T: ViewModel> koinViewModel(parametersHolder: ParametersHolder? = null): T {
    val scope = currentKoinScope()
    var parameters: ParametersDefinition? = null

    parametersHolder?.let {
        parameters = { it }
    }

    return viewModel { scope.get<T>(parameters = parameters) }
}