package com.test.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.web.entities.Tag;
import com.test.web.entities.TagPrimaryKey;

public interface TagRepository extends JpaRepository<Tag, TagPrimaryKey>//extends CommonRepository<Tag>
{

}
