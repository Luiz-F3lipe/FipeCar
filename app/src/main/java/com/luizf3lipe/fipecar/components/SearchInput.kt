package com.luizf3lipe.fipecar.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.luizf3lipe.fipecar.screens.marcas.MarcasViewModel
import com.luizf3lipe.fipecar.ui.theme.Lime300
import com.luizf3lipe.fipecar.ui.theme.Zinc400
import com.luizf3lipe.fipecar.ui.theme.Zinc800
import com.luizf3lipe.fipecar.ui.theme.Zinc950

@Composable
fun SearchInput(
    onSearch: (String) -> Unit,
    placeholder: String = "Pesquisar..."
) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
            onSearch(newText)
        },
        placeholder = {
            Text(
                text = placeholder,
                color = Zinc400
            )
        },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Zinc950,
            focusedTextColor = Zinc400,
            unfocusedTextColor = Zinc400,
            unfocusedContainerColor = Zinc950,
            disabledContainerColor = Zinc950,
            cursorColor = Lime300,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .height(56.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, Zinc800, RoundedCornerShape(12.dp))
    )
}