package org.abbtech.practice.lesson23_orm.dto;

import jakarta.validation.constraints.Size;

import java.util.Date;

public record PostDTO(@Size(min = 3, max = 20) String title, @Size(min = 30, max = 150) String content,
                      Date created_date, Long user_id) {
}
