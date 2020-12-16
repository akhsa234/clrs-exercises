package com.bahar.blog.util;

import com.bahar.blog.model.Tag;

public class TagMapper {

    public Tag mapDBToTagRestModel(Tag tag) {
        Tag tagRestModel = new Tag();
        tagRestModel.setId(tag.getId());
        tagRestModel.setLockVersion(tag.getLockVersion());
        tagRestModel.setName(tag.getName());
        tagRestModel.setDescription(tag.getDescription());

        return tagRestModel;
    }

    public void mapPostManDataToDB(Tag tagRestModel, Tag tag) {
        tag.setName(tagRestModel.getName());
        tag.setLockVersion(tagRestModel.getLockVersion());
        tag.setDescription(tagRestModel.getDescription());
    }
}
