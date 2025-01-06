package com.anujjainwork.mychess

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun ChessScreen() {
    val chessPieces = getInitialChessBoard()

    ChessBoard(
        pieces = chessPieces,
        lightColor = Color(0xFFD2B48C), // Light brown
        darkColor = Color(0xFF8B4513)  // Dark brown
    )
}

// Function to initialize the chessboard with pieces
fun getInitialChessBoard(): Map<Pair<Int, Int>, Int> {
    return buildMap {
        // Black pieces
        put(Pair(0, 0), R.drawable.rook_black)
        put(Pair(0, 1), R.drawable.knight_black)
        put(Pair(0, 2), R.drawable.bishop_black)
        put(Pair(0, 3), R.drawable.queen_black)
        put(Pair(0, 4), R.drawable.king_black)
        put(Pair(0, 5), R.drawable.bishop_black)
        put(Pair(0, 6), R.drawable.knight_black)
        put(Pair(0, 7), R.drawable.rook_black)

        // Black pawns
        (0..7).forEach { col ->
            put(Pair(1, col), R.drawable.pawn_black)
        }

        // White pieces
        put(Pair(7, 0), R.drawable.rook_white)
        put(Pair(7, 1), R.drawable.knight_white)
        put(Pair(7, 2), R.drawable.bishop_white)
        put(Pair(7, 3), R.drawable.queen_white)
        put(Pair(7, 4), R.drawable.king_white)
        put(Pair(7, 5), R.drawable.bishop_white)
        put(Pair(7, 6), R.drawable.knight_white)
        put(Pair(7, 7), R.drawable.rook_white)

        // White pawns
        (0..7).forEach { col ->
            put(Pair(6, col), R.drawable.pawn_white)
        }
    }
}

// ChessBoard composable with customizable colors
@Composable
fun ChessBoard(
    pieces: Map<Pair<Int, Int>, Int>,
    lightColor: Color = Color.LightGray,
    darkColor: Color = Color.DarkGray
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        ) {
            val cellSize = maxWidth / 8

            // Draw chessboard
            Canvas(
                modifier = Modifier.size(maxWidth)
            ) {
                for (row in 0 until 8) {
                    for (col in 0 until 8) {
                        val color = if ((row + col) % 2 == 0) lightColor else darkColor
                        drawRect(
                            color = color,
                            topLeft = androidx.compose.ui.geometry.Offset(
                                x = col * cellSize.toPx(),
                                y = row * cellSize.toPx()
                            ),
                            size = androidx.compose.ui.geometry.Size(
                                width = cellSize.toPx(),
                                height = cellSize.toPx()
                            )
                        )
                    }
                }
            }

            // Place chess pieces
            pieces.forEach { (position, resId) ->
                val (row, col) = position
                Image(
                    painter = painterResource(id = resId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(cellSize)
                        .offset(
                            x = cellSize * col,
                            y = cellSize * row
                        )
                )
            }
        }
    }
}
