package com.accp.model;

import javax.persistence.*;

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT replace(uuid(),-,')")
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片
     */
    @Column(name = "pic_url")
    private String picUrl;

    /**
     * 价格
     */
    @Column(name = "view_price")
    private String viewPrice;

    /**
     * 店铺名字
     */
    private String nick;

    /**
     * 评价人数
     */
    @Column(name = "view_sales")
    private String viewSales;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取图片
     *
     * @return pic_url - 图片
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 设置图片
     *
     * @param picUrl 图片
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * 获取价格
     *
     * @return view_price - 价格
     */
    public String getViewPrice() {
        return viewPrice;
    }

    /**
     * 设置价格
     *
     * @param viewPrice 价格
     */
    public void setViewPrice(String viewPrice) {
        this.viewPrice = viewPrice;
    }

    /**
     * 获取店铺名字
     *
     * @return nick - 店铺名字
     */
    public String getNick() {
        return nick;
    }

    /**
     * 设置店铺名字
     *
     * @param nick 店铺名字
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * 获取评价人数
     *
     * @return view_sales - 评价人数
     */
    public String getViewSales() {
        return viewSales;
    }

    /**
     * 设置评价人数
     *
     * @param viewSales 评价人数
     */
    public void setViewSales(String viewSales) {
        this.viewSales = viewSales;
    }
}