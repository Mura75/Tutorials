package app.epicenter.com.rotationprj.models;

/**
 * Created by Murager on 12.03.2016.
 */
public class Student {

    String name;

    String surname;

    String email;

    String phone;

    String university;

    public Student(String name, String surname,
                   String university) {
        this.name = name;
        this.surname = surname;
        this.university = university;
    }

    public Student(String name, String surname,
                   String email, String phone,
                   String university) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.university = university;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", university='" + university + '\'' +
                '}';
    }
}
