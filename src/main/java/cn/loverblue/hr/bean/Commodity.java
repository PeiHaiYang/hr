package cn.loverblue.hr.bean;

import java.util.Date;

public class Commodity {
    private Integer id;

    private String name;

    private Double price;

    private String brand;

    private Date jointime;

    private Integer tid;

    private String pic;

    private Num num;

    private Details details;

    public Num getNum() {
        return num;
    }

    public void setNum(Num num) {
        this.num = num;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public Date getJointime() {
        return jointime;
    }

    public void setJointime(Date jointime) {
        this.jointime = jointime;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", jointime=" + jointime +
                ", tid=" + tid +
                ", pic='" + pic + '\'' +
                ", num=" + num +
                ", details=" + details +
                '}';
    }
}