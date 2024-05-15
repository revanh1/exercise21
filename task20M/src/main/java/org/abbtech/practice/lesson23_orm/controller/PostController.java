package org.abbtech.practice.lesson23_orm.controller;

import lombok.RequiredArgsConstructor;
import org.abbtech.practice.lesson23_orm.dto.*;
import org.abbtech.practice.lesson23_orm.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @PostMapping("/{userId}/post-with-comments")
    public ResponseEntity<PostDTO> createPostWithCommnents(@PathVariable Long userId, @RequestBody PostCommentDTO postCommentDTO) {
        PostDTO createdPost = postService.addPost(postCommentDTO, userId);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/{postId}")
    public ResponseEntity <PostCommentDTO> getPostsWithComment(@PathVariable Long userId, @PathVariable Long postId) {
        PostCommentDTO postComments = postService.getPostsWithComment(postId, userId);
        return new ResponseEntity<>(postComments,HttpStatus.OK);
    }
}
