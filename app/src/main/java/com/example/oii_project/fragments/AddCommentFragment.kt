package com.example.oii_project.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import coil.load
import com.example.oii_project.App
import com.example.oii_project.R
import com.example.oii_project.data.dto.ActionData
import com.example.oii_project.utils.Utility
import com.example.oii_project.viewModel.ActionViewModel
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.observers.DisposableSingleObserver
import okhttp3.ResponseBody

@AndroidEntryPoint
class AddCommentFragment : Fragment() {
    private lateinit var navController: NavController
    private val viewModel: ActionViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_comment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var imageUrl = arguments?.getString("imageUrl")
        var appName = arguments?.getString("appName")

        var appCover: ImageView = view.findViewById(R.id.add_comment_image)
        appCover.load(imageUrl!!)
        var _appName:TextView = view.findViewById(R.id.add_comment_app_name)
        _appName.text = appName
        setListeners(view)
    }

    private fun setListeners(view:View){
        navController = view.findNavController()

        val buttonAddReview: Button = view.findViewById(R.id.add_comment_button)
        buttonAddReview.setOnClickListener{
            addReviewWithRating(view)
            navController.navigate(R.id.action_addCommentFragment_to_applicationDetailsFragment,arguments)
        }
    }

    private fun addReviewWithRating(view:View){
        var appId:Long = arguments?.getLong("appId")!!
        addReview(appId,view)
        addRating(appId,view)

    }

    private fun addReview(appId: Long,view:View){
        var textInputComment: TextInputEditText = view.findViewById(R.id.comment_text_input)
        val data = textInputComment.text.toString()
        viewModel.makeAction(
            ActionData(appId,data,1)
            ,object : DisposableSingleObserver<ResponseBody>() {
                override fun onError(e: Throwable) {
                    Utility.showToast("Error", App.appContext)
                }
                override fun onSuccess(t: ResponseBody) {
                }
            }
        )
    }

    private fun addRating(appId: Long,view:View){
        var commentRating: RatingBar = view.findViewById(R.id.add_comment_ratingbar)
        val data = commentRating.rating.toString()
        viewModel.makeAction(
            ActionData(appId,data,3)
            ,object : DisposableSingleObserver<ResponseBody>() {
                override fun onError(e: Throwable) {
                    Utility.showToast("Error", App.appContext)
                }
                override fun onSuccess(t: ResponseBody) {
                }
            }
        )
    }

}