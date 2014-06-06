package com.frame.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SQLQuery;

import com.frame.util.SessionUtil;

@SuppressWarnings("unchecked")
public class BaseDao <T> extends SessionUtil implements SQLDao<T>,HQLDao<T> {

	public List<T> findListBySQL(String sql,Object... objs){
		SQLQuery query = getSession().createSQLQuery(formatSQL(sql));
		fillParam(query,objs);
		return query.addEntity(getEntity()).list();
	}
	public List<T> executeBySQL(String sql){
		return getSession().createSQLQuery(sql).addEntity(getEntity()).list();
	}
	public List<T> findPaginationListBySQL(String sql, int start, int limit, Object... objs) {
		SQLQuery query = getSession().createSQLQuery(formatSQL(sql));
		query.setFirstResult(start);
		query.setMaxResults(limit);
		fillParam(query, objs);
		return query.addEntity(getEntity()).list();
	}
	private Class<?> getEntity(){
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	private static String formatSQL(String sql){
		int num = getSubstrByIndex(sql,"?",0);
		for(int i=0;i<num;i++){
			sql=sql.replaceFirst("[?]", ":param"+i);
		}
		return sql;
	}
	private static int getSubstrByIndex(String sql,String str,int fromIndex){
		int index=sql.indexOf(str, fromIndex);
		int num = 0;
		if(index!=-1){
			num = getSubstrByIndex(sql,str,index+1)+1;
		}
		return num;
	}
	private void fillParam(SQLQuery query, Object... objs){
		if(objs instanceof Object){
			for(int i=0;i<objs.length;i++){
				query.setParameter("param"+i, objs[i]);
			}
		}
	}
	
	public int getCountBySql(String sql, Object... objs) {
		SQLQuery query=getSession().createSQLQuery(formatSQL(sql));
		fillParam(query, objs);		
		return Integer.parseInt(query.uniqueResult()+"");
	}
	public T load(String sql, String id) {
		T t = (T)getSession().load(getEntity(), id);
		return t;
	}
	public T get(String sql, String id) {
		T t = (T)getSession().get(getEntity(), id);
		return t;
	}
	public void save(T t) {
		getSession().save(t);
	}
	public void update(T t) {
		getSession().update(t);
	}
	public void saveOrUpdate(T t) {
		getSession().saveOrUpdate(t);
	}
	public void delete(T t) {
		getSession().delete(t);
	}
	
	
}
