package com.mr.service.impl;

import com.mr.mapper.UserMapper;
import com.mr.model.User;
import com.mr.model.UserExample;
import com.mr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ydd on 2018/5/22.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper ;


    public User selectUserByUserName(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        return users.size()==0?null:users.get(0);
    }

    public List<String> selectRoleByUserId(Long userId) {
        List<String> list = userMapper.selectRoleByUserId(userId);
        return list;
    }
    

    public List<String> selectPermissionByUserId(Long userId) {
        return  userMapper.selectPermissionByUserId(userId);
    }
}
