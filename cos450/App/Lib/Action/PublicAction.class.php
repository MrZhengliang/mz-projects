<?php

//公共模块，用来存放验证码
class PublicAction extends Action {

	function PublicAction() {
	}

	/**
	 * 解决此错误
	 * Call to a member function display() on a non-object
	 */
	function __construct() {
		parent :: __construct();
	}


	/**
	 *输出验证码
	 */
	function code() {
		import('ORG.Util.Image');
//		if (class_exists('Image')) {
//			echo "found";
//			//var_dump("found");
//		} else {
//			echo "没有找到";
//			//var_dump("没有找到");
//		}
		//ob_end_clean();
		Image::buildImageVerify(4,1,png,48,30,'code');
	}

	/**
	 * 上传图片工具方法
	 */
	function uploadImg() {
//			$s = new SaeStorage();
//			var_dump($s);
			session_id($_POST['PHPSESSID']);

			import('ORG.Net.UploadFile');
			$upload = new UploadFile();// 实例化上传类
			$upload->maxSize  = 3145728 ;// 设置附件上传大小
			$upload->allowExts  = array('jpg', 'gif', 'png', 'jpeg');// 设置附件上传类型

//			$savepath='d:\\tmp\\uploads\\'.date('Ymd').'\\';
//			if (!file_exists($savepath)){
//				mkdir($savepath);
//			}
			//设置附件上传目录
			$upload->savePath = './Uploads/images/';
			$realPath = '/Uploads/images/';
			//设置上传文件规则
			$upload->saveRule = 'uniqid';
			//删除原图
			$upload->thumbRemoveOrigin = true;

			if(!$upload->upload()) {// 上传错误提示错误信息
				$this->error($upload->getErrorMsg());
			}else{// 上传成功 获取上传文件信息
				$info =  $upload->getUploadFileInfo();
			}
			//var_dump($info);
			$fname = $info[0]['name'];//原文件名称


			/**
			 * 插入数据到附件信息表 */
			$attachment = M('Attachment');//附件信息表
			$data["type"] = 1;//附件类型  1  图片  2 文件  3  音乐  4  视频
			$data["uid"] = $_POST['userid'];//会员id；添加人员id
			$data["filename"] = $fname;//文件原名称
			$data["newfilename"] = $info[0]['savename'];//文件新名称
			$data["filepath"] = $realPath;//文件保存路径
			$data["uploadtime"] = time();//上传时间

			//var_dump($data);
//			$session_id = $_POST['PHPSESSID'];
//			if(isset($_POST['PHPSESSID']) || !empty($_POST['PHPSESSID']))
//			{
//			    session_destroy();
//			    session_id($_POST['PHPSESSID']);
//			    session_start();
//			}
//			var_dump($session_id);


			//echo date('Y-m-d H:i:s',time());
			//echo time();
			$pid = $attachment->add($data);//插入图片数据,返回图片id--插入数据表的id

			if($pid>0){
				//$this->assign('aid',$pid);
				//$serverData['response'] = "<div id=\"prev_".$pid."\" style='width:172px;height:225px'><img src=\""."http://www.cos450.com/cos450".$realPath.$info[0]['savename']."\" width=172 height=225><a onclick='delOneTmpPic(\""."#gfs_pic_ids\"".",\"".$pid."\"".")' href='javascript:void(0)'>删除该图片</a></div>";
				//反序列化json不需要转义
				$serverData['response'] = "<div id=prev_".$pid." style='width:172px;height:225px'><img src="."http://www.cos450.com/cos450".$realPath.$info[0]['savename']." width=172 height=225><a onclick='delOneTmpPic("."\"#pic_ids\"".",\"".$pid."\")' href='javascript:void(0)'>删除该图片</a></div>";
				$serverData['aid'] = $pid;
				//echo $serverData;

				//echo json_encode($serverData);//前台处理需要序列化为json对象

				echo str_replace("\\/", "/", json_encode($serverData));//正则转换/

			}else{
				echo "<script>alert('上传出问题，请稍后');</script>";
			}

	}

	/**
	 * 删除附件或者图片操作
	 */
	function delFile() {
		$src=str_replace(__ROOT__.'/', '', str_replace('//', '/', $_GET['src']));
		if (file_exists($src)){
		unlink($src);
		}
		print_r($_GET['src']);
		exit();
	}

}
?>