package com.sh.manage.module.page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 分页对象. <br>
 * <p>
 * Copyright: Copyright (c) 
 * <p>
 * Company:
 * <p>
 * Author:
 * <p>
 * Version: 1.0
 * <p>
 */
public class Page {

	/** 总行数 */
	private long totalRowNum = 0;

	/** 每页显示行数 */
	private int pageSize = DEFAULT_PAGE_SIZE;

	/** 当前页 */
	private int currentPageIndex = 1;

	/** 总页数 */
	private int totalPageNum = 1;

	/** 起始页 */
	private int beginPageIndex = 1;

	/** 结束页 */
	private int endPageIndex = 1;

	/** 有无上一页 */
	private boolean hasPrev = false;

	/** 有无下一页 */
	private boolean hasNext = false;

	/** 本页起始行号 */
	private long firstResult = 0;

	/** 本页结束行号 */
	private long lastResult = 0;

	/** 默认每页显示行数 */
	public static final int DEFAULT_PAGE_SIZE = 4;

	/** 默认页号数目 */
	public static final int DEFAULT_PAGE_INDEX_NUM = 10;

	/** 页号数目 */
	private int pageIndexNum = DEFAULT_PAGE_INDEX_NUM;

	@SuppressWarnings("rawtypes")
	private List<?> list = new ArrayList();

	/** URL参数，用来保存查询条件 */
	@SuppressWarnings("rawtypes")
	private final HashMap params = new HashMap();
	
	/** 获得request*/
	private final ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	private final  HttpServletRequest request = servletRequestAttributes.getRequest();


	/** 当前的地址栏的URL */
	private String uri = request.getRequestURL().toString()+"?";

	/**
	 * 跳转到指定页
	 * 
	 * @param pageIndex
	 *            指定页数
	 */
	public void turnToPage(int pageIndex) {

		// 判断指定页和当前页的关系
		if (pageIndex < 1)
			currentPageIndex = 1;
		else if (pageIndex > totalPageNum)
			currentPageIndex = totalPageNum;
		else
			currentPageIndex = pageIndex;

		// 得到前页和后页
		hasPrev = (currentPageIndex != 1);
		hasNext = (currentPageIndex != totalPageNum);

		// 起始页和结束页
		beginPageIndex = Math.max(1, currentPageIndex - pageIndexNum / 2);
		endPageIndex = Math.min(currentPageIndex + (pageIndexNum - pageIndexNum / 2 - 1), totalPageNum);

		// 当前页起始行和结束行
		firstResult = (currentPageIndex - 1) * pageSize + 1;
		lastResult = Math.min(currentPageIndex * pageSize, totalRowNum);

	}

	/**
	 * @return List 结果
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getSubList(Collection collection) {
		if (collection == null)
			return null;
		List alist = new ArrayList(collection);

		return alist;
	}

	/**
	 * 设置总页数
	 */
	public void resetTotalPageNum() {
		if (totalRowNum == 0)
			totalPageNum = 1;
		else {
			totalPageNum = (int) ((totalRowNum + pageSize - 1) / pageSize);
		}
		turnToPage(1);
	}

	/**
	 * 查询总行数
	 * 
	 * @param count
	 *            总记录数
	 */
	public void search(long count) {
		totalRowNum = count;
		resetTotalPageNum();
	}

	/**
	 * 切换每页显示的行数
	 * 
	 * @param pageSize
	 *            每页显示的行数
	 */
	public void changePageSize(int pageSize) {
		this.pageSize = pageSize;
		resetTotalPageNum();
	}

	/** 添加URL参数 */
	@SuppressWarnings("unchecked")
	public void addParam(String key, String value) {
		params.put(key, value);
	}

