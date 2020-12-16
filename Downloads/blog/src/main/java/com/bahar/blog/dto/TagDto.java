package com.bahar.blog.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Getter @Setter
public class TagDto {

    private String name;
  //  @Getter @Setter
    private String description;
//    @Getter @Setter
    private Long lockVersion;

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
//    public Long getLockVersion() {
//        return lockVersion;
//    }
//
//    public void setLockVersion(Long lockVersion) {
//        this.lockVersion = lockVersion;
//    }
}
