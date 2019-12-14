package cn.zhanw.mapper;

import cn.zhanw.entity.MeetingJoin;
import org.apache.ibatis.jdbc.SQL;

public class MeetingJoinSqlProvider {

    public String insertSelective(MeetingJoin record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("meeting_join");
        
        if (record.getuId() != null) {
            sql.VALUES("u_id", "#{uId,jdbcType=INTEGER}");
        }
        
        if (record.getcId() != null) {
            sql.VALUES("c_id", "#{cId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }
}