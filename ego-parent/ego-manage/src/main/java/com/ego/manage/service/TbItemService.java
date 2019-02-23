package com.ego.manage.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.pojo.TbItem;
import com.ego.pojo.TbItemDesc;

public interface TbItemService {
	/**
	 * 显示商品
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGrid show(int page,int rows);
	/**
	 * 批量修改商品状态
	 * @param ids
	 * @param status
	 * @return
	 */
	int update(String ids,byte status);
	/**
	 * 商品新增
	 * @param tbItem
	 * @param tbItemDesc
	 * @return
	 */
	int save(TbItem tbItem,String desc,String itemParams) throws Exception;
	/**
	 * 根据商品id查询出商品描述表信息
	 * @param id
	 * @return
	 */
	TbItemDesc show(long id);
	
}
