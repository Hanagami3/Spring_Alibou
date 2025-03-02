package be.hanagami.exmpleAlibou;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private final MyFirstClass myFirstClass;

    //@Autowired not mandatory if constructor with private final fields
    public MyFirstService(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellStory() {
        return "the dependency is saying : " + myFirstClass.sayHello();
    }
}
