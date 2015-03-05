<?php
// 本类由首页进入登录
class MzUserAction extends Action {

	/**
	 * 解决此错误
	 * Call to a member function display() on a non-object
	 */
	function __construct() {
		parent :: __construct();
	}

	//跳转登陆页
    public function login(){
        //$this->name='AAA';
		$this->display();
    }
    //跳转注册页
    public function register(){
        //$this->name='AAA';
        $group = M('Group');
        $arr=$group->select();
        $this->assign("groups",$arr);
		$this->display();
    }

	//处理登陆请求
    public function doLogin(){
		//$ip = get_client_ip();
		$username = $_POST['username'];
		$pwd = md5($_POST['password']);

		//邮箱正则
		$emailReg = '/^[a-zA-Z0-9][a-zA-Z0-9._-]*\@[a-zA-Z0-9]+\.[a-zA-Z0-9\.]+$/A';

		$user = M('User');

		if(!preg_match($emailReg,$username)){
			//构造查询条件
			if(isset($username)&&isset($pwd)){
				$where['nickname'] = $username;
				$where['password'] = $pwd;
			}
			$i = $user->where($where)->count();
			if($i>0){
				//存在,用户放到session中
				$arr = $user->where($where)->select();
				//dump($arr);
				$_SESSION['username']=$arr[0]['username'];
				$_SESSION['nickname']=$arr[0]['nickname'];
				$_SESSION['userid']=$arr[0]['uid'];
				//cookie('userid',$arr[0]['uid'],3600); // 指定cookie保存时间

				$this->redirect('Index/index');
				//$this->success('用户登陆成功',U('/Index/index'));
			}else{
				//不存在
				$this->error(' 该用户'.$username.'不存在!');
			}
		}else{
			//构造查询条件
			if(isset($username)&&isset($pwd)){
				$where['email'] = $username;
				$where['password'] = $pwd;
			}
			$i = $user->where($where)->count();
			if($i>0){
				//存在,用户放到session中
				$arr = $user->where($where)->select();
				//dump($arr);
				$_SESSION['username']=$arr[0]['username'];
				$_SESSION['nickname']=$arr[0]['nickname'];
				$_SESSION['userid']=$arr[0]['uid'];
				//cookie('userid',$arr[0]['uid'],3600); // 指定cookie保存时间

				$this->redirect('Index/index');
				//$this->success('用户登陆成功',U('/Index/index'));
			}else{
				//不存在
				$this->error(' 该用户'.$username.'不存在!');
			}
		}

    }
    //退出
    public function logout(){
    	//清空session
		if(isset($_SESSION['username'])||isset($_SESSION['nickname'])){
			$_SESSION['username']='';
			$_SESSION['nickname']='';
			$this->redirect('Index/index');
		}
    }

