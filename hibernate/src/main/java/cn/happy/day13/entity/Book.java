package cn.happy.day13.entity;

import javax.persistence.*;

/**
 * Created by CY on 2018/1/4.
 */
@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue
    private Integer bookid;
    @Column
    private String bookname;
    @Column
    private String booktype;
    @Column
    private Integer bookprice;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public Integer getBookprice() {
        return bookprice;
    }

    public void setBookprice(Integer bookprice) {
        this.bookprice = bookprice;
    }
}
