<?php
return array(
	//'配置项'=>'配置值'
	'LAYOUT_ON'=>false,
    //'TPM_THEME'=>'mobile' //可定义手机客户端的主题模板
    //'TPM_THEME'=>'mobile' //可定义手机客户端的主题模板

	'URL_PATHINFO_DEPR'=>'/',//修改URL的分隔符

	'TMPL_L_DELIM'=>'<{',//修改左定界符
	'TMPL_R_DELIM'=>'}>',//修改右定界符

	'DB_PREFIX'=>'t_ygjj_',//表名前缀

	'SHOW_PAGE_TRACE'=>true,//开启页面trace

	//'URL_CASE_INSENSITIVE'=>true,//大小写不敏感

	'DB_DSN'=>'mysql://root:123@localhost:3306/ygjj',//使用DSN方式配置数据库

	//'DB_DSN'=>'mysql://root:sql405@localhost:3306/mz',//使用DSN方式配置数据库

	//添加自己的模版变量规则
	'TMPL_PARSE_STRING'=>array(
		//'__CSS__'=>'/think_php/Public/Css',
		//'__JS__'=>'/think_php/Public/Js',
		'__CSS__'=>__ROOT__.'/client/Public/css',
		'__JS__'=>__ROOT__.'/client/Public/js',
		'__IMAGE__'=>__ROOT__.'/client/Public/images',
		'/Uploads'=>__ROOT__.'/Uploads/images',
	),
);
?>
