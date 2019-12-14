package cn.zhanw.controller;

import cn.zhanw.entity.Article;
import cn.zhanw.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("manager/article")
public class ArticleController {
    @Autowired
    ArticleService service;

    @RequestMapping("selectAll")
    public PageInfo<Article> selectAll(@RequestBody Map<String,Object> params){
        if (params.get("pageNum")==null){
            params.put("pageNum",1);
        }
        if (params.get("pageSize")==null){
            params.put("pageSize",5);
        }
        if (params.get("title")==null){
            params.put("title","");
        }

        return service.selectAllLike(params);
    }

    /**
     * 我收藏的文章
     * @param params
     * @return
     */
    @RequestMapping("selectFavoriteArticle")
    public PageInfo<Article> selectFavoriteArticle(@RequestBody Map<String,Object> params){
        System.out.println("******");
        System.out.println(params.get("title"));
        return service.selectFavoriteArticle(params);
    }

}
