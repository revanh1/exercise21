package org.abbtech.practice.lesson23_orm.service;

import org.abbtech.practice.lesson23_orm.dto.*;
import org.springframework.stereotype.Service;


@Service
public interface PostService {
    PostDTO addPost(PostCommentDTO comments, Long userId);

    PostCommentDTO getPostsWithComment(Long userId, Long postId);

}
