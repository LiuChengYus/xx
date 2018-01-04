package com.accp.service;

import com.accp.mapper.ProductMapper;
import com.accp.model.Product;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;
    public List<Product> getList(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return  productMapper.selectAll();
    }

}
