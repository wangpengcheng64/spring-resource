package com.wpc.controller;

import com.wpc.aspect.Log;
import com.wpc.bean.User;
import com.wpc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @GetMapping("/{id}")
    @ResponseBody
    @Log(moduleName = "查询用户")
    public ModelAndView getUserById(@PathVariable("id") Long id, ModelAndView mv){
        System.out.println("通过id查询用户信息");
        User user = userService.getUserById(id);
        mv.addObject(user);
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/insert")
    @ResponseBody
    @Log(moduleName = "新增用户")
    public String insertUser(User user){
        try {
            user.setCreateTime(new Date());
            userService.insertUser(user);
            System.out.println("新增用户信息");
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FAIL;
    }

}
