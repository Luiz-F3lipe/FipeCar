package com.luizf3lipe.fipecar.screens.marcas

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.luizf3lipe.fipecar.AppViewModelFactory
import com.luizf3lipe.fipecar.components.marcas.MarcaCard
import com.luizf3lipe.fipecar.ui.theme.Lime300
import com.luizf3lipe.fipecar.ui.theme.Typography
import com.luizf3lipe.fipecar.ui.theme.Zinc400
import com.luizf3lipe.fipecar.ui.theme.Zinc50
import com.luizf3lipe.fipecar.ui.theme.Zinc800
import com.luizf3lipe.fipecar.ui.theme.Zinc950

@Composable
fun MarcasScreen(
    navController: NavController,
    viewModel: MarcasViewModel = viewModel(factory = AppViewModelFactory())
) {
    val marcas = viewModel.marcas

    Column(
        modifier = Modifier
            .background(color = Zinc950)
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título no topo, centralizado
        Text(
            text = "Marcas",
            style = Typography.headlineLarge,
            color = Zinc50,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )

        // Input um pouco mais embaixo
        SearchInput(viewModel)

        Spacer(modifier = Modifier.height(8.dp))

        // Lista rolável ocupa o resto da tela
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(bottom = 52.dp),
            verticalArrangement = Arrangement.spacedBy(-12.dp),
        ) {
            items(marcas) { marca ->
                MarcaCard(
                    marca = marca.nome,
                    codigo = marca.codigo,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun SearchInput(viewModel: MarcasViewModel) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
            viewModel.filtrarMarca(newText)
        },
        placeholder = {
            Text(
                text = "Pesquisar por marcas",
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