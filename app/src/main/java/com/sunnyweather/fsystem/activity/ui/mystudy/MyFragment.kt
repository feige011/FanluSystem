package com.sunnyweather.fsystem.activity.ui.mystudy

import com.sunnyweather.fsystem.activity.ui.home.BulletinboardAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunnyweather.fsystem.R
import com.sunnyweather.fsystem.model.boardThings
import kotlinx.android.synthetic.main.fragment_my.*

class MyFragment: Fragment() {
    private lateinit var myViewModel: MyViewModel
    val msgList= ArrayList<boardThings>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myViewModel =
            ViewModelProviders.of(this).get(MyViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_my, container, false)
//        val textView: TextView = root.findViewById(R.id.text_my)
//        myViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val boardThings= boardThings("feifei","feige011","????????????")
        msgList.add(boardThings)
        msgList.add(boardThings)
        msgList.add(boardThings)
        msgList.add(boardThings)
        msgList.add(boardThings)
        msgList.add(boardThings)
        val layoutMessage = LinearLayoutManager(context)
        boardRecyclerView2?.layoutManager = layoutMessage
        val adapter = BulletinboardAdapter(msgList)
        boardRecyclerView2?.adapter = adapter
    }

}