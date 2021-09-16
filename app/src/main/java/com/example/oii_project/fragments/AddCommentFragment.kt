package com.example.oii_project.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.oii_project.R


class AddCommentFragment : Fragment() {
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_comment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners(view)
    }

    private fun setListeners(view:View){
        navController = view.findNavController()

        val buttonAddReview: Button = view.findViewById(R.id.add_comment_button)
        buttonAddReview.setOnClickListener{
            navController.navigate(R.id.action_addCommentFragment_to_applicationDetailsFragment)
        }

    }

}