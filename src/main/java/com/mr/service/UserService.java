package com.mr.service;

import com.mr.model.User;

import java.util.List;

/**
 * Created by ydd on 2018/5/22.
 */
public interface UserService {
    User selectUserByUserName(String username);

    /**
     * 通过用户查询角色
     * @param userId
     * @return
     */
    List<String> selectRoleByUserId(Long userId);

    /**
     * 通过用户查询权限
     * @param userId
     * @return
     */
    List<String> selectPermissionByUserId(Long userId);

}
