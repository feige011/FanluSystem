package com.sunnyweather.fsystem.activity.ui.notifications;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.sunnyweather.fsystem.R;

import java.util.List;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ViewHolder> {

    private List<Project> projectList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView projectName;
        TextView projectSketch;

        public ViewHolder(View view){
            super(view);
            projectName = (TextView)view.findViewById(R.id.item_project_name);
            projectSketch=(TextView)view.findViewById(R.id.item_sketch_project);

        }
    }

    public ProjectListAdapter(List<Project> projectList){
        this.projectList = projectList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Project project = projectList.get(position);
        holder.projectName.setText(project.getProjectName());
        holder.projectSketch.setText(project.getSketchProject());
    }

    @Override
    public int getItemCount() {

//        Log.e("feifei",projectList.size()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return projectList.size();
    }
}
