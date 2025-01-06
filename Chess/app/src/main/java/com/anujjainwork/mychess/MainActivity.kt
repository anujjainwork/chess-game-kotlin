package com.anujjainwork.mychess

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.anujjainwork.mychess.ui.theme.MyChessTheme

class MainActivity : ComponentActivity() {

    private val chessModel = ChessModel()
    private val chessController = ChessController(chessModel)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyChessTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    ChessScreen(controller = chessController)
                }
            }
        }
    }
}
