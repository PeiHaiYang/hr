package cn.loverblue.hr.bean;

import org.springframework.stereotype.Component;


public class Num {
    private Integer id;

    private Integer number;

    private Integer sid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Num{" +
                "id=" + id +
                ", number=" + number +
                ", sid=" + sid +
                '}';
    }
}