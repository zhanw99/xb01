import cn.zhanw.config.SpringMybatisConfig;
import cn.zhanw.entity.Dept;
import cn.zhanw.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatisConfig.class)
public class TestDept {

    @Autowired
    DeptService service;

    @Test
    public void selectService(){
        List<Dept> depts = service.selectAll();
        for (Dept dept : depts) {
            System.out.println(dept);
        }
    }
}
