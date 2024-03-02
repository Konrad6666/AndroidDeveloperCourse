package com.example.unscramble.ui

data class GameUiState(
    val currentScrambledWord: String = "",
    val isGuessedWordWrong: Boolean = false,
    val solution: String = "",
    val score: Int = 0,
    val currentWordCount: Int = 0,
    val isGameOver: Boolean = false
)
