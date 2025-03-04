package be.hanagami.exmpleAlibou;

import jakarta.persistence.*;

@Entity
@Table(name = "T_STUDENT")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(
            name = "c-fname",
            length = 20
    )
    private String Firstname;
    private String Lastname;

    @Column(
            unique = true
    )
    private String Email;
    private int age;

    @Column(
            updatable = false
    )
    private String some_column;

    public Student() {
    }

    public Student(String firstname, String lastname, String email, int age) {
        Firstname = firstname;
        Lastname = lastname;
        Email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
