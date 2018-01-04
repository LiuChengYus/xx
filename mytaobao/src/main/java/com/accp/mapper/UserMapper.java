package com.accp.mapper;

import com.accp.model.User;
import com.accp.util.MyMapper;

public interface UserMapper extends MyMapper<User> {
   User selectByUser(User user);
}