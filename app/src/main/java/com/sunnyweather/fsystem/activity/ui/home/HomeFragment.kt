package com.sunnyweather.fsystem.activity.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunnyweather.fsystem.R
import com.sunnyweather.fsystem.activity.ui.notifications.Project
import com.sunnyweather.fsystem.activity.ui.notifications.ProjectListAdapter
import com.sunnyweather.fsystem.model.boardThings
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
     val msgList= ArrayList<boardThings>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        homeViewModel =
//            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        val m= boardThings("震惊！有人说飞哥做的公告栏竟","feige011","feige011")
        msgList.add(m)
        msgList.add(m)
        msgList.add(m)
        msgList.add(m)
        msgList.add(m)
        val layoutMessage = LinearLayoutManager(context)
        root.boardRecyclerView?.layoutManager = layoutMessage
        val adapter =  BulletinboardAdapter(msgList)
        root.boardRecyclerView?.adapter = adapter

        return root
    }

}