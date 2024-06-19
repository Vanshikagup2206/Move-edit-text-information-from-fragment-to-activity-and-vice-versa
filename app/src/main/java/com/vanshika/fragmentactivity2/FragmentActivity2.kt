package com.vanshika.fragmentactivity2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.vanshika.fragmentactivity2.databinding.FragmentActivity2Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentActivity2.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentActivity2 : Fragment(), ActivityInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var mainActivity : MainActivity?=null
    var btnChangeActivityText : Button?=null
    var binding : FragmentActivity2Binding ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        mainActivity?.activityInterface = this

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentActivity2Binding.inflate(layoutInflater)
        return binding?.root
//        return inflater.inflate(R.layout.fragment_activity2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        btnChangeActivityText = view.findViewById(R.id.buttonChangeActivityText)
        binding?.buttonChangeActivityText?.setOnClickListener {
            if(binding?.etEnterSomething?.text?.toString()?.isNullOrEmpty() == true){
                binding?.etEnterSomething?.error = resources.getString(R.string.enter_something)
            }
            else{
                mainActivity?.changeActivityText("${binding?.etEnterSomething?.text?.toString()}")
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentActivity2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentActivity2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun changeFragmentText(string: String) {
        binding?.buttonChangeActivityText?.setText(string.toString())
    }
}