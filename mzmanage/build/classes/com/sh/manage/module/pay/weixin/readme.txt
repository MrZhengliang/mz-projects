//调用微信内部浏览器
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady(){
	wxBuy(sss.appId, sss.timeStamp, sss.nonceStr, sss.packages, sss.paySign);
});

//调用支付
function wxBuy(appId, timeStamp, nonceStr, packages, paySign) {
	if (typeof WeixinJSBridge == "undefined") {
		alert("请先通过微信访问！");
	} else {
		WeixinJSBridge.invoke('getBrandWCPayRequest', {
			"appId" : appId, // 公众号名称，由商户传入

			"timeStamp" : timeStamp, // 时间戳 这里随意使用了一个值

			"nonceStr" : nonceStr, // 随机串

			"package" : packages, // 扩展字段，由商户传入

			"signType" : "SHA1", // 微信签名方式:sha1

			"paySign" : paySign
		// 微信签名

				}, function(res) {

					//alert(123);
					//WeixinJSBridge.log(res.err_msg);

//					cb(res);

					// 返回 res.err_msg,取值

				// get_brand_wcpay_request:cancel 用户取消

				// get_brand_wcpay_request:fail 发送失败

				// get_brand_wcpay_request:ok 发送成功

				 alert(res.err_msg);

			});

	}

};

// 微信收货地址
function wxGetAddress(appId, cb) {

	if (typeof WeixinJSBridge == "undefined") {

		alert("请先通过微信访问！");

	} else {

		WeixinJSBridge.invoke('getRecentlyUsedAddress', {

			// 公众号名称，由商户传入

				"appId" : appId

			}, function(res) {

				cb(res);

				// 返回 res.err_msg,取值

				// get_recently_used_address:fail 获取失败

				// get_recently_used_address:ok 获取成功

				// WeixinJSBridge.log(res.err_msg);

				// 收获地址格式为下列数据共同组成，其中参数列表如下：

				// userName:收货人姓名

				// telNumber:收货人电话号码

				// addressPostalCode:邮政编码

				// proviceFirstStageName:收货地址第⼀一级省、直辖市、自治区、特别行政区名称

				// addressCitySecondStageName:收货地址第二级市名称

				// addressCountiesThirdStageName:收货地址第三级区县名称

				// addressDetailInfo:收货地址详细信息

				// alert(res.userName+res.telNumber+res.addressPostalCode+res.proviceFirstStageName+res.addressCitySecondStageName+res.addressCountiesThirdStageName+res.addressDetailInfo);

			});

	}

};

// 修改微信地址
function wxEditAddress(appId, cb) {

	if (typeof WeixinJSBridge == "undefined") {

		alert("请先通过微信访问！");

	} else {

		WeixinJSBridge.invoke('editTransactionAddress', {

			// 公众号名称，由商户传入

				"appId" : appId

			}, function(res) {

				cb(res);

				// 返回 res.err_msg,取值

				// edit_address:fail 编辑被取消

				// edit_address:ok 编辑成功

				// WeixinJSBridge.log(res.err_msg);

				// 收获地址格式为下列数据共同组成，其中参数列表如下：

				// userName:收货人姓名

				// telNumber:收货人电话号码

				// addressPostalCode:邮政编码

				// proviceFirstStageName:收货地址第⼀一级省、直辖市、自治区、特别行政区名称

				// addressCitySecondStageName:收货地址第二级市名称

				// addressCountiesThirdStageName:收货地址第三级区县名称

				// addressDetailInfo:收货地址详细信息

				// alert(res.userName+res.telNumber+res.addressPostalCode+res.proviceFirstStageName+res.addressCitySecondStageName+res.addressCountiesThirdStageName+res.addressDetailInfo);

			});

	}

}

// 当微信内置浏览器完成内部初始化后会触发WeixinJSBridgeReady事件。

document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {

	alert("init");

	// 公众号支付

		$('#getBrandWCPayRequest').click(function(e) {

			WeixinJSBridge.invoke('getBrandWCPayRequest', {

				"appId" : "${appid}", // 公众号名称，由商户传入

				"timeStamp" : "${timeStamp}", // 时间戳

				"nonceStr" : "${nonceStr}", // 随机串

				"package" : "${package}", // //扩展包

				"signType" : "sha1", // 微信签名方式:1.sha1

				"paySign" : "${paySign}" // //微信签名

			}, function(res) {

				// if(res.err_msg == get_brand_wcpay_request:ok ) {

					alert(res.err_msg); // alert("OK");

					// }

					// 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回ok，但并不保证它绝对可靠。

					// 因此微信团队建议，当收到ok返回时，向商户后台询问是否收到交易成功的通知，若收到通知，前端展示交易成功的界面；若此时未收到通知，商户后台主动调用查询订单接口，查询订单的当前状态，并反馈给前
					// 展示相应的界面。

				});
			
		});

		WeixinJSBridge.log('yo~ ready.');
		
	}, false);