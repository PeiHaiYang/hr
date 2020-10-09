package cn.loverblue.hr.service;

import cn.loverblue.hr.bean.Dept;
import cn.loverblue.hr.repository.DeptMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author PHY
 * @date 2020-09-23$-21:40
 */
@Service
public class DeptService {

    @Resource
    private DeptMapper deptMapper;

    public List<Dept> findAll(){
        return deptMapper.findAll();
    };

    public  List<Dept> selectById(Integer id){
        return deptMapper.selectById(id);
    }


}
