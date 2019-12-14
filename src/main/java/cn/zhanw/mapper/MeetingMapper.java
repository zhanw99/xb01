package cn.zhanw.mapper;

import cn.zhanw.entity.Meeting;
import cn.zhanw.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MeetingMapper extends Mapper<Meeting> {

    @Select(" SELECT *  " +
            " FROM meeting me " +
            " WHERE " +
            " me.`status`like CONCAT('%',#{state},'%') " +
            " AND me.title like CONCAT('%',#{title},'%') ")
    List<Meeting> selectMeeting(@Param("state") String state,@Param("title") String title);
    
    
    @Select(" SELECT  us.id,us.real_name " +
            " FROM " +
            " `user` us " +
            " WHERE " +
            " us.dept_id = #{id}")
    List<User> selectDeptUser(@Param("id") Integer id);
    
    
    
    
}