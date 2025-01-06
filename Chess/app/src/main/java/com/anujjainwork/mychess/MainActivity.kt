package com.anujjainwork.mychess

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.anujjainwork.mychess.ui.theme.MyChessTheme

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {

    var chessModel = ChessModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyChessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    Log.d(TAG,"Hello,Chess")
                    Log.d(TAG,chessModel.toString())
                    ChessApp()
                }
            }
        }
    }
}

@Composable
fun ChessApp(){
    ChessScreen()
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyChessTheme {
        ChessApp()
    }
}