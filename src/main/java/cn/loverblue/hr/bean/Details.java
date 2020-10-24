package cn.loverblue.hr.bean;



public class Details {

    private Integer id;

    private String describe;

    private Integer sid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", describe='" + describe + '\'' +
                ", sid=" + sid +
                '}';
    }
}