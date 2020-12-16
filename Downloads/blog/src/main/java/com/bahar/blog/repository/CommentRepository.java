package com.bahar.blog.repository;

import com.bahar.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    void deleteById(Long id);
    Comment findCommentById(Long id);
    Comment findCreatorById(Long id);
}
