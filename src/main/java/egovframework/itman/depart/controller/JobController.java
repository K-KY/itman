package egovframework.itman.depart.controller;

import egovframework.itman.depart.dto.JobDto;
import egovframework.itman.depart.model.service.interfaces.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public String job() {
        return "test";
    }

    @PostMapping
    public JobDto.Response insert(@RequestBody JobDto.Request dto) {
        return jobService.insert(dto).toDto();
    }
}
