package cn.tmsreception.service.impl;

import cn.tmsreception.dao.IColumnDAO;
import cn.tmsreception.entity.Column;
import cn.tmsreception.service.IColumnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 17921 on 2017/11/25.
 */
@Service("ColumnService")
public class ColumnServiceImpl implements IColumnService {

    @Resource(name = "IColumnDAO")
    private IColumnDAO columnDAO;


    public List<Column> getColumn() {
        return columnDAO.getColumn();
    }


    public IColumnDAO getColumnDAO() {
        return columnDAO;
    }

    public void setColumnDAO(IColumnDAO columnDAO) {
        this.columnDAO = columnDAO;
    }
}
