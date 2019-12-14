package cn.zhanw.controller;

import cn.zhanw.entity.Meeting;
import cn.zhanw.entity.Result;
import cn.zhanw.service.MeetingService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("manager/metting")
public class meetingController {

    @Autowired
    MeetingService meetingService;

    @RequestMapping("selectAll")
    public PageInfo<Meeting> selectMeeting(@RequestBody Map<String, Object> params) {
        System.out.println(params.get("pageNum"));
        System.out.println(  params.get("pageSize"));
        System.out.println( params.get("title"));
        System.out.println( params.get("state"));//状态
        return meetingService.selectFavoriteArticle(params);
    }
}
