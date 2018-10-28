package com.anna.gierat.blogApplication.repository;

import com.anna.gierat.blogApplication.model.Post;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAllByTitleContains(String title);
    List<Post> findAllByTitleContains(String title, Sort sort);
}
