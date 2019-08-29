package com.zking.sys.controller;

import com.zking.sys.jwt.JwtUtils;
import com.zking.sys.model.User;
import com.zking.sys.service.IUserBiz;
import com.zking.sys.util.JsonData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserBiz userBiz;

    @ModelAttribute
    public void init(Model model) {
        System.out.println("init");
        User user = new User();
        model.addAttribute("user", user);
    }


    //首页
    @RequestMapping("/index.shtml")
    public String toLogin(Model model) {
        System.out.println("toLogin");
        return "login";
    }

    /*@RequestMapping("/login")
    public String login(Model model, User user) {
        System.out.println(user);
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        String message = null;
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {// 捕获未知用户名异常
            message = "帐号错误";
        } catch (LockedAccountException e) {// 捕获错误登录过多的异常
            message = "帐号已锁定，请与管理员联系";
        } catch (IncorrectCredentialsException e) {// 捕获密码错误异常
            message = "密码错误";
        } catch (ExcessiveAttemptsException e) {// 捕获错误登录过多的异常
            message = "多次登录尝试失败，请60秒后再试";
        }

        if (null == message) {//JWT
            Session session = subject.getSession();//此session为org.apache.shiro.session.Session
            session.setAttribute("user", user);//登陆成功后要保存shiro的会话中，已备之后使用
            return "main";
        } else {
            model.addAttribute("message", message);
            return "login";
        }
    }*/


    @RequestMapping("/login")
    @ResponseBody
    public JsonData logina(Model model, User user) {
        JsonData json=new JsonData();


        System.out.println("用户信息---------"+user.getUsername()+"===密码==="+user.getPassword());
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        String message = null;
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {// 捕获未知用户名异常
            message = "帐号错误";
            json.put("message",message);
        } catch (LockedAccountException e) {// 捕获错误登录过多的异常
            message = "帐号已锁定，请与管理员联系";
        } catch (IncorrectCredentialsException e) {// 捕获密码错误异常
            message = "密码错误";
            json.put("message",message);
        } catch (ExcessiveAttemptsException e) {// 捕获错误登录过多的异常
            message = "多次登录尝试失败，请60秒后再试";
            json.put("message",message);
        }

        if (null == message) {//JWT
            Session session = subject.getSession();//此session为org.apache.shiro.session.Session
            session.setAttribute("user", user);//登陆成功后要保存shiro的会话中，已备之后使用
            User user1 = userBiz.loadByUsername(user);


           // Map<String, Object> claims = new HashMap<String, Object>();
            //claims.put("username",user1.getUsername());

            //String jwt= JwtUtils.createJwt(claims, JwtUtils.JWT_WEB_TTL);
          //  System.out.println(jwt);
           /* HttpServletResponse response=ServletActionContext.getResponse();
            //设置响应头  返回给客户端
            response.setHeader(JwtUtils.JWT_HEADER_KEY, jwt);*/
            json.setCode(0);
            json.setMessage("登陆成功");
            json.setResult(user1);
            return json;
        } else {
            model.addAttribute("message", message);
            return json;
        }
    }

    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "login";
    }

}
