package cn.zhanw.mapper;

import cn.zhanw.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper extends Mapper<User> {
    @Select("SELECT " +
            " id, " +
            " username, " +
            " PASSWORD, " +
            " email, " +
            " real_name, " +
            " age, " +
            " phone, " +
            " gender, " +
            " `desc`, " +
            " register_time, " +
            " login_time, " +
            " pic, " +
            " look, " +
            " is_secret, " +
            " dept_name, " +
            " dept_id  " +
            "FROM  " +
            " `user`" +
            "   WHERE   " +
            "   real_name LIKE  CONCAT( '%', #{name}, '%' ) ")
    List<User> selectAllName(String name);
    @Select("  SELECT  " +
            "    uc.id,uc.username,uc.email,uc.real_name,uc.age,uc.phone ,uc.gender,uc.`desc`,uc.register_time,uc.login_time,uc.pic,uc.look,uc.is_secret,uc.dept_name,uc.dept_id  " +
            "FROM  " +
            "  `user` us  " +
            "  LEFT JOIN  " +
            "  userfocus uf  " +
            "  ON  " +
            "  uf.user_id=us.id  " +
            "  LEFT JOIN  " +
            "  `user` uc  " +
            "  ON uf.user_focus_id=uc.id  " +
            "  where  " +
            "  us.id = #{id} ")
    List<User> selectFocusId(@Param("id")Integer id);

    @Select("SELECT " +
            " id, " +
            " username, " +
            " `password`, " +
            " email, " +
            " real_name, " +
            " age, " +
            " phone, " +
            " gender, " +
            " `desc`, " +
            " register_time, " +
            " login_time, " +
            " pic, " +
            " look, " +
            " is_secret, " +
            " dept_name, " +
            " dept_id  " +
            "FROM " +
            "`user`  " +
            "WHERE " +
            " username = #{username}  " +
            " AND `password` = #{password}")
    User selectLogin(User user);


    /**
     * 详细资料
     * @param id
     * @return
     */
    @Select("SELECT us.* ,COUNT(*) follow " +
            "FROM `user` us " +
            "LEFT JOIN " +
            "userfocus uf " +
            "ON  " +
            "uf.user_focus_id =us.id " +
            "WHERE " +
            "us.id=#{id}")
    User updataOpenId(Integer id);

}