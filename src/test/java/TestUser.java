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
        User user = mapper.updataOpenId(1);
            System.out.println(user);
    }
}
