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
  <link rel="stylesheet" type="text/css" href="__CSS__/bootstrap-datetimepicker.min.css" />
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
<link rel="stylesheet" type="text/css" href="__CSS__/mzuser/mzinfo.css" />

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

	<div class="main_box">
		<div class="main_box_A">
			<div class="left emptyDiv"></div>
			<h1 class="mz_title">发布漫展</h1>
			<form name="mzForm" id="mzForm" class="mz_form left" method="post">
				<input type="hidden" id="userId" name="userId" value="<?php echo ($_SESSION['userid']); ?>"/>
				<div class="left block_n">
					<div class="left block_info">
						 为了保护展方利益，发布后请联系cos450工作人员确认您的展方身份，验证通过后漫展页面正式对外公布。
						<br/>
						cos405媒体合作QQ：
						<span class="blue">XXX</span>
						    媒体合作邮箱：
						<span class="blue">XXX@qq.com</span>
					</div>
					<div class="left block_info_2">
						 请填写您的联系方式（至少一项），让我们的工作人员可以联系到您。<br/>
						<p class="left labelC" style="width:100px;">电话：</p>
						<input class="contact_phone" type="text"  name="contact_phone"><br/>
						<p class="left labelC" style="width:100px;">QQ：</p>
						<input class="contact_qq mr20" type="text" name="contact_qq"><br/>
						<p class="left labelC" style="width:100px;">邮箱：</p>
						<input class="contact_email" type="text" name="contact_email">
					</div>
				</div>
				<h2 class="mz_title2 blue">漫展基本信息</h2>

				<div class="left block_n block_d">
					<div class="left labelC img_div">
						<input type="hidden" value="" name="picture">
						<div class="upload_div">
							<div id="uploadgfs_hint" class="upload_div">
								<div id="gif" class="post_gif" style="top:0"></div>

								<div id="upload_preview" class="upload_div">
									图片预览：
									<div id="divFileProgressContainer">
										<ul id="pic_list" style="margin: 5px;"></ul>
										<div style="clear: both;"></div>
									</div>
									<!-- 需要js控制展示 -->
									<!--div id="prev_64740" class="prev_a left labelC" draggable="true" mid="64740">
										<div class="width100 labelC">
											<img class="prev" alt="" src="http://img5.bcyimg.com/party/expo/picture/f/541adae567533.png/w230" onload="updateH()">
										</div>
										<a href="javascript:void(0)" onclick="delOneTmpPic('#gfs_pic_ids','64740')">删除该图片</a>
									</div-->
								</div>

								<div class="upload_tag">
									<label class="left mgr5" for="etime">上传漫展封面</label>
									<div id="pic_upload" class="upload_btn_cs">
										<div id="pic_upload_button" class="upload_Button">
											<span id="spanButtonPlaceHolder"></span>
										</div>
									</div>

									<input type="hidden" name="faceImg" id="faceImg" value=""/>
								</div>
							</div>
						</div>
					</div>
					<div></div>

					<div class="lh24" style="margin-left:354px;">
						<div class="lwf mb10">
							<div class="left " style="width:120px;">漫展名称：<span class="red">*</span></div>
							<div class="left">
								<input class="" style="width:370px;" name="title" id="title" type="text" value="">
							</div>
						</div>

						<div class="lwf mb10">
							<div class="left " style="width:120px;">个性域名：</div>
							<div class="" style="margin-left:120px;"> http://www.cos450.com/mz/<input class="short-url" name="url" id="url" type="text" value=""></div>
						</div>

						<div class="lwf mb10">
							<div class="left" style="width:120px;">我的位置：<span class="red">*</span></div>
							<div class="left location"><span><a id="mylocation" href="javascript:void(0);" onclick="getMyLocation();">获取我的位置</a></span></div>
						</div>

						<div class="lwf mb10">
							<div class="left" style="width:120px;">城市：<span class="red">*</span>
						</div>
						<div class="left">
							<div class="left"> <input class="" style="width:100px;" name="city" id="city" type="text" value="" disabled> </div>

							<input type="hidden" name="cityname" id="cityname" value=""/>
							<input type="hidden" name="address" id="address" value=""/>
							<input type="hidden" name="lng" id="lng" value=""/>
							<input type="hidden" name="lat" id="lat" value=""/>
						</div>
						</div>
						<div class="lwf mb10">
							<div class="left " style="width:120px;">详细地址：<span class="red">*</span></div>
							<div class="left"> <input class="" style="width:370px;" name="show-address" id="show-address" type="text" value="" disabled> </div>
						</div>

						<div class="lwf mb10">
							<div class="left" style="width:120px;">开始时间：</div>
							<div class="left mr20">
								<input type="text" id="startDate" name="startDate" style="width:120px;" value=""/>
				          		<input type="hidden" name="startTime" id="startTime" value="${startDate}"/>
							</div>
						</div>

						<div class="lwf mb10"> <div class="left" style="width:120px;">结束时间：</div>
							<div class="left">
								<input type="text" id="endDate" name="endDate"  style="width:120px;" value=""/>
				          		<input type="hidden" name="endTime" id="endTime" value="${endDate}" />
				          	</div>
						</div>

						<div class="lwf mb10"> <div class="left" style="width:120px;">票价：</div>
						<div class="left mr20">
								<select name="fee_opt" id="fee_opt" onchange="selectFee(this);">
								<option value="1">免费</option>
								<option value="2">收费</option>
								</select>
						</div>

						<div id="price-control" class="left" style="display:none"> <input style="margin-left:10px;width:50px;" class="left mr" name="price" id="price" type="text" value="" />元 </div>

						</div>
						<div class="lwf mb10">
						<div class="left" style="width:120px;">订票方式：</div>
						<div class="left"> <input class="" style="width:370px;" name="ticket" id="ticket" type="text" value=""> </div> </div>
						<div class="lwf mb10"> <div class="left" style="width:120px;">网络售票地址：</div>
						<div class="" style="margin-left:120px;"> <input class="" style="width:370px;" name="net_sell" id="net_sell" type="text" value="">
						<p class="lwf">注：若不填写则不会显示</p> </div> </div>

						<div class="lwf"> <div class="left" style="width:120px;">漫展简介：<span class="red">*</span></div>
						<div class="left"> <textarea class="" style="width:370px; height:300px;" name="content" id="content" type="content" rows="5"></textarea>
						</div> </div> <div class="lwf">注：带<span class="red">*</span>号为必填项目</div> </div>
						<input class="btn_big mt30" style="" type="button" id="publish_handle" value="提交" />
						<input type="hidden" name="__hash__" value="6eb3965b43fe47e4a29ecb81cdfc88ef" />
				</div>
			</form>

		</div>
	</div>
