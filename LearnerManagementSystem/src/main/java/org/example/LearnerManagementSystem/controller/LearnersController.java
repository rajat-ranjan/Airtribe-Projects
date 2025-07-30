package org.example.LearnerManagementSystem.controller;

import jakarta.validation.Valid;
import org.example.LearnerManagementSystem.entity.Learners;
import org.example.LearnerManagementSystem.exception.LearnerNotFoundException;
import org.example.LearnerManagementSystem.service.LearnersManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LearnersController {

    @Autowired
    private LearnersManagementService learnersManagementService;

    @PostMapping("/learners")
    public Learners createLearner(@Valid @RequestBody Learners learner) {
        // Here you would typically save the learner to a database
        // For now, we will just return the learner object
        return learnersManagementService.createLearner(learner);
    }

/*    @GetMapping("/learners")
    public List<Learners> fetchLearners() {
        // This is a placeholder method to demonstrate fetching learners
        // In a real application, you would return a list of learners from the database
        return learnersManagementService.fetchLearners();
    }*/

/*    @GetMapping("/learners/{learnerId}")
    public Learners fetchLearnerById(@PathVariable long learnerId) {
        // This method would typically fetch a learner by their ID from the database
        // For now, we will return a dummy learner object
        return learnersManagementService.fetchLearnerById(learnerId);
    }*/

   /* @GetMapping("/learners/name/{learnerName}")
    public Learners fetchLearnerByName(@PathVariable String learnerName) {
        // This method would typically fetch a learner by their name from the database
        // For now, we will return a dummy learner object
        return learnersManagementService.fetchLearnerByName(learnerName);
    }*/

    @GetMapping("/learners")
    public List<Learners> fetchAllLearnersMultiMode(@RequestParam(value = "learnerName", required = false) String learnerName,
                                                    @RequestParam(value = "learnerId", required = false) Long learnerId)
            throws LearnerNotFoundException {
        if (learnerName == null && learnerId == null) {
            return learnersManagementService.fetchLearners();
        }

        List<Learners> learnersList = new ArrayList<>();
        if (learnerId != null) {
            Learners learner = learnersManagementService.fetchLearnerById(learnerId);
            if (learner != null) {
                learnersList.add(learner);
                return learnersList;
            }
        }

        Learners learners = learnersManagementService.fetchLearnerByName(learnerName);
        learnersList.add(learners);
        return learnersList;
    }

    @ExceptionHandler(LearnerNotFoundException.class)
    public ResponseEntity handleLearnerNotFoundException(LearnerNotFoundException ex) {
        // Handle the LearnerNotFoundException and return a meaningful response
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}