package cn.zhanw.mapper;

import cn.zhanw.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ArticleMapper extends Mapper<Article> {

    @Select("   SELECT ar.*   " +
            "   FROM   " +
            "   `user` us   " +
            "   LEFT JOIN   " +
            "   favorite fa   " +
            "   ON   " +
            "   fa.u_id=us.id   " +
            "   LEFT JOIN   " +
            "   article ar   " +
            "   ON   " +
            "   fa.a_id=ar.id   " +
            "   WHERE    " +
            "   us.id=#{id}" +
            " and " +
            " ar.content LIKE CONCAT('%',#{title},'%')")
    public List<Article> selectFavoriteArticle(@Param(value = "id")Integer id,@Param(value = "title") String title);

    @Select("SELECT ac.*  " +
            "FROM " +
            "article ac " +
            "WHERE " +
            "ac.title LIKE CONCAT('%',#{title},'%')")
     List<Article> selectAllLike(String title);

}