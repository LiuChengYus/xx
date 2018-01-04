package com.accp.service;

import com.accp.mapper.UserMapper;
import com.accp.model.User;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;//这里会报错，但是并不会影响
   public int addUser(User user){
       return userMapper.insertSelective(user);
    }

  public User selectByUser(User user){
      return userMapper.selectByUser(user);
  }
}
