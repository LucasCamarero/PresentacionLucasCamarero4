package com.lucascamarero.presentacionlucascamarero2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucascamarero.presentacionlucascamarero2.ui.theme.PresentacionLucasCamarero2Theme
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    /**
     * Crea la actividad principal
     *
     * @param savedInstanceState Estado guardado de la actividad
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PresentacionLucasCamarero2Theme(dynamicColor = false) {
                Surface {
                    App()
                }
            }
        }
    }
}

/**
 * Vista previa de la aplicación en el editor de diseño.
 */
@Preview
@Composable
fun AppPreview() {
    PresentacionLucasCamarero2Theme(dynamicColor = false) {
        Surface(
        ) {
            App()
        }
    }
}

/**
 * Configura la navegación entre pantallas, la barra superior con títulos dinámicos
 * y la barra de navegación inferior con iconos. Usa Scaffold para estructurar
 * el diseño general de la interfaz.
 */
//@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val navController = rememberNavController()
    // Observar la ruta actual para cambiar el título dinámicamente
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "info"
    Scaffold(

        // barra superior
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        when (currentRoute) {
                            "home" -> "Pantalla Home"
                            "info" -> "Presentación Lucas Camarero III"
                            "gallery" -> "Galería"
                            "settings" -> "Ajustes"
                            else -> "App"
                        },
                        style = MaterialTheme.typography.labelSmall
                    )
                },
            )
        },

        // barra inferior
        bottomBar = {
            BottomAppBar(
            containerColor = MaterialTheme.colorScheme.secondary,
            ) {
                BottomNavBar(navController)
            }
        }
    )

    // cuerpo central de la pantalla
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.primary),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            // definición de rutas de pantallas
            NavHost(navController = navController,
                startDestination = "info",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("home") {
                    VentanaHome(navController)
                }
                composable("info") {
                    VentanaInfo(navController)
                }
                composable("gallery") {
                    VentanaGaleria(navController)
                }
                composable("settings") {
                    VentanaSettings(navController)
                }
            }
        }
    }
}

/**
 * Barra de navegación inferior.
 *
 * Contiene los iconos de navegación (Home, Info, Galería, Ajustes) que permiten
 * al usuario cambiar entre las diferentes secciones de la app.
 *
 * @param navController Controlador de navegación que gestiona el cambio de rutas.
 */
@Composable
fun BottomNavBar(navController: NavHostController) {
    NavigationBar (containerColor = MaterialTheme.colorScheme.secondary){
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            selected = navController.currentBackStackEntry?.destination?.route == "home",
            onClick = {
                navController.navigate("home") {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            label = { Text("Home") }
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.Info, contentDescription = "info") },
            selected = navController.currentBackStackEntry?.destination?.route == "info",
            onClick = {
                navController.navigate("info") {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            label = { Text("Info") }
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.Create, contentDescription = "gallery") },
            selected = navController.currentBackStackEntry?.destination?.route == "gallery",
            onClick = {
                navController.navigate("gallery") {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            label = { Text("Galería") }
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.Settings, contentDescription = "settings") },
            selected = navController.currentBackStackEntry?.destination?.route == "settings",
            onClick = {
                navController.navigate("settings") {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            label = { Text("Ajustes") }
        )
    }
}

