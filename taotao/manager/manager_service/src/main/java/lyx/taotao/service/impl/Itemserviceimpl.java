package lyx.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lyx.taotao.mapper.TbItemMapper;
import lyx.taotao.pojo.TbItem;
import lyx.taotao.pojo.TbItemExample;
import lyx.taotao.pojo.TbItemExample.Criteria;
import lyx.taotao.service.Itemservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EUdateresult;

import javax.swing.text.EditorKit;
import java.util.List;

/**
 * @Title Itemserviceimpl
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\12\19 0019 11:33
 */

@Service
public class Itemserviceimpl implements Itemservice {

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getitembyid(long itemid) {
//        TbItem tbItem = itemMapper.selectByPrimaryKey(itemid);
        TbItemExample tbItemExample=new TbItemExample();
        Criteria criteria = tbItemExample.createCriteria();
        criteria.andIdEqualTo(itemid);
        List<TbItem> tbItems = itemMapper.selectByExample(tbItemExample);
        if (tbItems.size()>0&&tbItems!=null){
            return tbItems.get(0);
        }
        return null;
    }

    @Override
    public EUdateresult getitemlist(int page, int rows) {
        TbItemExample example=new TbItemExample();
        PageHelper.startPage(page,rows);

        List<TbItem> itemList = itemMapper.selectByExample(example);
        PageInfo<TbItem> pageInfo = new PageInfo<>(itemList);


        EUdateresult eUdateresult=new EUdateresult();
        eUdateresult.setRows(itemList);
        eUdateresult.setTotal(pageInfo.getTotal());
        return eUdateresult;
    }
}
