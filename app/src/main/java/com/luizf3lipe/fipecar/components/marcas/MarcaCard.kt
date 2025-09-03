package com.luizf3lipe.fipecar.components.marcas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luizf3lipe.fipecar.R
import com.luizf3lipe.fipecar.ui.theme.Lime300
import com.luizf3lipe.fipecar.ui.theme.Typography
import com.luizf3lipe.fipecar.ui.theme.Zinc100
import com.luizf3lipe.fipecar.ui.theme.Zinc900

@Composable
fun MarcaCard(
    modifier: Modifier = Modifier,
    codigo: String,
    marca: String,
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .height(62.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Zinc900),
        elevation = CardDefaults.cardElevation(4.dp),
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.ic_code),
                    contentDescription = "Ícone de código",
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(Lime300)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = codigo,
                    style = Typography.bodyMedium,
                    color = Zinc100
                )
            }
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = marca,
                    style = Typography.bodyMedium,
                    color = Zinc100
                )
                Spacer(modifier = Modifier.size(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_tag),
                    contentDescription = "Ícone de código",
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(Lime300)
                )

            }
        }
    }
}

@Preview
@Composable
private fun MarcaCardPrev() {
    MarcaCard(
        modifier = Modifier.fillMaxWidth(),
        codigo = "0001",
        marca = "Acura"
    )
}