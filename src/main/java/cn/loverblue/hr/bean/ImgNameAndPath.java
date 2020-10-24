package cn.loverblue.hr.bean;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

/**
 * @author PHY
 * @date 2020-10-17$-10:31
 */
public class ImgNameAndPath {
    private int sortid;
    private String sortname;
    private String imgname;

    public int getSortid() {
        return sortid;
    }

    public void setSortid(int sortid) {
        this.sortid = sortid;
    }

    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }
}
