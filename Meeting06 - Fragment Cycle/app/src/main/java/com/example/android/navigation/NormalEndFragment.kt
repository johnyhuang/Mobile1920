package com.example.android.navigation


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentNormalEndBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class NormalEndFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentNormalEndBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_normal_end, container, false)
        binding.buttonNext.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_normalEndFragment_to_gameFragment)
        }
        Timber.i("In onCreateView")
        return binding.root
    }

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
