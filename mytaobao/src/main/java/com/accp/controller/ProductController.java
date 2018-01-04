package com.accp.controller;

import com.accp.Common.AjaxRtn;
import com.accp.Common.Pager;
import com.accp.model.Product;
import com.accp.service.ProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("getList")
    @ResponseBody
    public Object getList(Pager pager){
        List<Product> productList= productService.getList(pager.getPage(),pager.getRows());
        PageInfo<Product> pageInfo = new PageInfo<Product>(productList);
        return new AjaxRtn(true,pageInfo.getTotal(),productList);

    }
}
