package cn.zhanw.controller;

import cn.zhanw.entity.Article;
import cn.zhanw.entity.Result;
import cn.zhanw.service.ArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("manager/articleAdd")
public class ArticleAdd {

    @Autowired
    ArticleService articleService;

    /**
     * 发布文章
     * @param params
     * @return
     */
    @RequestMapping("updateArticle")
    public Result updateArticle(@RequestBody Map<String,Object> params){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
        String date = dateFormat.format( now );
        String title = (String) params.get("Title");
        String article1 = (String) params.get("Article");
        Object loginId = params.get("LoginId");
        Object realName =  params.get("realName");
        Article article =new Article();
        article.setTitle(title);
        article.setContent(article1);
        article.setPublishRealName((String) realName);
        article.setBrowseCount(0);
        article.setUserId((Integer)loginId );
        article.setPublishDate(date);
        int insert = articleService.insert(article);
        Result result = new Result();
        if (insert==1){
            result.setMsg("发布成功");
            result.setSuccess(true);
        }
        System.out.println("******");
        return result;
    }
}
