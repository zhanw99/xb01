package cn.zhanw.controller;

import cn.zhanw.entity.Result;
import cn.zhanw.entity.User;
import cn.zhanw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("HTML/manager/login")
public class MainController {
    @Autowired
    UserService service;

    @RequestMapping("login")
    public Result Login(@RequestBody Map<String, Object> params, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String checkCode1 = (String) session.getAttribute("checkCode");
        String username = (String) params.get("username");
        String password = (String) params.get("password");
        String checkbox = (String) params.get("checkbox");
        String checkCode2 = (String) params.get("checkCode2");
        System.out.println(username);
        System.out.println(password);
        System.out.println(checkbox);
        System.out.println(checkCode1);
        System.out.println(checkCode2);
        Result result = new Result();
        if (username != null && !"".equals(username) && password != null && !"".equals(password)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            User user1 = service.selectLogin(user);
            if (user1 == null) {
                return result;
            } else {
                session.setAttribute("userId",user1.getId());
                result.setSuccess(true);
                result.setObj(user1);
                result.setMsg("登录成功");
            }
        } else {
            return result;
        }
        return result;
    }
}
