package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.myapplication.ui.theme.MyApplicationTheme

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()

                Surface(color = MaterialTheme.colorScheme.background) {
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Login.route
                    ) {
                        composable(Screen.Login.route) {
                            LoginScreen(
                                onLoginSuccess = {
                                    navController.navigate(Screen.Home.route) {
                                        popUpTo(Screen.Login.route) { inclusive = true }
                                    }
                                },
                                onGoToRegister = {
                                    navController.navigate(Screen.Register.route)
                                }
                            )
                        }

                        composable(Screen.Register.route) {
                            RegisterScreen(
                                onRegisterSuccess = {
                                    navController.navigate(Screen.Home.route) {
                                        popUpTo(Screen.Register.route) { inclusive = true }
                                    }
                                },
                                onGoToLogin = {
                                    navController.navigate(Screen.Login.route)
                                }
                            )
                        }

                        composable(Screen.Home.route) {
                            val sampleRecipes = listOf(
                                Recipe("Retro Burger", R.drawable.sample_recipe),
                                Recipe("Creamy Ramen", R.drawable.sample_recipe),
                                Recipe("Golden Waffles", R.drawable.sample_recipe)
                            )

                            HomeScreen(
                                featuredRecipes = sampleRecipes,
                                onRecipeClick = { /* TODO: Open detail */ }
                            )
                        }
                    }
                }
            }
        }
    }
}
