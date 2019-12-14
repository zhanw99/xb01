package cn.zhanw.service.serviceImpl;

import cn.zhanw.entity.UserfocusKey;
import cn.zhanw.mapper.UserfocusMapper;
import cn.zhanw.service.UserfocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserfocusServiceImpl extends IServiceImpl<UserfocusKey> implements UserfocusService {
    @Autowired
    UserfocusMapper mapper;

    @Override
    public Integer deleDetaID(Integer item, Integer id){
        return mapper.deleDetaID(item, id);
    }

}