</div>
<div id="content" style="display:none;">
	<form id="form1" action="index.php" method="post" >
		<p></p>
		<p></p>
		<div class="fieldset flash" id="fsUploadProgress">
			<span class="legend"></span>
	  </div>
		<div id="divStatus"></div>
			<div>
				<span id="spanButtonPlaceHolder"></span>
				<input id="btnCancel" type="button" value="" onclick="swfu.cancelQueue();" disabled="disabled" style="margin-left: 2px; font-size: 8pt; height: 29px;" />
			</div>
	</form>
</div>



<div id="mapOverlay" class="mapOverlay"></div>
<div id="mapContent" class="mapContent">
	<div id="r-result">
	请输入城市名: <input id="cityName" type="text" value="北京" style="width:100px; margin:0 10px;" />
		<input type="button" value="查询" onclick="theLocation()" />
		<input id="map-address" type="text" style="width:300px; margin:0 10px;" disabled/>
		<input type="button" value="确认" onclick="saveLocation()" />
		<span onclick="closeMap();">X</span>
	</div>
	<div style="width:698px;height:387px;border:1px solid gray" id="container"></div>
</div>

<script src="__JS__/jquery-1.9.1.min.js" type="text/javascript"></script>


<script src="__JS__/SWFUpload/js/fileprogress.js" type="text/javascript"></script>
<script src="__JS__/SWFUpload/js/handlers.js" type="text/javascript"></script>
<script src="__JS__/SWFUpload/js/swfupload.queue.js" type="text/javascript"></script>
<script src="__JS__/SWFUpload/swfupload/swfupload.js" type="text/javascript"></script>
<script src="__JS__/jquery.cookie.js" type="text/javascript"></script>
<script src="__JS__/mzuser/mzinfo.js" type="text/javascript"></script>



