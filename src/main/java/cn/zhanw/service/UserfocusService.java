package cn.zhanw.service;

import cn.zhanw.entity.UserfocusKey;

public interface UserfocusService extends IService<UserfocusKey> {
    Integer deleDetaID(Integer item, Integer id);
}
