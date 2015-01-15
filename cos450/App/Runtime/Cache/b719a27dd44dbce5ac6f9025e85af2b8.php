<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE HTML>
<html lang="zh-cn">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta content="cos450,cosplay,coser,绘师,二次创作,漫展,acg" name="keywords">
	<meta content="COS450是国内领先的ACG社区，最专业的中文cosplay平台，提供cosplay作品分享、Coser交流，同时提供漫展活动主页创建、信息发布、场照返图和认领、互动讨论等商务合作平台。" name="description">
	<meta charset="UTF-8">
	<title>二次元的空间cos450</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


  <script src="__JS__/jquery-1.9.1.min.js"></script>
  <script src="__JS__/jquery.cookie.js"></script>
  <script src="__JS__/jquery.slides.min.js"></script>
  <script src="__JS__/base.js" type="text/javascript"></script>


  <link rel="stylesheet" type="text/css" href="__CSS__/base.css" />
  <link rel="stylesheet" type="text/css" href="__CSS__/bootstrap.min.css" />
  <link rel="stylesheet" type="text/css" href="__CSS__/hap_common.css" />
  <link rel="stylesheet" type="text/css" href="__CSS__/datepicker.css" />
  <link rel="stylesheet" type="text/css" href="__CSS__/font-awesome.min.css" />


 </head>
