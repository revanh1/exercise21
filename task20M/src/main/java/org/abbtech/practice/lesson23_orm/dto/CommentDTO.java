package org.abbtech.practice.lesson23_orm.dto;

import jakarta.validation.constraints.Size;

import java.util.Date;

public record CommentDTO(@Size(min = 5, max = 100) String content, Date created_date, Long post_id) {
}
