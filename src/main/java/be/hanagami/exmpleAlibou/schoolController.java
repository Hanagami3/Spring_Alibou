package be.hanagami.exmpleAlibou;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class schoolController {

    private final SchoolRepository schoolRepository;

    public schoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public School create(
            @RequestBody School school
    ){
        return schoolRepository.save(school);
    }

    @GetMapping("/schools")
    public List<School> create(){
        return schoolRepository.findAll();
    }
}
