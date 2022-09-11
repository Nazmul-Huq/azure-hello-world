package com.example.azurehelloworld.repo;

import com.example.azurehelloworld.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {

}
