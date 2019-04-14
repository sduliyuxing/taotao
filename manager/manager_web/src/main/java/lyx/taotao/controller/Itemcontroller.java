package lyx.taotao.controller;


import com.github.pagehelper.Page;
import lyx.taotao.pojo.TbItem;
import lyx.taotao.service.Itemservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EUdateresult;

/**
 * @Title Itemcontroller
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\12\19 0019 11:42
 */

@Controller
public class Itemcontroller {

   @Autowired
    private Itemservice itemservice;

   @ResponseBody
    @RequestMapping("/item/{itemid}")
    public TbItem getitembyid(@PathVariable long itemid){
       TbItem item = itemservice.getitembyid(itemid);
       return item;
   }

   @ResponseBody
    @RequestMapping("/item/list")
    public EUdateresult getlist(@RequestParam(defaultValue = "1")int page,  @RequestParam(defaultValue = "10") int rows){
       EUdateresult eUdateresult = itemservice.getitemlist(page, rows);
       return eUdateresult;
   }



}
