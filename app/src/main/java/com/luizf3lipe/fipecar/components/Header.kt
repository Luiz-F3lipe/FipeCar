package com.luizf3lipe.fipecar.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.luizf3lipe.fipecar.ui.theme.Lime300
import com.luizf3lipe.fipecar.ui.theme.Lime950
import com.luizf3lipe.fipecar.ui.theme.Typography


@Composable
fun Header(
    navController: NavController,
    title: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Clean back button
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Voltar",
                tint = Lime300,
                modifier = Modifier.size(24.dp)
            )
        }

        // Clean title - perfectly centered
        Text(
            text = title,
            style = Typography.headlineMedium.copy(
                fontWeight = FontWeight.Normal,
                brush = Brush.horizontalGradient(
                    colors = listOf(Lime300, Lime950)
                )
            ),
            modifier = Modifier
                .weight(1f)
                .offset(x = (-24).dp),
            textAlign = TextAlign.Center
        )
    }
}
