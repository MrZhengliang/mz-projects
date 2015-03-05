<?php
// 本类由系统自动生成，仅供测试用途
class IndexAction extends Action {

	/**
	 * 解决此错误
	 * Call to a member function display() on a non-object
	 */
	function __construct() {
		parent :: __construct();
	}

    public function index(){
        if(!isset($_SESSION['nickname']) || $_SESSION['nickname'] == ''){
			$this->assign();
		}
		$this->display();
    }
    function test(){
		$this->show('<h1>Hello SAE</h1>');
    }

    function zhaopin(){
		$this->display();
    }

}
