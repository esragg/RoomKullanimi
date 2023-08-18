package com.pisiitech.roomkullanimi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.pisiitech.roomkullanimi.ui.theme.RoomKullanimiTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomKullanimiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Sayfa()
                }
            }
        }
    }
}

@Composable
fun Sayfa() {
    val context = LocalContext.current
    val vt = Veritabani.veritabaniErisim(context)!!


    LaunchedEffect(key1 = true) {
        //ekle(vt)
        //guncelle(vt)
        //sil(vt)
        //tumKisiler(vt)
        rastgele(vt)
    }
}

    fun tumKisiler(vt: Veritabani) {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            val liste = vt.kisilerDao().tumKisiler()

            for (k in liste) {
                Log.e("Kisi  Bilgi", "********************")
                Log.e("Kisi id", k.kisi_id.toString())
                Log.e("Kisi ad", k.kisi_ad)
                Log.e("Kisi tel", k.kisi_tel)
            }
        }
    }

    fun ekle(vt: Veritabani) {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            val yeniKisi = Kisiler(0, "Mehmet", "33333")
            vt.kisilerDao().kisiEkle(yeniKisi)
        }
    }

    fun guncelle(vt: Veritabani) {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenKisi = Kisiler(4, "Ali", "99999")
            vt.kisilerDao().kisiGuncelle(guncellenenKisi)
        }
    }

    fun sil(vt: Veritabani) {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            val silinenKisi = Kisiler(4, "Ali", "99999")
            vt.kisilerDao().kisiSil(silinenKisi)
        }
    }
fun rastgele(vt: Veritabani) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val liste = vt.kisilerDao().rastgele1KisiGetir()

        for (k in liste) {
            Log.e("Kisi  Bilgi", "********************")
            Log.e("Kisi id", k.kisi_id.toString())
            Log.e("Kisi ad", k.kisi_ad)
            Log.e("Kisi tel", k.kisi_tel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RoomKullanimiTheme {
        Sayfa()
    }
}