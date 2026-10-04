package com.xadice.devtrack.dto.request;

import com.xadice.devtrack.model.GoalStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class GoalRequest {

    @NotBlank
    private String title;

    private String description;

    @NotBlank
    private String technology;

    @NotNull
    private GoalStatus status;

    @NotNull
    @Min(0)
    @Max(100)
    private Integer progress;

    public GoalRequest() {
    }

    public GoalRequest(
            String title,
            String description,
            String technology,
            GoalStatus status,
            Integer progress
    ) {
        this.title = title;
        this.description = description;
        this.technology = technology;
        this.status = status;
        this.progress = progress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public GoalStatus getStatus() {
        return status;
    }

    public void setStatus(GoalStatus status) {
        this.status = status;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }
}