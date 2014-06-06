package com.skss.portal.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.frame.dao.BaseDao;
import com.skss.portal.dao.ColumnDao;
import com.skss.portal.entity.TbColumn;

@Repository("dao.columnDao")
public class ColumnDaoImpl extends BaseDao<TbColumn> implements ColumnDao {

	public List<TbColumn> getColumn(String sql) {
		// TODO Auto-generated method stub
		List<TbColumn> list = findListBySQL(sql);
		return list;
	}

	public int getColumnCount(String parentColumnCode) {
		
		return getCountBySql("select count(*) from cms_front_column where parent_column_code = ?", parentColumnCode);
	} 

}
