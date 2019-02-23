package com.ego.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbItemDubboService;
import com.ego.mapper.TbItemDescMapper;
import com.ego.mapper.TbItemMapper;
import com.ego.mapper.TbItemParamItemMapper;
import com.ego.mapper.TbItemParamMapper;
import com.ego.pojo.TbItem;
import com.ego.pojo.TbItemDesc;
import com.ego.pojo.TbItemExample;
import com.ego.pojo.TbItemParam;
import com.ego.pojo.TbItemParamItem;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TbItemDubboServiceImpl implements TbItemDubboService {
	@Resource
	private TbItemMapper tbItemMapper;
	@Resource
	private TbItemDescMapper tbItemDescMapper;
	@Resource
	private TbItemParamItemMapper tbItemParamItemMapper;
	@Resource
	private TbItemParamMapper tbItemParamMapper;
	@Override
	public EasyUIDataGrid show(int page, int rows) {
		PageHelper.startPage(page, rows);
		//查询全部
		List<TbItem> list = tbItemMapper.selectByExample(new TbItemExample());
		//分页代码
		//设置分页条件
		PageInfo<TbItem> pi = new PageInfo<>(list);
		
		//放入到实体类
		EasyUIDataGrid datagrid = new EasyUIDataGrid();
		datagrid.setRows(pi.getList());
		datagrid.setTotal(pi.getTotal());
		return datagrid;
	}
	@Override
	public int updItemStatus(TbItem tbItem) {
		return tbItemMapper.updateByPrimaryKeySelective(tbItem);
	}
	@Override
	public int insTbItemDesc(TbItem tbItem, TbItemDesc tbItemDesc,TbItemParamItem paramItem) throws Exception {
		int index = 0; 
		try {
			index+= tbItemMapper.insertSelective(tbItem);
			index+= tbItemDescMapper.insertSelective(tbItemDesc);
			index+= tbItemParamItemMapper.insertSelective(paramItem);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(index==3) {
			return 1;
		}else {
			throw new Exception("新增失败，数据还原"); 
		}
		
	}
	@Override
	public TbItemDesc selByDescId(long id) {
		return tbItemDescMapper.selectByPrimaryKey(id);
	}
	
	
}
