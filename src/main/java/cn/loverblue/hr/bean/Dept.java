package cn.loverblue.hr.bean;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PHY
 * @date 2020-09-23$-21:32
 * lombok 的格式 data是是赋予set和get操作
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private int deptno;
    private String dname;
    private String Ioc;
}
