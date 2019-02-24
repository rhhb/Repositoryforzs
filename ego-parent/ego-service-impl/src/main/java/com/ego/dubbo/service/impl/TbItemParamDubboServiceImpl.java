package com.ego.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbItemParamDubboService;
import com.ego.mapper.TbItemMapper;
import com.ego.mapper.TbItemParamItemMapper;
import com.ego.mapper.TbItemParamMapper;
import com.ego.pojo.TbItem;
import com.ego.pojo.TbItemParam;
import com.ego.pojo.TbItemParamExample;
import com.ego.pojo.TbItemParamItem;
import com.ego.pojo.TbItemParamItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TbItemParamDubboServiceImpl implements TbItemParamDubboService{
	@Resource
	private TbItemParamMapper tbItemParamMapper;
	@Resource
	private TbItemMapper tbItemMapper;
	@Resource
	private TbItemParamItemMapper tbItemParamItemMapper;
	@Override
	public EasyUIDataGrid showPage(int page, int rows) {
		//先设置分页条件
		PageHelper.startPage(page,rows);
		//设置查询的SQL语句
		//XXXXExample() 设置了什么,相当于在 sql 中 where 从句中添加条件
		//如果表中有一个或一个以上的列是text类型. 生成的方法xxxxxxxxWithBlobs()
		//如果使用 xxxxWithBlobs() 查询结果中包含带有 text 类的列,如果没有使用 withblobs() 方法不带有 text 类型.
		List<TbItemParam> list  =tbItemParamMapper.selectByExampleWithBLOBs(new TbItemParamExample());
		//根据程序员自己编写的 SQL 语句结合分页插件产生最终结果,封装到 PageInfo
		PageInfo<TbItemParam> pi  = new PageInfo<>(list);
		//设置方法返回结果
		EasyUIDataGrid datagrid = new EasyUIDataGrid();
		datagrid.setRows(pi.getList());
		datagrid.setTotal(pi.getTotal());
		return datagrid;
	}
	@Override
	public int delByIds(String ids) throws Exception {
		int index = 0;
		String[] idStr = ids.split(",");
		for (String id : idStr) {
			index +=tbItemParamMapper.deleteByPrimaryKey(Long.parseLong(id));
		}
		if(index==idStr.length) {
			return 1;
		}else {
			throw new Exception("删除失败.数据不存在");
		}		
	}
	@Override
	public TbItemParam selByCatid(long catId) {
		TbItemParamExample example = new TbItemParamExample();
		example.createCriteria().andItemCatIdEqualTo(catId);
		List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	@Override
	public int insParam(TbItemParam param) {
		
		return tbItemParamMapper.insertSelective(param);
	}
	
	@Override
	public TbItemParamItem selByItemId(long id) {
		TbItemParamItemExample itemExample = new TbItemParamItemExample();
		itemExample.createCriteria().andItemIdEqualTo(id);
		List<TbItemParamItem> list = tbItemParamItemMapper.selectByExampleWithBLOBs(itemExample);
		System.out.println(list);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
}
