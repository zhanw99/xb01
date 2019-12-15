import cn.zhanw.config.SpringMybatisConfig;
import cn.zhanw.entity.User;
import cn.zhanw.mapper.UserMapper;
import cn.zhanw.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatisConfig.class)
public class TestUser {
    @Autowired
    UserMapper mapper;

    @Autowired
    UserService service;

    @Test
    public void updataOpenId2(){
        User user = new User();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        System.out.println(format);
        user.setRegisterTime(format);
        user.setUsername("xiangbai");
        user.setPassword("123456");
       mapper.insertUser(user);
    }
    @Test
    public void updataOpenId3(){
        Integer admin = mapper.updatePassword("admin1", "zijun1024@aliyun.com");
        System.out.println(admin);
    }
}
