package org.abbtech.practice.lesson23_orm.dto;

import java.util.List;

public record PostCommentDTO(PostDTO post, List<CommentDTO> comments)  {
}
