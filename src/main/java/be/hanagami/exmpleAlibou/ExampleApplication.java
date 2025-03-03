package be.hanagami.exmpleAlibou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		var app = new SpringApplication(ExampleApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "test "));
		var ctx = app.run(args);

		//var ctx = SpringApplication.run(ExampleApplication.class, args);

		//MyFirstClass myFirstClass = new MyFirstClass();
		//MyFirstClass myFirstClass = ctx.getBean("myBean", MyFirstClass.class);
		//System.out.println(myFirstClass.sayHello());

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellStory());
		System.out.println(myFirstService.getJavaVersion());
		System.out.println(myFirstService.getOsName());
		System.out.println(myFirstService.readProp());
		System.out.println("--------------------------------");
		System.out.println(myFirstService.getCustomPropertyMyInt());


		System.out.println(myFirstService.getCustomPropertyFromAnotherFile());
		System.out.println(myFirstService.getCustomPropertyFromAnotherFile2());
		System.out.println(myFirstService.getCustomPropertyInt());
		System.out.println(myFirstService.getCustomProperty());


	}

//	//@Bean
//	public MyFirstClass myFirstClass() {
//		return new MyFirstClass();
//	}
}
