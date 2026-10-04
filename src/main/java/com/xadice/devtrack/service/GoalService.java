package com.xadice.devtrack.service;

import com.xadice.devtrack.dto.request.GoalRequest;
import com.xadice.devtrack.dto.response.GoalResponse;
import com.xadice.devtrack.model.Goal;
import com.xadice.devtrack.model.User;
import com.xadice.devtrack.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public GoalResponse createGoal(GoalRequest request, User user) {

        Goal goal = new Goal();

        goal.setTitle(request.getTitle());
        goal.setDescription(request.getDescription());
        goal.setTechnology(request.getTechnology());
        goal.setStatus(request.getStatus());
        goal.setProgress(request.getProgress());
        goal.setUser(user);

        return mapToResponse(goalRepository.save(goal));
    }

    public List<GoalResponse> getUserGoals(User user) {
        return goalRepository
                .findAllByUser(user)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public GoalResponse getGoalById(Long id, User user) {

        Goal goal = goalRepository
                .findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new RuntimeException("Goal not found")
                );

        return mapToResponse(goal);
    }

    public GoalResponse updateGoal(
            Long id,
            GoalRequest request,
            User user
    ) {

        Goal goal = goalRepository
                .findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new RuntimeException("Goal not found")
                );

        goal.setTitle(request.getTitle());
        goal.setDescription(request.getDescription());
        goal.setTechnology(request.getTechnology());
        goal.setStatus(request.getStatus());
        goal.setProgress(request.getProgress());

        return mapToResponse(goalRepository.save(goal));
    }

    public void deleteGoal(Long id, User user) {

        Goal goal = goalRepository
                .findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new RuntimeException("Goal not found")
                );

        goalRepository.delete(goal);
    }

    private GoalResponse mapToResponse(Goal goal) {
        return new GoalResponse(
                goal.getId(),
                goal.getTitle(),
                goal.getDescription(),
                goal.getTechnology(),
                goal.getStatus(),
                goal.getProgress(),
                goal.getCreatedAt()
        );
    }
}