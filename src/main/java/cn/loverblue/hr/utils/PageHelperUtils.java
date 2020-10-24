package cn.loverblue.hr.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author PHY
 * @date 2020-10-17$-17:41
 */
public class PageHelperUtils {
    /*
     在二级分类的基础上
     商品的分页操作
 */
    public static <T> PageInfo<T> pageHelperpart(Class<T> tClass,int pageNum,int pageSize,List<T> list){

        PageHelper.startPage(pageNum, pageSize);

        return new PageInfo<T>(list);
    }

}
