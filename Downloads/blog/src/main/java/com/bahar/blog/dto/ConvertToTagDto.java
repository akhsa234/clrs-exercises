package com.bahar.blog.dto;

import com.bahar.blog.model.Tag;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConvertToTagDto implements Converter<Tag,TagDto> {

    ////convertToTagDto --> ?  TagMutateTagDto

        @Override
        public TagDto convert(Tag tag) {

            if (tag == null) {
                return null;
            }
            TagDto tagDto=new TagDto();
            tagDto.setName(tag.getName());
            tagDto.setDescription(tag.getDescription());
            tagDto.setLockVersion(tag.getLockVersion());
            return tagDto;
        }



    }



/*
public void mapPostManDataToDB(Tag tagRestModel, Tag tag) {
        tag.setName(tagRestModel.getName());
        tag.setLockVersion(tagRestModel.getLockVersion());
        tag.setDescription(tagRestModel.getDescription());
    }
 */