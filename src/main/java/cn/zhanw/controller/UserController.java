package cn.zhanw.controller;

import cn.zhanw.entity.Result;
import cn.zhanw.entity.User;
import cn.zhanw.entity.UserfocusKey;
import cn.zhanw.service.UserService;
import cn.zhanw.service.UserfocusService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("HTML/html/manager")
public class UserController {

    @Autowired
    UserService UserService;

    @Autowired
    UserfocusService userfocusService;

    /**
     * 查看用户
     * @return
     */
    @RequestMapping("user")
    public PageInfo<User> selectAll(@RequestBody Map<String,Object> params, HttpServletRequest req){
        HttpSession session = req.getSession();
        Integer userId =(Integer) session.getAttribute("userId");
        return UserService.pageAll(params, userId);
    }

    /**
     * 修改用户用户
     * @return
     */
    @RequestMapping("openId")
    public Result updataOpenId(@RequestBody Map<String,Object> params) {
        Result result = new Result();
        Integer id= (Integer) params.get("focusId");
        Integer loginId= (Integer) params.get("id");
        String success= (String) params.get("success");
        System.out.println(id);//用户id
        System.out.println(loginId);//账号id
        System.out.println(success);
        UserfocusKey userfocusKey = new UserfocusKey();
        if ("true".equals(success)){
            userfocusKey.setUserId(loginId);//账号id
            userfocusKey.setUserFocusId(id);//关注id
            userfocusService.insert(userfocusKey);
            result.setMsg("关注成功");
            result.setSuccess(true);
             return result;
        }else {
            userfocusService.deleDetaID(loginId,id);
            result.setMsg("取关成功");
            result.setSuccess(true);
            return result;
        }

    }
    /**
     * 详细
     * @return
     */
    @RequestMapping("detailed")
    public User updataOpenId(@RequestParam Integer id) {
        return UserService.updataOpenId(id);
    }



}
