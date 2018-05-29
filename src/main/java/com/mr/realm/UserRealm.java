package com.mr.realm;

import com.mr.model.User;
import com.mr.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    public String getName() {
        return "UserRealm";
    }

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前对象
        User user = (User) principalCollection.getPrimaryPrincipal();
        //定义角色集合
        List<String> roles = new ArrayList<String>();
        //定义权限集合
        List<String> permissions = new ArrayList<String>();

        //通过对象id查询当前对象的角色
        roles = userService.selectRoleByUserId(user.getId());
        permissions = userService.selectPermissionByUserId(user.getId());

        //创建授权info
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加角色集合
        info.addRoles(roles);
        //添加权限集合
        info.addStringPermissions(permissions);
        return info;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1:从token中获取用户信息
        String username = (String) token.getPrincipal();
        //2：通过用户名查询数据库
        User user = userService.selectUserByUserName(username);
        //如果用户不存在，则之间返回null即可。
        if(user == null){
            return null;
        }
        //如果不为null。创建  SimpleAuthenticationInfo对象
        //(当前对象，查询出的密码 ，当前对象名)
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(),
                ByteSource.Util.bytes(user.getUsername()), getName());
        return info;
    }

    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
