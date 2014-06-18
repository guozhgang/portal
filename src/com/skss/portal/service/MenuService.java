package com.skss.portal.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Repository;

import com.frame.entity.ExtJsTree;
import com.frame.util.CglibProxy;
import com.skss.portal.biz.MenuBiz;
import com.skss.portal.entity.Menu;
import com.skss.portal.entity.TreeNode;

@Repository("service.menuService")
/**
 * 
 * ClassName：MenuService
 * 功能描述：菜单服务类 
 * 作者：guozhigang
 * 日期：2014年5月18日,下午7:58:24
 * 版本：V1.0
 */
public class MenuService {
	
	@Resource(name="biz.menuBiz")
	private MenuBiz menuBiz;
	

	/**
	 * 
	 * 方法名称：getMenu
	 * 方法描述：
	 * 参数：  @param menuId
	 * 参数：  @return    
	 * 返回值： JSONArray
	 */
	public JSONArray getMenu(String menuId){
		List<Menu> list = menuBiz.getAllMenu(menuId);
		List<TreeNode> treelist = new ArrayList<TreeNode>();
		for(int i = 0;i<list.size();i++){
			TreeNode treeNode = new TreeNode();
			treeNode.setId(list.get(i).getMenuId());
			treeNode.setText(list.get(i).getMenuName());
			if(menuId == null){
				treeNode.setState("closed");
			}else{
				//根据parent_menu_id统计是否含有子节点
				int count = menuBiz.getMenuCount(list.get(i).getMenuId());
				if(count == 0 ){
					treeNode.setState("open");
				}else{
					treeNode.setState("closed");
				}
			}
			
			treelist.add(treeNode);
		}
		JSONArray json = JSONArray.fromObject(treelist);
		return json;
	}
	public JSONArray findMenu(String menuId){
		List<Menu> list = menuBiz.getAllMenu(menuId);
		List<ExtJsTree> treelist = new ArrayList<ExtJsTree>();
		for(int i = 0;i<list.size();i++){
			ExtJsTree treeNode = new ExtJsTree();
			treeNode.setId(list.get(i).getMenuId());
			treeNode.setText(list.get(i).getMenuName());
			if(menuId == null){
				treeNode.setLeaf(false);
			}else{
				//根据parent_menu_id统计是否含有子节点
				int count = menuBiz.getMenuCount(list.get(i).getMenuId());
				if(count == 0 ){
					treeNode.setLeaf(true);
				}else{
					treeNode.setLeaf(false);
				}
			}
			
			treelist.add(treeNode);
		}
		JSONArray json = JSONArray.fromObject(treelist);
		return json;
	}
	
	
}
