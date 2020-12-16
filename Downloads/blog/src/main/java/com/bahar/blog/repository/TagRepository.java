package com.bahar.blog.repository;

import com.bahar.blog.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {

    void deleteById(Long id);
     Tag findTagById(Long id);

}
