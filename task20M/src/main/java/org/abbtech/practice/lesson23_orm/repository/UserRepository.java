package org.abbtech.practice.lesson23_orm.repository;

import org.abbtech.practice.lesson23_orm.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> {
    Optional<Object> findUserInfoByUsernameIgnoreCase(String username);
}
