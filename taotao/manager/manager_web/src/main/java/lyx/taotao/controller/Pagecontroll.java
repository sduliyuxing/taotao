package lyx.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title pagecontroll
 * @Description
 * @Copyright: ��Ȩ���� (c) 2018 - 2019
 * @Company: ������������
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\12\20 0020 10:35
 */

@Controller
public class Pagecontroll {

    @RequestMapping("/")
    public String showindex(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String showpage(@PathVariable String page){
        return page;
    }
}
