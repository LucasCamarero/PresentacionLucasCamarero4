package com.lucascamarero.presentacionlucascamarero2

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

/**
 * Muestra un mensaje temporal cuando el usuario pulsa un botón.
 *
 * @param navController Controlador de navegación para gestionar rutas (no utilizado).
 */
@Composable
fun VentanaHome(navController: NavController) {
    // estado que gestiona el Snackbar (es como el "controlador" del mensaje)
    val snackbarHostState = remember { SnackbarHostState() }
    // corrutina scope para lanzar tareas en segundo plano (necesario para mostrar el Snackbar)
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            onClick = {
                // iniciamos una corrutina para mostrar el mensaje
                scope.launch {
                    snackbarHostState.showSnackbar("¡Hola desde Home!")
                }
            }
        ) {
            Text("Mostrar Snackbar")
        }

        // componente que muestra realmente el Snackbar en pantalla
        SnackbarHost(hostState = snackbarHostState)
    }
}

