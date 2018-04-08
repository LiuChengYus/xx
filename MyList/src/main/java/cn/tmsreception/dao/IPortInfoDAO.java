package cn.tmsreception.dao;



import cn.tmsreception.entity.PortInfo;

import java.util.List;

/**
 * Created by 17921 on 2017/12/12.
 */
public interface IPortInfoDAO {
    //查询所有仓库
    public List<PortInfo> findallPort();
}
