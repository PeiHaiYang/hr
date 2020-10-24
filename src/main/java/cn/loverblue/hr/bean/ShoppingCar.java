package cn.loverblue.hr.bean;

public class ShoppingCar {
    private Integer shop_car_id;

    private Integer pid;

    private Integer uid;

    private Integer productnum;

    private String productprice;

    private String address;

    private String type;

    public Integer getShop_car_id() {
        return shop_car_id;
    }

    public void setShop_car_id(Integer shop_car_id) {
        this.shop_car_id = shop_car_id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getProductnum() {
        return productnum;
    }

    public void setProductnum(Integer productnum) {
        this.productnum = productnum;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice == null ? null : productprice.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    @Override
    public String toString() {
        return "ShoppingCar{" +
                "shop_car_id=" + shop_car_id +
                ", pid=" + pid +
                ", uid=" + uid +
                ", productnum=" + productnum +
                ", productprice='" + productprice + '\'' +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}