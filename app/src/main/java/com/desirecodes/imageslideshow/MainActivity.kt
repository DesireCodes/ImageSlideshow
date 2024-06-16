package com.desirecodes.imageslideshow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.desirecodes.imageslider.ImageSlider
import com.desirecodes.imageslider.constants.ActionTypes
import com.desirecodes.imageslider.constants.AnimationTypes
import com.desirecodes.imageslider.constants.ScaleTypes
import com.desirecodes.imageslider.interfaces.ItemChangeListener
import com.desirecodes.imageslider.interfaces.ItemClickListener
import com.desirecodes.imageslider.interfaces.TouchListener
import com.desirecodes.imageslider.models.SlideModel

/**
 * Created by Deniz Coşkun on 6/23/2020.
 * denzcoskun@hotmail.com
 * İstanbul
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageSlider = findViewById<ImageSlider>(R.id.image_slider) // init imageSlider

        val imageList = ArrayList<SlideModel>() // Create image list
        imageList.add(SlideModel("https://media.istockphoto.com/id/1339686801/photo/cloud-computing.jpg?s=2048x2048&w=is&k=20&c=NKi1-84KT0XpLKfN1-a6XX7Lp_mS54yz6n8KIrkCrko=", "The future is our hands."))
        imageList.add(SlideModel("https://cdn.pixabay.com/photo/2016/11/29/12/13/fence-1869401_1280.jpg"))
        imageList.add(SlideModel("https://cdn.pixabay.com/photo/2016/04/20/19/05/horse-1341775_1280.jpg"))

        imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)

        imageSlider.setSlideAnimation(AnimationTypes.ZOOM_OUT)

        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {
                // You can listen here.
                println("normal")
            }

            override fun doubleClick(position: Int) {
                // Do not use onItemSelected if you are using a double click listener at the same time.
                // Its just added for specific cases.
                // Listen for clicks under 250 milliseconds.
                println("its double")
            }
        })

        imageSlider.setItemChangeListener(object : ItemChangeListener {
            override fun onItemChanged(position: Int) {
                //println("Pos: " + position)
            }
        })

        imageSlider.setTouchListener(object : TouchListener {
            override fun onTouched(touched: ActionTypes, position: Int) {
                if (touched == ActionTypes.DOWN){
                    imageSlider.stopSliding()
                } else if (touched == ActionTypes.UP ) {
                    imageSlider.startSliding(1000)
                }
            }
        })
    }

}
