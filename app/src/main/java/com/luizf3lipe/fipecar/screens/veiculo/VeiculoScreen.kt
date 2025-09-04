package com.luizf3lipe.fipecar.screens.veiculo

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.luizf3lipe.fipecar.AppViewModelFactory
import com.luizf3lipe.fipecar.R
import com.luizf3lipe.fipecar.domain.model.Veiculo
import com.luizf3lipe.fipecar.ui.theme.Lime300
import com.luizf3lipe.fipecar.ui.theme.Lime950
import com.luizf3lipe.fipecar.ui.theme.Typography
import com.luizf3lipe.fipecar.ui.theme.Zinc100
import com.luizf3lipe.fipecar.ui.theme.Zinc400
import com.luizf3lipe.fipecar.ui.theme.Zinc50
import com.luizf3lipe.fipecar.ui.theme.Zinc800
import com.luizf3lipe.fipecar.ui.theme.Zinc900
import com.luizf3lipe.fipecar.ui.theme.Zinc950

@Composable
fun VeiculoScreen(
    navController: NavController,
    codigoMarca: String,
    codigoModelo: String,
    anoModelo: String,
    viewModel: VeiculoViewModel = viewModel(factory = AppViewModelFactory())
) {
    LaunchedEffect(codigoMarca, codigoModelo, anoModelo) {
        viewModel.buscarFipeVeiculo(codigoMarca, codigoModelo, anoModelo)
    }
    val vehicleData = viewModel.veiculo

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Zinc900)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
            .windowInsetsPadding(WindowInsets.systemBars),
    ) {
        // Header
        HeaderSection()

        Spacer(modifier = Modifier.height(24.dp))

        // Valor em destaque
        InfoCard(
            icon = R.drawable.ic_money,
            label = "Valor",
            value = vehicleData.value.valor,
            isAccent = true,
            isLarge = false,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Marca e Modelo
        InfoCard(
            icon = R.drawable.car,
            label = "Marca e Modelo",
            isLarge = false,
            value = "${vehicleData.value.marca}\n${vehicleData.value.modelo}",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Grid de informações
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            InfoCard(
                icon = R.drawable.ic_calendar,
                label = "Ano do Modelo",
                value = vehicleData.value.anoModelo.toString(),
                modifier = Modifier.weight(1f)
            )

            InfoCard(
                icon = R.drawable.ic_gas,
                label = "Combustível",
                value = "${vehicleData.value.combustivel} (${vehicleData.value.siglaCombustivel})",
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            InfoCard(
                icon = R.drawable.ic_qr_code,
                label = "Código FIPE",
                value = vehicleData.value.codigoFipe,
                modifier = Modifier.weight(1f)
            )

            InfoCard(
                icon = R.drawable.ic_calendar,
                label = "Mês de Referência",
                value = vehicleData.value.mesReferencia,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Footer com informações técnicas
        TechnicalInfoSection(vehicleData.value)
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 16.dp)
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
                    text = "Voltar",
                    style = Typography.labelLarge,
                    color = Zinc950
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                onClick = {
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true}
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 16.dp)
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
                    text = "Nova Consulta",
                    style = Typography.labelLarge,
                    color = Zinc950
                )
            }
        }
    }
}

@Composable
private fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Zinc800)
            .padding(24.dp)
    ) {
        // Elemento decorativo de fundo
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(60.dp))
                .background(Lime300.copy(alpha = 0.1f))
                .align(Alignment.TopEnd)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Lime300),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id= R.drawable.car),
                    contentDescription = "Veículo",
                    modifier = Modifier.size(32.dp),
                    colorFilter = ColorFilter.tint(Lime950)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "Informações do Veículo",
                    color = Zinc50,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Dados da Tabela FIPE",
                    color = Zinc400,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
private fun InfoCard(
    @DrawableRes icon: Int,
    label: String,
    value: String,
    isAccent: Boolean = false,
    isLarge: Boolean = true,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .let {
                var mod = it
                if (isAccent) {
                    mod = mod.border(2.dp, Lime300, RoundedCornerShape(16.dp))
                }
                if (isLarge) {
                    mod = mod.height(130.dp)
                }
                mod
            },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Zinc800
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isAccent) 8.dp else 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        if (isAccent) Lime300 else Zinc800
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = label,
                    colorFilter = ColorFilter.tint(if (isAccent) Lime950 else Zinc100),
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = label,
                    color = Zinc100,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = value,
                    color = Zinc400,
                    fontSize = if (isAccent) 20.sp else 16.sp,
                    fontWeight = if (isAccent) FontWeight.Bold else FontWeight.SemiBold,
                    lineHeight = if (isAccent) 24.sp else 20.sp
                )
            }
        }
    }
}

@Composable
private fun TechnicalInfoSection(vehicleData: Veiculo) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Zinc800
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_info),
                    contentDescription = "Informações",
                    colorFilter = ColorFilter.tint(Zinc100),
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Informações Técnicas",
                    color = Zinc100,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TechnicalInfoRow(
                    "Tipo de Veículo:",
                    if (vehicleData.tipoVeiculo == 1) "Carro" else "Outro"
                )
                TechnicalInfoRow("Código:", vehicleData.codigoFipe)
                TechnicalInfoRow("Referência:", vehicleData.mesReferencia)
            }
        }
    }
}

@Composable
private fun TechnicalInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            color = Zinc100,
            fontSize = 14.sp,
            modifier = Modifier.weight(0.4f)
        )
        Text(
            text = value,
            color = Zinc50,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(0.6f)
        )
    }
}