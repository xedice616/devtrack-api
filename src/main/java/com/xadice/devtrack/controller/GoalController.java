package com.xadice.devtrack.controller;

import com.xadice.devtrack.dto.request.GoalRequest;
import com.xadice.devtrack.dto.response.GoalResponse;
import com.xadice.devtrack.model.User;
import com.xadice.devtrack.service.GoalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping
    public ResponseEntity<GoalResponse> createGoal(
            @Valid @RequestBody GoalRequest request,
            Authentication authentication
    ) {

        User user = (User) authentication.getPrincipal();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(goalService.createGoal(request, user));
    }

    @GetMapping
    public ResponseEntity<List<GoalResponse>> getGoals(
            Authentication authentication
    ) {

        User user = (User) authentication.getPrincipal();

        return ResponseEntity.ok(
                goalService.getUserGoals(user)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoalResponse> getGoalById(
            @PathVariable Long id,
            Authentication authentication
    ) {

        User user = (User) authentication.getPrincipal();

        return ResponseEntity.ok(
                goalService.getGoalById(id, user)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<GoalResponse> updateGoal(
            @PathVariable Long id,
            @Valid @RequestBody GoalRequest request,
            Authentication authentication
    ) {

        User user = (User) authentication.getPrincipal();

        return ResponseEntity.ok(
                goalService.updateGoal(id, request, user)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(
            @PathVariable Long id,
            Authentication authentication
    ) {

        User user = (User) authentication.getPrincipal();

        goalService.deleteGoal(id, user);

        return ResponseEntity.noContent().build();
    }
}