package cn.tmsreception.service;

import cn.tmsreception.entity.Column;

import java.util.List;

/**
 * Created by 17921 on 2017/11/25.
 */
public interface IColumnService {

    //查询所有栏目
    public List<Column> getColumn();
}
