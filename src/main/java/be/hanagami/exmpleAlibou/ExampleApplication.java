package be.hanagami.exmpleAlibou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(ExampleApplication.class, args);

		//MyFirstClass myFirstClass = new MyFirstClass();
		//MyFirstClass myFirstClass = ctx.getBean("myBean", MyFirstClass.class);
		//System.out.println(myFirstClass.sayHello());

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellStory());

	}

//	//@Bean
//	public MyFirstClass myFirstClass() {
//		return new MyFirstClass();
//	}
}
