package org.example.LearnerManagementSystem.repository;

import org.example.LearnerManagementSystem.entity.Cohorts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CohortRepository extends JpaRepository<Cohorts, Long> {
    // This interface extends JpaRepository to provide CRUD operations for Cohort entities
    // Additional custom query methods can be defined here if needed
}
