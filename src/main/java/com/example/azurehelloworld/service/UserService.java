package com.example.azurehelloworld.service;

import com.example.azurehelloworld.model.User;
import com.example.azurehelloworld.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired UserRepo userRepo;

    public void save(User user) {
        userRepo.save(user);
    }

    /**
     * first we will get the user's detail we want to delete
     * then we will set the course_id to null, so there is no foreign key for the user
     * then we will save the user with foreign key null
     * finally we will do the delete operation
     */
    public void deleteUserUsingId(Long id) {
        Optional<User> userToDelete = userRepo.findById(id);
        User user = new User();
        user.setId(userToDelete.get().getId());
        user.setName(userToDelete.get().getName());
        userRepo.save(user);
        userRepo.deleteById(id);
    }

    public List<User> findAll() {
        return (List<User>) userRepo.findAll();
    }
}
