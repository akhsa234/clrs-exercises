package com.bahar.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NotEmpty(message = "Name may not be empty")
//    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    @NotBlank(message = "Name may not be empty.")
    private String name;
    @NotBlank(message = "Description may not be empty.")
    private String description;
    @NotNull(message="lockVersion may not be empty.")
    private Long lockVersion;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="paper_ID")
    private Paper papers;

//    public void setDescription(String tagBody) {
//    }

//    public Tag() {
//    }

//    public Tag(String name, String description,Long lockVersion) {
//        this.name=name;
//        this.description=description;
//        this.lockVersion=lockVersion;
//    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
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
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
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

}
