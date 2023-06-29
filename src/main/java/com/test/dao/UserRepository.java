package com.test.dao;//package com.test.dao;

import com.test.domain.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // query User
    // userId는 unique한 _id(primary key)이기 때문에 userId로만 특정 User 검색 가능
    @Autowired
    public User findByUserId(String userId);
}