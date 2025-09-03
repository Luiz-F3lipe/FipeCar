package com.luizf3lipe.fipecar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.luizf3lipe.fipecar.R
import com.luizf3lipe.fipecar.ui.theme.Lime300
import com.luizf3lipe.fipecar.ui.theme.Lime950
import com.luizf3lipe.fipecar.ui.theme.Typography
import com.luizf3lipe.fipecar.ui.theme.Zinc950

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .background(color = Zinc950)
            .fillMaxSize(),
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.car),
                contentDescription = "Car Icon",
                modifier = Modifier.size(42.dp),
                colorFilter = ColorFilter.tint(Lime300)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "FipeCar",
                style = Typography.headlineLarge,
                color = Lime300
            )
        }

        Button(
            onClick = {
                navController.navigate("marcas")
            },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 52.dp, start = 24.dp, end = 24.dp)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Lime300,
                disabledContentColor = Lime950,
                contentColor = Lime300,
                disabledContainerColor = Lime950
            ),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(
                text = "Consultar Marcas",
                style = Typography.labelLarge,
                color = Zinc950
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    HomeScreen(rememberNavController())
}