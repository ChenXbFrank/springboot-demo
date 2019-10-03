package com.pls.accesstoken.dao;

import com.pls.accesstoken.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

//必须要加Componet使得该组件可以被spring管理起来
@Component
public class MongoDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insert(UserInfo user) {
        mongoTemplate.insert(user);
        System.out.println("添加成功");
    }

    public void update(UserInfo user) {
        Criteria criteria = Criteria.where("id").in(user.getId());
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("username", user.getUsername());
        update.set("password", user.getPassword());
        mongoTemplate.updateMulti(query, update, UserInfo.class);
        System.out.println("更新成功！！！");
    }

    public List<UserInfo> select (Integer id) {
        Criteria criteria = Criteria.where("id").in(id);
        Query query = new Query(criteria);
        return mongoTemplate.find(query,UserInfo.class);
    }

    public void delById (Integer id) {
        Criteria criteria = Criteria.where("id").in(id);
        Query query = new Query(criteria);
        mongoTemplate.remove(query, UserInfo.class);
        System.out.println("删除成功！！！");
    }

    public List<UserInfo> findAll () {
        return mongoTemplate.findAll(UserInfo.class);
    }
}
