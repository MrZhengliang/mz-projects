<?php
return array(
	//SAE下固定mysql配置
	'DB_TYPE'=> 'mysql',     // 数据库类型
	'DB_DEPLOY_TYPE'=> 1,
	'DB_RW_SEPARATE'=>true,
	'DB_HOST'=> SAE_MYSQL_HOST_M.','.SAE_MYSQL_HOST_S, // 服务器地址
	'DB_NAME'=> SAE_MYSQL_DB,        // 数据库名
	'DB_USER'=> SAE_MYSQL_USER,    // 用户名
	'DB_PWD'=> SAE_MYSQL_PASS,         // 密码
	'DB_PORT'=> SAE_MYSQL_PORT,        // 端口
	'LOG_RECORD'=>true,//开启了日志记录
	//更改模板替换变量，让普通能在所有平台下显示
	'TMPL_PARSE_STRING'=>array(
	  // __PUBLIC__/upload  -->  /Public/upload -->http://appname-public.stor.sinaapp.com/upload
	'/Public/upload'=>file_domain('Public').'/upload',
	),


	'TMPL_L_DELIM'=>'<{',//修改左定界符
	'TMPL_R_DELIM'=>'}>',//修改右定界符

	'URL_PATHINFO_DEPR'=>'/',//修改URL的分隔符

	//配置模版渲染
	'LAYOUT_ON'=>false,

	'DB_PREFIX'=>'t_mz_',//表名前缀

	//添加自己的模版变量规则
	'TMPL_PARSE_STRING'=>array(
		//'__CSS__'=>'/think_php/Public/Css',
		//'__JS__'=>'/think_php/Public/Js',
		'__CSS__'=>__ROOT__.'/client/Public/css',
		'__JS__'=>__ROOT__.'/client/Public/js',
		'__IMAGE__'=>__ROOT__.'/client/Public/images',
	),

);
