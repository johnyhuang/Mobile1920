/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.ProxyFileDescriptorCallback
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentGameBinding
import kotlinx.android.synthetic.main.fragment_game.*
import timber.log.Timber

class GameFragment : Fragment() {

    data class Question(
            val text: String,
            val answers: List<String>,
            val image: Int
    )


    // The first answer is the correct one.  We randomize the answers before showing the text.
    // All questions must have four answers.  We'd want these to contain references to string
    // resources so we could internationalize. (Or better yet, don't define the questions in code...)


    private lateinit var viewModel:GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        Timber.i("In onCreateView")
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
                inflater, R.layout.fragment_game, container, false)

        // Shuffles the questions and sets the question index to the first question.
        // setQuestion()

        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        viewModel.question.observe(this, Observer { newQuestion ->
            binding.questionImage.setImageResource(newQuestion.image)
            binding.questionText.setText(newQuestion.text)
            binding.firstAnswerRadioButton.setText(newQuestion.answers[0])
            binding.firstAnswerRadioButton.setText(newQuestion.answers[1])
        })

        viewModel.score.observe(this, Observer { currentScore ->
            when (currentScore) {
                -1 -> view?.findNavController()?.navigate(R.id.action_gameFragment_to_badEndFragment)
                1 -> view?.findNavController()?.navigate(R.id.action_gameFragment_to_normalEndFragment)
                2 -> view?.findNavController()?.navigate(R.id.action_gameFragment_to_goodEndFragment)
            }
        })

        // Bind this fragment class to the layout
        binding.game = this

        // Set the onClickListener for the submitButton
        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            var choice = 0
            when (checkedId) {
                R.id.secondAnswerRadioButton -> choice = 1
            }
            onSubmit(choice)
        }
        return binding.root
    }

    private fun onSubmit(choice: Int) {
        viewModel.onSubmit(choice)
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Timber.i("In onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("In onCreate")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.i("In onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Timber.i("In onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("In onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("In onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("In onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.i("In onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("In onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.i("In onDetach")
    }


}