<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.5&ak=1jwM1UGS8wPTvaiUSUaUnuOG"></script>
<script type="text/javascript">
		var APP = "__APP__";
	    var MODULE = "__MODULE__";
	    var CONTROLLER = "__CONTROLLER__";
	    var ACTION = "__ACTION__";

		var swfu;
		cookiesifo = "PHPSESSID=<?php echo session_id(); ?>";
		window.onload = function() {
			var settings = {
				flash_url : "__JS__/SWFUpload/swfupload/swfupload.swf",
				upload_url: "__APP__/Public/uploadImg",	// Relative to the SWF file
				post_params: {"PHPSESSID" : "<?php echo session_id(); ?>", 'userid' : "<?php echo $_SESSION['userid']; ?>"},
				file_size_limit : "100 MB",
				file_types : "*.*",
				file_types_description : "All Files",
				file_upload_limit : 100,
				file_queue_limit : 0,
				custom_settings : {
					progressTarget : "fsUploadProgress",
					cancelButtonId : "btnCancel"
				},
				debug: false,

				// Button settings
				button_image_url: "__JS__/SWFUpload/images/TestImageNoText_65x29-2.png",	// Relative to the Flash file
				button_width: "65",
				button_height: "29",
				button_placeholder_id: "spanButtonPlaceHolder",
				button_text: '<span class="theFont">选择图片</span>',
				button_text_style: ".theFont { font-size: 13; }",
				button_window_mode: SWFUpload.WINDOW_MODE.TRANSPARENT,
				button_cursor: SWFUpload.CURSOR.HAND,
				button_text_left_padding: 3,
				button_text_top_padding: 3,

				// The event handler functions are defined in handlers.js
				file_queued_handler : fileQueued,
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				upload_start_handler : uploadStart,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : uploadSuccess,
				upload_complete_handler : uploadComplete,
				queue_complete_handler : queueComplete	// Queue plugin event
			};

			swfu = new SWFUpload(settings);
	     };

	//预览区域设置
	function uploadSuccess(file, serverData){

		addImage(serverData);
		var $svalue=$('form>input[name=s]').val();
		if($svalue==''){
			$('form>input[name=s]').val(serverData);
		}else{
			$('form>input[name=s]').val($svalue+"|"+serverData);
		}
	}
	//添加图片
	function addImage(serverData){

		var result = new Array();
    	result = eval('('+serverData+')');//序列化的json对象
		//alert(result.response);
		//alert(result.aid);
		//var newElement = "图片预览：<br><div style='width:172px;height:225px'><img src=\""+APP+"/"+data.savepath+data['savename']+"\" width=172 height=225/>"+data['savename']+"</div>";
		//alert('<?php echo ($aid); ?>');
		$("#pic_list").empty();
		$("#pic_list").append(result.response);
		$("#faceImg").val(result.aid);
		$('.left .mgr5').html('重新上传图片');
		//$("img.button").last().bind("click", del);
	}


	/**var del = function(){
	//var fid = $(this).parent().prevAll().length + 1;
	var src=$(this).siblings('img').attr('src');
	var $svalue=$('form>input[name=s]').val();
	$.ajax({
		type: "GET", //访问WebService使用Post方式请求
		url: window.url+"/delFile", //调用WebService的地址和方法名称组合---WsURL/方法名
		data: "src=" + src,
		success: function(data){
		var $val=$svalue.replace(data,'');
			$('form>input[name=s]').val($val);
		}
	});
		$(this).parent().remove();
	}**/



	//删除图片
	var delOneTmpPic =function(objStr,picId){
		var con =confirm("确认要删除?");
		if (!con) {
			return false;
		}
		$("#prev_"+picId).hide('slow');
		$("#prev_"+picId).queue(function() {
			$(this).remove();
			$('.left .mgr5').html('上传漫展封面');
		});
	}
	</script>

