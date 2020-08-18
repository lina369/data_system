package com.example.data_system.controller;

import com.example.data_system.mapper.LoginMapper;
import com.example.data_system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class systemController {
    @Autowired
    private LoginMapper loginMapper;
    @GetMapping("/login")
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginuser = loginMapper.login(username,password);
        if(loginuser!=null){
            map.put("msg3","welecom!"+username);
            return "index";
        }else {
            map.put("msg1","username or password error,please input again!");
            return "login";
        }
    }
    @RequestMapping("/register")
    public String register(HttpServletRequest request,Map<String,Object> map) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User user1 = loginMapper.getuser(username);
        if (user1 != null) {
            map.put("msg2", "the user has been used,please register again");
            return "register";
        } else {
            loginMapper.adduser(user);
            return "login";
        }
    }
    @RequestMapping("/goreg")
    public String goreg(HttpServletRequest request,Map<String,Object> map){
        return "register";
    }
    @RequestMapping("/manage")
    public String userManage(HttpServletRequest request,Map<String,Object> map){
        return "index";
    }
    @RequestMapping("/study")
    public String knowledge(HttpServletRequest request,Map<String,Object> map){
        return "index";
    }
    @RequestMapping("/gotomanage")
    public String gotomanage(HttpServletRequest request,Map<String,Object> map){
        return "manage";
    }
    @RequestMapping("/gotostudy")
    public String gotoknowledge(HttpServletRequest request,Map<String,Object> map){
        return "study";
    }
    @RequestMapping("/goto1")
    public String goto1(HttpServletRequest request,Map<String,Object> map){ return "1"; }
    @RequestMapping("/goto2")
    public String goto2(HttpServletRequest request,Map<String,Object> map){ return "2"; }
    @RequestMapping("/goto3")
    public String goto3(HttpServletRequest request,Map<String,Object> map){ return "3"; }
    @RequestMapping("/goto4")
    public String goto4(HttpServletRequest request,Map<String,Object> map){ return "4"; }
    @RequestMapping("/goto5")
    public String goto5(HttpServletRequest request,Map<String,Object> map){ return "5"; }
    @RequestMapping("/goto6")
    public String goto6(HttpServletRequest request,Map<String,Object> map){ return "6"; }
    @RequestMapping("/goto7")
    public String goto7(HttpServletRequest request,Map<String,Object> map){ return "7"; }

    @RequestMapping("/adduser")
    public String adduser(HttpServletRequest request,Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User user3 = loginMapper.getuser(username);
        if(user3!=null){
            map.put("msg4","用户名已存在！");
            return "manage";
        }else {
            loginMapper.adduser(user);
            return "manage";
        }
    }
    @RequestMapping("/updateuser")
    public String update(HttpServletRequest request,Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = loginMapper.getuser(username);
        if(user!=null){
            loginMapper.updateuser(username,password);
            return "manage";
        }else {
            map.put("msg5","用户不存在！");
            return "manage";
        }
    }
    @RequestMapping("/deleteuser")
    public String deleteuser(HttpServletRequest request,Map<String ,Object> map){
        String username = request.getParameter("username");
        User user2 = loginMapper.getuser(username);
        if(user2!=null){
            loginMapper.deleteuser(username);
            return "manage";
        }else {
            map.put("msg6","用户不存在！");
            return "manage";
        }
    }
}
