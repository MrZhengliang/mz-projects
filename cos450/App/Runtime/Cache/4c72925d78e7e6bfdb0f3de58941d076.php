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
	<script>
		$(function() {
	      $('#slides').slidesjs({
	      	width: 330,
        	height: 200,
	        navigation: false,//是否自己生成页码
	        play: {
		      active: false,
		        // [boolean] 生成的播放和停止按钮.
		        //不能使用自己的按键。
		      effect: "slide",
		        // [string] 可以是 "slide" 或者 "fade".
		      interval: 5000,
		        // [number] 每张幻灯片上花费的时间以毫秒为单位。
		      auto: true,
		        // [boolean] 加载开始播放幻灯片。
		      swap: true,
		        // [boolean] 显示/隐藏停止和播放按钮
		      pauseOnHover: false,
		        // [boolean] 鼠标经过暂停正在播放的幻灯片。
		      restartDelay: 2500
		        // [number] 重新启动延迟无效幻灯片。
		    },

		    effect: {
		      slide: {
		        // 滑动效果设置.
		        speed: 200
		          // [number] 速度以毫秒为单位的幻灯片动画。
		      },
		      fade: {
		        speed: 300,
		          // [number] 速度以毫秒为单位的幻灯片动画。
		        crossfade: true
		          // [boolean] 交叉过度效果.
		      }
		    }

	      });
	    });
	</script>
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
				<?php if($_SESSION['nickname'] != ''): ?>欢迎<?php echo ($_SESSION['nickname']); ?>来到cos405
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
		    display: block;
		    top: auto;
		}
		.float_back .float_content{
			background: none repeat scroll 0 0 #D1D1D1;
			padding: 15px 10px;
		}
	</style>
		<!-- float div -->
		<div id="login_fldiv" class="float_back">
		<!-- head -->
			<div class="float_content">
					asdddddddddd
			</div>
		</div>
		</body>
<script>

</script>
<div class="head_banner">
</div>
<div class="mz_nav">
		<a class="nav-fir" href="__APP__/Index/index">首页</a>
		<a class="nav-fz" href="__APP__/MzInfo/mzList">漫展信息</a>
		<a class="nav-fzz">外景地点</a>
		<a class="nav-tz">约妆</a>
		<a class="nav-tz">摄影</a>
		<a class="nav-tz">后勤</a>
		<a class="nav-tz">后期</a>
		<a class="nav-fzj">物品交易</a>
		<a class="nav-fzw" href="__URL__/zhaopin">加入我们</a>
		<div class="nav-mt"></div>
