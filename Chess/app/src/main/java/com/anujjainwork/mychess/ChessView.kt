package com.anujjainwork.mychess

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun ChessScreen(controller: ChessController) {
    // Use the controller to get the chess pieces
    val chessPieces = controller.getChessPieces()

    ChessBoard(
        pieces = chessPieces,
        lightColor = Color(0xFFD2B48C), // Light brown
        darkColor = Color(0xFF8B4513)  // Dark brown
    )
}

@Composable
fun ChessBoard(
    pieces: Set<ChessPiece>,
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
            pieces.forEach { piece ->
                val resId = piece.getDrawableResId()
                val (row, col) = piece.row to piece.col
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
fun ChessPiece.getDrawableResId(): Int {
    return when (this.rank) {
        ChessRank.KING -> if (this.player == ChessPlayer.WHITE) R.drawable.king_white else R.drawable.king_black
        ChessRank.QUEEN -> if (this.player == ChessPlayer.WHITE) R.drawable.queen_white else R.drawable.queen_black
        ChessRank.ROOK -> if (this.player == ChessPlayer.WHITE) R.drawable.rook_white else R.drawable.rook_black
        ChessRank.BISHOP -> if (this.player == ChessPlayer.WHITE) R.drawable.bishop_white else R.drawable.bishop_black
        ChessRank.KNIGHT -> if (this.player == ChessPlayer.WHITE) R.drawable.knight_white else R.drawable.knight_black
        ChessRank.PAWN -> if (this.player == ChessPlayer.WHITE) R.drawable.pawn_white else R.drawable.pawn_black
    }
}

