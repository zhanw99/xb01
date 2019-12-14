package cn.zhanw.service.serviceImpl;

import cn.zhanw.entity.User;
import cn.zhanw.entity.UserfocusKey;
import cn.zhanw.mapper.UserMapper;
import cn.zhanw.mapper.UserfocusMapper;
import cn.zhanw.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
@Transactional//这个方法的事务由spring处理，即是方法里面对数据库操作
public class UserServiceImpl extends IServiceImpl<User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserfocusMapper userfocusMapper;


    public List<User> selectPage(Map<String, Object> params){
        if (params.get("name")==null){
            params.put("name","");
        }
        PageHelper.startPage((Integer) params.get("pageNum"), (Integer)params.get("pageSize"));//开启分页拦截功能;//开启分页拦截功能
        return userMapper.selectAllName((String) params.get("name"));
    }
    @Override
    public PageInfo<User> pageAll(Map<String, Object> params,Integer userId){
        if (params.get("pageNum")==null||"".equals(params.get("pageNum"))){
            params.put("pageNum",1);
        }
        if (params.get("pageSize")==null||"".equals(params.get("pageSize"))){
            params.put("pageSize",5);
        }
        if (params.get("name")==null){
            params.put("name","");
        }
        //先查询全部用户
        List<User> name = userMapper.selectAllName((String) params.get("name"));
        //在查询全部关注
        List<UserfocusKey> list = userfocusMapper.selectAll();
        List<User> list2 = new ArrayList<User>();
        //遍历用户
        for (User user : name) {
            //遍历关注
            for (UserfocusKey userfocusKey : list) {
                //如果关注id和登陆用户相等，并且用户id被关注人id相等
                if (userfocusKey.getUserId()==userId&&user.getId()==userfocusKey.getUserFocusId()){
                    user.setFlag(true);
                }
            }
            list2.add(user);
        }
        PageHelper.startPage((Integer) params.get("pageNum"), (Integer)params.get("pageSize"));//开启分页拦截功能;//开启分页拦截功能
        return new PageInfo<User>(list2);
    }
    @Override
    public PageInfo<User> selectFocusId(Map<String, Object> params){
        if (params.get("pageNum")==null){
            params.put("pageNum",1);
        }
        if (params.get("pageSize")==null){
            params.put("pageSize",5);
        }
        PageHelper.startPage((Integer) params.get("pageNum"), (Integer)params.get("pageSize"));//开启分页拦截功能;//开启分页拦截功能
        return new PageInfo<User>(userMapper.selectFocusId((Integer) params.get("id")));
    }

    @Override
    public User selectLogin(User user){
        return userMapper.selectLogin(user);
    }
    @Override
    public User updataOpenId(Integer id){
        return userMapper.updataOpenId(id);
    }
}
