package com.sunnyweather.fsystem.hao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;

import com.sunnyweather.fsystem.R;
import com.sunnyweather.fsystem.activity.LoginForgetPassword;
import com.sunnyweather.fsystem.activity.ui.notifications.Project;
import com.sunnyweather.fsystem.model.Me;
import com.sunnyweather.fsystem.model.ReleaseProject;
import com.sunnyweather.fsystem.model.ReleaseProjectMe;
import com.sunnyweather.fsystem.model.ThingsRegister;
import com.sunnyweather.fsystem.model.ThingsViewModel;

import java.util.Observable;


import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;


public class CreateProjectActivity extends AppCompatActivity {
    private EditText projectName;
    private EditText sketchProject;
    private EditText mainProject;
    private Toolbar titleBar;
    private TextView titleTV;
    private ThingsViewModel viewModel=new ThingsViewModel();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_create_project);
        init();

        viewModel.getLiveReleaseProject().observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                if(o!=null){
                    if(o instanceof ReleaseProject){
                        ReleaseProject things=(ReleaseProject)o;
                        if(things.getCode()==200){
                            Log.e("feifei",things.getMsg());
                            Log.e("feifei",things.getData().getNewProject().getMainProject());
                            finish();

                        }else{
                            Log.e("feifei",things.getCode()+"");
                        }
                    }
                }
            }
            });

        }

    private void init(){
        initControlBind();
        initToolBar();
    }

    @SuppressLint("NewApi")
    private void initControlBind(){
        projectName = (EditText)findViewById(R.id.create_project_et_projectName);
        sketchProject = (EditText)findViewById(R.id.create_project_et_sketchProject);
        mainProject = (EditText)findViewById(R.id.create_project_et_mainProject);
        titleBar = (Toolbar)findViewById(R.id.create_project_tb_toolbar);
        titleTV=(TextView)findViewById(R.id.create_project_tv_create);

    }

    private void initToolBar(){
        setSupportActionBar(titleBar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
        titleBar.setNavigationIcon(R.drawable.back);
        titleBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        titleTV.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Project project=new Project( projectName.getText().toString(), sketchProject.getText().toString(),mainProject.getText().toString());
                ReleaseProjectMe releaseProjectMe=new ReleaseProjectMe(Me.account,project);
                viewModel.ReleaseProject(releaseProjectMe);
            }
        });
    }
}
