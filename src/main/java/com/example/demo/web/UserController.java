package com.example.demo.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.core.Result;
import com.example.demo.core.ResultGenerator;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李理
 * @since 2017-12-01
 */
@Api(description = "用户模块")
@RequestMapping("/demo/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "增加用户")
    @PostMapping(value = "/add")
    public Result add(String name, String className) {
        try {
            boolean success = userService.create(name, className);
            return ResultGenerator.genSuccessResult(success);
        } catch (Exception e) {
            return ResultGenerator.genServerFailResult();
        }
    }

    @ApiOperation(value = "删除用户")
    @PostMapping(value = "/del")
    public Result del(String id) {
        try {
            boolean success = userService.del(id);
            return ResultGenerator.genSuccessResult(success);
        } catch (Exception e) {
            return ResultGenerator.genServerFailResult();
        }
    }

    @ApiOperation(value = "更新用户")
    @PostMapping(value = "/update")
    public Result update(String id, String name) {
        try {
            boolean success = userService.update(id, name);
            return ResultGenerator.genSuccessResult(success);
        } catch (Exception e) {
            return ResultGenerator.genServerFailResult();
        }
    }

    @ApiOperation(value = "查询用户")
    @PostMapping(value = "/select")
    public Result select(String id) {
        try {
            User user = userService.getUser(id);
            return ResultGenerator.genSuccessResult(user);
        } catch (Exception e) {
            return ResultGenerator.genServerFailResult();
        }
    }

    @ApiOperation(value = "查询用户集合")
    @PostMapping(value = "/selectUsers")
    public Result selectUsers(String name) {
        try {
            List<User> users = userService.getUsers(name);
            return ResultGenerator.genSuccessResult(users);
        } catch (Exception e) {
            return ResultGenerator.genServerFailResult();
        }
    }

    @ApiOperation(value = "根据姓名查询")
    @PostMapping(value = "/selectByName")
    public Result selectByName(String name) {
        try {
            User user = userService.getUserByName(name);
            return ResultGenerator.genSuccessResult(user);
        } catch (Exception e) {
            return ResultGenerator.genServerFailResult();
        }
    }

    @ApiOperation(value = "根据班级名称查询")
    @PostMapping(value = "/selectByClassName")
    public Result selectByClassName(String name) {
        try {
            Page<User> page = new Page<>(1, 10);
            List<User> users = userService.getUsers(name, page);
            return ResultGenerator.genSuccessResult(users);
        } catch (Exception e) {
            return ResultGenerator.genServerFailResult();
        }
    }

    @ApiOperation(value = "根据姓名和班级查询唯一学生")
    @PostMapping(value = "/selectUserByNameAndClassName")
    public Result selectUserByNameAndClassName(String name, String className) {
        try {
            User user = userService.selectUserByNameAndClassName(name, className);
            return ResultGenerator.genSuccessResult(user);
        } catch (Exception e) {
            return ResultGenerator.genServerFailResult();
        }
    }

    @ApiOperation(value = "根据姓名和班级查询学生集合")
    @PostMapping(value = "/selectUsersByNameAndClassName")
    public Result selectUsersByNameAndClassName(String name, String className) {
        try {
            List<User> users = userService.selectUsersByNameAndClassName(name, className);
            return ResultGenerator.genSuccessResult(users);
        } catch (Exception e) {
            return ResultGenerator.genServerFailResult();
        }
    }

}
