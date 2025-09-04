package com.luizf3lipe.fipecar.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luizf3lipe.fipecar.R
import com.luizf3lipe.fipecar.ui.theme.Lime300
import com.luizf3lipe.fipecar.ui.theme.Lime950
import com.luizf3lipe.fipecar.ui.theme.Zinc800

@Composable
fun Goback(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(42.dp), // botão quadrado
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Lime300,
            disabledContentColor = Lime950,
            contentColor = Lime300,
            disabledContainerColor = Lime950
        ),
        contentPadding = PaddingValues(0.dp) // remove padding interno
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = "Go back",
            colorFilter = ColorFilter.tint(Zinc800),
            modifier = Modifier.size(24.dp) // ícone ocupa parte do botão (padrão Material)
        )
    }
}