package cn.loverblue.hr.bean;

/**
 * @author PHY
 * @date 2020-10-23$-20:15
 */
public class Commodity_Category {
    private Integer id;
    private Integer commodity_id;
    private Integer category_id;

    public Commodity_Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(Integer commodity_id) {
        this.commodity_id = commodity_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Commodity_Category{" +
                "id=" + id +
                ", commodity_id=" + commodity_id +
                ", category_id=" + category_id +
                '}';
    }
}
