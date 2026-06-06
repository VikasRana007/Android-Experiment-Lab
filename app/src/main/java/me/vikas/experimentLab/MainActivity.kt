package me.vikas.experimentLab

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import me.vikas.experimentLab.ui.theme.DevPlaygroundAppTheme
import me.vikas.feature_coroutine.ui.CoroutineActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DevPlaygroundAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android", modifier = Modifier.padding(innerPadding)
                    )
                    StartCoroutineActivity(LocalContext.current)
                }
            }
        }
    }
}

@Composable
fun StartCoroutineActivity(context: Context) {
    ElevatedButton(onClick = {
        context.startActivity(Intent(context, CoroutineActivity::class.java))
    }) {
        Text(
            text = "Navigate To Coroutine in Compose UI",

            )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello Vikas : $name!", modifier = modifier
    )
}
