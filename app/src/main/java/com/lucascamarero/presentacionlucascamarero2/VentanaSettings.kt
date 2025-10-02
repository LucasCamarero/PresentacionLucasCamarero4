package com.lucascamarero.presentacionlucascamarero2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

/**
 * Cambia un texto en base a si el checkbox está o no activado
 *
 * @param navController Controlador de navegación para gestionar rutas (no utilizado).
 */
@Composable
fun VentanaSettings(navController: NavController) {
    var checked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {

            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )

            Text(text = if (checked) "Notificaciones activadas" else "Notificaciones desactivadas")
        }
    }
}