package cn.loverblue.hr.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author PHY
 * @date 2020-10-23$-11:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsInfo {

   private String category;
   private String key;
   private List<Goods> goods;


}
