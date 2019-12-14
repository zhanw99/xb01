package cn.zhanw.mapper;

import cn.zhanw.entity.UserfocusKey;
import org.apache.ibatis.jdbc.SQL;

public class UserfocusSqlProvider {

    public String insertSelective(UserfocusKey record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("userfocus");
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserFocusId() != null) {
            sql.VALUES("user_focus_id", "#{userFocusId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }
}