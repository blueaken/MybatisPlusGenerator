package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.model.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 李理
 * @since 2017-12-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public boolean create(String name, String className) {
        User user = new User();
        user.setName(name);
        user.setClassName(className);
        return insert(user);
    }

    @Override
    public boolean del(String id) {
        User user = new User();
        user.setId(id);
        return deleteById(user);
    }

    @Override
    public boolean update(String id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return updateById(user);
    }

    @Override
    public User getUser(String id) {
        return selectById(id);
    }

    @Override
    public User getUserByName(String name) {
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.where("name={0}", name);
        return selectOne(entityWrapper);
    }

    @Override
    public List<User> getUsers(String name) {
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.where("name={0}", name);
        return selectList(entityWrapper);
    }

    @Override
    public List<User> getUsers(String className, Page<User> page) {
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.where("class_name={0}", className);

        selectPage(page, entityWrapper);

        return page.getRecords();
    }

    @Override
    public User selectUserByNameAndClassName(String name, String className) {
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.where("name={0}", name).and("class_name={0}", className);
        return selectOne(entityWrapper);
    }

    @Override
    public List<User> selectUsersByNameAndClassName(String name, String className) {
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.where("name={0}", name).and("class_name={0}", className);
        return selectList(entityWrapper);
    }
}
