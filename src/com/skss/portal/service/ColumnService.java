package com.skss.portal.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;

import com.skss.portal.biz.ColumnBiz;
import com.skss.portal.entity.TbColumn;
import com.skss.portal.entity.TreeNode;

@Service("service.columnService")
public class ColumnService {
	@Resource(name = "biz.columnBiz")
	private ColumnBiz columnBiz;
	
	public JSONArray getColumn(String parentColumnCode){
		String sql = "select * from cms_front_column ";
		if(parentColumnCode == null){
			sql+="where parent_column_code = '1'";
		}else{
			sql+="where parent_column_code = '"+parentColumnCode+"'";
		}
		List<TbColumn> list = columnBiz.getColumn(sql);
		List<TreeNode> treelist = new ArrayList<TreeNode>();
		if(list.size()!=0){
			for(int i=0;i<list.size();i++){
				TreeNode tree = new TreeNode();
				tree.setId(list.get(i).getColumnCode());
				tree.setText(list.get(i).getColumnName());
				if(list.get(i).getParentColumnCode().equals("1")){
					tree.setState("closed");
				}else{
					int count = columnBiz.getColumnCount(list.get(i).getColumnCode());
					if(count!=0) {
						tree.setState("closed");
					} else {
						tree.setState("open");
					}					
				}
				treelist.add(tree);
			}
		}
		JSONArray json = JSONArray.fromObject(treelist);
		return json;
	}
}