	/**
	 * 分页效果显示
	 */
	@SuppressWarnings("unused")
	public String getDisplay() {

		if(request.getQueryString() != null && request.getQueryString().length() > 0) {
			String param = request.getQueryString();
			int index = param.indexOf("pageNo");
			if(index != -1){
				param = param.substring(0,index);
			}
			if(param != null && param.length() > 0){
				uri += param+"&";
			}
			uri.replaceAll("&", "%26");
		}
		String str = "";
		int next, prev;
		prev = currentPageIndex - 1;
		next = currentPageIndex + 1;

		String uriParam = this.getParams().equals("") ? "" : "?" + this.getParams().substring(1, this.getParams().length());
		str += "<form action=" + uri + uriParam + " method=post id=page name=page>";
		str += "<a class=\"btn btn-xs btn-disabled btn-light\" >"+totalRowNum + "&nbsp;条信息;";
		str += "&nbsp;共&nbsp;" + totalPageNum + "&nbsp;页</a>";

		if (currentPageIndex > 1) {
			str += "<a style=\"margin:0 1px\" id=first style=\"margin:0 1px\" class=\"btn btn-xs btn-info\"  href=" + uri + "pageNo=1" + this.getParams() + "&backType=1>首页</a>";
			str += "<a id=prev class=\"btn btn-xs btn-info\" href=" + uri + "pageNo=" + (currentPageIndex - 1) + this.getParams() + "&backType=1>上页</a>";
		} else {
			str += "<a style=\"margin:0 1px\" class=\"btn btn-xs btn-disabled btn-light\" >首页</a>";
			str += "<a class=\"btn btn-xs btn-disabled btn-light\" >上页 </a>";
		}
		str += "&nbsp;<span style='font-weight: bold; color: #5858E6'>" + currentPageIndex + "</span>&nbsp;";

		if (currentPageIndex < totalPageNum) {
			str += "<a id=next class=\"btn btn-xs btn-info\" href=" + uri + "pageNo=" + (currentPageIndex + 1) + this.getParams() + "&backType=1>下页 </a>";
			str += "<a style=\"margin:0 1px\" id=last class=\"btn btn-xs btn-info\" href=" + uri + "pageNo=" + totalPageNum + this.getParams() + "&backType=1>尾页</a>";
		} else {
			str += "<a class=\"btn btn-xs btn-disabled btn-light\" >下页</a>";
			str += "<a style=\"margin:0 1px\" class=\"btn btn-xs btn-disabled btn-light\" >尾页 </a> </font>";
		}
		str += " <select id='pageNo' name='pageNo' onchange='submit();'>";

		// 调整为当前页的前后500页
		int start = 1;
		int end = totalPageNum;
		if (currentPageIndex > 1000) {
			if (currentPageIndex + 500 < 1000)
				end = 1000;
			else if (currentPageIndex + 500 > totalPageNum) {
				start = totalPageNum - 1000;
				end = totalPageNum;
			} else {
				start = currentPageIndex - 500;
				end = currentPageIndex + 500;
				if (start < 1)
					start = 1;
				if (end > totalPageNum)
					end = totalPageNum;
			}
		}
		for (int i = start; i <= end; i++) {
			if (i != currentPageIndex)
				str += "<option value='" + i + "'>" + i + "</option>";
			else
				str += "<option value='" + i + "' selected>" + i + "</option>";
		}
		str += "</select></form>";
		return str;
	}

	/** 获取URL参数 */
	@SuppressWarnings("rawtypes")
	public String getParams() {
		String ret = "";
		if (params.size() == 0)
			return ret;
		for (Iterator it = params.keySet().iterator(); it.hasNext();) {
			String key = (String) it.next();
			String value = (String) params.get(key);
			ret += ("&" + key + "=" + value);
		}
		return ret;
	}

	public static void main(String[] args) {
//		Page page = new Page();
//		// 传入总记录数，实例化分页信息
//		page.search(695);
//		// 跳转到指定页
//		page.turnToPage(1);
//		// 显示效果
//		// page.display();
//
//		// 跳转到指定页
//		page.turnToPage(27);
		// 显示效果
		// page.display();
	}

	/**
	 * 获得总行书
	 * 
	 * @return
	 */
	public long getTotalRowNum() {
		return totalRowNum;
	}

	/**
	 * 设置总行书
	 * 
	 * @param totalRowNum
	 */
	public void setTotalRowNum(long totalRowNum) {
		this.totalRowNum = totalRowNum;
	}

	/**
	 * 获得每页显示行数
	 * 
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页显示的行数
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 获得当前页
	 * 
	 * @return
	 */
	public int getCurrentPageIndex() {
		return currentPageIndex;
	}

