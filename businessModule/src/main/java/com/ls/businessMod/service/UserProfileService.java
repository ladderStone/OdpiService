package com.ls.businessMod.service;
 
import java.util.List;
 
import com.ls.dataMod.model.UserProfile;
 
 
public interface UserProfileService {
 
    UserProfile findById(int id);
 
    UserProfile findByType(String type);
     
    List<UserProfile> findAll();
     
}