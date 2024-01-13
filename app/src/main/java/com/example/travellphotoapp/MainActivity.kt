package com.example.travellphotoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var currentImage = 0
    lateinit var image:ImageView
    var places= arrayOf("Varanasi","Tajmahal","Chilika Lake","Rajastan Historicall Place","India Gate","Golden Temple")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next =findViewById<ImageButton>(R.id.btnNext)
        val prev =findViewById<ImageButton>(R.id.btnPrev)
        val placeName= findViewById<TextView>(R.id.tvName)

        next.setOnClickListener {
            var idCurrentImageString= "pic$currentImage"
            var idCurrentImageInt=this.resources.getIdentifier(idCurrentImageString ,"id",packageName)
             image = findViewById(idCurrentImageInt)
            image.alpha=0f
            currentImage=(6+currentImage+1)%6
            var  idImageShowString="pic"+currentImage
            var idImageToShowInt=this.resources.getIdentifier(idImageShowString ,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha=1f

            placeName.text=places[currentImage]
        }
        prev.setOnClickListener {
            var idCurrentImageString= "pic$currentImage"
            var idCurrentImageInt=this.resources.getIdentifier(idCurrentImageString ,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha=0f
            currentImage=(6+currentImage-1)%6
            var  idImageShowString="pic"+currentImage
            var idImageToShowInt=this.resources.getIdentifier(idImageShowString ,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha=1f
            placeName.text=places[currentImage]

        }
    }
}