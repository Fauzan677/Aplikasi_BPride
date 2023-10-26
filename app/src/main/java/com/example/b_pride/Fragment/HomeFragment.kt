package com.example.b_pride.fragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.b_pride.data.MainAdapter
import com.example.b_pride.data.remote.ApiService
import com.example.b_pride.data.remote.UsersItem
import com.example.b_pride.databinding.FragmentHomeBinding
import com.example.b_pride.util.constant.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {
    private lateinit var viewAdapter: MainAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewManager = LinearLayoutManager(context)


        getUsersData()
    }

    private fun getUsersData() {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        retrofit.getUsers().enqueue(object : retrofit2.Callback<List<UsersItem>> {
            override fun onResponse(
                call: retrofit2.Call<List<UsersItem>>,
                response: retrofit2.Response<List<UsersItem>>
            ){
                if (response.isSuccessful){
                    val data = response.body()!!
                    viewAdapter = MainAdapter(requireContext(), data)
                    binding.itemRv.apply {
                        layoutManager = viewManager
                        adapter = viewAdapter

                    }
                }
            }

            override fun onFailure(call: retrofit2.Call<List<UsersItem>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

}