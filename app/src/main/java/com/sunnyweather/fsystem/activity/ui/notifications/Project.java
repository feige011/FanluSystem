package com.sunnyweather.fsystem.activity.ui.notifications;

public class Project {
    private String projectName;
    private String sketchProject;
    private String mainProject;

    public Project(String projectName, String sketchProject, String mainProject) {
        this.projectName = projectName;
        this.sketchProject = sketchProject;
        this.mainProject = mainProject;
    }

    public String getSketchProject() {
        return sketchProject;
    }

    public void setSketchProject(String sketchProject) {
        this.sketchProject = sketchProject;
    }

    public String getMainProject() {
        return mainProject;
    }

    public void setMainProject(String mainProject) {
        this.mainProject = mainProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
