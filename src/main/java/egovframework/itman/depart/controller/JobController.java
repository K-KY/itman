package egovframework.itman.depart.controller;

import egovframework.itman.depart.dto.JobDto;
import egovframework.itman.depart.model.service.interfaces.JobService;
import egovframework.itman.util.dto.SortDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public Page<JobDto.Response> read(int page, int size, SortDto sort) {
        PageRequest pageRequest = PageRequest.of(page - 1, size, sort.getSorts());
        return jobService.read(pageRequest);
    }

    @PostMapping
    public JobDto.Response insert(@RequestBody JobDto.Request dto) {
        return jobService.insert(dto).toDto();
    }

    @PatchMapping
    public JobDto.Response update(@RequestBody JobDto.Request dto) {
        return jobService.update(dto).toDto();
    }

    @GetMapping("/count")
    public Long countJobs() {
        return jobService.countAll();
    }

    @GetMapping("/count/{del}")
    public Long countJobs(@PathVariable boolean del) {
        return jobService.count(del);
    }
}
