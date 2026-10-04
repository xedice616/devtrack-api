package com.xadice.devtrack.dto.response;

import com.xadice.devtrack.model.GoalStatus;

import java.time.LocalDateTime;

public class GoalResponse {

    private Long id;
    private String title;
    private String description;
    private String technology;
    private GoalStatus status;
    private Integer progress;
    private LocalDateTime createdAt;

    public GoalResponse() {
    }

    public GoalResponse(
            Long id,
            String title,
            String description,
            String technology,
            GoalStatus status,
            Integer progress,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.technology = technology;
        this.status = status;
        this.progress = progress;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTechnology() {
        return technology;
    }

    public GoalStatus getStatus() {
        return status;
    }

    public Integer getProgress() {
        return progress;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}