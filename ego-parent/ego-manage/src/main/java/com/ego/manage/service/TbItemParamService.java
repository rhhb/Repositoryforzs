package com.ego.manage.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.pojo.TbItemParam;

public interface TbItemParamService {
	/**
	 * 分页显示商品规格参数
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGrid showPage(int page,int rows);
	/**
	 * 批量删除规格参数
	 * @param ids
	 * @return
	 */
	int delete(String ids) throws Exception;
	/**
	 * 根据类目id查询模板信息
	 * @param catId
	 * @return
	 */
	EgoResult showParam(long catId);
	/**
	 * 新增模板信息
	 * @param param
	 * @return
	 */
	EgoResult save(TbItemParam param);
	/**
	 * 根据商品id查询商品参数规格
	 * @param id
	 * @return
	 */
	TbItemParam showItemParam(long id);
}
