package com.anujjainwork.mychess

import android.util.Log

private const val TAG = "ChessController"

class ChessController(private val model: ChessModel) {

    fun resetGame() {
        model.reset()
        Log.d(TAG, "Game reset. New board:\n${model}")
    }

    fun getChessPieces(): Set<ChessPiece> {
        Log.d(TAG, "get Chess Pieces for board:\n${model}")
        return model.piecesBox
    }

    override fun toString(): String {
        return model.toString()
    }
}
