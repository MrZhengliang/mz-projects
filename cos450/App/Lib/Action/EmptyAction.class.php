<?php
/*
 * Created on 2014-8-10
 *
 * To change the template for this generated file go to
 * Window - Preferences - PHPeclipse - PHP - Code Templates
 */
 class EmptyAction extends Action{
	/**
	 * 解决此错误
	 * Call to a member function display() on a non-object
	 */
	function __construct() {
		parent :: __construct();
	}

	function index(){
		$city = M('City');
		$arr = $city->select();

		//dump($arr);
		$this->assign('list', $arr);
		//echo MODULE_NAME;

		//判断数据库，城市是否存在，存在返回1
		$name = MODULE_NAME;//模块名
		$data['name']=$name;
		//查询数据库
		$count=$city->where($data)->count();//或者find()

		if($count>0){
			$this->display("City:$name");
		}else{
			$this->show("<p>该模块".MODULE_NAME."不存在</p> 返回<a href='__APP__/Index/index'>首页</a>");
		}


	}
 }
?>
