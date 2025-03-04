package be.hanagami.exmpleAlibou;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController//need to have spring-boot-starter-web in the pom.xml
public class FirstController {

//    @GetMapping("/hello")
//    public String sayHello(){
//        return "Hello from my first Controller";
//    }

    @GetMapping("/hello2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello2(){
        return "Hello from my first Controller - 2";
    }

    @PostMapping("/post")
    public String post(
            @RequestBody String message
    ){
        return "Request accepted and messahe is " + message;
    }

    @PostMapping("/post-order")
    public String post(
            @RequestBody Order order
    ){
        return "Request accepted and order is " + order.toString();
    }

    @PostMapping("/post-order-record")
    public String postRecord(
            @RequestBody OrderRecord order
    ){
        return "Request accepted and order is " + order.toString();
    }

    @GetMapping("/hello/{user-name}")
    //@GetMapping("/hello/{userName}") Si exactement le même nom, spring va reconnaitre
    public String pathVar(
            @PathVariable("user-name") String userName
    ){
        return "my value = " + userName;
    }

    @GetMapping("/hello")
    public String paramVar(
            @RequestParam("user-name") String userName,
            @RequestParam("user-lastname") String lastname
    ){
        return "my value = " + userName + " " + lastname;
    }

}
