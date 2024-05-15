package org.abbtech.practice.lesson23_orm.service.impl;

import lombok.RequiredArgsConstructor;
import org.abbtech.practice.lesson23_orm.dto.*;
import org.abbtech.practice.lesson23_orm.model.Comment;
import org.abbtech.practice.lesson23_orm.model.Post;
import org.abbtech.practice.lesson23_orm.model.UserInfo;
import org.abbtech.practice.lesson23_orm.repository.CommentRepository;
import org.abbtech.practice.lesson23_orm.repository.PostRepository;
import org.abbtech.practice.lesson23_orm.service.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Override
    public PostDTO addPost(PostCommentDTO postComments, Long userId) {
        UserInfo user = new UserInfo();
        user.setId(userId);

        Post post = new Post();
        post.setUserInfo(user);
        post.setTitle(postComments.post().title());
        post.setContent(postComments.post().content());
        post.setCreatedDate(new Date());
        postRepository.save(post);

        List<CommentDTO> comments = postComments.comments();
        for (int i = 0; i < comments.size(); i++) {
            Comment comment = new Comment();
            comment.setPost(post);
            comment.setContent(comments.get(i).content());
            comment.setCreatedDate(new Date());
            commentRepository.save(comment);
        }
        return new PostDTO(post.getTitle(), post.getContent(), post.getCreatedDate(), post.getUserInfo().getId());
    }

    @Override
    public PostCommentDTO getPostsWithComment(Long postId, Long userId) {

        Post post = postRepository.findByIdAndUserInfoId(postId, userId);
        List<Comment> comments = commentRepository.findByPostId(postId);
        PostDTO postDTO = new PostDTO(post.getTitle(), post.getContent(), post.getCreatedDate(), post.getUserInfo().getId());
        List<CommentDTO> commentDTOs = new ArrayList<>();
        for (Comment comment : comments) {
            CommentDTO commentDTO = new CommentDTO(comment.getContent(), comment.getCreatedDate(), comment.getPost().getId());
            commentDTOs.add(commentDTO);
        }
        return new PostCommentDTO(postDTO, commentDTOs);
    }
}