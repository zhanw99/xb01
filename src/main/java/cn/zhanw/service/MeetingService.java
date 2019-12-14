package cn.zhanw.service;

import cn.zhanw.entity.Meeting;
import cn.zhanw.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface MeetingService extends IService<Meeting> {
    PageInfo<Meeting> selectFavoriteArticle(Map<String, Object> params);

    List<User> selectDeptUser(Integer id);
}