	//找回密码
	public function resetpassword(){
		$this->display();
	}
	//验证码ajax校验
	public function checkCode(){
		$code = $_SESSION['code'];
		$captcha = $_POST['captcha'];

		if($code != md5($captcha)){
			//验证码不正确
			$this->ajaxReturn('false','error',0);
		}else{
			$this->ajaxReturn('true','success',1);
		}
	}
	//邮箱ajax校验
	public function checkEmail(){
		$email = $_POST['email'];
		$user = M('User');

		$where['email'] = $email;
		$count=$user->where($where)->count();
		if($count > 0){
			//该邮箱已经注册
			$this->ajaxReturn('false','error',0);
		}else{
			$this->ajaxReturn('true','success',1);
		}
	}
	//验证登陆用户名
	public function checkloginName(){

		//邮箱正则
		$emailReg = '/^[a-zA-Z0-9][a-zA-Z0-9._-]*\@[a-zA-Z0-9]+\.[a-zA-Z0-9\.]+$/A';

		//登陆信息邮箱或者昵称
		$loginName = $_POST['login_name'];
		$user = M('User');

		if(!preg_match($emailReg,$loginName)){
			//echo '不是邮箱';
			$where['nickname'] = $loginName;
			$count=$user->where($where)->count();
			if($count > 0){
				//该用户名已经注册
				$this->ajaxReturn('false','error',0);
			}else{
				$this->ajaxReturn('true','success',1);
			}
		}else{
			//echo '是邮箱';
			$where['email'] = $loginName;
			$count=$user->where($where)->count();
			if($count > 0){
				//该用户名已经注册
				$this->ajaxReturn('false','error',0);
			}else{
				$this->ajaxReturn('true','success',1);
			}
		}

		/*$user = M('User');

		$where['email'] = $loginName;
		$count=$user->where($where)->count();
		if($count > 0){
			//该用户名已经注册
			$this->ajaxReturn('false','error',0);
		}else{
			$this->ajaxReturn('true','success',1);
		}*/
	}
    //处理注册请求
    public function doRegister(){
		header("Content-Type:text/html; charset=utf-8");
		//echo "准备注册";
		$user = M('User');

		$data["email"] = $_POST['form_email'];
		$data["password"] = md5($_POST['form_password']);
		$data["nickname"]= $_POST['form_nickname'];//名号
		$data["regdate"] = time(); // 写入数据
		$data["groupid"] = $_POST['group']; // 写入数据
		//dump($data);

		$idNum = $user->add($data);
		if($idNum>0){
			$arr = $user->where($data)->select();
			$_SESSION['username']=$arr[0]['username'];
			$_SESSION['nickname']=$arr[0]['nickname'];
			$_SESSION['userid']=$arr[0]['uid'];
			//cookie('userid',$arr[0]['uid'],3600); // 指定cookie保存时间
			//注册成功,跳转到首页
			$this->redirect('Index/index');
			//$this->success('注册成功',U('Index/index'));//数据添加成功
		}else{
			//跳转到统一错误界面
			$this->error('注册失败',U('/Public/error'));//数据添加失败
		}
		//$ip = get_client_ip();
		//echo $ip;
		//$this->success('用户注册成功',U('/Public/error'));
    }



    //个人中心
    function userinfo(){
		//获取省分、地市信息
		$area = M('Area');
		//用户信息
		$user = M('User');

		$data["areagrade"]=1;
		$data2["areagrade"]=2;
		$data2["parentcode"]=22;
		$province = $area->where($data)->order('id desc')->select();
		$city = $area->where($data2)->order('id desc')->select();

		$this->assign('provinces',$province);
		$this->assign('citys',$city);

		//用户资料
		$nickname = $_GET['nickname'];
		$where['nickname']=$nickname;
		$arr = $user->where($where)->select();
		$this->assign('user',$arr);
		//$this->assign('usersex',$arr[0]['sex']);
		//dump($arr);

		$this->display();
    }
    //ajax获取地市信息
    function ajaxGetCitys(){
		$area = M('Area');

		$data["parentcode"]=$_POST['prov']; // 写入数据;
		$data["areagrade"]=2;

		$count=$area->where($data)->count();
		if($count > 0){
			$arr=$area->where($data)->select();
			//dump($arr)
			$this->ajaxReturn($arr,'JSON');
		}else{
			$this->ajaxReturn('','JSON');
		}
    }

    //保存用户资料
    function saveUserInfo(){
    	header("Content-Type:text/html; charset=utf-8");
		//用户信息
		$user = M('User');

		//用户资料
		$userid = $_POST['userid'];
		$nickname = $_POST['nickname'];
		$provincecode = $_POST['province'];
		$citycode = $_POST['city'];
		$sex = $_POST['usersex'];
		$userintro = $_POST['userintro'];
		$provincename = $_POST['provincename'];
		$cityname = $_POST['cityname'];



		$data['uid'] = $userid;
		$data['nickname'] = $nickname;
		$data['provincecode'] = $provincecode;
		$data['citycode'] = $citycode;
		$data['sex'] = $sex;
		$data['userintro'] = $userintro;

		$data['provincename'] = $provincename;
		$data['cityname'] = $cityname;



		 // 更新的条件
    	$condition['uid'] = $userid;
		//$result = $user->where('uid='+$userid)->data($data)->save();
		//$result = $user->save($data);


		$result = $user->save($data);
//		if(false !== $result || $result == 0){
//			//$this->redirect('/MzUser/userinfo/nickname/'+$nickname,1,'更新中...');//数据修改成功,跳回index方法,line5
//		}else{
//			$this->success(U('/Index/index'));//数据保存失败
//		}

//		if(false !== $result || $result > 0){
//			//保存成功,刷新界面
//			$this->redirect('MzUser/userinfo/nickname/'+$nickname);
//		}else{
//			$this->error('保存失败',U('/Public/error'));//数据保存失败
//		}
		//dump($where);
    }



}