<body>
<!-- float div -->
<div class="mz_content">
	<div id="flt_logon_head"></div>
	<!-- head -->
	<div class="head_nav">
		<div class="top">
			<div class="sy_dq">
				<a class="top_home_l"></a>
				<a href="__APP__/Index/index">首页</a>
				<script>
					document.write('<a id="this_area" href="javascript:void(0);">'+thisCity()+'</a>'+
						'<div id="area" class="area_items">'+
							'<a class="">切换</a>'+
							'<div id="area_locations" class="show_area" style="display:none;">'+showArea()+
							'</div>'+
						'</div>');
				</script>
			</div>
			<div class="login">
				<a class="top_home_r"></a>
				<?php if($_SESSION['username'] != ''): ?>欢迎<?php echo ($_SESSION['username']); ?>来到cos450
					<a href="__APP__/MzUser/logout">退出</a>
					<?php else: ?>
					<a href="__APP__/MzUser/login">登录</a>
					<a href="__APP__/MzUser/register">注册</a><?php endif; ?>

			</div>
		</div>
	</div>
	<style>
		.float_back{
			left: 0;
		    position: fixed;
		    top: 0;
		    width: 100%;
		    z-index: 200;
		    bottom: 0 !important;
		    display: none;
		    top: auto;
		}
		.float_back .float_content{
			background: none repeat scroll 0 0 #D1D1D1;
			padding: 15px 10px;
			height: 26px;
		}

		#login_fldiv a.link-close{
			color: #aaa;
		    font-size: 25px;
		    font-weight: lighter;
		    line-height: 1.4;
		    padding: 0 2px;
		    position: absolute;
		    right: 100px;
		    top: 5px;
		}
		#login_fldiv a:hover{
			background-color:#D1D1D1;
		}
		#login_fldiv p{
			color: #072;
		    float: left;
		    font-size: 18px;
		    margin: 0 60px 15px 368px;
		}
		#login_fldiv .mz-operation{
			 float: left;
    		 margin-right: 10px;
		}
		#login_fldiv .mz-operation a{
			 background: none repeat scroll 0 0 #60BFD1;
		     border: 1px solid #60BFD1;
		     border-radius: 2px;
		     color: #fff;
		     display: inline-block;
		     font-size: 14px;
		     margin-right: 12px;
		     padding: 3px 16px;
		}
		#login_fldiv label{
			font-family: Tahoma;
    		vertical-align: middle;
		}
		.mz-3rd{
			color: #999;
		    float: left;
		    font-size: 15px;
		    line-height: 26px;
		    width: 200px;
		}
	</style>
		<!-- float div -->
		<div id="login_fldiv" class="float_back">
		<!-- head -->
			<div class="float_content">
					<p>最好的漫展交流平台</p>
					<div class="mz-operation">
						<a class="a_show_register" href="">注册</a>
						<a class="a_show_login" href="">登录</a>
					</div>
					<div class="mz-3rd">
						<label>第三方登录</label>
						<a class="item-qq" href="http://www.douban.com/accounts/connect/qq/?from=group&redir=http%3A//www.douban.com/accounts/join_and_redir%3Fgroup_id%3D73535" target="_top">
							<img title="QQ" src="http://img3.douban.com/pics/connect_qq.png">
						</a>
						<a class="item-weibo" href="http://www.douban.com/accounts/connect/sina_weibo/?from=group&redir=http%3A//www.douban.com/accounts/join_and_redir%3Fgroup_id%3D73535&fallback=http://www.douban.com/group/Sharing/" target="_top">
							<img title="新浪微博" src="http://img3.douban.com/pics/connect_sina_weibo.png">
						</a>
					</div>
					<a class="link-close">X</a>
			</div>
		</div>
		</body>
	<link rel="stylesheet" type="text/css" href="__CSS__/mzuser/userinfo.css" />
	<script src="__JS__/jquery-1.9.1.min.js"></script>


	<script type="text/javascript">

		var selectCity = function(){
			//省分编码
			var prov = $('#province').val();
			var provname = $('#province').find('option:selected').text();
			$('#provincename').val(provname);
			//ajax获取地市数据
					$.post('__URL__/ajaxGetCitys',{prov:prov},function(jsonData){
							var jsonO = eval(jsonData);
							//返回的地市数组
							$('#city').empty();//清空之前数据
							if(typeof jsonO=="object" && jsonO.length>0){
								for(var i=0;i<jsonO.length;i++){
									//追加地市
									$('#city').append('<option value="'+jsonO[i]['areacode']+'" >'+jsonO[i]['areaname']+'</option>');
								}
								var cityname = $('#city').find('option:selected').text();
								$('#cityname').val(cityname);
							}else{
								$('#city').append('<option value="'+prov+'" >'+provname+'</option>');
								$('#cityname').val(provname);
							}
						},'json');
	           		////////////
			}
		///确定地市
		var submitCity = function(){
			var cityname = $('#city').find('option:selected').text();
			$('#cityname').val(cityname);
		}
		/////////////////////

		$(function(){
			flag=true;
			var nm = $('#nick_name');
			$('#nick_name').blur(function(){
				if(nm.val() == ''){
					$('#nick_name_err').text('请填写昵称!');
					$('#nick_name').css({
						  "border":"1px solid red"
					 });
					falg = false;
				}else{
	           		//ajax获取校验邮箱数据
					$.post('__URL__/checkloginName',{login_name:$('#nick_name').val()},function(jsonData){
						//alert(jsonData);
						if(jsonData.status=='0' && $('#nick_name').val() != '<?php echo ($_SESSION['nickname']); ?>' ){
							$('#nick_name_err').css('color','red').text('该昵称已被使用,请换一个!');
							$('#nick_name').css({"border":"0px solid red"});
							falg=false;
						}else{
							$('#nick_name').css("border","1px solid green");
							$('#nick_name_err').css('color','green').text('该昵称不存在,可使用');
							falg=true;
						}
						},'json');
	           		////////////
	           	}
			});
			//提交
			$('#button').click(function(){
				var userintro = $('#user-intro').val();
				if(userintro.length>80){
					alert('个人简介最多输入80字');
					flag = false;
					return;
				}
				//校验通过
				//alert(flag);
				if(flag){
					$("#userForm").submit();
					alert('保存完成');
					window.location.reload();
				}
			});
		});
	</script>

	<div class="userinfo_content">
		<div class="right_form">
			<h2>我的资料</h2>
			<form name="userForm" id="userForm" action="__URL__/saveUserInfo" method="post">
				<input id="userid" class="basic-input" type="hidden" name="userid" value="<?php echo ($user[0]["uid"]); ?>"/>
				<input id="provincename" class="basic-input" type="hidden" name="provincename" />
				<input id="cityname" class="basic-input" type="hidden"  name="cityname" />
				<div class="item">
					<label>站内昵称：<?php echo ($user["email"]); ?></label><input id="nick_name" class="basic-input" type="text" name="nickname" value="<?php echo ($user[0]["nickname"]); ?>"/>
					 <span id="nick_name_err" style="color:red;font-size: 12px;width: 120px;"></span>
				</div>
				<div class="item">
					<label>所在地区：</label>
		            <select class="basic-select" id="province" name="province" onChange="selectCity()" >

		            	<option value="<?php echo ($user[0]["provincecode"]); ?>" selected><?php echo ($user[0]["provincename"]); ?></option>
		            	<?php if(is_array($provinces)): foreach($provinces as $key=>$v): if($user[0].provincecode != $v.areacode): ?><option value="<?php echo ($v["areacode"]); ?>" ><?php echo ($v["areaname"]); ?></option><?php endif; endforeach; endif; ?>
		            </select>
		            <select class="basic-select" id="city" name="city" onChange="submitCity()">
		            	<?php if($user[0].citycode != ''): ?><option value="<?php echo ($user[0]["citycode"]); ?>" selected><?php echo ($user[0]["cityname"]); ?></option>
		            		<?php else: ?>
		            		<?php if(is_array($citys)): foreach($citys as $key=>$v): ?><option value="<?php echo ($v["areacode"]); ?>"><?php echo ($v["areaname"]); ?></option><?php endforeach; endif; endif; ?>
		            </select>
				</div>
				<div class="item">
					<label style="padding:0 30px 0 0px;">性别：</label>
						<input class="basic-input" type="radio" name="usersex" value="1" id="user_sex" <?php if($user[0]['sex'] == 1): ?>checked<?php endif; ?>/>男
						<input class="basic-input" type="radio" name="usersex" value="2" id="user_sex" <?php if($user[0]['sex'] == 2): ?>checked<?php endif; ?>/>女</br>
				</div>
				<div class="item">
					<label style="padding:0 0 5px 5px;">个人简介:</label>
					<textarea id="user-intro" rows="4"  name="userintro" class="basic-textarea"><?php echo ($user[0]["userintro"]); ?></textarea>
					<p class="fbase">个人简介在80个字之内</p>
				</div>
				<div class="item_th">
					<input class="btn-submit" id="button" type="button" tabindex="5" name="user_login" value="保存">
				</div>
			</form>
		</div>
	</div>
</body>