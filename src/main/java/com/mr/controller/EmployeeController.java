package com.mr.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {


    /**
     * @RequiresPermissions("employee:list") 必须拥有employee:list权限
     * @return
     * @throws Exception
     */
    @RequestMapping("")
    @RequiresPermissions("employee:list")
    public String index() throws  Exception{
        System.out.println("执行了员工列表....");
        return "employee";
    }

    @RequestMapping("/save")
    @RequiresPermissions("employee:save")
    public String save() throws  Exception{
        System.out.println("执行了员工保存....");
        return "employee";
    }

    @RequestMapping("/edit")
    @RequiresPermissions("employee:edit")
    public String edit() throws  Exception{
        System.out.println("执行了员工编辑....");
        return "employee";
    }

    @RequestMapping("/delete")
    @RequiresPermissions("employee:delete")
    public String delete() throws  Exception{
        System.out.println("执行了员工删除....");
        return "employee";
    }
}
