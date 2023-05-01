package com.assignments.JoseAssignemnt14.repository;

import com.assignments.JoseAssignemnt14.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // select * from users where name = :name
    List<User> findByName(String name);

}
