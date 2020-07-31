package com.sunnyweather.fsystem.activity.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sunnyweather.fsystem.R
import com.sunnyweather.fsystem.hao.CreateProjectActivity
import com.sunnyweather.fsystem.model.ThingsViewModel
import com.sunnyweather.fsystem.network.Repository
import kotlinx.android.synthetic.main.activity_user.*
import java.util.*

class NotificationsFragment : Fragment() {
    val viewModel by lazy { ViewModelProvider(this).get(ThingsViewModel::class.java)}
    private val projectList: ArrayList<Project> = ArrayList()
    private var recyclerView: RecyclerView? = null
    private var titleBar: Toolbar? = null
    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.layout_project_list, container, false)
//        val textView: TextView = root.findViewById(R.id.text_notifications)
//        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.user_toolbar_textView?.text="我的项目"
        activity?.user_toolbar_right_textView?.text="发布"
        activity?.user_toolbar_right_textView?.setOnClickListener {
            val intent=Intent(this.context,CreateProjectActivity::class.java)
            startActivity(intent)
        }
        init()


//        viewModel.LivesearchProject.observe(this, Observer {
//            val things=it.getOrNull()
//            if(things!=null){
//                if(things.code==200){
//                    Log.e("feifei",things.data.data[0].mainProject)
//                }else{
//                    Log.e("feifei","22222222222222222222")
//                }
//            }else{
//                Log.e("feifei","things.data[0].toString()")
//            }
//        })
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.user_toolbar_right_textView?.text=""

    }

    fun init() {
        initControlBind()
        initToolBar()
        initProjectListData()
//        initProjectListView()
    }

    fun initControlBind() {
        recyclerView =
            activity?.findViewById<View>(R.id.project_list_recyclerview) as RecyclerView
    }

    private fun initToolBar() {

    }

    fun initProjectListData() {
//        for (i in 0..9) {
//            val project = Project("项目$i", null, null)
//            projectList.add(project)
//        }
//       viewModel.SearchAllProject("1")
        Repository.searchAllProject().observe(this, Observer {
            val things=it.getOrNull()
            if(things!=null){
                if(things.code==200){
//                    Log.e("feifei",things.data.data[0].projectName)
                    for(i in things.data.data){
                        Log.e("feifei",things.data.data[0].projectName)
                        Log.e("feifei",things.data.data[0].sketchPorject)
                        Log.e("feifei",things.data.data[0].mainProject)

                        val m=Project(i.projectName,i.sketchPorject,i.mainProject)
                        projectList.add(m)
//                        projectList.add(m)
//                        projectList.add(m)
//                        projectList.add(m)
//                        projectList.add(m)

                    }
                    initProjectListView()

                }else{
                    Log.e("feifei","22222222222222222222")
                }
            }else{
                Log.e("feifei","things.data[0].toString()")
            }
        })
    }

    fun initProjectListView() {
        val layoutManager = LinearLayoutManager(this.context)
        recyclerView?.setLayoutManager(layoutManager)
        val adapter = ProjectListAdapter(projectList)
        recyclerView?.setAdapter(adapter)
        recyclerView?.addItemDecoration(ProjectListItemDecoration(ProjectListItemDecoration.px2dp(8F)))
    }
}