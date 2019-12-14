import cn.zhanw.config.SpringMybatisConfig;
import cn.zhanw.entity.Article;
import cn.zhanw.mapper.ArticleMapper;
import cn.zhanw.service.ArticleService;
import com.github.pagehelper.PageInfo;
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
public class TestArticle {
    @Autowired
    ArticleMapper mapper;

    @Autowired
    ArticleService service;

    @Test
    public void selectFavoriteArticleMapper(){
        List<Article> articles = mapper.selectFavoriteArticle(1,"如何");
    }
    @Test
    public void selectFavoriteArticleService(){
        Map map= new HashMap();
        PageInfo pageInfo = service.selectFavoriteArticle(map);
            System.out.println(pageInfo.getSize());
    }
    @Test
    public void TestAll(){
        Map map= new HashMap();
        map.put("pageNum",1);
        map.put("pageSize",5);
        map.put("title","如何");

        PageInfo pageInfo = service.selectAllLike(map);
        System.out.println(pageInfo.getSize());

    }
}
