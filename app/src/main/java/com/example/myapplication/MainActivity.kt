package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                HalamanPemesananTiket()
            }
        }
    }
}

@Composable
fun HalamanPemesananTiket() {

    val hargaTiket = 25000
    var jumlahTiket by remember { mutableStateOf(1) }

    val totalBayar = hargaTiket * jumlahTiket

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Pemesanan Tiket",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1976D2)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Harga Tiket",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Rp25.000",
                    fontSize = 28.sp,
                    color = Color(0xFF1976D2),
                    fontWeight = FontWeight.Bold
                )

                Text("per tiket")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Jumlah Tiket",
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Button(
                        onClick = {
                            if (jumlahTiket > 1) jumlahTiket--
                        }
                    ) {
                        Icon(Icons.Default.Remove, null)
                    }

                    Text(
                        text = jumlahTiket.toString(),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Button(
                        onClick = {
                            jumlahTiket++
                        }
                    ) {
                        Icon(Icons.Default.Add, null)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Total",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Rp${String.format("%,d", totalBayar).replace(',', '.')}",
                    fontSize = 30.sp,
                    color = Color(0xFF008F39),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                jumlahTiket = 1
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            )
        ) {
            Icon(Icons.Default.Refresh, null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("RESET")
        }
    }
}