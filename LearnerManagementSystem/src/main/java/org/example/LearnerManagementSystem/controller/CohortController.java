package org.example.LearnerManagementSystem.controller;

import org.example.LearnerManagementSystem.entity.Cohorts;
import org.example.LearnerManagementSystem.entity.Learners;
import org.example.LearnerManagementSystem.exception.LearnerNotFoundException;
import org.example.LearnerManagementSystem.service.CohortManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CohortController {

    @Autowired
    private CohortManagementService cohortManagementService;

    @PostMapping("/cohorts")
    public Cohorts createCohort(@RequestBody Cohorts cohort) {
        // This method will handle the creation of a new cohort
        // In a real application, you would typically save the cohort to a database here
        // For now, we will just return the cohort object as a placeholder
        return cohortManagementService.createCohort(cohort);
    }

    @PostMapping("/assignLearnersToCohorts")
    public Cohorts assignLearnersToCohorts(@RequestParam("learnerId") Long learnerId,
                                         @RequestParam("cohortId") Long cohortId) throws LearnerNotFoundException {
        // This method will handle the assignment of a learner to a cohort
        // In a real application, you would typically update the cohort in the database here
        // For now, we will just return the updated cohort object as a placeholder
        return cohortManagementService.assignLearnersToCohorts(learnerId, cohortId);
    }

    @GetMapping("/cohorts")
    public List<Cohorts> getCohorts(){
        return cohortManagementService.findAllCohorts();
    }

    @PostMapping("/cohorts/{cohortId}/learners")
    public Cohorts assignAndCreateLearnersToCohorts(@RequestBody List<Learners> learners,
                                                    @PathVariable("cohortId") Long cohortId){
        return cohortManagementService.assignAndCreateLearnersToCohort(learners, cohortId);
    }

}
