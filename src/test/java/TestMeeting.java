import cn.zhanw.config.SpringMybatisConfig;
import cn.zhanw.entity.Meeting;
import cn.zhanw.entity.User;
import cn.zhanw.mapper.MeetingMapper;
import cn.zhanw.service.MeetingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatisConfig.class)
public class TestMeeting {
    @Autowired
    MeetingMapper mapper;
    @Autowired
    MeetingService meetingService;


    @Test
    public void selectFavoriteArticleMapper(){
        Map map = new HashMap();
        map.put("state","2");
        map.put("title","今天");
        meetingService.selectFavoriteArticle(map);
    }

    @Test
    public void selectFavoriteArticleMapper2(){
        List<User> meetings = mapper.selectDeptUser(1);
    }
}
