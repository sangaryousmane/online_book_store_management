package com.example.springmongo.service.users;

import com.example.springmongo.repo.user.UserRepository;
import com.example.springmongo.security.entities.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepo;


    public List<User> findAllUsers(){
        return userRepo.findAll(Sort.by("firstName").ascending());
    }
}
