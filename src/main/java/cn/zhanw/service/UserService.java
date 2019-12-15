package cn.zhanw.service;

import cn.zhanw.entity.User;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface UserService extends IService<User> {

    PageInfo<User> pageAll(Map<String, Object> params,Integer userId);

    PageInfo<User> selectFocusId(Map<String, Object> params);

    User selectLogin(User user);

    User updataOpenId(Integer id);

    Integer selectByName(String id);

    void insertUser(User user);

    Integer updatePassword(String password,String email);

}
