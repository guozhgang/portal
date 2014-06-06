package com.skss.portal.dao;

import java.util.List;

import com.skss.portal.entity.TbColumn;

public interface ColumnDao {
	public List<TbColumn> getColumn(String sql);
	
	public int getColumnCount(String parentColumnCode);
}