</div>
<!-- content1 info -->
<div class="mz_info">
		<div class="mz_left">
			<div class="leftslide left">
				<div id="slides">
			      <img src="__IMAGE__/example/example-slide-1.jpg" height="200" alt="Photo by: Missy S Link: http://www.flickr.com/photos/listenmissy/5087404401/">
			      <img src="__IMAGE__/example/example-slide-2.jpg" height="200" alt="Photo by: Daniel Parks Link: http://www.flickr.com/photos/parksdh/5227623068/">
			      <img src="__IMAGE__/example/example-slide-3.jpg" height="200" alt="Photo by: Mike Ranweiler Link: http://www.flickr.com/photos/27874907@N04/4833059991/">
			      <img src="__IMAGE__/example/example-slide-4.jpg" height="200" alt="Photo by: Stuart SeegerLink: http://www.flickr.com/photos/stuseeger/97577796/">
			    </div>
			</div>
			<div class="middleinfo left">
				<h1><a href="#">后园·第十二辑：时间无言，如此这般</a></h1>
				<div class="summary">
					时间太过残酷，一切仿佛还在昨天，可是我们曾经拥有的一切，转个弯就消失不见了。...
					<a href="#">[详情>>]</a>
				</div>
				<h1><a href="#">【小卖部】礼物推荐，您值得拥有(╯3╰)(╯ε╰)</a></h1>
				<div class="summary">“有意思的小卖部”中一些比较适合作为礼物送给朋友的东东，您值得拥有(╯3╰) ...
					<a href="#">[详情>>]</a>
				</div>
				<div class="line"></div>
			   	<ul>
			   		<li><a href="#" class="alink">[图画]</a><a href="#">【图U起名】第336期：冠名征集中 (1575)</a></li>
			   		<li><a href="#" class="alink">[图画]</a><a href="#">字幕也雷人（75）拜托自重一点好吗，姑娘 (12852)</a></li>
			   	</ul>
			</div>
			<div class="mz_adv">
				<a><img height="110" width="759" src="__IMAGE__/advs/mz_adv_04.gif"/></a>
			</div>
			<div class="mz_xx">
				<label><span class="mz_title_left">漫展信息</span><span class="mz_title_right">+MORE</span></label>
				<div class="mz_xx_showarea">
					<ul>
						<li>
							<div><img src="__IMAGE__/mz_content/default_user.png"/></div>
							<div class="right_info">
								<h4>测试</h4>
								<span>描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述
								描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述
									描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述
									描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述
									描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述
								</span>
								<span></span>
							</div>
						</li>
						<li>
							<div><img src="__IMAGE__/mz_content/default_user.png"/></div>
							<div class="right_info">
								<h4>测试</h4>
								<span>描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述
								描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述
									描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述
									描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述
									描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述
								</span>
								<span></span>
							</div>
						</li>
						<li>
							<div><img src="__IMAGE__/mz_content/default_user.png"/></div>
							<div class="right_info">
								<h4>测试</h4>
								<span>描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述
								描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述
									描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述
									描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述
									描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述
								</span>
								<span></span>
							</div>
						</li>
					</ul>
				</div>
			</div>

			<div class="mz_wj">
				<label><span class="mz_title_left">外景地点</span><span class="mz_title_right">+MORE</span></label>
				<div class="mz_wj_showarea">
					<span class="mz_wj_left_arrow"></span>
						<ul>
							<?php $__FOR_START_11799__=1;$__FOR_END_11799__=6;for($i=$__FOR_START_11799__;$i < $__FOR_END_11799__;$i+=1){ if($i < 5 ): ?><li id="<?php echo ($i); ?>" class="mz_wj_small-pic">
								    		<a href=""><img src="__IMAGE__/example/example-slide-2.jpg"/></a></li>
								        <?php else: ?>
								        <li id="<?php echo ($i); ?>" class="mz_wj_small-pic" style="display:none;"><img src="__IMAGE__/example/example-slide-4.jpg"/></li>
								        <li id="<?php echo ($i); ?>" class="mz_wj_small-pic" style="display:none;"><img src="__IMAGE__/example/example-slide-3.jpg"/></li>
										<li id="<?php echo ($i); ?>" class="mz_wj_small-pic" style="display:none;"><img src="__IMAGE__/example/example-slide-2.jpg"/></li><?php endif; } ?>
						</ul>
					<span class="mz_wj_right_arrow"></span>
				</div>
			</div>

			<div class="mz_yy">
				<label><span class="mz_title_left">预约</span><span class="mz_title_right">+MORE</span></label>
				<div class="mz_yy_showarea">
					<ul>
						<li id="" class="mz_yy_small-pic">
							<a href=""><img src="__IMAGE__/example/example-slide-1.jpg"/></a>
							<div class="mz_yy_yz"><a href="">约妆</a></div>
						</li>
						<li id="" class="mz_yy_small-pic">
							<a href=""><img src="__IMAGE__/example/example-slide-1.jpg"/></a>
							<div class="mz_yy_sy"><a href="">摄影</a></div>
						</li>
						<li id="" class="mz_yy_small-pic">
							<a href=""><img src="__IMAGE__/example/example-slide-1.jpg"/></a>
							<div class="mz_yy_hqn"><a href="">后勤</a></div>
						</li>
						<li id="" class="mz_yy_small-pic">
							<a href=""><img src="__IMAGE__/example/example-slide-1.jpg"/></a>
							<div class="mz_yy_hq"><a href="">后期</a></div>
						</li>
					</ul>
				</div>
			</div>

			<div class="mz_jy">
				<label><span class="mz_title_left">物品交易</span><span class="mz_title_right">+MORE</span></label>
				<div class="mz_jy_showarea">
					<span class="mz_jy_left_arrow"></span>
						<ul>
							<?php $__FOR_START_20996__=1;$__FOR_END_20996__=7;for($i=$__FOR_START_20996__;$i < $__FOR_END_20996__;$i+=1){ if($i < 6 ): ?><li id="<?php echo ($i); ?>" class="mz_jy_small-pic">
								    		<a href=""><img src="__IMAGE__/example/example-slide-3.jpg"/></a></li>
								        <?php else: ?>
								        <li id="<?php echo ($i); ?>" class="mz_jy_small-pic" style="display:none;"><img src="__IMAGE__/example/example-slide-4.jpg"/></li>
								        <li id="<?php echo ($i); ?>" class="mz_jy_small-pic" style="display:none;"><img src="__IMAGE__/example/example-slide-3.jpg"/></li>
										<li id="<?php echo ($i); ?>" class="mz_jy_small-pic" style="display:none;"><img src="__IMAGE__/example/example-slide-2.jpg"/></li><?php endif; } ?>
						</ul>
					<span class="mz_jy_right_arrow"></span>
				</div>
			</div>

			<div class="mz_adv2">
				<a><img height="110" width="759" src="__IMAGE__/advs/mz_adv_04.gif"/></a>
			</div>

			<div class="mz_bottom">
				<div class="mz_bottom_l">
					<ul>
						<li class="strong">关于</li>
						<li>关于我们</li>
						<li>版权声明</li>
						<li>广告服务</li>
						<li>联系我们</li>
					</ul>
					<ul>
						<li class="strong">收藏</li>
						<li><a rel="sidebar" href="" onclick="addBookmark('COS405漫展','http://www.cos450.com');">加入收藏</a></li>
						<li>放到桌面</li>
						<li>加入右键</li>
						<li>订阅rss</li>
					</ul>
					<ul>
						<li class="strong">关注</li>
						<li>新浪微博</li>
						<li>QQ空间</li>
						<li>腾讯微博</li>
						<li>漫展博客</li>
					</ul>
				</div>

				<div class="mz_bottom_r">

				</div>
			</div>
		</div>

		<div class="mz_right">
			<div class="mz_u_info">
				<div class="mz_u_info_img"><img width="90" height="90" src="__IMAGE__/mz_content/default_user.png"/></div>
				<div class="mz_u_info_text">
					<ul>
						<li>昵称:<?php echo ($_SESSION['nickname']); ?></li>
						<li>等级:3</li>
						<li>
							<?php if($_SESSION['username'] != ''): ?><a href="__APP__/MzUser/userinfo/nickname/<?php echo ($_SESSION['nickname']); ?>">进入个人中心</a><?php endif; ?>
						</li>
					</ul>
				</div>
			</div>
			<div class="mz_h_info">
				<a class="join_us" href="__URL__/zhaopin">
					<img src="__IMAGE__/mz_content/arrow_join.gif"/>
				</a>
			</div>
		</div>
</div>


</div>