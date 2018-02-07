package com.example.demo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.model.User;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 李理
 * @since 2017-12-01
 */
public interface UserService extends IService<User> {
    public boolean create(String name, String className);

    public boolean del(String id);

    public boolean update(String id, String name);

    public User getUser(String id);

    public User getUserByName(String name);

    public List<User> getUsers(String name);

    public List<User> getUsers(String className, Page<User> page);

    public User selectUserByNameAndClassName(String name, String className);

    public List<User> selectUsersByNameAndClassName(String name, String className);

}
