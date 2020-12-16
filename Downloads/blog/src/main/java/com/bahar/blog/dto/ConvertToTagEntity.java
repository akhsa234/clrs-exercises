package com.bahar.blog.dto;

import com.bahar.blog.model.Tag;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConvertToTagEntity implements Converter<TagDto,Tag> {
//convertToTagEntity --> ?  TagDtoMutateTag

    @Override
    public Tag convert(TagDto tagDto) {

        if (tagDto == null) {
            return null;
        }
        Tag tag=new Tag();
        tag.setName(tagDto.getName());
        tag.setDescription(tagDto.getDescription());
        tag.setLockVersion(tagDto.getLockVersion());
        return tag;
    }
}
