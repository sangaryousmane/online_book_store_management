package com.example.springmongo.repo.token;

import com.example.springmongo.security.entities.token.Token;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends MongoRepository<Token, Integer> {

    Optional<Token> findByToken(String token);

    @Query("{'user.userId': ?0, $or: [{expired: false}, {revoked: false}]}")
    List<Token> findAllValidTokenByUser(Integer userId);
}
