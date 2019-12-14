package cn.zhanw.controller;

import cn.zhanw.entity.Meeting;
import cn.zhanw.entity.Result;
import cn.zhanw.entity.User;
import cn.zhanw.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("manager/mettingAdd")
public class MeetingAddController {

    @Autowired
    MeetingService meetingService;

    @RequestMapping("insertMeetingAdd")
    public Result insertMeetingAdd(@RequestBody Map<String, Object> params) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        Integer deptId = (Integer) params.get("deptId");//部门id
        params.get("deptName");//部门id  再用一条SQL语句查找
        String title = (String) params.get("title");
//        String content = (String) params.get("content");
        params.get("publishDate");//发布时间
        String startTime = (String) params.get("startTime");//开始时间
//        Date parse = formatter.parse(startTime);

        String endTime = (String) params.get("endTime");//结束时间
//        Date parse2 = formatter.parse(endTime);
//        System.out.println(params.get("status"));
//        String makeUser = (String) params.get("makeUser");//开会人数【数组】
        Meeting meeting = new Meeting();
        meeting.setDeptId(deptId);
        meeting.setDeptName("研发部");
        meeting.setTitle(title);//标题
//        meeting.setContent(content);
        meeting.setPublishDate(null);//发布时间
        meeting.setStartTime(null);//开始时间
        meeting.setEndTime(null);//结束时间
        meeting.setStatus(0);//会议状态
//        meeting.setMakeUser((String) makeUser);//抄送人
//        meeting.setMakeUser(makeUser);//抄送人
        System.out.println(startTime);
        System.out.println(endTime);
        System.out.println(meeting);
        return new Result();
    }

    /**
     * 更新对应部门人员
     * @param deptId
     * @return
     */
    @RequestMapping("selectDeptUser")
    public List<User> selectDeptUser(@RequestParam Integer deptId){
        return meetingService.selectDeptUser(deptId) ;
    }
}