<script type="text/javascript">
	var selectFee = function (e){
		if(e.value == 2){//收费
			$('#price-control').css({'display':'block'});
		}
		if(e.value == 1){//免费
			$('#price-control').css({'display':'none'});
		}
		//alert();
	}
</script>

<script>
	//百度地图api
	var map = new BMap.Map("container");

    map.centerAndZoom(new BMap.Point(116.416522,41.897445), 11);
    //map.setCenter('北京');
	map.enableScrollWheelZoom();    //启用滚轮放大缩小，默认禁用
	map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
	//为了使用地图更加方便，我们还可以添加上缩放的平移控件，以及地图的缩略图控件，并设置他要显示的位置：
	map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
	map.addControl(new BMap.OverviewMapControl()); //添加默认缩略地图控件
	map.addControl(new BMap.OverviewMapControl({ isOpen: true, anchor: BMAP_ANCHOR_BOTTOM_RIGHT }));   //右下角，打开

    //var local = new BMap.LocalSearch(map, {
    //    renderOptions: {map: map, panel: "results"}
    //});
    //var opts = {anchor: BMAP_ANCHOR_TOP_RIGHT, offset: map.getCenter()};
    ////var opts = {anchor: BMAP_ANCHOR_TOP_RIGHT, offset: new BMap.Size(10, 10)};
    //map.addControl(new BMap.NavigationControl(opts));

	//local.search("北京市海淀区上地地铁站");



	//1.构建搜索
	/*var localSearch = new BMap.LocalSearch(map);
	localSearch.enableAutoViewport(); //允许自动调节窗体大小
	//2.开始做最关键的一步了，就是获取地址的具体经纬度：
	var searchByStationName = function(){
		var keyword = document.getElementById("text_").value;
		//搜索回调方法
	　　localSearch.setSearchCompleteCallback(function (searchResult) {
			alert(searchResult);
	　　　　var poi = searchResult.getPoi(0);
	　　　　document.getElementById("result_").value = poi.point.lng + "," + poi.point.lat; //获取经度和纬度，将结果显示在文本框中
	　　　　map.centerAndZoom(poi.point, 13);
	　　});
	　　localSearch.search(keyword);
	}*/


	/**********************************
	***********百度地图API功能*********
	**********************************/
	//1.城市名定位
	/*var map = new BMap.Map("allmap");
	var point = new BMap.Point(116.331398,39.897445);
	map.centerAndZoom(point,11);*/

	function theLocation(){
		var city = document.getElementById("cityName").value;
		if(city != ""){
			map.centerAndZoom(city,10);      // 用城市名设置地图中心点
		}
	}

	//2.IP定位获取当前城市
	function myFun(result){
		var cityName = result.name;
		//map.setCenter(cityName);
		map.centerAndZoom(cityName,11);
		//alert("当前定位城市:"+cityName);
	}
	var myCity = new BMap.LocalCity();
	myCity.get(myFun);

	setTimeout(function(){
            map.setCenter("北京");   //设置地图中心点。center除了可以为坐标点以外，还支持城市名
            map.setZoom(11);  //将视图切换到指定的缩放等级，中心点坐标不变
        }, 1000);

	//3.单击获取点击的经纬度
	//单击获取点击的经纬度
	var longitude = "";//经度
	var latitude = "";//纬度
	map.addEventListener("click",function(e){
		//alert("经度:"+e.point.lng + "," + "纬度:" +e.point.lat);
		longitude = e.point.lng;
		latitude = e.point.lat;
		if(longitude != "" && latitude != ""){
			map.clearOverlays();
			var new_point = new BMap.Point(longitude,latitude);
			var marker = new BMap.Marker(new_point);  // 创建标注
			map.addOverlay(marker);              // 将标注添加到地图中
			map.panTo(new_point);
			marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
		}
	});


	//4 用经纬度设置地图中心点
	/*function theLocation(){
		if(longitude != "" && latitude != ""){
			map.clearOverlays();
			var new_point = new BMap.Point(longitude,latitude);
			var marker = new BMap.Marker(new_point);  // 创建标注
			map.addOverlay(marker);              // 将标注添加到地图中
			map.panTo(new_point);
		}
	}*/

	//5.逆地址解析,点击地图展示详细地址
	var geoc = new BMap.Geocoder();

	map.addEventListener("click", function(e){
		var pt = e.point;
		geoc.getLocation(pt, function(rs){
			var addComp = rs.addressComponents;
			//显示选择的地址
			$('#map-address').val(addComp.province + addComp.city + addComp.district + addComp.street + addComp.streetNumber);
			//alert(addComp.province + addComp.city + addComp.district + addComp.street + addComp.streetNumber);
			//alert("经度:"+longitude + "," + "纬度:" +latitude);
		});
	});


	//click getMyLocation
	var getMyLocation = function(){
		$('#mapOverlay').css({'display':'block'});
		$('#mapContent').css({'display':'block'});
	}

	//click closeMap
	var closeMap = function(){
		$('#mapOverlay').css({'display':'none'});
		$('#mapContent').css({'display':'none'});
	}

	//click saveLocation
	var saveLocation = function (){
		//1.保存地图信息
		var cityName = $('#cityName').val();
		var mapAddress = $('#map-address').val();

		$('#city').val(cityName);//城市
		$('#show-address').val(mapAddress);//详细地址
		$('#cityname').val(cityName);//城市
		$('#address').val(mapAddress);//详细地址
		$('#lng').val(longitude);//经度
		$('#lat').val(latitude);//纬度

		//2.隐藏地图
		$('#mapOverlay').css({'display':'none'});
		$('#mapContent').css({'display':'none'});
	}
