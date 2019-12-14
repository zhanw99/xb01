package cn.zhanw.controller;


import cn.zhanw.entity.Result;
import cn.zhanw.entity.User;
import cn.zhanw.service.UserService;
import cn.zhanw.service.UserfocusService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("userfocus")
public class UserfocusController {

    @Autowired
    UserService userService;

    @Autowired
    UserfocusService userfocusService;

    /**
     * 我关注的用户
     *
     * @param params
     * @return
     */
    @RequestMapping("focusId")
    public PageInfo<User> selectFocusId(@RequestBody Map<String, Object> params) {
        return userService.selectFocusId(params);
    }

    /**
     * 我关注的用户
     *
     * @return
     */
    @RequestMapping("deleDetaid")
    public Result deleDetaID(@RequestParam Integer id, @RequestParam Integer item) {
        System.out.println(item);//admin
        System.out.println(id);//我关注的用户
        userfocusService.deleDetaID(item, id);
        Result result = new Result();
        result.setMsg("取消关注成功");
        result.setSuccess(true);
        return result;
    }
}
