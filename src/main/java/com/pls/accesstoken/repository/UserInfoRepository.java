package com.pls.accesstoken.repository;

import com.pls.accesstoken.model.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserInfoRepository extends MongoRepository<UserInfo,Long> {
}
