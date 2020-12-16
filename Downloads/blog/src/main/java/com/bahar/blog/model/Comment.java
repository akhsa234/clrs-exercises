package com.bahar.blog.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Data
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long lockVersion;
    @Column(unique = true)
    private String code;
    private String body;
    //    @NotNull
//   @Size(min=2,max=20)
    @NotBlank(message = "name may not be empty.")
    private String name;
    @NotBlank(message = "creator may not be empty.")
    private String creator;
    @NotBlank(message = "description may not be empty.")
    private String description;
    //private LocalTime currentDate;
    private Integer likes;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "paper_ID")
    private Paper paper;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "personID")
    private Person person;

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLockVersion() {
        return lockVersion;
    }

    public void setLockVersion(Long lockVersion) {
        this.lockVersion = lockVersion;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }


//    public Comment() {
//    }


//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        id = id;
//    }
////
//
//    public long getLockVersion() {
//        return lockVersion;
//    }
//
//    public void setLockVersion(long lockVersion) {
//        this.lockVersion = lockVersion;
//    }
////
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//     public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//    public String getCreator() {
//        return creator;
//    }
//
//    public void setCreator(String creator) {
//        this.creator = creator;
//    }
//
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
////    public LocalTime getCurrentDate() {
////        return currentDate;
////    }
////
////    public void setCurrentDate(LocalTime currentDate) {
////        this.currentDate = currentDate;
////    }
//
//    public Integer getLikes() {
//        return likes;
//    }
//
//    public void setLikes(Integer likes) {
//        this.likes = likes;
//    }
}
