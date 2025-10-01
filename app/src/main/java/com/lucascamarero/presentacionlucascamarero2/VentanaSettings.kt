package com.lucascamarero.presentacionlucascamarero2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

/**
 * Pantalla de ajustes sin desarrollar.
 *
 * @param navController Controlador de navegación para gestionar rutas (no utilizado).
 */
@Composable
fun VentanaSettings(navController: NavController) {
    var presses by remember { mutableIntStateOf(0) }
    val context = LocalContext.current
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

    }
}