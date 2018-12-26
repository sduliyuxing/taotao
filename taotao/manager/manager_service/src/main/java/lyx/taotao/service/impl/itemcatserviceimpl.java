package lyx.taotao.service.impl;

import lyx.taotao.mapper.TbItemCatMapper;
import lyx.taotao.pojo.TbItemCat;
import lyx.taotao.pojo.TbItemCatExample;
import lyx.taotao.pojo.TbItemCatExample.Criteria;
import lyx.taotao.service.Itemcatservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EUtreenode;

import java.util.*;

/**
 * @Title itemcatserviceimpl
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\12\20 0020 16:08
 */

@Service
public class itemcatserviceimpl implements Itemcatservice  {

    @Autowired
    private TbItemCatMapper itemCatMapper;


    @Override
    public List<EUtreenode> getitemcatlist(long parentid) {

        TbItemCatExample example=new TbItemCatExample();
        Criteria criteria = example.createCriteria();
        Criteria criteria1 = criteria.andParentIdEqualTo(parentid);
        List<TbItemCat> tbItemCats = itemCatMapper.selectByExample(example);

        List<EUtreenode> eUtreenodeList=new ArrayList<>();
        for (TbItemCat itemCat: tbItemCats){
            EUtreenode eUtreenode=new EUtreenode();
            eUtreenode.setId(itemCat.getId());
            eUtreenode.setTest(itemCat.getName());
            eUtreenode.setStatus(itemCat.getIsParent()?"close":"open");
            eUtreenodeList.add(eUtreenode);
        }
        return eUtreenodeList;
    }
}
