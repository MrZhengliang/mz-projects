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
	<link rel="stylesheet" type="text/css" href="__CSS__/mzuser/mzinfo.css" />
	<script src="__JS__/jquery-1.9.1.min.js"></script>
	<script src="__JS__/mzuser/mzinfo.js"></script>

	<script type="text/javascript">

	</script>

	<div class="mzinfo_content">
		<div id="mzinfo_head">
			<a class="show left ml20 mr20" title="半次元-漫展频道" href="/expo">
				<img class="show" src="__IMAGE__/header_nav_back3.png?20140608">
			</a>
			<ul>
				<li><a href="__APP__/Index/index">返回首页</a></li>
				<li><a>全部漫展</a></li>
				<li><a>我参加的</a></li>
			</ul>
		</div>

		<div id="mzinfo_box">
			<div class="mzinfo_box_l">
				<div class="box_l_h">
					<div id="box_l_h_time" class="box_l_h_time">
						<a class="prev left box_l_h_time_prev">&lt;</a>
						<div class="box_l_h_time_all">
							<ul id="box_l_h_time_ul">
								<li class="left lineS_left" style="overflow: hidden; float: left; width: 119px; height: 28px;">
									<a onclick="clickExpoDate('2014-08-25',this)" href="javascript:void(0);">08月25日~08月31日</a>
								</li>
								<li class="left lineS_left" style="overflow: hidden; float: left; width: 119px; height: 28px;">
									<a onclick="clickExpoDate('2014-09-01',this)" href="javascript:void(0);">上&nbsp;&nbsp;周</a>
								</li>
								<li class="left lineS_left on" style="overflow: hidden; float: left; width: 119px; height: 28px;">
									<a onclick="clickExpoDate('2014-09-01',this)" href="javascript:void(0);">本&nbsp;&nbsp;周</a>
								</li>
								<li class="left lineS_left" style="overflow: hidden; float: left; width: 119px; height: 28px;">
									<a onclick="clickExpoDate('2014-09-01',this)" href="javascript:void(0);">下&nbsp;&nbsp;周</a>
								</li>
								<li class="left lineS_left" style="overflow: hidden; float: left; width: 119px; height: 28px;">
									<a onclick="clickExpoDate('2014-09-22',this)" href="javascript:void(0);">09月22日~09月28日</a>
								</li>
							</ul>
						</div>
						<a class="next right box_l_h_time_next lineS_left">&gt;</a>
					</div>
				</div>

				<ul class="box_l_h_c">
					<div id="container" class="box_l_h_c_show">
						<?php if(is_array($data)): $i = 0; $__LIST__ = $data;if( count($__LIST__)==0 ) : echo "" ;else: foreach($__LIST__ as $key=>$mzlist): $mod = ($i % 2 );++$i;?><li class="box_l_h_c_li" style="transform: translate(0px, 0px);">
								<a title="<?php echo ($mzlist["filename"]); ?>" target="_blank" href="/party/expodetail/<?php echo ($mzlist["faceimg"]); ?>">
									<img class="img_show" src="http://www.cos450.com/Uploads/<?php echo ($mzlist["newfilename"]); ?>">
								</a>
								<div class="party_l_right">
									<a class="flarge lwf mb10 ttl overflowH" title="<?php echo ($mzlist["title"]); ?>" target="_blank" href="__URL__/mzDetail/cid/<?php echo ($mzlist["cid"]); ?>">
										<?php echo ($mzlist["title"]); ?>
									</a>
									<p class="lwf mb10 lh1em"> 时间：<?php echo (date('Y-m-d',$mzlist["starttime"])); ?> ~ <?php echo (date('Y-m-d',$mzlist["closetime"])); ?> </p>
									<p class="lwf autocut lh1em"> 地址：<?php echo ($mzlist["address"]); ?></p>

									<div class="left party_l_cc">
										<div class="party_l_ccc">
											<div class="party_loc_pic left"></div>
											<p class="left"><?php echo ($mzlist["cityname"]); ?></p>
										</div>
										<div class="left party_l_ddd">
											<p class="left">1人参加</p>
										</div>
										<div class="left party_l_eee">
											<p class="left">0张场照</p>
										</div>
									</div>

									<div class="go_detail">
										<a class="cosgo_d" href="__URL__/mzDetail/cid/<?php echo ($mzlist["cid"]); ?>">
											查看详情&gt;&gt;
										</a>
									</div>
								</div>
							</li><?php endforeach; endif; else: echo "" ;endif; ?>
						<!--li class="box_l_h_c_li" style="transform: translate(0px, 0px);">
							<a title="2014第十届南京国际动漫游戏展（ESCC电竞国内总决赛奖金50万）" target="_blank" href="/party/expodetail/674">
								<img class="img_show" src="http://img9.bcyimg.com/party/expo/picture/2/53e30d3ce451a.jpg/2X3">
							</a>
							<div class="party_l_right">
								<a class="flarge lwf mb10 ttl overflowH" title="2014第十届南京国际动漫游戏展（ESCC电竞国内总决赛奖金50万）" target="_blank" href="/party/expodetail/674">
									2014第十届南京国际动漫游戏展（ESCC电竞国内总决赛奖金50万）
								</a>
								<p class="lwf mb10 lh1em"> 时间：2014-09-12 ~ 2014-09-14 </p>
								<p class="lwf autocut lh1em"> 地址：南京国际博览中心F馆（河西） </p>

								<div class="left party_l_cc">
									<div class="party_l_ccc">
										<div class="party_loc_pic left"></div>
										<p class="left">南京</p>
									</div>
									<div class="left party_l_ddd">
										<p class="left">1人参加</p>
									</div>
									<div class="left party_l_eee">
										<p class="left">0张场照</p>
									</div>
								</div>

								<div class="go_detail">
									<a class="cosgo_d" href="/party/expodetail/674">
										查看详情&gt;&gt;
									</a>
								</div>
							</div>
						</li-->
						<li class="box_l_h_c_li" style="transform: translate(335px, 0px);">
							<a title="2014第十届南京国际动漫游戏展（ESCC电竞国内总决赛奖金50万）" target="_blank" href="/party/expodetail/674">
								<img class="img_show" src="http://img9.bcyimg.com/party/expo/picture/2/53e30d3ce451a.jpg/2X3">
							</a>
							<div class="party_l_right">
								<a class="flarge lwf mb10 ttl overflowH" title="2014第十届南京国际动漫游戏展（ESCC电竞国内总决赛奖金50万）" target="_blank" href="/party/expodetail/674">
									2014第十届南京国际动漫游戏展（ESCC电竞国内总决赛奖金50万）
								</a>
								<p class="lwf mb10 lh1em"> 时间：2014-09-12 ~ 2014-09-14 </p>
								<p class="lwf autocut lh1em"> 地址：南京国际博览中心F馆（河西） </p>

								<div class="left party_l_cc">
									<div class="party_l_ccc">
										<div class="party_loc_pic left"></div>
										<p class="left">南京</p>
									</div>
									<div class="left party_l_ddd">
										<p class="left">1人参加</p>
									</div>
									<div class="left party_l_eee">
										<p class="left">0张场照</p>
									</div>
								</div>

								<div class="go_detail">
									<a class="cosgo_d" href="/party/expodetail/674">
										查看详情&gt;&gt;
									</a>
								</div>
							</div>
						</li>
						<li class="box_l_h_c_li" style="transform: translate(0px, 170px);">
							<a title="2014第十届南京国际动漫游戏展（ESCC电竞国内总决赛奖金50万）" target="_blank" href="/party/expodetail/674">
								<img class="img_show" src="http://img9.bcyimg.com/party/expo/picture/2/53e30d3ce451a.jpg/2X3">
							</a>
							<div class="party_l_right">
								<a class="flarge lwf mb10 ttl overflowH" title="2014第十届南京国际动漫游戏展（ESCC电竞国内总决赛奖金50万）" target="_blank" href="/party/expodetail/674">
									2014第十届南京国际动漫游戏展（ESCC电竞国内总决赛奖金50万）
								</a>
								<p class="lwf mb10 lh1em"> 时间：2014-09-12 ~ 2014-09-14 </p>
								<p class="lwf autocut lh1em"> 地址：南京国际博览中心F馆（河西） </p>

								<div class="left party_l_cc">
									<div class="party_l_ccc">
										<div class="party_loc_pic left"></div>
										<p class="left">南京</p>
									</div>
									<div class="left party_l_ddd">
										<p class="left">1人参加</p>
									</div>
									<div class="left party_l_eee">
										<p class="left">0张场照</p>
									</div>
								</div>

								<div class="go_detail">
									<a class="cosgo_d" href="/party/expodetail/674">
										查看详情&gt;&gt;
									</a>
								</div>
							</div>
						</li>

						<li class="box_l_h_c_li" style="transform: translate(335px, 170px);">
							<a title="2014第十届南京国际动漫游戏展（ESCC电竞国内总决赛奖金50万）" target="_blank" href="/party/expodetail/674">
								<img class="img_show" src="http://img9.bcyimg.com/party/expo/picture/2/53e30d3ce451a.jpg/2X3">
							</a>
							<div class="party_l_right">
								<a class="flarge lwf mb10 ttl overflowH" title="2014第十届南京国际动漫游戏展（ESCC电竞国内总决赛奖金50万）" target="_blank" href="/party/expodetail/674">
									2014第十届南京国际动漫游戏展（ESCC电竞国内总决赛奖金50万）
								</a>
								<p class="lwf mb10 lh1em"> 时间：2014-09-12 ~ 2014-09-14 </p>
								<p class="lwf autocut lh1em"> 地址：南京国际博览中心F馆（河西） </p>

								<div class="left party_l_cc">
									<div class="party_l_ccc">
										<div class="party_loc_pic left"></div>
										<p class="left">南京</p>
									</div>
									<div class="left party_l_ddd">
										<p class="left">1人参加</p>
									</div>
									<div class="left party_l_eee">
										<p class="left">0张场照</p>
									</div>
								</div>

								<div class="go_detail">
									<a class="cosgo_d" href="/party/expodetail/674">
										查看详情&gt;&gt;
									</a>
								</div>
							</div>
						</li>
					</div>
					<div class="box_l_empty_block" style="display: none;">本周暂时没有漫展哟，去别的时间段看看吧~</div>
				</ul>
			</div>

			<div class="mzinfo_box_r">
				<div class="box_r_h">
					<a href="__URL__/addMz" target="_blank">发布新漫展</a>
					<a href="__APP__/unCompleteMz" target="_blank">补充之前漫展</a>
				</div>

				<div class="mz_area">
					<div class="title_r"><p>漫展地区</p></div>
					<ul id="area_ul">
						<div class="mz_area_all">
							<li class="on"><a>全部(100)</a></li>
							<li><a>北京(55)</a></li>
							<li><a>上海(25)</a></li>
							<li><a>广州(10)</a></li>
							<li><a>天津(10)</a></li>
						</div>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>