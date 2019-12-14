package cn.zhanw.controller;

import cn.zhanw.entity.Dept;
import cn.zhanw.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("HTML/html/manager/dept")
public class DeptController {

    @Autowired
    DeptService service;

    @RequestMapping("selectAll")
    public List<Dept> selectAll(){
        return service.selectAll();
    }

}
