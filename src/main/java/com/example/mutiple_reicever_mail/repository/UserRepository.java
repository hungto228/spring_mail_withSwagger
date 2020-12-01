package com.example.mutiple_reicever_mail.repository;

import com.example.mutiple_reicever_mail.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String userName);

}
