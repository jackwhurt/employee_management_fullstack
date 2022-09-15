package com.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.signature.qual.Identifier;
import org.checkerframework.common.aliasing.qual.Unique;

import javax.validation.constraints.NotNull;

public class Projects {

    @NotNull
    @Identifier
    @Unique
    private int ProjectID;
    @Unique
    private String ProjectName;

    @JsonCreator
    public Projects(@JsonProperty("ProjectID") @Identifier @Unique int projectID,
                    @JsonProperty("ProjectName") @Unique String projectName) {
        ProjectID = projectID;
        ProjectName = projectName;
    }

    public int getProjectID() {
        return ProjectID;
    }

    public void setProjectID(int projectID) {
        ProjectID = projectID;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }
}
