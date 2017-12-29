package com.example.malin.apitest

import android.content.Context
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import org.jetbrains.anko._LinearLayout
import org.jetbrains.anko.linearLayout

/**
 * Created by malin on 28.12.2017.
 */
class myImage {
    fun ShowURLimage(iv_url:String?, io_imgView: ImageView, io_context:Context){
        Glide.with( io_context ).load(iv_url).into(io_imgView)
    }
}
