package cn.zhanw.service.serviceImpl;

import cn.zhanw.entity.Meeting;
import cn.zhanw.entity.User;
import cn.zhanw.mapper.MeetingMapper;
import cn.zhanw.service.MeetingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MeetingServiceImpl extends IServiceImpl<Meeting> implements MeetingService {
    @Autowired
    MeetingMapper meetingMapper;

    @Override
    public PageInfo<Meeting> selectFavoriteArticle(Map<String, Object> params) {
        if (params.get("pageNum") == null) {
            params.put("pageNum", 1);
        }
        if (params.get("pageSize") == null) {
            params.put("pageSize", 5);
        }
        PageHelper.startPage((Integer) params.get("pageNum"),(Integer)params.get("pageSize"));
        List<Meeting> meetings = meetingMapper.selectMeeting((String) params.get("state"), (String) params.get("title"));
        return new  PageInfo<Meeting>(meetings);
    }
    @Override
    public List<User> selectDeptUser(Integer id) {
        return meetingMapper.selectDeptUser(id);
    }



}
