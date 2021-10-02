package com.example.zapfood.presentation.scenes.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.zapfood.presentation.scenes.detail.MealDetailDestination
import com.example.zapfood.presentation.scenes.detail.MealDetailScreen
import com.example.zapfood.presentation.scenes.detail.MealDetailsViewModel
import com.example.zapfood.presentation.ui.theme.ZapFoodTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZapFoodTheme {
                MainApp()
            }
        }
    }
}

@Composable
private fun MainApp() {
    val navController = rememberNavController()
    NavHost(navController,startDestination = MealsCategoryDestination.TAG) {
        composable(route = MealsCategoryDestination.TAG) {
            MealsCategoriesScreen { navigationMealId ->
                navController.navigate("${MealDetailDestination.TAG}/$navigationMealId")
            }
        }
        composable(
            route = "${MealDetailDestination.TAG}/{meal_category_id}",
            arguments = listOf(navArgument("meal_category_id") {
                type = NavType.StringType
            })) {
            val viewModel: MealDetailsViewModel = viewModel()
            viewModel.mealState.value?.let { it1 -> MealDetailScreen(it1) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ZapFoodTheme {
        MealsCategoriesScreen { }
    }
}