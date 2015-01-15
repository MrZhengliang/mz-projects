package com.sh.manage.demo.weixin;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InterWeixin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8347837298626161681L;

	/**
	 * Constructor of the object.
	 */
	public InterWeixin() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 * signature �� ΢�ż���ǩ��
     * timestamp �� ʱ���
     * nonce �� �����
     * echostr �� ����ַ�
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //System.out.println("i am ok");
		String signature=request.getParameter("signature");
		
		String timestamp=request.getParameter("timestamp");
		
		String nonce=request.getParameter("nonce");
		
		String echostr=request.getParameter("echostr");
		
		String token="169gold";
	    
		String[] str={token,timestamp,nonce};
	    Arrays.sort(str);
	    String bigStr=str[0]+str[1]+str[2];
        String digest = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase(); 
        if(digest.equals(signature)){
	    	response.setCharacterEncoding("utf-8");
	    	System.out.println(echostr);
	    	 BufferedReader sis = request.getReader();
			  char[] buf = new char[1024];
			  int len = 0;
			  StringBuffer sb = new StringBuffer();
			  while((len = sis.read(buf))!= -1){
			   sb.append(buf,0,len);
			  }       
	        //System.out.println(sb.toString()+";;;;;;;");
	        response.setContentType("text/xml");
	        response.getWriter().print("<?xml version=\"1.0\"?><xml><ToUserName><![CDATA[o3B6FjkJtJB_VCQnbMH65lA_6l2s]]></ToUserName>"+
"<FromUserName><![CDATA[gh_53d680696bf4]]></FromUserName>"+

"<CreateTime>1357449401</CreateTime>"+
"<MsgType><![CDATA[text]]></MsgType>"+
"<Content><![CDATA[爱人民币]]></Content>"+
"</xml>");
	    	response.getWriter().print(echostr);
	    
        }
		
	}
	 
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
