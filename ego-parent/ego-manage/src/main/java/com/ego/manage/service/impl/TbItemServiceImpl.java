package com.ego.manage.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.utils.IDUtils;
import com.ego.dubbo.service.TbItemDubboService;
import com.ego.manage.service.TbItemService;
import com.ego.pojo.TbItem;
import com.ego.pojo.TbItemDesc;
import com.ego.pojo.TbItemParamItem;

@Service
public class TbItemServiceImpl implements TbItemService{
	@Reference
	private TbItemDubboService tbItemDubboServiceImpl;
	@Override
	public EasyUIDataGrid show(int page, int rows) {
		return tbItemDubboServiceImpl.show(page, rows);
	}
	@Override
	public int update(String ids, byte status) {
		int index = 0 ;
		TbItem item = new TbItem();
		String[] idsStr = ids.split(",");
		for (String id : idsStr) {
			item.setId(Long.parseLong(id));
			item.setStatus(status);
			index +=tbItemDubboServiceImpl.updItemStatus(item);
		}
		if(index==idsStr.length){
			return 1;
		}
		return 0;
	}
	@Override
	public int save(TbItem tbItem, String desc,String itemParams) throws Exception {
		long id = IDUtils.genItemId();
		tbItem.setId(id);
		Date data = new Date();
		tbItem.setCreated(data);
		tbItem.setUpdated(data);
		tbItem.setStatus((byte) 1);
		TbItemDesc itemdesc = new TbItemDesc();
		itemdesc.setItemDesc(desc);
		itemdesc.setCreated(data);
		itemdesc.setUpdated(data);
		itemdesc.setItemId(id);
		TbItemParamItem paramItem = new TbItemParamItem();
		paramItem.setId(id);
		paramItem.setCreated(data);
		paramItem.setUpdated(data);
		paramItem.setParamData(itemParams);
		int index = 0;
		
		index = tbItemDubboServiceImpl.insTbItemDesc(tbItem, itemdesc,paramItem);
		
		return index;
	}
	@Override
	public TbItemDesc show(long id) {
		
		return tbItemDubboServiceImpl.selByDescId(id);
	}
}
