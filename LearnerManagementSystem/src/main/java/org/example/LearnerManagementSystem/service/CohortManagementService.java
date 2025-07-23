package org.example.LearnerManagementSystem.service;

import jakarta.transaction.Transactional;
import org.example.LearnerManagementSystem.entity.Cohorts;
import org.example.LearnerManagementSystem.entity.Learners;
import org.example.LearnerManagementSystem.exception.LearnerNotFoundException;
import org.example.LearnerManagementSystem.repository.CohortRepository;
import org.example.LearnerManagementSystem.repository.LearnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CohortManagementService {

    @Autowired
    private CohortRepository cohortRepository;
    @Autowired
    private LearnersManagementService learnersManagementService;

    @Autowired
    private LearnersRepository learnersRepository;

    public Cohorts createCohort(Cohorts cohort) {
        // This method will handle the creation of a new cohort
        // In a real application, you would typically save the cohort to a database here
        // For now, we will just return the cohort object as a placeholder
        return cohortRepository.save(cohort);
    }

    public Cohorts assignLearnersToCohorts(Long learnerId, Long cohortId) throws LearnerNotFoundException {
        Optional<Cohorts> fetchedCohorts = cohortRepository.findById(cohortId);
        Learners fetchedlearners = learnersManagementService.fetchLearnerById(learnerId);
        Cohorts cohort = fetchedCohorts.get();


        List<Learners> learnersList = cohort.getLearnersList();
        learnersList.add(fetchedlearners);
        cohort.setLearnersList(learnersList);

        return cohortRepository.save(cohort);
    }

    public List<Cohorts> findAllCohorts() {
        return cohortRepository.findAll();
    }

//    @Transactional
    public Cohorts assignAndCreateLearnersToCohort(List<Learners> learners, Long cohortId) {
        Cohorts cohorts = cohortRepository.findById(cohortId).get();

        cohorts.getLearnersList().addAll(learners);
//        learnersRepository.saveAll(learners); - removed because using cascaded functionality
        return cohortRepository.save(cohorts);
    }
}
