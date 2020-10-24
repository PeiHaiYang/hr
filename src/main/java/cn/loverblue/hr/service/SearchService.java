package cn.loverblue.hr.service;

import cn.loverblue.hr.bean.Commodity;
import cn.loverblue.hr.repository.CommodityMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author PHY
 * @date 2020-10-21$-10:32
 */
@Service
public class SearchService {
    @Resource
    CommodityMapper commodityMapper;


    public PageInfo<Commodity> search(int pageNum, int pageSize,String name){

        PageHelper.startPage(pageNum, pageSize);

        List<Commodity> list = commodityMapper.search(name);

        return new PageInfo<Commodity>(list);

    }
}
