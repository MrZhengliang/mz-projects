<?php
/*
 * Created on 2014-8-27
 *
 * To change the template for this generated file go to
 * Window - Preferences - PHPeclipse - PHP - Code Templates
 */
	class CommonAction extends Action{

			 Public function _initialize(){
			   // 初始化的时候检查用户权限
			   //$this->checkRbac();
			   if(!isset($_SESSION['email']) || $_SESSION['email']==''){
			   		$this->redirect('MzUser/login');
			   }
			 }
	}
?>
