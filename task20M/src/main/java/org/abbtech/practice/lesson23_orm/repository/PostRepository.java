package org.abbtech.practice.lesson23_orm.repository;

import org.abbtech.practice.lesson23_orm.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findByIdAndUserInfoId(Long postId, Long userId);

}
