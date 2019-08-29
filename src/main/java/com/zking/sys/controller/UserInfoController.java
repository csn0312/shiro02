package com.zking.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    /*需要权限*/
    @RequiresPermissions("system:user:updatePassword")
    @RequestMapping("/updatePassword")
    public String updatePassword(Model model) {
        model.addAttribute("msg", "user updatePassword");
        return "msg";
    }

//@RequiresRoles()  角色
    @RequiresPermissions("system:user:doResetPassword")
    @RequestMapping("/doResetPassword")
    public String doResetPassword(Model model) {
        model.addAttribute("msg", "user doResetPassword");
        return "msg";
    }

}
