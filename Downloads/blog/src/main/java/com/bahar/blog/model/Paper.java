package com.bahar.blog.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
public class Paper {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long lockVersion;
    private String body;
//    @NotNull
//    @Size(min=3,max = 20)
@NotBlank(message = "title may not be empty")
    private String title;
   // private String tags;
    @NotBlank(message = "description may not be empty")
    private String description;
  //  private LocalDateTime currentDate;
 //   private LocalDateTime releaseDate;
 //   private LocalDateTime modifiedDate;
   @NotNull(message = "likes may not be empty")
    private Integer likes;
    @NotNull(message = "rates may not be empty")
    private Integer rates;
    @OneToMany(mappedBy = "paper")
    private List<Comment> commentsList;
    @OneToMany(mappedBy = "papers")
    private List<Tag> tagsList;

    public Paper() {
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getRates() {
        return rates;
    }

    public void setRates(Integer rates) {
        this.rates = rates;
    }

    public List<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    public List<Tag> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<Tag> tagsList) {
        this.tagsList = tagsList;
    }

//    public Paper() {
//    }
//
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public long getLockVersion() {
//        return lockVersion;
//    }
//
//    public void setLockVersion(long lockVersion) {
//        this.lockVersion = lockVersion;
//    }
//
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }

    //    @Basic
//    @Column(name="tag")
//    public String getTags() {
//        return tags;
//    }
//
//    public void setTags(String tags) {
//        this.tags = tags;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

//    public LocalDateTime getCurrentDate() {
//        return currentDate;
//    }
//
//    public void setCurrentDate(LocalDateTime currentDate) {
//        this.currentDate = currentDate;
//    }
//
//    public LocalDateTime getReleaseDate() {
//        return releaseDate;
//    }
//
//    public void setReleaseDate(LocalDateTime releaseDate) {
//        this.releaseDate = releaseDate;
//    }
//
//    public LocalDateTime getModifiedDate() {
//        return modifiedDate;
//    }
//
//    public void setModifiedDate(LocalDateTime modifiedDate) {
//        this.modifiedDate = modifiedDate;
//    }

//    public Integer getLike() {
//        return likes;
//    }
//
//    public void setLike(Integer like) {
//        this.likes = likes;
//    }
//
//    public Integer getRate() {
//        return rates;
//    }
//
//    public void setRate(Integer rate) {
//        this.rates = rates;
//    }
}
