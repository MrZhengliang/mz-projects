<?php
// 本类使用协议
class AboutAction extends Action {
	/**
	 * 解决此错误
	 * Call to a member function display() on a non-object
	 */
	function __construct() {
		parent :: __construct();
	}

    public function index(){

		$aggree = $_GET['policy'];
        if($aggree == 'aggrement'){
        	//echo $aggree;
			$this->display();
        };
    }

}
