/**
 * 
 */
package com.sh.manage.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 微信示例
 * @author fuzl
 *
 */




/**
 * 微信设置控制器
 * @author Administrator
 *
 */
@RequestMapping("/client")
@Controller
public class WeChatController{

	private static final Logger log = Logger.getLogger(WeChatController.class);
	public final String TOKEN = "ziqiangbuxi";
	//private final String SUBSCRIBE_EVENT = "subscribe";//订阅事件
	//private final String MENU_CLICK_EVENT = "CLICK";
	/*@Autowired
	private GTextInfoService gTextInfoService;//图文信息服务
	*//**
	 * 验证微信URL的合法性，申请开发者模式
	 * @param request
	 * @param response
	 * @throws IOException 
	 *//*
	@RequestMapping("/valid.do")
	public void weChatService(HttpServletRequest request, HttpServletResponse response, InputStream is) throws IOException{
		String method = request.getMethod();
		if(method.equals("GET")){
			valid(request, response);
		}else{
			doPost1(request, response, is);
		}
		
	}
	
	*//**
	 * 微信服务器验证
	 * @param request
	 * @param response
	 *//*
	private void valid(HttpServletRequest request, HttpServletResponse response){
		String signature = request.getParameter("signature");//微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		String timestamp = request.getParameter("timestamp");//时间戳
		String nonce = request.getParameter("nonce");//随机数
		String echostr = request.getParameter("echostr");//随机字符串
		
		try {
			boolean result =  checkSignature(signature, timestamp, nonce, TOKEN);
			if(result == true){
				PrintWriter pw = response.getWriter();
				pw.write(echostr);
			}
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	*//**
	 * 响应微信发来的消息
	 * @param request
	 * @param response
	 *//*
	private void doPost1(HttpServletRequest request, HttpServletResponse response, InputStream is){
		try {
			WeChatReceiveMsg msg = getMsg(is);
			String msgType = msg.getMsgType();//获得信息类型
			if(msgType == null || msgType.length() == 0)
				throw new YymobilegameException("----------公众平台服务器返回的信息不实标准格式，请检查!--------");
			
			if(msgType.equals("text")){//如果得到的是文本信息
				String content = msg.getContent();
				List<GTextInfo> gTList = gTextInfoService.getByKey(content);
				if(gTList.size() == 0){//如果没有此关键词的图文信息，则以文本的形式返回提示信息
					String keyTipMsg1 = String.format(keyTipMsg, "只有输入正确的关键字，才能获得您想要的信息哦~\n");
					String textResponseMsg1 = String.format(textResponseMsg, msg.getFromUserName(), msg.getToUserName(), getCurrentSec(), keyTipMsg1);
					response.getWriter().print(textResponseMsg1);
				}else{//如果存在图文信息，则返回图文信息
					String gTextXml = getGTextXml(gTList, msg);
					response.getWriter().write(gTextXml);
				}
			}
			
			if(msgType.equals("event")){//如果是事件推送信息
				String event = msg.getEvent();
				if(event == null || event.length() == 0)
					throw new YymobilegameException("不能获得Even数据");
				
				if(event.equals(SUBSCRIBE_EVENT)){//如果是订阅事件，返回欢迎提示信息
					String textResponseMsg1 = String.format(textResponseMsg, msg.getFromUserName(), msg.getToUserName(), getCurrentSec(), initKeyTipMsg);
					response.getWriter().write(textResponseMsg1);
				}
				
				if(event.equals(MENU_CLICK_EVENT)){//如果是菜单点击事件
					String eventKey = msg.getEventKey();
					if(eventKey == null || eventKey.length() == 0)
						throw new YymobilegameException("不能获得eventKey数据");
					
					List<GTextInfo> gTList = gTextInfoService.getByEventkey(eventKey);
					if(gTList.size() == 0){//如果没有关于此事件Key的图文信息
						String keyTipMsg1 = String.format(keyTipMsg, "很抱歉暂时没有此项的信息！\n");
						String textResponseMsg1 = String.format(textResponseMsg, msg.getFromUserName(), msg.getToUserName(), getCurrentSec(), keyTipMsg1);
						response.getWriter().write(textResponseMsg1);
					}else{//返回图文信息
						String gTextResponseMsg1 = getGTextXml(gTList, msg);
						response.getWriter().write(gTextResponseMsg1);
					}
				}
			}
		} catch (Exception e) {
			log.error("------------------" + e.getMessage() + "--------------", e);
		}
	}

	*//**
	 * 检查请求是否合法
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param token
	 * @return
	 * @throws NoSuchAlgorithmException
	 *//*
	private boolean checkSignature(String signature, String timestamp, String nonce, String token) throws NoSuchAlgorithmException{
		String[] tmpArr = new String[]{timestamp, nonce, token};
		Arrays.sort(tmpArr);//对字符串数组 排序
		String tmpStr = getArrayStr(tmpArr);
		String sha1 = makeSHA1(tmpStr);
		if(signature.equals(sha1))
			return true;
		return false;
	}
	
	private WeChatReceiveMsg getMsg(InputStream request) throws Exception{
		WeChatReceiveMsg receiveMsg = new WeChatReceiveMsg();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(request);
		
		Element root = doc.getDocumentElement();//获得根节点
		NodeList msgs = root.getChildNodes();
		for(int i = 0; i < msgs.getLength(); i++){//遍历元素
			Node msg = msgs.item(i);
			if(msg.getNodeType() == Node.ELEMENT_NODE){//如果是元素节点
				String nodeName = msg.getNodeName().trim();//获得元素的名
				String nodeValue = msg.getTextContent();
				setReceiveMsg(receiveMsg, nodeName, nodeValue);
			}
		}
		return receiveMsg;
	}
	
	private void setReceiveMsg(WeChatReceiveMsg msg, String name, String value){
		if(name.equals("ToUserName"))
			msg.setToUserName(value);
		if(name.equals("FromUserName"))
			msg.setFromUserName(value);
		if(name.equals("CreateTime"))
			msg.setCreateTime(value);
		if(name.equals("MsgType"))
			msg.setMsgType(value);
		if(name.equals("Content"))
			msg.setContent(value);
		if(name.equals("Event"))
			msg.setEvent(value);
		if(name.equals("EventKey"))
			msg.setEventKey(value);
	}
	*//**
	 * 获得字符串数组的字符串形式
	 * @param array
	 * @return
	 *//*
	private String getArrayStr(String[] array){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < array.length; i++){
			sb.append(array[i]);
		}
		return sb.toString();
	}
	
	*//**
	 * 对字符串进行SHA1加密
	 * @param tmpStr
	 * @return
	 * @throws NoSuchAlgorithmException 
	 *//*
	private String makeSHA1(String tmpStr) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA-1");//获取MessageDigest实例
		md.update(tmpStr.getBytes());
		byte[] tmpArr = md.digest();
		
		return byteToHex(tmpArr);
	}
	
	*//**
	 * 将二进制数据转化为十六进制数据串
	 * @param arr
	 * @return
	 *//*
	private String byteToHex(byte[] arr){
		String hs = "";
		String tmp = "";
		for(int i = 0; i < arr.length; i++){
			tmp = Integer.toHexString(arr[i] & 0xFF);
			if(tmp.length() < 2){
				tmp = "0" + tmp;
			}
			hs = hs + tmp;
		}
		return hs;
	}
	
	*//**
	 * 获得图文信息的XML
	 * @param list
	 * @return
	 *//*
	private String getGTextXml(List<GTextInfo> list, WeChatReceiveMsg msg){
		if(list == null || msg == null)
			return "";
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < list.size(); i++){//遍历图文信息列表
			GTextInfo g = list.get(i);//获得图文对象
			String strTmp = String.format(gTextResponseBody, g.getTitle(), g.getDescription(), g.getPicUrl(), g.getUrl());
			sb.append(strTmp);
		}
		sb.insert(0, "<Articles>");
		sb.append("</Articles>");
		String gTextResponseHeader1 = String.format(gTextResponseHeader, msg.getFromUserName(), msg.getToUserName(), getCurrentSec(), list.size());
		sb.insert(0, gTextResponseHeader1);//插入图文信息头
		sb.insert(0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?><xml>");
		sb.append("</xml>");
		
		return sb.toString();
	}
	*//**
	 * 获得1970年至今的秒数
	 * @return
	 *//*
	private long getCurrentSec(){
		long l = System.currentTimeMillis();
		return l/1000;
	}
	
	*//**
	 * 图文信息头
	 *//*
	public static final String gTextResponseHeader = "<ToUserName><![CDATA[%s]]></ToUserName>"
			+ "<FromUserName><![CDATA[%s]]></FromUserName>"
			+ "<CreateTime>%d</CreateTime>"
			+ "<MsgType><![CDATA[news]]></MsgType>"
			+ "<ArticleCount>%d</ArticleCount>";
	
	*//**
	 * 图文信息主体
	 *//*
	public static final String gTextResponseBody = "<item>"
			+ "<Title><![CDATA[%s]]></Title>"
			+ "<Description><![CDATA[%s]]></Description>"
			+ "<PicUrl><![CDATA[%s]]></PicUrl>"
			+ "<Url><![CDATA[%s]]></Url>"
			+ "</item>";
	
	*//**
	 * 用户导航提示信息
	 *//*
	public static final String initKeyTipMsg = "想要更新更好更酷的手游，那你就来对了！\n"
									+ "游戏资讯，第一时间秒同步，达人就是这么练成的/:jj~\n"
									+ "礼包福利，轻松点击就送到，土豪就是那么屌炫酷/:@@~\n"
									+ "游评攻略，呕心沥血神回复，高玩就是这么显摆的/:v\n\n"
									+ "【回复1】获取独家内部消息\n"
									+ "【回复2】获取最多礼包信息\n"
									+ "【回复3】获取最酷玩家攻略\n"
									+ "【回复4】获取手游包下载";
	
	*//**
	 * 提示信息
	 *//*
	public static final String keyTipMsg = "%s\n"
									+ "【回复1】获取独家内部消息\n"
									+ "【回复2】获取最多礼包信息\n"
									+ "【回复3】获取最酷玩家攻略\n"
									+ "【回复4】获取手游包下载";
	
	*//**
	 * 文本信息的回复
	 *//*
	public static final String textResponseMsg = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			+ "<xml>"
			+ "<ToUserName><![CDATA[%s]]></ToUserName>"
			+ "<FromUserName><![CDATA[%s]]></FromUserName>"
			+ "<CreateTime>%d</CreateTime>"
			+ "<MsgType><![CDATA[text]]></MsgType>"
			+ "<Content><![CDATA[%s]]></Content>"
			+ "</xml>";*/
}
