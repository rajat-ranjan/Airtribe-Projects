package org.example.LearnerManagementSystem.service;

import org.example.LearnerManagementSystem.entity.Learners;
import org.example.LearnerManagementSystem.repository.LearnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnersManagementService {

    @Autowired
    private LearnersRepository learnersRepository;

    public Learners createLearner(Learners learner) {
        return learnersRepository.save(learner);
    }

    public List<Learners> fetchLearners() {
        return learnersRepository.findAll();
    }

    public Learners fetchLearnerById(long learnerId) {
        return learnersRepository.findById(learnerId).get();
//                .orElseThrow(() -> new RuntimeException("Learner not found with id: " + learnerId));
    }

    public Learners fetchLearnerByName(String learnerName) {
        Learners learner = learnersRepository.findByLearnerName(learnerName);
        if (learner == null) {
            throw new RuntimeException("Learner not found with name: " + learnerName);
        }
        return learner;
    }
}
