package lyx.taotao.service;

import lyx.taotao.pojo.TbItemCat;
import pojo.EUtreenode;

import java.util.List;

/**
 * @Title Itemcatservice
 * @Description
 * @Copyright: ��Ȩ���� (c) 2018 - 2019
 * @Company: ������������
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\12\20 0020 16:07
 */
public interface Itemcatservice {
    List<EUtreenode> getitemcatlist(long parentid);
}
