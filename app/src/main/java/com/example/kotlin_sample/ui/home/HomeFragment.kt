package com.example.kotlin_sample.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_sample.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val edtfirstname: EditText = binding.edtFirstName;
        val edtlastname: EditText = binding.edtLastName

        binding.button.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE

            if (edtfirstname.text.isNullOrEmpty()) {
                edtfirstname.setError("first name should notbe empty")
                binding.progressBar.visibility = View.INVISIBLE

            } else if (edtlastname.text.isNullOrEmpty()) {
                edtlastname.setError("Last name should not be empty")
                binding.progressBar.visibility = View.INVISIBLE
            } else {

               /* var userAdded =  homeViewModel.login(edtfirstname.text.toString(), edtlastname.text.toString()).value
              Log.v("TAG","USern added ="+userAdded)
                binding.progressBar.visibility = View.INVISIBLE
                edtfirstname.setText("")
                edtlastname.setText("")*/
                activity?.let { it1 ->
                    homeViewModel.login(edtfirstname.text.toString(), edtlastname.text.toString()).observe(
                        it1, Observer(){
                            Log.v("TAG","USern added ="+it+"    "+homeViewModel.useradded.value)
                            if(HomeRepository.isloading == true) {


                                if (homeViewModel.useradded.value == true) {
                                    Log.v("TAG","Success in View"+it+"    "+homeViewModel.useradded.value)
                                    Toast.makeText(
                                        activity,
                                        "Added data successfully",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    binding.progressBar.visibility = View.INVISIBLE
                                    HomeRepository.isloading = false

                                    edtfirstname.setText("")
                                    edtlastname.setText("")
                                } else {
                                    binding.progressBar.visibility = View.INVISIBLE
                                    HomeRepository.isloading = false
                                    Log.v("TAG","Failure in View"+it+"    "+homeViewModel.useradded.value)
                                    Toast.makeText(
                                        activity,
                                        "Failure in adding the data",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }



                        })
                }
           }
        }

        /* homeViewModel.text.observe(viewLifecycleOwner) {
             textView.text = it
         }*/

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}