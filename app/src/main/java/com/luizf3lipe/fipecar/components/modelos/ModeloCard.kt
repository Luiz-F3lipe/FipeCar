package com.luizf3lipe.fipecar.components.modelos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luizf3lipe.fipecar.R
import com.luizf3lipe.fipecar.ui.theme.Lime300
import com.luizf3lipe.fipecar.ui.theme.Typography
import com.luizf3lipe.fipecar.ui.theme.Zinc100
import com.luizf3lipe.fipecar.ui.theme.Zinc900

@Composable
fun ModeloCard(
    modifier: Modifier = Modifier,
    codModelo: Int,
    nome: String
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
            .height(80.dp), // aumentei a altura para caber a coluna
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Zinc900),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            // Linha do código
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_code),
                    contentDescription = "Ícone de código",
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(Lime300)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = codModelo.toString(),
                    style = Typography.bodyMedium,
                    color = Zinc100
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Linha do nome do veículo
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.car),
                    contentDescription = "Ícone do veículo",
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(Lime300)
                )
                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = nome,
                    style = Typography.bodyMedium,
                    color = Zinc100,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
private fun ModeloCardPrev() {
    ModeloCard(
        codModelo = 5585,
        nome = "AMAROK"
    )
}