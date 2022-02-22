package com.hakanerdogmus.kotlinrunnables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.hakanerdogmus.kotlinrunnables.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var number = 0
    var runnable : Runnable = Runnable {  }
    var handler : Handler = Handler(Looper.getMainLooper())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun startButton(view : View){
        number = 0

        runnable = object : Runnable{  // runnable object olarak atıyoruz.
            override fun run() {    //starta basıldığında arka planda çalışacak kod bloğu.
                number = number + 1
                binding.textView.text = "Timer: ${number}"

                handler.postDelayed(runnable,1000) //arka planda çalışma aralığını belirlediğimiz kısım.

            }

        }
        handler.post(runnable)

    }


    fun stopButton(view : View){
        handler.removeCallbacks(runnable) //hangi runnable işlemden kaldırılacak ise o runnable durdurulur.
        number = 0
        binding.textView.text = "Time: ${number}"


    }





}