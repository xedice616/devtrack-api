package com.xadice.devtrack.repository;

import com.xadice.devtrack.model.Goal;
import com.xadice.devtrack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GoalRepository extends JpaRepository<Goal, Long> {

    List<Goal> findAllByUser(User user);

    Optional<Goal> findByIdAndUser(Long id, User user);
}