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
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import timber.log.Timber

class AboutFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Timber.i("In onCreateView")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
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
