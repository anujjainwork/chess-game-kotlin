package com.anujjainwork.mychess

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill

@Composable
fun ChessBoard() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth(1f)
                .aspectRatio(1f)
        ) {
            val boardSize = maxWidth
            val cellSize = boardSize / 8

            Canvas(
                modifier = Modifier.size(boardSize)
            ) {
                for (row in 0 until 8) {
                    for (col in 0 until 8) {
                        val color = if ((row + col) % 2 == 0) Color.LightGray else Color.DarkGray
                        drawRect(
                            color = color,
                            topLeft = androidx.compose.ui.geometry.Offset(
                                x = col * size.width / 8,
                                y = row * size.height / 8
                            ),
                            size = androidx.compose.ui.geometry.Size(
                                width = size.width / 8,
                                height = size.height / 8
                            ),
                            style = Fill
                        )
                    }
                }
            }
        }
    }
}
