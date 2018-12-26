package lyx.taotao.service;

import lyx.taotao.pojo.TbItem;
import pojo.EUdateresult;

public interface Itemservice {
    TbItem getitembyid(long itemid);
    EUdateresult getitemlist(int page,int rows);
}
