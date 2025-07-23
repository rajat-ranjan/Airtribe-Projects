package org.example.LearnerManagementSystem.service;

import org.example.LearnerManagementSystem.entity.Learners;
import org.example.LearnerManagementSystem.exception.LearnerNotFoundException;
import org.example.LearnerManagementSystem.repository.LearnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  /*  public Learners fetchLearnerById(long learnerId) {
        Optional<Learners> learnerOptional = learnersRepository.findById(learnerId);
        if(learnerOptional.isPresent()){
            return learnerOptional.get();
        }
        throw new RuntimeException("Learner not found with id: " + learnerId);
//        return learnersRepository.findById(learnerId).get();
//                .orElseThrow(() -> new RuntimeException("Learner not found with id: " + learnerId));
    }*/

    public Learners fetchLearnerById(long learnerId) throws LearnerNotFoundException {
        Optional<Learners> learnerOptional = learnersRepository.findById(learnerId);
        if(learnerOptional.isPresent()){
            return learnerOptional.get();
        }
        throw new LearnerNotFoundException("Learner not found with id: " + learnerId);
    }

    public Learners fetchLearnerByName(String learnerName) throws LearnerNotFoundException {
        Learners learner = learnersRepository.findByLearnerName(learnerName);
        if (learner == null) {
            throw new LearnerNotFoundException("Learner not found with Name: " + learnerName);
        }
        return learner;
    }
}
