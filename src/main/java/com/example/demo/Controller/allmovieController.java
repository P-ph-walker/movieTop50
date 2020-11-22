package com.example.demo.Controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Dao.*;
import com.example.demo.Entity.Top;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @ClassName: allmovieController
 * @Description:
 * @Author: CHonghao
 * @Date: 2020/11/11 20:19
 * @Version: V1.0
 **/


@RestController
@RequestMapping("/movie")
@CrossOrigin
public class allmovieController {
    @Autowired
    private TopDao topDao;

    @RequestMapping("/selectAll")
    @ResponseBody
    public Map<String ,Object> selectAll(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        System.out.println(topDao.selectAll());
        List<Top> topall = topDao.selectAll();
        modelMap.put("data",topall);
        return modelMap;
    }
    @RequestMapping("/selectId")
    @ResponseBody
    public Map<String ,Object> selectId(int id) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Top movie = topDao.selectByPrimaryKey(id);
        modelMap.put("data", movie);
        return modelMap;
    }
    @RequestMapping("/delete")
    public int deleteMovie(int id){
        // 删除成功返回1，删除失败返回0
        int rt = topDao.deleteByPrimaryKey(id);
        return rt;
    }

    @RequestMapping("/update")
    @ResponseBody
    public int updateMovie(@RequestBody Top top){
        System.out.println(top);
        int rt = topDao.updateByPrimaryKey(top);
        return rt;
    }


}