package com.example.oii_project.interface_items

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import com.example.oii_project.App
import com.example.oii_project.R
import com.example.oii_project.data.dto.ActionAnswer
import com.example.oii_project.data.dto.ActionData
import com.example.oii_project.data.dto.CommentsData
import com.example.oii_project.utils.Utility
import com.example.oii_project.viewModel.ActionViewModel
import com.example.oii_project.viewModel.CommentsViewModel
import io.reactivex.observers.DisposableSingleObserver
import okhttp3.Response

class CustomImageButton(context:FragmentActivity?,view: View,listener: OnButtonTouchListener){
    var status: Status = Status.DOWNLOAD
    enum class Status(val status: Int) {
        DOWNLOAD(0),
        START(1),
        STOP(2),
    }

    init{
        val multiFunctionalImageButton: ImageView =view.findViewById(R.id.multy_func_imageButton)
        multiFunctionalImageButton.setOnClickListener{
            when(status){
                Status.DOWNLOAD->{
                    multiFunctionalImageButton.setImageResource(R.drawable.ic_start)
                    Toast.makeText(context,"Загрузилось!",Toast.LENGTH_SHORT).show();
                    listener.doAction(2)
                    status = Status.START
                }
                Status.START->{
                    multiFunctionalImageButton.setImageResource(R.drawable.ic_stop)
                    Toast.makeText(context,"Остановилось!",Toast.LENGTH_SHORT).show();
                    listener.doAction(4)
                    status = Status.STOP
                }
                Status.STOP->{
                    multiFunctionalImageButton.setImageResource(R.drawable.ic_start)
                    Toast.makeText(context,"Запустилось!",Toast.LENGTH_SHORT).show();
                    listener.doAction(5)
                    status = Status.START
                }
            }
        }
    }

    interface OnButtonTouchListener{
        fun doAction(actionType:Long)
    }
}