package com.example.oii_project.interface_items

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.example.oii_project.R

class CustomImageButton(context:FragmentActivity?,view: View){
    var status: Status = Status.DOWNLOAD

    enum class Status(val status: Int) {
        DOWNLOAD(0),
        START(1),
        STOP(2),
    }

    init{
        val multiFunctionalImageButton: ImageView =view.findViewById(R.id.multy_func_imageButton)
        Toast.makeText(context,"Text!",Toast.LENGTH_SHORT).show();
        multiFunctionalImageButton.setOnClickListener{
            when(status){
                Status.DOWNLOAD->{
                    multiFunctionalImageButton.setImageResource(R.drawable.ic_start)
                    status = Status.START
                }
                Status.START->{
                    multiFunctionalImageButton.setImageResource(R.drawable.ic_stop)
                    status = Status.STOP
                }
                Status.STOP->{
                    multiFunctionalImageButton.setImageResource(R.drawable.ic_start)
                    status = Status.START

                }
            }
        }
    }
}