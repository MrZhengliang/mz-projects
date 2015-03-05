<?php
/**
 * 微信公众账号接入验证token
 * 定义微信链接TOKEN
 */

class WeixinAction extends Action {

    function WeixinAction() {
    }
	//入口
    function index(){
    	//dump(123);
    	/**
    	 * 定义微信链接TOKEN
 		 */
		define("TOKEN", "weiHappy");
        if (isset($_GET['echostr'])) {
            $this->valid();
        }else{
            $this->responseMsg();
        }

    }
    function valid(){
    	//valid signature , option
         $echoStr = $_GET["echostr"];
        if($this->checkSignature()){
            echo $echoStr;
            exit;
        }
    }
	//校验
    private function checkSignature() {
        $signature = $_GET["signature"];
        $timestamp = $_GET["timestamp"];
        $nonce = $_GET["nonce"];

        $token = TOKEN;
        $tmpArr = array($token, $timestamp, $nonce);
        sort($tmpArr, SORT_STRING);
        $tmpStr = implode($tmpArr);
        $tmpStr = sha1($tmpStr);

        if ($tmpStr == $signature) {
            return true;
        } else {
            return false;
        }
    }

	//响应
    public function responseMsg(){
        $postStr = $GLOBALS["HTTP_RAW_POST_DATA"];

        if (!empty($postStr)){
        	//事件订阅
        	$postObj = simplexml_load_string($postStr, 'SimpleXMLElement', LIBXML_NOCDATA);
			$RX_TYPE = trim($postObj->MsgType);

			switch($RX_TYPE){
			    case "text":
			        $resultStr = $this->handleText($postObj);
			        break;
			    case "event":
			        $resultStr = $this->handleEvent($postObj);
			        break;
			    default:
			    $resultStr = "Unknow msg type: ".$RX_TYPE;
			    break;
			}

        	//消息自动回复
            //$postObj = simplexml_load_string($postStr, 'SimpleXMLElement', LIBXML_NOCDATA);
//            $fromUsername = $postObj->FromUserName;
//            $toUsername = $postObj->ToUserName;
//            $keyword = trim($postObj->Content);
//            $time = time();
//            $textTpl = "<xml>
//                        <ToUserName><![CDATA[%s]]></ToUserName>
//                        <FromUserName><![CDATA[%s]]></FromUserName>
//                        <CreateTime>%s</CreateTime>
//                        <MsgType><![CDATA[%s]]></MsgType>
//                        <Content><![CDATA[%s]]></Content>
//                        <FuncFlag>0</FuncFlag>
//                        </xml>";
//            if($keyword == "?" || $keyword == "？")
//            {
//                $msgType = "text";
//                $contentStr = "你好,现在时间是：".date("Y-m-d H:i:s",time());
//                $resultStr = sprintf($textTpl, $fromUsername, $toUsername, $time, $msgType, $contentStr);
//                echo $resultStr;
//            }
        }else{
        	echo "什么都没输";
            exit;
        }
    }


	//实现处理文本和图片订阅事件
	//文本
	public function handleText($postObj){
        $fromUsername = $postObj->FromUserName;
        $toUsername = $postObj->ToUserName;
        $keyword = trim($postObj->Content);
        $time = time();
        $textTpl = "<xml>
                    <ToUserName><![CDATA[%s]]></ToUserName>
                    <FromUserName><![CDATA[%s]]></FromUserName>
                    <CreateTime>%s</CreateTime>
                    <MsgType><![CDATA[%s]]></MsgType>
                    <Content><![CDATA[%s]]></Content>
                    <FuncFlag>0</FuncFlag>
                    </xml>";
        if(!empty( $keyword ))
        {
        	//一般消息自动回复
            $msgType = "text";
            $contentStr="";
            //天气查询
            $str = mb_substr($keyword,-2,2,"UTF-8");
            $str_key = mb_substr($keyword,0,-2,"UTF-8");
            $weather_cityId = array("北京"=>"101010100","上海"=>"101020100","苏州"=>"101190401");
			if($str == '天气' && !empty($str_key)){
				//抓取天气数据
				$data = $this->weather($str_key);

				if(empty($data->weatherinfo)){
                    $contentStr = '抱歉，没有查到\"'.$str_key.'\"的天气信息！';
                }else{
					$contentStr = "【".$data->weatherinfo->city."天气预报】\n".$data->weatherinfo->date_y." ".$data->weatherinfo->fchh."时发布"."\n\n实时天气\n".$data->weatherinfo->weather1." ".$data->weatherinfo->temp1." ".$data->weatherinfo->wind1."\n\n温馨提示：".$data->weatherinfo->index_d."\n\n明天\n".$data->weatherinfo->weather2." ".$data->weatherinfo->temp2." ".$data->weatherinfo->wind2."\n\n后天\n".$data->weatherinfo->weather3." ".$data->weatherinfo->temp3." ".$data->weatherinfo->wind3;
				}
            }else if($keyword=='什么' || $keyword =='what'){
 				$contentStr = "可以输点好玩的吗?";
            }else if($keyword == '北京公交52'){
 				$contentStr = "北京公交52路带你去看北京站-东单-王府井-天安门-西单!";
            }else if($keyword == '为什么'){
            	$contentStr = '需要告诉你吗?';
            }else if($keyword == '嗯' || $keyword == '需要'){
            	$contentStr = '逗你玩,就不想理你';
            }else{
				$contentStr = "感谢您关注【微小昨】"."\n"."微信号：weixiaozuo"."\n"."快乐就好,微小昨，我们为您提供最原生的快乐因子,努力做最好的快乐分享微信平台。"."\n"."目前平台功能如下："."\n"."【1】 查天气，如输入：北京天气"."\n"."【2】 查公交，如输入：北京公交52"."\n"."【3】 翻译，如输入：翻译I love you"."\n"."【4】 生活信息查询，如输入：北京王府井"."\n"."更多内容，敬请期待..."."\n";
            }



            $resultStr = sprintf($textTpl, $fromUsername, $toUsername, $time, $msgType, $contentStr);
            echo $resultStr;
        }else{
            echo "Input something...";
        }
    }
	//事件
    public function handleEvent($object){
        $contentStr = "";
        switch ($object->Event)
        {
            case "subscribe":
                $contentStr = "感谢您关注【微小昨】"."\n"."微信号：weixiaozuo"."\n"."快乐就好,微小昨，我们为您提供最原生的快乐因子,努力做最好的快乐分享微信平台。"."\n"."目前平台功能如下："."\n"."【1】 查天气，如输入：北京天气"."\n"."【2】 查公交，如输入：北京公交52"."\n"."【3】 翻译，如输入：翻译I love you"."\n"."【4】 生活信息查询，如输入：北京王府井"."\n"."更多内容，敬请期待..."."\n";
                break;
            default :
                $contentStr = "Unknow Event: ".$object->Event;
                break;
        }
        $resultStr = $this->responseText($object, $contentStr);
        echo $resultStr;
    }
	//响应文本
    public function responseText($object, $content, $flag=0)
    {
        $textTpl = "<xml>
                    <ToUserName><![CDATA[%s]]></ToUserName>
                    <FromUserName><![CDATA[%s]]></FromUserName>
                    <CreateTime>%s</CreateTime>
                    <MsgType><![CDATA[text]]></MsgType>
                    <Content><![CDATA[%s]]></Content>
                    <FuncFlag>%d</FuncFlag>
                    </xml>";
        $resultStr = sprintf($textTpl, $object->FromUserName, $object->ToUserName, time(), $content, $flag);
        return $resultStr;
    }
}
?>