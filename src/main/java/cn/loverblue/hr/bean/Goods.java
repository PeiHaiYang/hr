package cn.loverblue.hr.bean;


/**
 * @author PHY
 * @date 2020-10-23$-11:12
 */


public class Goods {

    private Integer id ;
    private String name;
    private String tips;
    private double price;
    private Integer selectNum;
    private String imgUrl;
    private boolean isSelected;
    private Integer upperLimit;

    public Goods() {
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
        this.name = name;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getSelectNum() {
        return selectNum;
    }

    public void setSelectNum(Integer selectNum) {
        this.selectNum = selectNum;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Integer getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Integer upperLimit) {
        this.upperLimit = upperLimit;
    }
}
