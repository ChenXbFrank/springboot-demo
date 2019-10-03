package com.pls.accesstoken.service;

import com.pls.accesstoken.dao.UserDao;
import com.pls.accesstoken.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by 81046 on 2018-08-02
 */
@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<User> getAllUserList(){
        // 从缓存中获取accesstoken信息
        String key = "getAllUserList";
        ValueOperations<String, List<User>> operations = redisTemplate.opsForValue();
        // 缓存存在  直接返回
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            List<User> userList = operations.get(key);
            LOGGER.info("UserService.getAllUserList() : 从缓存中获取了List<User> >> " + userList);
            return userList;
        }
        // 从 DB 中获取userList信息
        List<User> userList = userDao.getAllUserList();
        // 插入缓存
        operations.set(key, userList, 1000, TimeUnit.SECONDS);
        LOGGER.info("UserService.getAllUserList() : List<User>插入缓存 >> " + userList);
        return userList;
    }

    public List<User> getUserListByName(String name){
        // 从缓存中获取accesstoken信息
        String key = "getUserListByName_" + name;
        ValueOperations<String, List<User>> operations = redisTemplate.opsForValue();
        // 缓存存在  直接返回
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            List<User> userList = operations.get(key);
            LOGGER.info("UserService.getUserListByName() : 从缓存中获取了List<User> >> " + userList);
            return userList;
        }
        // 从 DB 中获取userList信息
        List<User> userList = userDao.getUserListByName(name);
        // 插入缓存
        operations.set(key, userList, 1000, TimeUnit.SECONDS);
        LOGGER.info("UserService.getUserListByName() : List<User>插入缓存 >> " + userList);
        return userList;
    }

    /**
     * 根据名字修改用户信息
     */
    public void updateUserByName(User user){
        userDao.updateUserByName(user);
        // 缓存存在，删除缓存  更新时，先更新用户，然后再将缓存中的信息删除
        /*String key = "userId_" + user.getId();
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            LOGGER.info("UserService.updateUserByName() : 从缓存中删除用户 >> " + user.toString());
        }*/
    }

    /**
     * 保存用户信息
     */
    public void saveUser(User user){
        userDao.insertUser(user);
    }

    /**
     * 删除用户
     */
    public void deleteUserById(String id){
        userDao.deleteUserById(id);
        // 将缓存中的信息删除
        /*String key = "userId_" + user.getId();
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            LOGGER.info("UserService.updateUserByName() : 从缓存中删除用户 >> " + user.toString());
        }*/
    }
}
