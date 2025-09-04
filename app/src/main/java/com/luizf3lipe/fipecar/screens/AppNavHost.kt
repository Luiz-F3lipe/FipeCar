package com.luizf3lipe.fipecar.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.luizf3lipe.fipecar.screens.marcas.MarcasScreen
import com.luizf3lipe.fipecar.screens.modelos.ModelosScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController)}
        composable("home") { HomeScreen(navController)}
        composable("marcas") { MarcasScreen(navController) }
        composable("modelos/{codigoMarca}") { backStackEntry ->
            val codigoMarca = backStackEntry.arguments?.getString("codigoMarca") ?: ""
            ModelosScreen(navController, codigoMarca)
        }
    }
}