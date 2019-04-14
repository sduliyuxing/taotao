package lyx.taotao.controller;

import lyx.taotao.service.Itemcatservice;
import lyx.taotao.service.Itemservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EUtreenode;

import java.util.List;

/**
 * @Title Itemcatcontroller
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\12\20 0020 16:20
 */

@Controller
public class Itemcatcontroller {

    @Autowired
    private Itemcatservice itemcatservice;

    @ResponseBody
    @RequestMapping("/item/cat/list")
    public List<EUtreenode> getliemcatlist(@RequestParam(value = "id",defaultValue = "0")long parentid)
    {
        return itemcatservice.getitemcatlist(parentid);
    }
}

