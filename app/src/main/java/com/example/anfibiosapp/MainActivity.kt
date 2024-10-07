package com.example.anfibiosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    val navController = rememberNavController()

                    val amphibians = listOf(
                        Amphibian("Rana Verde", R.drawable.ranaverde, "Descripción de la rana verde :)."),
                        Amphibian("Rana de árbol", R.drawable.rana_arbol, "Descripción de la rana de árbol :)"),
                        Amphibian("Salamandra", R.drawable.salamandra, "Descripción de la salamandra :)")
                    )

                    NavHost(navController = navController, startDestination = "amphibians_list") {
                        composable("amphibians_list") {
                            AmphibianList(amphibians = amphibians, navController = navController)
                        }
                        composable("amphibian_detail/{amphibianName}") { backStackEntry ->
                            val amphibianName = backStackEntry.arguments?.getString("amphibianName")
                            val amphibian = amphibians.find { it.name == amphibianName }
                            amphibian?.let { AmphibianDetail(it) }
                        }
                    }
                }
            }
        }
    }
}
