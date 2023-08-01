package com.ergun.news.dataAccess.abstracts;

import com.ergun.news.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User ,Integer> {
    User findById(int id);
}