</script>
<script type="text/javascript">
	//提交按钮
	$('#publish_handle').click(function(){
		//校验电话+qq+email
		var contactPhone = $("input[type='text'][name='contact_phone']").val();
		var contactQQ = $("input[type='text'][name='contact_qq']").val();
		var contactEmail = $("input[type='text'][name='contact_email']").val();

		//邮箱正则
		var emailReg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		//alert(contactEmail);
		if(contactEmail !=''){
			if(!emailReg.test(contactEmail)){
				alert('请输入有效的E_mail！');
		        //$('#email').css("border","1px solid red");
		        $("input[type='text'][name='contact_email']").focus();
		        return;
			}
		}
		if(contactPhone =='' && contactQQ == '' && contactEmail == ''){
			alert('请填写正确电话、QQ或者邮箱');
			$("input[type='text'][name='contact_phone']").focus();
			return;
		}

		var title = $('#title').val();//漫展名字
		if(title == ''){
			alert('请输入漫展名称');
			$('#title').focus();
			return;
		}

		var city = $('#city').val();//城市
		var showAddress = $('#showAddress').val();//详细地址
		if(city =='' || showAddress ==''){
			alert('请选择您的位置');
			$('#mylocation').focus();
			return;
		}

		$("#mzForm").attr("action","__URL__/doAddMz").submit();
	});
</script>


<script src="__JS__/bootstrap.min.js" type="text/javascript"></script>
<script src="__JS__/date/bootstrap-datetimepicker.js" type="text/javascript"></script>
<script src="__JS__/date/bootstrap-datetimepicker.zhCN.js" charset="UTF-8" type="text/javascript"></script>

<script>
	$('#startDate').datetimepicker({format:'yyyy-mm-dd hh:ii:ss',language: 'ch',autoclose:'true'});
  	$('#endDate').datetimepicker({format:'yyyy-mm-dd hh:ii:ss',language: 'ch',autoclose:'true'});
</script>