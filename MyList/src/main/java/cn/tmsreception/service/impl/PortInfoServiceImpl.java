package cn.tmsreception.service.impl;

import cn.tmsreception.dao.IPortInfoDAO;
import cn.tmsreception.entity.PortInfo;
import cn.tmsreception.service.IPortInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 17921 on 2017/12/12.
 */
@Service("PortInfoService")
public class PortInfoServiceImpl implements IPortInfoService {

    @Resource(name = "IPortInfoDAO")
    private IPortInfoDAO portInfoDAO;



    public List<PortInfo> findallPort() {
        return portInfoDAO.findallPort();
    }


    public IPortInfoDAO getPortInfoDAO() {
        return portInfoDAO;
    }

    public void setPortInfoDAO(IPortInfoDAO portInfoDAO) {
        this.portInfoDAO = portInfoDAO;
    }
}
