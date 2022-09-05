package com.boot.repository;

import com.boot.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository  extends CrudRepository<User, Long> {
}
