package org.example.LearnerManagementSystem.controller.v1;

import org.example.LearnerManagementSystem.entity.Cohorts;
import org.example.LearnerManagementSystem.service.CohortManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class CohortV1Controller {

    @Autowired
    private CohortManagementService cohortManagementService;

    @GetMapping("/cohorts")
    public PageResponse<Cohorts> createCohort(@RequestParam(value = "pageSize", defaultValue = "10") int pageSize, @RequestParam(value = "sortBy", defaultValue = "cohortId") String sortBy, @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber, @RequestParam(value = "sortDir", defaultValue = "asc") String sortDir) {
        if (pageNumber < 0) {
            pageNumber = 0;
        }
        if (pageSize > 2000) {
            pageSize = 10;
        }
        if (sortBy.equalsIgnoreCase("cohortId") || sortBy.equalsIgnoreCase("cohortName")) {
            sortBy = "cohortId";
        }
        if (!(sortDir.equalsIgnoreCase("ascc") || sortDir.equalsIgnoreCase("desc"))) {
            sortDir = "asc";
        }

       return cohortManagementService.getPaginatedCohorts(pageSize, sortBy, pageNumber, sortDir);
    }
}
