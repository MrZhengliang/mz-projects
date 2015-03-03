<?php
// 本类使用协议
class SnailappAction extends Action {
	/**
	 * 解决此错误
	 * Call to a member function display() on a non-object
	 */
	function __construct() {
		parent :: __construct();
	}

	function SnailappAction() {

	}

	public function coin(){
		$this->display();
	}

    public function index(){
		$type = $_GET['type'];

		$hub_mode= $_GET['hub_mode'];
		$hub_challenge = $_GET['hub_challenge'];
		$verify_token = $_GET['hub_verify_token'];

		//facepay20150203
        if($type == 'facepay'){

        	echo $type;
        	var_dump($type);
			//$this->display();
        }else if($verify_token == 'facepay20150203'){
        	//token 验证通过

			//接口需要返回$hub_challenge参数；
			echo $hub_challenge;
//			echo $hub_mode;
//
//			echo 'facepay 测试..';
        }else{
//			var_dump($_GET);
//        	echo $hub_challenge;
//        	echo $verify_token;
//			echo "token is valid!";

			$this->redirect('fb_login');
        }
    }

	//登陆页
    public function fb_login(){
		$this->display();
    }

	//动态价格回调
	public function dynamicPriceCallback(){
		echo "55";
	}
}
