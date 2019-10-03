package com.pls.accesstoken.web;

import com.pls.accesstoken.dao.MongoDAO;
import com.pls.accesstoken.model.UserInfo;
import com.pls.accesstoken.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private MongoDAO mongoDAO;

    //http://localhost:8087/save
    @GetMapping("save")
    public String save(){
        UserInfo userInfo = new UserInfo(System.currentTimeMillis(),"用户"+System.currentTimeMillis(),"123");
        userInfoRepository.save(userInfo);
        return "success";
    }

    //http://localhost:8087/getUserList
    @GetMapping("getUserList")
    public List<UserInfo> getUserList(){
        List<UserInfo> userInfoList = userInfoRepository.findAll();
        List<UserInfo> all = mongoDAO.findAll();
        return all;
    }

    //http://localhost:8087/delete?id=1570029312757
    @GetMapping("delete")
    public String delete(Long id){
        userInfoRepository.deleteById(id);
        return "success";
    }

    //http://localhost:8087/update?id=1570029345583&username=111&password=222
    @GetMapping("update")
    public String update(Long id,String username,String password){
        UserInfo userInfo = new UserInfo(id,username,password);
        userInfoRepository.save(userInfo);
        return "success";
    }
}
