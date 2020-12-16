package com.bahar.blog.service;

import com.bahar.blog.dto.TagDto;
import com.bahar.blog.dto.ConvertToTagEntity;
import com.bahar.blog.dto.ConvertToTagDto;
import com.bahar.blog.model.Tag;
import com.bahar.blog.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    private final TagRepository tagRepository;
    private final ConvertToTagDto converterToTagDto;
    private final  ConvertToTagEntity convertToTagEntity;
    @Autowired
    public TagService(TagRepository tagRepository, ConvertToTagDto converterToTagDto, ConvertToTagEntity convertToTagEntity) {
        this.tagRepository = tagRepository;
        this.converterToTagDto = converterToTagDto;
        this.convertToTagEntity = convertToTagEntity;
    }


    public List<TagDto> fetchAllTags() { // call which convertor ?? -->
        return tagRepository.findAll()
                .stream()
                .map(converterToTagDto::convert)
                .collect(Collectors.toList());
    }

    public TagDto save(TagDto tagDto) {
        Tag   tag= convertToTagEntity.convert(tagDto); ///change tagDto --> tag
        Tag tagCreated = tagRepository.save(tag); // save in db
         return converterToTagDto.convert(tagCreated); //I need to  send tagDto to view
      //  return tagConverter(tagCreated);
    }

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



//    public Optional<Object> findAvailableById(Long id) {
//        return  tagRepository.findById(newTag,id)
//        .map(tag -> {
//            tag.setName(newTag.getName());
//            tag.setLockVersion(newTag.getLockVersion());
//            tag.setDescription(newTag.getDescription());
//            return tagRepository.save(tag);
//        })
//                .orElseGet(() -> {
//                    newTag.setId(id);
//                    return tagRepository.save(newTag);
//                });
//    }



//    @PutMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void updatePost(@RequestBody PostDto postDto) {
//        Post post = convertToEntity(postDto);
//        postService.updatePost(post);
//    }

    //findRequestedTagById(newTagDto,id)
    public Tag findRequestedTagById(TagDto PostedTagDto, Long id) {
//       Tag tagId=  tagRepository.findTagById(id);
//            Tag   tagDtoTotag =  convertToTagEntity.convert(PostedTagDto);
//return  tagId;
//            return tagRepository.save(tagDtoTotag);
//                    convertToTagEntity.convert(PostedTagDto);
//
//                    return tagRepository.save(tag);
//                });

        return  tagRepository.findById(id)
                .map(tag-> {
                    convertToTagEntity.convert(PostedTagDto);

                    return tagRepository.save(tag);
                })
                .orElseGet(() -> {
                    Tag tagConverted = convertToTagEntity.convert(PostedTagDto);
                    tagConverted.setId(id);
                    return tagRepository.save(tagConverted);
                });
    }
//
//    @PutMapping("/put/{id}")
//    @ResponseBody
//    public ResponseEntity<TagDto> updateTag(@PathVariable(value = "id") Long TagId,
//                                            @Valid @RequestBody TagDto tagDtoDetails) throws ResourceNotFoundException {
//    Tag tag = tagRepository.findById(TagId)
//            .orElseThrow(() -> new ResourceNotFoundException(TagId));
//
//        tag.setDescription(tagDetails.getDescription());
//        tag.setLockVersion(tagDetails.getLockVersion());
//        tag.setName(tagDetails.getName());
//    final Tag updatedTag = tagRepository.save(tag);
//        return ResponseEntity.ok(updatedTag);

    public TagDto findDemandedTagById(TagDto tagDtoDetails, Long id) throws ResourceNotFoundException {
    Tag tag = tagRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(id));

             Tag updateSetInfo=  convertToTagEntity.convert(tagDtoDetails);
             tag.setDescription(updateSetInfo.getDescription());
             tag.setLockVersion(updateSetInfo.getLockVersion());
             tag.setName(updateSetInfo.getName());
             Tag updatedTag=  tagRepository.save(tag); // save in db
///*final*/
              return  converterToTagDto.convert(updatedTag); //I need to  send tagDto to view

              //  return ResponseEntity.ok(converterToTagDto.convert(updatedTag));



    }

    public void deleteIntendedTag(Long id) {
        tagRepository.deleteById(id);
    }
//tagService.deleteById(id);


    //patch method
//    public Tag findTagById(Long id) {
//
//        //Map the persistent data to the REST dto
//        //This is done to enforce REST validation groups
//        Tag tagModel = tagMapper.mapDBToTagRestModel(tagIDFromDB);
//
//    }

    public void MyPatchService(Long tagIds, String tagBody) {
     Tag tagIdPacth=   tagRepository.findTagById(tagIds);
     tagIdPacth.setDescription(tagBody);
     tagRepository.save(tagIdPacth);

    }
    /*
      //Fetch the data from the database
        Tag tagIDFromDB = tagRepository.findTagById(id);

        //Map the persistent data to the REST dto
        //This is done to enforce REST validation groups
        TagMapper tagMapper = new TagMapper();
        Tag tagModel = tagMapper.mapDBToTagRestModel(tagIDFromDB);
        // ex:-->   ...RestModel ..variableRestModel = mapPersistenceModelToRestModel(....);

        //apply the changes to the REST model.
        changesTag.forEach(
                (change, value) -> {
                    switch (change) {
                        case "name":
                            tagModel.setName((String) value);
                            break;
                        case "description":
                            tagModel.setDescription((String) value);
                            break;
                        case "lockVersion":
                            tagModel.setLockVersion((Long) value);
                            break;
                    }
                }
        );

        tagMapper.mapPostManDataToDB( tagModel ,tagIDFromDB);
        tagRepository.save(tagIDFromDB);
        return  ResponseEntity.ok().build();
     */

}
