package com.example.recyclerprac

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.Log
import com.example.recyclerprac.viewmodel.RecentViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import com.example.recyclerprac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val vm : RecentViewModel by viewModel()
    lateinit var recentAdapter: RecentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivity = this

        recentAdapter = RecentAdapter(vm.getRecentData().data, this@MainActivity)
        //binding.rv.setLayoutManager(LinearLayoutManager(this@MainActivity))
        Log.d("datadata",vm.getRecentData().data.get(1).name)
        Log.d("datadata","asdfasdf")

        var itemDecoration :RecyclerView.ItemDecoration = DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        binding.rv.addItemDecoration(itemDecoration)
        binding.rv.adapter = recentAdapter
        Log.d("datadata", "adapter set")

        /*
        ItemTouchHelper
        ItemTouchHelper.Callback
        */
    }


}

