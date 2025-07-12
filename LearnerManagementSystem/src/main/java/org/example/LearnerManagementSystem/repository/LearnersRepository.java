package org.example.LearnerManagementSystem.repository;

import org.example.LearnerManagementSystem.entity.Learners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnersRepository extends JpaRepository<Learners, Long> {

     Learners findByLearnerName(String learnerName);
}