	/**
	 * 设置当前页
	 * 
	 * @param currentPageIndex
	 */
	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}

	/**
	 * 获得总页数
	 * 
	 * @return
	 */
	public int getTotalPageNum() {
		return totalPageNum;
	}

	/**
	 * 设置总页数
	 * 
	 * @param totalPageNum
	 */
	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	/**
	 * 获得起始页
	 * 
	 * @return
	 */
	public int getBeginPageIndex() {
		return beginPageIndex;
	}

	/**
	 * 设置起始页
	 * 
	 * @param beginPageIndex
	 */
	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	/**
	 * 获得结束页
	 * 
	 * @return
	 */
	public int getEndPageIndex() {
		return endPageIndex;
	}

	/**
	 * 设置结束页
	 * 
	 * @param endPageIndex
	 */
	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}

	/**
	 * 获得是否有上一页
	 * 
	 * @return
	 */
	public boolean isHasPrev() {
		return hasPrev;
	}

	/**
	 * 设置是否有上一页
	 * 
	 * @param hasPrev
	 */
	public void setHasPrev(boolean hasPrev) {
		this.hasPrev = hasPrev;
	}

	/**
	 * 获得是否有下一页
	 * 
	 * @return
	 */
	public boolean isHasNext() {
		return hasNext;
	}

	/**
	 * 设置是否有下一页
	 * 
	 * @param hasNext
	 */
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	/**
	 * 获得本页起始行数
	 * 
	 * @return
	 */
	public long getFirstResult() {
		return firstResult;
	}

	/**
	 * 设置本页起始行数
	 * 
	 * @param firstResult
	 */
	public void setFirstResult(long firstResult) {
		this.firstResult = firstResult;
	}

	/**
	 * 获得本页结束行数
	 * 
	 * @return
	 */
	public long getLastResult() {
		return lastResult;
	}

	/**
	 * 设置本页结束行数
	 * 
	 * @param lastResult
	 */
	public void setLastResult(long lastResult) {
		this.lastResult = lastResult;
	}

	/**
	 * 获得页号数目
	 * 
	 * @return
	 */
	public int getPageIndexNum() {
		return pageIndexNum;
	}

	/**
	 * 设置页号数目
	 * 
	 * @param pageIndexNum
	 */
	public void setPageIndexNum(int pageIndexNum) {
		this.pageIndexNum = pageIndexNum;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
	
	
	
	/**
	 * 专门做个为bbs留言记录的分页效果
	 * 分页效果显示
	 */
	@SuppressWarnings("unused")
	public String getDisplay2() {

		if(request.getQueryString() != null && request.getQueryString().length() > 0) {
			String param = request.getQueryString();
			int index = param.indexOf("pageNo");
			if(index != -1){
				param = param.substring(0,index);
			}
			if(param != null && param.length() > 0){
				uri += param+"&";
			}
			uri.replaceAll("&", "%26");
			//System.out.println("param:"+param);
		}
		
		String str = "";
		int next, prev;
		prev = currentPageIndex - 1;
		next = currentPageIndex + 1;

		String uriParam = this.getParams().equals("") ? "" : "?" + this.getParams().substring(1, this.getParams().length());
		str += "<form action=" + uri + uriParam + " method=post id=page name=page>";
		str += totalRowNum + "&nbsp;条信息&nbsp;";
		str += "&nbsp;共&nbsp;" + totalPageNum + "&nbsp;页&nbsp;";
		str += "<input type=hidden name=checkboxId2Str id=checkboxId2Str value=>";
		if (currentPageIndex > 1) {
			str += "   <a id=first  href=" + uri + "pageNo=1" + this.getParams() + "&backType=1>&nbsp;最前页</a>   ";
			str += "   <a id=prev  href=" + uri + "pageNo=" + (currentPageIndex - 1) + this.getParams() + "&backType=1>&nbsp;|  上一页</a>   ";
		} else {
			str += "   最前页   ";
			str += "   |  上一页   ";
		}
		str += "&nbsp;&nbsp;<span style='font-weight: bold; color: #5858E6'>" + currentPageIndex + "</span>&nbsp;&nbsp;";

		if (currentPageIndex < totalPageNum) {
			str += "   <a id=next  href=" + uri + "pageNo=" + (currentPageIndex + 1) + this.getParams() + "&backType=1>&nbsp;下一页    |</a>   ";
			str += "   <a id=last  href=" + uri + "pageNo=" + totalPageNum + this.getParams() + "&backType=1>最后页&nbsp;</a>";
		} else {
			str += "   下一页    |";
			str += "   最后页   </font>";
		}
		str += "     <select id='pageNo' name='pageNo' onchange='submit();'>";

		// 调整为当前页的前后500页
		int start = 1;
		int end = totalPageNum;
		if (currentPageIndex > 1000) {
			if (currentPageIndex + 500 < 1000)
				end = 1000;
			else if (currentPageIndex + 500 > totalPageNum) {
				start = totalPageNum - 1000;
				end = totalPageNum;
			} else {
				start = currentPageIndex - 500;
				end = currentPageIndex + 500;
				if (start < 1)
					start = 1;
				if (end > totalPageNum)
					end = totalPageNum;
			}
		}
		for (int i = start; i <= end; i++) {
			if (i != currentPageIndex)
				str += "<option value='" + i + "'>" + i + "</option>";
			else
				str += "<option value='" + i + "' selected>" + i + "</option>";
		}
		str += "</select></form>";
		return str;
	}
}
