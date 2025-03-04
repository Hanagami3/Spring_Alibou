//package be.hanagami.exmpleAlibou;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//@Configuration
//@Profile("test")
//public class ApplicationConfig {
//
//    @Bean//("myBean")// si pas de nom ou de qualifier ==> nom pour spring = nom de la method
//    @Qualifier("bean1")
//    //@Profile("dev")
//    public MyFirstClass myFirstClass() {
//        return new MyFirstClass("First bean");
//    }
//
//    @Bean
//    @Qualifier("bean2") //qualifier ne remplace pas le nom de la method maus donne indo supplémentaire
//    //@Profile("test")
//    public MyFirstClass mySecondClass() {
//        return new MyFirstClass("Second bean");
//    }
//
//    @Bean
//    ///@Primary
//    public MyFirstClass myThirdClass() {
//        return new MyFirstClass("Third bean");
//    }
//}
