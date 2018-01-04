package cn.mybook.entity;

import java.util.Date;

/**
 * Created by CY on 2017/12/22.
 */
public class Book {
    private Integer  book_id;
    private String  book_code;
    private String  book_name;
    private Integer  book_type;
    private Integer  book_author;
    private String  publish_press;
    private Date    publish_date;
    private Integer  is_borrow;
    private String  createdBy;
    private Date    creation_time;
    private Date    last_updatetime;
    private Type    type;
    private Author author;

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_code() {
        return book_code;
    }

    public void setBook_code(String book_code) {
        this.book_code = book_code;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Integer getBook_type() {
        return book_type;
    }

    public void setBook_type(Integer book_type) {
        this.book_type = book_type;
    }

    public Integer getBook_author() {
        return book_author;
    }

    public void setBook_author(Integer book_author) {
        this.book_author = book_author;
    }

    public String getPublish_press() {
        return publish_press;
    }

    public void setPublish_press(String publish_press) {
        this.publish_press = publish_press;
    }

    public Date getPublish_data() {
        return publish_date;
    }

    public void setPublish_data(Date publish_date) {
        this.publish_date = publish_date;
    }

    public Integer getIs_borrow() {
        return is_borrow;
    }

    public void setIs_borrow(Integer is_borrow) {
        this.is_borrow = is_borrow;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Date creation_time) {
        this.creation_time = creation_time;
    }

    public Date getLast_updatetime() {
        return last_updatetime;
    }

    public void setLast_updatetime(Date last_updatetime) {
        this.last_updatetime = last_updatetime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
