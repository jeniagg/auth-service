package com.auth.repositories;

import com.auth.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u from User u WHERE username = ?1 ")
    public User getUserByUsername(String username);
}
