package com.example.springmongo.security.entities.token;

import com.example.springmongo.security.entities.user.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "token")
public class Token {

    @Id
    public Integer id;
    public String token;

    @DBRef public TokenType tokenType;
    public boolean revoked;
    public boolean expired;

    public User userId;
}
