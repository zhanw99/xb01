package cn.zhanw.controller;

import cn.zhanw.utils.Email;
import cn.zhanw.entity.Result;
import cn.zhanw.entity.User;
import cn.zhanw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("HTML/manager/login")
public class MainController {
    @Autowired
    UserService service;

    @Autowired
    Email sendEmail;

    /**
     * 登陆
     * @param params
     * @param req
     * @return
     */
    @RequestMapping("login")
    public Result Login(@RequestBody Map<String, Object> params, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String username = (String) params.get("username");
        String password = (String) params.get("password");
        String checkCode = (String) session.getAttribute("checkCode");//图片验证码
        String checkCode2 = (String) params.get("checkCode");//text验证码
        Boolean checked = (Boolean) params.get("checkbox");//记住密码
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println(checked);
//        System.out.println(checkCode);
//        System.out.println(checkCode2);
        Result result = new Result();
        if (checkCode.equals(checkCode2)){
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
        }
        return result;
    }

    /**
     * 注册
     * @param params
     * @return
     */
    @RequestMapping("register")
    public Result Login(@RequestBody Map<String, Object> params){
        String email = (String) params.get("email");
        String username = (String) params.get("username");
        String password = (String) params.get("password");
        String password2 = (String) params.get("password2");
        Result result = new Result();
        if (password.equals(password2)){
            Integer integer = service.selectByName(username);
            if (integer==1){
                result.setMsg("账号已存在");
            }else {
                User user =new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                user.setRegisterTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                service.insertUser(user);
                result.setMsg("注册成功");
                result.setSuccess(true);
            }
        }else {
            result.setMsg("密码不一致");
        }
        return result;
    }

    /**
     * 发送邮箱
     * @return
     */
    @RequestMapping("send")
    public Result send(@RequestBody Map<String, Object> params,HttpServletRequest request){
        HttpSession session = request.getSession();
        //516767841@qq.com,1024
        String email= (String) params.get("email");
        int code=(int)(Math.random()*9000)+1000;
        session.setAttribute("code",code);
        sendEmail.send(email,code);
//        System.out.println(email);
//        System.out.println(code);
//        System.out.println(session.getAttribute("code"));
        Result result = new Result();
        return result;
    }

    /**
     * 修改密码
     * @param params
     * @return
     */
    @RequestMapping("forget")
    public Result forget(@RequestBody Map<String, Object> params,HttpServletRequest request){
        Result result = new Result();
        HttpSession session = request.getSession();
        Integer code1 = (Integer) session.getAttribute("code");//邮箱验证码
        String code2 = code1.toString();
        String email = (String) params.get("email");//邮箱
        String code = (String) params.get("code");//验证码
        String password = (String) params.get("password");//新密码
        session.setAttribute("code","");
//        System.out.println(email);
//        System.out.println(code);
//        System.out.println(password);
//        System.out.println(code1);
        if (code2.equals(code)){
            int i= service.updatePassword(email,password);
            if (i==1){
                result.setMsg("修改成功");
                result.setSuccess(true);
            }else {
                result.setMsg("修改失败");
                result.setSuccess(false);
            }
        }
        return result;
    }

}
