package cn.uptra.schoolwork.modules.book.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("books")
public class Book {

    @TableId("id")
    private Integer id;

    private Integer bid;
    private String title;
    private String author;
    private String description;
    private String tags;
    private String cover_url;
    private Double price;
    private Integer stock;
    private Integer sales;
}
