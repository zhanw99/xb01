package cn.zhanw.mapper;

import cn.zhanw.entity.UserfocusKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserfocusMapper extends Mapper<UserfocusKey> {

    @Select(" SELECT " +
            " uf.* " +
            " FROM " +
            "  userfocus uf " +
            "  WHERE uf.user_id= #{id}")
    public List<UserfocusKey> selectNameList(Integer id);
    @Select("DELETE  " +
            "FROM " +
            " userfocus   " +
            "WHERE " +
            " user_id = #{item} " +
            " AND user_focus_id =#{id}")
    public Integer deleDetaID(@Param("item")Integer item,@Param("id")Integer id);



}