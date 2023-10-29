package com.example.intenthomework

import android.content.Intent
import android.os.Bundle
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.*
import com.example.intenthomework.ui.theme.IntentHomeworkTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntentHomeworkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SecondPage()
                }
            }
        }
    }
}

@Composable
fun SecondPage() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner2),
            contentDescription = "Concert Banner",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.FillWidth
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomStart
        ) {
            Row {
                Text(
                    text = "Concert Detail",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontSize = 20.sp),
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomStart
        ) {
            Row {
                Text(
                    text = "Lokasi : Graha Unesa Surabaya \n" + "Tanggal : 17 Desember 2023 \n" + "Open Gate : 17.00 WIB",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontSize = 14.sp),
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomStart
        ) {
            Row {
                Text(
                    text = "Harga Tiket",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontSize = 16.sp),
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomStart
        ) {
            Row {
                Text(
                    text = "Kategori ROSE : Rp. 1.300.000\n" +
                            "Kategori ORCHID : Rp. 750.000\n" +
                            "Kategori TULIP : Rp. 600.000\n" +
                            "Kategori JASMINE FLOOR : Rp. 350.000\n" +
                            "Kategori JASMINE TRIBUNE : Rp. 350.000\n" +
                            "Online : Akan diumumkan lebih lanjut \n",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontSize = 14.sp),
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomStart
        ) {
            Row {
                Button( //Intent implicit
                    onClick = {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://maps.app.goo.gl/jKk7ub4w6UdksDcX9")
                        )
                        startActivity(context, intent, null)
                    },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Maps")
                }
                Button( //Intent implicit and intent filter
                    onClick = {
                        val emailIntent = Intent(Intent.ACTION_SENDTO)
                        emailIntent.data = Uri.parse("mailto:")
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("example@example.com"))
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Buy Ticket Concert")
                        emailIntent.putExtra(Intent.EXTRA_TEXT, "Kategori : (Isi Seat Category) \n" +
                                "Nama : (Isi Nama Anda) \n" + "No. Hp : (Isi No. Hp Anda) \n" +
                                "Nomor Keanggotaan : (Isi No. Keanggotaan Anda)")
                        startActivity(context, emailIntent, null)
                    },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Buy Ticket")
                }
            }
        }
    }
}