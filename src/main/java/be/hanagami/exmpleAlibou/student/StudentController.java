package be.hanagami.exmpleAlibou.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//need to have spring-boot-starter-web in the pom.xml
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(
            //@RequestBody Student student
            @RequestBody StudentDto dto
    ){
        return this.studentService.saveStudent(dto);
    }


    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto findStudentsById(
            @PathVariable("student-id") Integer id
    ){
      return studentService.findStudentsById(id);
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> findStudentsByName(
            @PathVariable("student-name") String  name
    ){
      return studentService.findStudentsByName(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer studentId
    ){
        studentService.delete(studentId);
    }

//    @GetMapping("/hello")
//    public String sayHello(){
//        return "Hello from my first Controller";
//    }

//
//    @GetMapping("/hello2")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public String sayHello2(){
//        return "Hello from my first Controller - 2";
//    }


//    @PostMapping("/post-order")
//    public String post(
//            @RequestBody Order order
//    ){
//        return "Request accepted and order is " + order.toString();
//    }
//
//    @PostMapping("/post-order-record")
//    public String postRecord(
//            @RequestBody OrderRecord order
//    ){
//        return "Request accepted and order is " + order.toString();
//    }
//
//    @GetMapping("/hello/{user-name}")
//    //@GetMapping("/hello/{userName}") Si exactement le même nom, spring va reconnaitre
//    public String pathVar(
//            @PathVariable("user-name") String userName
//    ){
//        return "my value = " + userName;
//    }
//
//    @GetMapping("/hello")
//    public String paramVar(
//            @RequestParam("user-name") String userName,
//            @RequestParam("user-lastname") String lastname
//    ){
//        return "my value = " + userName + " " + lastname;
//    }

}
