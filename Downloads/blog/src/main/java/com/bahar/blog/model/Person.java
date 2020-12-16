package com.bahar.blog.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "phone may not be empty")
    private Long phone;
    @NotBlank(message = "lockVersion may not be empty")
    private Long lockversion;
    //    @NotEmpty(message = "Name may not be empty")
//    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    @NotBlank(message = "firstName may not be empty")
    private String firstName;
    //    @NotEmpty(message = "lastName may not be empty")
//    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    @NotBlank(message = "LastName may not be empty")
    private String lastName;
    private String country;
    //    @NotEmpty(message = "gender may not be empty")
//    @Size(min = 2, max = 10, message = "Name must be between 2 and 10 characters long")
    @NotBlank(message = "gender may not be empty")
    private String gender;
    @NotBlank(message = "description may not be empty")
    private String description;
    @NotBlank(message = "email may not be empty")
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank(message = "natinalCode may not be empty")
    @Column(unique = true)
    private int natinalCode;
    @OneToMany(mappedBy = "person")
    private List<Comment> commentList;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Long getLockversion() {
        return lockversion;
    }

    public void setLockversion(Long lockversion) {
        this.lockversion = lockversion;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNatinalCode() {
        return natinalCode;
    }

    public void setNatinalCode(int natinalCode) {
        this.natinalCode = natinalCode;
    }

//    public List<Comment> getCommentList() {
//        return commentList;
//    }
//
//    public void setCommentList(List<Comment> commentList) {
//        this.commentList = commentList;
//    }

//    public Person() {
//    }


//    public long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//
//    public long getPhone() {
//        return phone;
//    }
//
//    public void setPhone(Long phone) {
//        this.phone = phone;
//    }
//
//
//    public long getLockversion() {
//        return lockversion;
//    }
//
//    public void setLockversion(Long lockversion) {
//        this.lockversion = lockversion;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getNatinalCode() {
//        return natinalCode;
//    }
//
//    public void setNatinalCode(int natinalCode) {
//        this.natinalCode = natinalCode;
//    }
}
