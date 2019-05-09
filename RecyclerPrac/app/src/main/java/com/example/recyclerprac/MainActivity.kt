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

class MainActivity : AppCompatActivity(), ItemDragListener {

    lateinit var binding: ActivityMainBinding
    private val vm : RecentViewModel by viewModel()
    lateinit var recentAdapter: RecentAdapter
    lateinit var mItemTouchHelper: ItemTouchHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivity = this

        recentAdapter = RecentAdapter(vm.getRecentData().data, this@MainActivity, this)
        //binding.rv.setLayoutManager(LinearLayoutManager(this@MainActivity)) // xml파일에서 설정해줌..
        Log.d("datadata",vm.getRecentData().data.get(1).name)
        Log.d("datadata","asdfasdf")

        // 아이템 순서바꾸기 위한 콜백함수객체 만들어 넘겨주기
        var mCallback: ItemTouchHelper.Callback = RecentItemTouchHelperCallback(recentAdapter)
        mItemTouchHelper = ItemTouchHelper(mCallback)
        mItemTouchHelper.attachToRecyclerView(binding.rv)

        var itemDecoration :RecyclerView.ItemDecoration = DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        binding.rv.addItemDecoration(itemDecoration)
        binding.rv.adapter = recentAdapter
        Log.d("datadata", "adapter set")

    }

    override fun onStartDrag(vh: RecyclerView.ViewHolder) {
        mItemTouchHelper.startDrag(vh)
    }

}

