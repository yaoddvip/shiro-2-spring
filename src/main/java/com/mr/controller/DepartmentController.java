package com.mr.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    public static void main(String[] args) {
        //参数(密码、盐、加密的次数)
        Md5Hash hash = new Md5Hash("666","zhangsan",3);
        System.out.println(hash);
    }

    @RequestMapping("")
    @RequiresPermissions("department:list")
    public String index() throws  Exception{
        System.out.println("执行了部门列表....");
        return "department";
    }
    @RequestMapping("/save")
    @RequiresPermissions("department:save")
    public String save() throws  Exception{
        System.out.println("执行了部门保存....");
        return "department";
    }

    @RequestMapping("/edit")
    @RequiresPermissions("department:edit")
    public String edit() throws  Exception{
        System.out.println("执行了部门编辑....");
        return "department";
    }

    @RequestMapping("/delete")
    @RequiresPermissions("department:delete")
    public String delete() throws  Exception{
        System.out.println("执行了部门删除....");
        return "department";
    }
}
