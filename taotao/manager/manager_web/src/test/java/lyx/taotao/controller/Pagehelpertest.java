package lyx.taotao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lyx.taotao.mapper.TbItemMapper;
import lyx.taotao.pojo.TbItem;
import lyx.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Title Pagehelpertest
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\12\20 0020 14:34
 */
public class Pagehelpertest
{
    @Test
    public void test(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/spring_*.xml");
        TbItemMapper tbItemMapper = applicationContext.getBean(TbItemMapper.class);

        TbItemExample tbItemExample=new TbItemExample();
        PageHelper.startPage(1,10);

        List<TbItem> tbItemslist = tbItemMapper.selectByExample(tbItemExample);
        for (TbItem item:tbItemslist){
            System.out.println(item.getTitle());
        }
        PageInfo<TbItem> tbItemPageInfo = new PageInfo<>(tbItemslist);
        long total = tbItemPageInfo.getTotal();
        System.out.println("共计："+total);
        System.out.println(tbItemPageInfo.getPageNum());
        System.out.println(tbItemPageInfo.getPageSize());
    }
}
