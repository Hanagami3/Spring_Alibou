//package be.hanagami.exmpleAlibou;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.annotation.PropertySources;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Service;
//
//@Service
////@PropertySource("classpath:custom.properties")
////@PropertySources({
////        @PropertySource("classpath:custom.properties"),
////        @PropertySource("classpath:custom2.properties")
////
////})
//public class MyFirstService {
//
//    //@Autowired pas recommandé mais si par là, pas besoin de constructorsans le final
//    private final MyFirstClass myFirstClass;
//
//    private final Environment environment;
//
//    @Value("Hello Hanagami")
//    private String customProperty;
//
//    @Value("${my.prop}")
//    private String customPropertyFromAnotherFile;
//
//    @Value("${my.prop.2}")
//    private String customPropertyFromAnotherFile2;
//
//    @Value("123")
//    private Integer customPropertyInt;
//
//    //!\ au cast si des char dedans, exception
//    @Value("${my.custom.property.int}")
//    private Integer customPropertyMyInt;
//
//
//    //@Autowired not mandatory if constructor with private final fields
//    public MyFirstService(
//            @Qualifier("bean2") MyFirstClass myFirstClass,
//            Environment environment) {
//        //( MyFirstClass myFirstClass) {
//        this.myFirstClass = myFirstClass;
//        this.environment = environment;
//    }
//
//    public String tellStory() {
//        return "the dependency is saying : " + myFirstClass.sayHello();
//    }
//
//    public String getJavaVersion() {
//        return environment.getProperty("java.version");
//    }
//
//    public String getOsName() {
//        return environment.getProperty("os.name");
//    }
//
//    //from application.properties
//    public String readProp() {
//        return environment.getProperty("my.custom.property");
//    }
//
//    public String getCustomPropertyFromAnotherFile() {
//        return customPropertyFromAnotherFile;
//    }
//
//    public Integer getCustomPropertyInt() {
//        return customPropertyInt;
//    }
//
//    public String getCustomProperty() {
//        return customProperty;
//    }
//
//    public String getCustomPropertyFromAnotherFile2() {
//        return customPropertyFromAnotherFile2;
//    }
//
//    public Integer getCustomPropertyMyInt() {
//        return customPropertyMyInt;
//    }
//
////    @Autowired
////    public void setEnvironment(Environment environment) {
////        this.environment = environment;
////    }
//
//    // 3method pour injecter
////    @Autowired
////    public void injectDependencies(@Qualifier("myBean") MyFirstClass myFirstClass) {
////        this.myFirstClass = myFirstClass;
////    }
//
//    //4e methode pour injecter setter injection
////    @Autowired
////    public void setMyFirstClass(MyFirstClass myFirstClass) {
////        this.myFirstClass = myFirstClass;
////    }
//}
