/**
 * 
 */
package com.sh.manage.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import com.sh.manage.module.dbhelper.DBHelper;

/**
 * jdbc帮助类
 * @author fuzl
 *
 */
public class JdbcSpTemplate {

	
	
	/**
	 * 根据当前用户查询对应的按钮
	 * @param user
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getRolesBtnByUser(String username){
		
		List<String> roleList = new ArrayList<String>();
		//数据库通用帮助类
		DBHelper dbHelper = new DBHelper();
		StringBuffer sf = new StringBuffer();
		sf.append("select m.menu_btns from t_sys_user u,t_sys_user_role o,t_sys_role_menu m ");
		sf.append(" where 1 = 1");
		sf.append(" and u.uid = o.user_id");
		sf.append(" and o.role_id = m.role_id");
		sf.append(" and u.username = ?");
		
		List params = new ArrayList();
		params.add(username);
		dbHelper.setSql(sf.toString());
		dbHelper.setSqlValues(params);
		//查询结果
		Result qResult = dbHelper.executeQuery();
		
		if(null!=qResult && qResult.getRowCount()!=0){
			
			String roleStr = "";
			for(int i=0;i<qResult.getRowCount();i++){
				Map rowMap = qResult.getRows()[i];
			    roleStr = (String) rowMap.get("menu_btns");
			    roleList.addAll(Arrays.asList(roleStr.split(",")));
			    roleStr = "";
			}
		}
		return roleList;
	}
}
