package com.example.miniapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import com.example.miniapp.databinding.ActivityDetailedBinding
import java.util.*

class DetailedActivity : AppCompatActivity() {
    private lateinit var tts: TextToSpeech
    private lateinit var binding : ActivityDetailedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var spanish = intent.getStringExtra("spanish")
        var english = intent.getStringExtra("english")
        var menus = intent.getStringExtra("menus")

        binding.txtSpanish.text = "Spanish $menus of"
        binding.txtSpanishWord.text = spanish
        binding.txtEnglish.text = "is an English $menus of"
        binding.txtEnglishWord.text = english

        binding.btnSpeakEnglish.setOnClickListener {
            tts = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
                if(it==TextToSpeech.SUCCESS){
                    tts.language = Locale.US
                    tts.setSpeechRate(1.0f)
                    tts.speak(english, TextToSpeech.QUEUE_ADD, null)
                }
            })
         }

        binding.btnSpeakSpanish.setOnClickListener {
            tts = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
                if(it==TextToSpeech.SUCCESS){
                    tts.language = Locale("es","ES")
                    tts.setSpeechRate(1.0f)
                    tts.speak(spanish, TextToSpeech.QUEUE_ADD, null)
                }
            })
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    /*
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts.setLanguage(Locale("es", "ES"))
            //val result = tts.setLanguage(Locale("eng","ENG"))

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Language is not supported
                // Handle error accordingly
                Toast.makeText(applicationContext,"Language is not supported",Toast.LENGTH_SHORT).show()
            }
        } else {
            // Initialization failed
            // Handle error accordingly
            Toast.makeText(applicationContext,"Language is not supported 1",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        if (tts.isSpeaking) {
            tts.stop()
        }
        tts.shutdown()
        super.onDestroy()
    } */
}