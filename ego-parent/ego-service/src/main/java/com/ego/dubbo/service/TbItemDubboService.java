package com.ego.dubbo.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.pojo.TbItem;
import com.ego.pojo.TbItemDesc;
import com.ego.pojo.TbItemParam;
import com.ego.pojo.TbItemParamItem;

public interface TbItemDubboService {
	/**
	 * 商品分页查询
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGrid show(int page,int rows);
	/**
	 * 根据id修改状态
	 * @param id
	 * @param status
	 * @return
	 */
	int updItemStatus(TbItem tbItem);
	/**
	 * 新增包含商品表和商品描述表
	 * @param tbItem
	 * @param tbItemDesc
	 * @return
	 */
	int insTbItemDesc(TbItem tbItem,TbItemDesc tbItemDesc,TbItemParamItem paramItem) throws Exception;
	/**
	 * 根据商品id显示商品描述信息
	 * @param cid
	 * @return
	 */
	TbItemDesc selByDescId(long id);
	/**
	 * 根据商品id修改商品相关信息
	 * @param tbItem
	 * @param tbItemDesc
	 * @param paramItem
	 * @return
	 */
	int updItemDescParam(TbItem tbItem,TbItemDesc tbItemDesc,TbItemParamItem paramItem) throws Exception;
}
