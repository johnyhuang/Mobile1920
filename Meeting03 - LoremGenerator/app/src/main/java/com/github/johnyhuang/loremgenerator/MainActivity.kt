package com.github.johnyhuang.loremgenerator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import com.github.johnyhuang.loremgenerator.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    private val loremIpsum: MyData = MyData("Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vitae ultricies leo integer malesuada. Sed sed risus pretium quam vulputate dignissim suspendisse in est. Odio pellentesque diam volutpat commodo sed. Dictum fusce ut placerat orci. Libero enim sed faucibus turpis in eu mi bibendum neque. Ipsum a arcu cursus vitae. At volutpat diam ut venenatis tellus in. Penatibus et magnis dis parturient montes nascetur ridiculus. Tincidunt arcu non sodales neque sodales ut etiam sit amet. Lorem ipsum dolor sit amet consectetur adipiscing. Platea dictumst quisque sagittis purus sit amet volutpat. Nibh praesent tristique magna sit. Fames ac turpis egestas integer eget.")

    private val trumpIpsum: MyData = MyData("Trump Ipsum", "Lorem Ipsum is the single greatest threat. We are not - we are not keeping up with other websites. Lorem Ipsum best not make any more threats to your website. It will be met with fire and fury like the world has never seen. Does everybody know that pig named Lorem Ipsum? An ‘extremely credible source’ has called my office and told me that Barack Obama’s placeholder text is a fraud.")

    private val hodorIpsum: MyData = MyData("Hodor Ipsum", "Hodor. Hodor hodor, hodor. Hodor hodor hodor hodor hodor. Hodor. Hodor! Hodor hodor, hodor; hodor hodor hodor. Hodor. Hodor hodor; hodor hodor - hodor, hodor, hodor hodor. Hodor, hodor. Hodor. Hodor, hodor hodor hodor; hodor hodor; hodor hodor hodor! Hodor hodor HODOR! Hodor hodor... Hodor hodor hodor...")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.loremIpsum = loremIpsum
        binding.trumpIpsum = trumpIpsum
        binding.hodorIpsum = hodorIpsum
        binding.creatorButton.setOnClickListener{pickCreatorName(it)}
        binding.creatorText.setOnClickListener{changeCreatorName(it)}

        val aa = ArrayAdapter.createFromResource(this, R.array.type_of_lorem, android.R.layout.simple_spinner_dropdown_item)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.loremSelector.adapter = aa

        binding.loremSelector.onItemSelectedListener = this


    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val currentType: String = binding.loremSelector.getItemAtPosition(p2).toString()
        when (currentType) {
            "Lorem Ipsum" -> {
                binding.creatorText.text = loremIpsum.type
                binding.loremText.text = loremIpsum.ipsum
            }
            "Trump Ipsum" -> {
                binding.creatorText.text = trumpIpsum.type
                binding.loremText.text = trumpIpsum.ipsum
            }
            "Hodor Ipsum" -> {
                binding.creatorText.text = hodorIpsum.type
                binding.loremText.text = hodorIpsum.ipsum
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }


    private fun pickCreatorName(view: View){
        binding.apply {
            loremIpsum?.ipsum = loremText.text.toString()
            invalidateAll()
            creatorText.text = binding.creatorText.text.toString()
            loremText.visibility = View.GONE
            creatorButton.visibility = View.GONE
            creatorText.visibility = View.VISIBLE

        }

        //hide keyboard
        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun changeCreatorName(view: View){

        binding.apply {
            creatorText.visibility = View.GONE
            loremText.visibility = View.VISIBLE
            creatorButton.visibility = View.VISIBLE
            loremText.requestFocus()
        }



        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.showSoftInput(binding.loremText, 0)

    }
}
