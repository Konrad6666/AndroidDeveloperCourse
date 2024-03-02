package com.example.unscramble.data.ui.test

import com.example.unscramble.ui.GameViewModel
import org.junit.Test

class GameViewModelTest {
    private val viewModel= GameViewModel()

    @Test
    fun gameViewModel_CorrectWordGuessed_ScoreUpdatedAndErrorFlagUnset()  {
        var currentGameUiState = viewModel.uiState.value
        val currentScrambledWord = currentGameUiState.currentScrambledWord
    }
}