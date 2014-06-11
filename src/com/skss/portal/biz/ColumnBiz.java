package com.skss.portal.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.skss.portal.dao.ColumnDao;
import com.skss.portal.entity.TbColumn;

@Repository("biz.columnBiz")
public class ColumnBiz {
	@Resource(name = "dao.columnDao")
	private ColumnDao columnDao;
	
	public List<TbColumn> getColumn(String sql){
		return columnDao.getColumn(sql);
	}
	
	public int getColumnCount(String parentColumnCode) {
		return columnDao.getColumnCount(parentColumnCode);
	}
}
