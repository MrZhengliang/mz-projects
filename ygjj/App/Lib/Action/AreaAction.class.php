<?php

//地区模块
class AreaAction extends Action {
	/**
	 * 解决此错误
	 * Call to a member function display() on a non-object
	 */
	function __construct() {
		parent :: __construct();
	}

	function AreaAction() {
	}

	function bj() {
		$oi = new IndexAction();
		$oi->index();//调用Index模块下的index方法
//		$city = M('City');
//		$arr = $city->select();
//
//		//dump($arr);
//		$this->assign('list', $arr);
//		$this->display();
	}
	function wh() {
		$oi = new IndexAction();
		$oi->index();
	}
	function cd() {
		$oi = new IndexAction();
		$oi->index();
	}
	function gz() {
		$oi = new IndexAction();
		$oi->index();
	}
	function km() {
		$oi = new IndexAction();
		$oi->index();
	}
	function hs() {
		$oi = new IndexAction();
		$oi->index();
	}
	function sh() {
		$oi = new IndexAction();
		$oi->index();
	}

	//空操作方法处理
	function _empty($name){
		$this->show("$name 不存在 返回<a href='__APP__/Index/index'>首页</a>") ;
	}
}
?>