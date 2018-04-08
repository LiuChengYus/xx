package cn.tmsreception.dao;

import cn.tmsreception.entity.Column;

import java.util.List;

/**
 * Created by 17921 on 2017/12/9.
 */
public interface IColumnDAO {
    //查询所有栏目
    public List<Column> getColumn();
}
