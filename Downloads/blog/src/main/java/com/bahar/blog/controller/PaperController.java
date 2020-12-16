package com.bahar.blog.controller;

import com.bahar.blog.model.Paper;
import com.bahar.blog.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/paper")
public class PaperController {

    //    @RequestMapping(path = "/paper/{id}" ,method = RequestMethod.GET)
//    public String getResponse(@PathVariable(value = "id") String id){
//        return "ID : " + id;
//    }
//
//    @RequestMapping(path = "/paper/{id}/{title}" ,method = RequestMethod.GET)
//    public String getResponse(@PathVariable(value = "id") String id, @PathVariable(value = "title") String title){
//        return "ID : " + id +", Title is : " + title;
//    }
    @Autowired
    private PaperRepository paperRepository;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK )
    public List<Paper> papers() {
        return paperRepository.findAll();
    }

    @GetMapping("/body/{id}")
    @ResponseStatus(HttpStatus.OK )
    public Paper getPaperBody(@PathVariable Long id) {
        return paperRepository.findPaperBodyById(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK )
    public Paper getPaperBodyAndTitle(@PathVariable Long id) {
       return paperRepository.findPaperBodyAndTitleById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED )
    public Paper save(@Valid @RequestBody Paper paper) {
        return paperRepository.save(paper);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK )
    public void deletePaper(@PathVariable Long id) {
        paperRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK )
    public Paper replacePaper(@Valid @RequestBody Paper newPaper, @PathVariable Long id) {

        return paperRepository.findById(id)
                .map(Paper -> {
                    Paper.setDescription(newPaper.getDescription());
                    Paper.setTitle(newPaper.getTitle());
                    Paper.setRates(newPaper.getRates());
                    Paper.setLikes(newPaper.getLikes());
                    Paper.setBody(newPaper.getBody());

                    return paperRepository.save(Paper);
                })
                .orElseGet(() -> {
                    newPaper.setId(id);
                    return paperRepository.save(newPaper);
                });
    }
}
