package cn.zhanw.service.serviceImpl;

import cn.zhanw.entity.Dept;
import cn.zhanw.mapper.DeptMapper;
import cn.zhanw.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeptServiceImpl extends IServiceImpl<Dept> implements DeptService {

    @Autowired
    DeptMapper mapper;

    public List<Dept> selectAll(){
        return mapper.selectAll();
    }

}
