package com.luizf3lipe.fipecar.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.luizf3lipe.fipecar.screens.anos.AnosScreen
import com.luizf3lipe.fipecar.screens.marcas.MarcasScreen
import com.luizf3lipe.fipecar.screens.modelos.ModelosScreen
import com.luizf3lipe.fipecar.screens.veiculo.VeiculoScreen

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
        composable("anos/{codigoMarca}/{codigoModelo}") { backStackEntry ->
            val codigoMarca = backStackEntry.arguments?.getString("codigoMarca") ?: ""
            val codigoModelo = backStackEntry.arguments?.getString("codigoModelo")?.toIntOrNull() ?: 0
            AnosScreen(navController, codigoMarca, codigoModelo)
        }
        composable("veiculo/{codigoMarca}/{codigoModelo}/{anoModelo}") { backStackEntry ->
            val codigoMarca = backStackEntry.arguments?.getString("codigoMarca") ?: ""
            val codigoModelo = backStackEntry.arguments?.getString("codigoModelo") ?: ""
            val anoModelo = backStackEntry.arguments?.getString("anoModelo") ?: ""
            VeiculoScreen(navController, codigoMarca, codigoModelo, anoModelo)
        }
    }
}