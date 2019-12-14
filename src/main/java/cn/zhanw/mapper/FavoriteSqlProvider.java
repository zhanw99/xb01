package cn.zhanw.mapper;

import cn.zhanw.entity.FavoriteKey;
import org.apache.ibatis.jdbc.SQL;

public class FavoriteSqlProvider {

    public String insertSelective(FavoriteKey record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("favorite");
        
        if (record.getuId() != null) {
            sql.VALUES("u_id", "#{uId,jdbcType=INTEGER}");
        }
        
        if (record.getaId() != null) {
            sql.VALUES("a_id", "#{aId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }
}