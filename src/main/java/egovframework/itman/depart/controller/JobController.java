package egovframework.itman.depart.controller;

import egovframework.itman.depart.dto.JobDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

    @GetMapping
    public String job() {
        return "test";
    }

    @PostMapping
    public JobDto.Response insert(JobDto.Request dto) {
        return null;
    }
}
