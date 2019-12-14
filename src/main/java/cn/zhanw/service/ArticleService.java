package cn.zhanw.service;

import cn.zhanw.entity.Article;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface ArticleService extends  IService<Article> {
    PageInfo<Article> selectFavoriteArticle(Map<String, Object> params);

     PageInfo<Article> selectAllLike(Map<String,Object> params);
}
