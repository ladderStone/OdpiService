package com.ls.businessMod.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
//import com.ls.dataMod.dao.UserProfileDao;
import com.ls.dataMod.model.UserProfile;
 
 
@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl {/*
     
    @Autowired
    UserProfileDao dao;
     
    public UserProfile findById(int id) {
        return dao.findById(id);
    }
 
    public UserProfile findByType(String type){
        return dao.findByType(type);
    }
 
    public List<UserProfile> findAll() {
        return dao.findAll();
    }
*/}