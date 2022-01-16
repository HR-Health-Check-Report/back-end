package com.xxxx.hrhealthcheck.controller;

import com.alibaba.fastjson.JSON;
import com.xxxx.hrhealthcheck.bean.Admin;
import com.xxxx.hrhealthcheck.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {

    @Autowired
    AdminDao adminDao;

    @RequestMapping("/login")
    public String login(@RequestBody Admin admin){
        String flag = "error";
        Admin us = adminDao.getUserByMessage(admin.getUsername(),admin.getPassword());
        HashMap<String, Object> res = new HashMap<>();
        if (us != null){
            flag = "ok";
        }
        res.put("flag", flag);
        res.put("user", us);
        String res_json = JSON.toJSONString(res);
        return res_json;
    }
}
