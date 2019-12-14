package cn.zhanw.service.serviceImpl;

import cn.zhanw.entity.Article;
import cn.zhanw.mapper.ArticleMapper;
import cn.zhanw.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional//这个方法的事务由spring处理，即是方法里面对数据库操作
public class ArticleServiceImpl extends IServiceImpl<Article> implements ArticleService {
    @Autowired
    ArticleMapper mapper;

    @Override
    public PageInfo<Article> selectFavoriteArticle(Map<String,Object> params){
        if (params.get("pageNum")==null){
            params.put("pageNum",1);
        }
        if (params.get("pageSize")==null){
            params.put("pageSize",5);
        }
        PageHelper.startPage(params);
        List<Article> articles = mapper.selectFavoriteArticle((Integer) params.get("id"),(String) params.get("title"));
        return new PageInfo<Article>(articles);
    }

    @Override
    public PageInfo<Article> selectAllLike(Map<String,Object> params){
        PageHelper.startPage((Integer) params.get("pageNum"),(Integer) params.get("pageSize"));
        PageInfo<Article> pageInfo = new PageInfo<Article>(mapper.selectAllLike((String) params.get("title")));
        return pageInfo;
    }
}
