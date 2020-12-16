package com.bahar.blog.controller;

import com.bahar.blog.model.Comment;
import com.bahar.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> comments(){
        return commentRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment getCreatorOfComment(Long id){
        return commentRepository.findCreatorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment save(@Valid @RequestBody Comment comment){
        return commentRepository.save(comment);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK )
    public Comment replaceComment(@Valid @RequestBody Comment newComment, @PathVariable Long id) {

        return commentRepository.findById(id)
                .map(comment -> {
                    comment.setBody(newComment.getBody());
                    comment.setLockVersion(newComment.getLockVersion());
                    comment.setDescription(newComment.getDescription());
                    comment.setCode(newComment.getCode());
                    comment.setCreator(newComment.getCreator());
                    comment.setLikes(newComment.getLikes());
                    comment.setName(newComment.getName());

                    return commentRepository.save(comment);
                })
                .orElseGet(() -> {
                    newComment.setId(id);
                    return commentRepository.save(newComment);
                });
    }
}
