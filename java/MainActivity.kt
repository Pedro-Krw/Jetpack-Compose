package com.pedro.fragmentapplication

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pedro.fragmentapplication.Fragment.EndFragment
import com.pedro.fragmentapplication.Fragment.FirtsFragment
import com.pedro.fragmentapplication.Fragment.SecondFragment
import com.pedro.fragmentapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
    }


    override fun onStart() {
        super.onStart()
        Fragment()
    }


    private fun Fragment(){
        val firtsFragment = FirtsFragment()
        val secondFragment = SecondFragment()
        val endFragment = EndFragment()


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.dataFragment , firtsFragment)
            addToBackStack(null)
            commit()



            binding.btSatu.setOnClickListener {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.dataFragment , firtsFragment)
                    addToBackStack(null)
                    commit()
                }
            }


            binding.btDua.setOnClickListener {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.dataFragment , secondFragment)
                        addToBackStack(null)
                        commit()
                }
            }
        }

        binding.btTiga.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.dataFragment , endFragment)
                addToBackStack(null)
                commit()
            }
        }



    }


}