package com.github.johnyhuang.findingstar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.github.johnyhuang.findingstar.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }
    //Function to change star into an empty star
    private fun makeEmpty(view: View){

        when(view.id){
            binding.boxOne.id -> binding.boxOne.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_off, 0, 0, 0)
            binding.boxTwo.id -> binding.boxTwo.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_off, 0, 0, 0)
            binding.boxThree.id -> binding.boxThree.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_off, 0, 0, 0)
            binding.boxFour.id -> binding.boxFour.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_off, 0, 0, 0)
            binding.boxFive.id -> binding.boxFive.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_off, 0, 0, 0)
            binding.boxSix.id -> binding.boxSix.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_off, 0, 0, 0)
            binding.boxSeven.id -> binding.boxSeven.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_off, 0, 0, 0)
            binding.boxEight.id -> binding.boxEight.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_off, 0, 0, 0)
            binding.boxNine.id -> binding.boxNine.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_off, 0, 0, 0)
        }
    }
    //Function to change star into a yellow star
    private fun makeStar(view: View){
        when(view.id){
            binding.boxOne.id -> binding.boxOne.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_on, 0, 0, 0)
            binding.boxTwo.id -> binding.boxTwo.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_on, 0, 0, 0)
            binding.boxThree.id -> binding.boxThree.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_on, 0, 0, 0)
            binding.boxFour.id -> binding.boxFour.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_on, 0, 0, 0)
            binding.boxFive.id -> binding.boxFive.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_on, 0, 0, 0)
            binding.boxSix.id -> binding.boxSix.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_on, 0, 0, 0)
            binding.boxSeven.id -> binding.boxSeven.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_on, 0, 0, 0)
            binding.boxEight.id -> binding.boxEight.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_on, 0, 0, 0)
            binding.boxNine.id -> binding.boxNine.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_on, 0, 0, 0)
        }
        Toast.makeText(this, "You Win!", Toast.LENGTH_LONG).show()
    }

    private fun setListeners() {
        val box_one = findViewById<TextView>(binding.boxOne.id)
        val box_two = findViewById<TextView>(binding.boxTwo.id)
        val box_three = findViewById<TextView>(binding.boxThree.id)
        val box_four = findViewById<TextView>(binding.boxFour.id)
        val box_five = findViewById<TextView>(binding.boxFive.id)
        val box_six = findViewById<TextView>(binding.boxSix.id)
        val box_seven = findViewById<TextView>(binding.boxSeven.id)
        val box_eight = findViewById<TextView>(binding.boxEight.id)
        val box_nine = findViewById<TextView>(binding.boxNine.id)

        //Makes list of all stars, then randomly picks one out and fills it in with onClickListener to display a yellow star
        val clickableEmptyStarViews =
            mutableListOf<View>(box_one, box_two, box_three, box_four, box_five, box_six, box_seven, box_eight, box_nine)
        clickableEmptyStarViews.shuffle()
        val clickableHiddenStarView = clickableEmptyStarViews[8]
        clickableEmptyStarViews.removeAt(8)

        clickableHiddenStarView.setOnClickListener{
            makeStar(it)
        }


        for (item in clickableEmptyStarViews){
            item.setOnClickListener{
                makeEmpty(it)
            }
        }


    }
}
