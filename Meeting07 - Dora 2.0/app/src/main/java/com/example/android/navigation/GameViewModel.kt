package com.example.android.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    data class Question(
            val text: String,
            val answers: List<String>,
            val image: Int
    )

    private val _question = MutableLiveData<Question>()

    val question: LiveData<Question>
        get() = _question

    private val _score = MutableLiveData<Int>()

    val score: LiveData<Int>
        get() = _score

    private lateinit var questionList: MutableList<Question>
    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = 2

    private fun resetList() {
        questionList = mutableListOf(
                Question(text = "You see a room with a red button",
                        answers = listOf("Leave it", "Press it"),
                        image = R.mipmap.red_button_foreground),
                Question(text = "You see a room with a big pile of treasure",
                        answers = listOf("Take it", "Leave it"),
                        image = R.mipmap.treasure_foreground)
        )
    }

    init {
        resetList()
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = questionList[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()
    }

    fun onSubmit(choice: Int){

        // The first answer in the original question is always the correct one, so if our
        // answer matches, we have the correct answer.
        if (answers[choice] == currentQuestion.answers[0]) {
            questionIndex++
            // Advance to the next question
            if (questionIndex < numQuestions) {
                currentQuestion = questionList[questionIndex]
                setQuestion()
            } else {
                _score.value = 2
            }
        } else if (answers[choice] != currentQuestion.answers[0] && questionIndex > 0) {
            _score.value = 1
        } else {
            _score.value = -1
        }
    }
}