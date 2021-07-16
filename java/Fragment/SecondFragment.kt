package com.pedro.fragmentapplication.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pedro.fragmentapplication.Adapter.AdapterSecond
import com.pedro.fragmentapplication.Model.ModelSecond
import com.pedro.fragmentapplication.Model.dataModelSecond
import com.pedro.fragmentapplication.Network.ApiService
import com.pedro.fragmentapplication.R
import com.pedro.fragmentapplication.databinding.FragmentSecondBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SecondFragment : Fragment() {

    lateinit var binding: FragmentSecondBinding
    private val list = ArrayList<dataModelSecond>()


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        getDataFromApi()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }



    private fun getDataFromApi(){
        binding.recycleViewHealth.setHasFixedSize(true)
        binding.recycleViewHealth.layoutManager = LinearLayoutManager(context)

        ApiService.instance.getDataApi()
            .enqueue(object : Callback<ModelSecond> {
                override fun onResponse(call: Call<ModelSecond>, response: Response<ModelSecond>) {

                    val listOf = response.body()?.articles
                    listOf?.let { list.addAll(it) }

                    val adapter = AdapterSecond(list)

                    binding.recycleViewHealth.adapter = adapter

                }

                override fun onFailure(call: Call<ModelSecond>, t: Throwable) {

                }

            })

    }




}

