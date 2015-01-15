package com.sh.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Title. 支付控制类<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2014年11月30日
 * <p>
 * Company: ff
 * <p>
 * Author: fuzl
 * <p>
 * Version: 1.0
 * <p>
 */
@Controller
public class PayController {
	// 跳转支付页
	@RequestMapping(value = "/alipay")
	public ModelAndView aliPayPage() {
		return new ModelAndView("/pay/index");
	}
}
