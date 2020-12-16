package com.bahar.blog.controller;

import com.bahar.blog.dto.TagDto;
import com.bahar.blog.service.ResourceNotFoundException;
import com.bahar.blog.service.TagService;
import com.bahar.blog.util.TagMapper;
import com.bahar.blog.model.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }



    @GetMapping
    @ResponseStatus(HttpStatus.OK )
    public List<TagDto> getTags() {
        return tagService.fetchAllTags();

    }
// get -- id

    /*
     @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PostDto createPost(@RequestBody PostDto postDto) {
        Post post = convertToEntity(postDto);
        Post postCreated = postService.createPost(post));
        return convertToDto(postCreated);
    }
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
   // @ResponseBody
    public TagDto createTag(@Valid @RequestBody TagDto tagDto){
        return tagService.save(tagDto);
    }


//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED )
//    public Tag save(@Valid @RequestBody TagDto tagDto) {
//        return tagService.save(tagDto);
//    }


//    @PutMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void updatePost(@RequestBody PostDto postDto) {
//        Post post = convertToEntity(postDto);
//        postService.updatePost(post);
//    }

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK )
//   public Tag replaceTag(@Valid @RequestBody TagDto PostedTagDto, @PathVariable Long id) {
//
//        return tagService.findRequestedTagById(PostedTagDto,id);
//                .map(tag -> {
//                    tag.setName(newTag.getName());
//                    tag.setLockVersion(newTag.getLockVersion());
//                    tag.setDescription(newTag.getDescription());
//                    return tagRepository.save(tag);
//                })
//                .orElseGet(() -> {
//                    newTag.setId(id);
//                    return tagRepository.save(newTag);
//                });
//    }

    @PutMapping("/put/{id}")
   // @ResponseBody
    public ResponseEntity<TagDto> updateTag(@PathVariable(value = "id") Long TagId,
                                         @Valid @RequestBody TagDto tagDtoDetails) throws ResourceNotFoundException {

        TagDto tagDto= tagService.findDemandedTagById(tagDtoDetails,TagId);


//        Tag tag = tagRepository.findById(TagId)
//                .orElseThrow(() -> new ResourceNotFoundException(TagId));
//
//        tag.setDescription(tagDetails.getDescription());
//        tag.setLockVersion(tagDetails.getLockVersion());
//        tag.setName(tagDetails.getName());
//        final Tag updatedTag = tagRepository.save(tag);
      return ResponseEntity.ok(tagDto);
    }

    //mr.mahmoud's ideas
    @PatchMapping("/patch-v/{TagIds}/{tagDescription}")
    public ResponseEntity patchMethods(@PathVariable Long TagIds,
                                            @PathVariable String tagDescription){
        tagService.MyPatchService(TagIds,tagDescription);

       return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }


//@RequestParam
    //@PatchMapping("/patch/{id}")
    ////   // @ResponseBody
    ////   public ResponseEntity<Tag> changeTagOneElement(@RequestParam Map<String, Object> modifiedTag, @PathVariable Long id) {


//    @PatchMapping("/patch/{id}")
//   // @ResponseBody
//   public ResponseEntity<Tag> changeTagOneElement(@MatrixVariable Map<String, Object> modifiedTag, @PathVariable Long id) {
//
//        // Fetch the data from the database
//       Tag tagIDFromDB = tagService.findTagById(id);
//
////        //Fetch the data from the database
////        Tag tagIDFromDB = tagRepository.findTagById(id);
////
////        //Map the persistent data to the REST dto
////        //This is done to enforce REST validation groups
////        TagMapper tagMapper = new TagMapper();
////        Tag tagModel = tagMapper.mapDBToTagRestModel(tagIDFromDB);
////        // ex:-->   ...RestModel ..variableRestModel = mapPersistenceModelToRestModel(....);
////
////        //apply the changes to the REST model.
////        changesTag.forEach(
////                (change, value) -> {
////                    switch (change) {
////                        case "name":
////                            tagModel.setName((String) value);
////                            break;
////                        case "description":
////                            tagModel.setDescription((String) value);
////                            break;
////                        case "lockVersion":
////                            tagModel.setLockVersion((Long) value);
////                            break;
////                    }
////                }
////        );
////
////        tagMapper.mapPostManDataToDB( tagModel ,tagIDFromDB);
////        tagRepository.save(tagIDFromDB);
////        return  ResponseEntity.ok().build();
//        return  ResponseEntity.ok().build();
//    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK )
    void deleteTag(@PathVariable Long id) {
        // long ids=1;
        tagService.deleteIntendedTag(id);
    }

}

/*
@PatchMapping("/heavyresource")
    public ResponseEntity<?> partialUpdateName(
            @RequestBody Student partialUpdate ) {
 Student a=repository.findById(partialUpdate.getId());
 a.setName(partialUpdate.getName());
        return ResponseEntity.ok(repository.save(a));
    }
 */