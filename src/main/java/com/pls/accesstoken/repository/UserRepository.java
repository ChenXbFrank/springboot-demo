package com.pls.accesstoken.repository;

import com.pls.accesstoken.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 81046 on 2018-07-20
 */
public interface UserRepository extends JpaRepository<User,String> {

}
