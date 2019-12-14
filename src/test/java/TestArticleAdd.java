import cn.zhanw.config.SpringMybatisConfig;
import cn.zhanw.entity.Article;
import cn.zhanw.mapper.ArticleMapper;
import cn.zhanw.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatisConfig.class)
public class TestArticleAdd {

    @Autowired
    ArticleService articleService;

    @Test
    public void selectService(){



    }
}
