CREATE TABLE `customer` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '客户名称',
  `phone` varchar(255) DEFAULT NULL COMMENT '客户手机',
  `dest` varchar(255) NOT NULL COMMENT '目的地',
  `h_price` double DEFAULT NULL COMMENT '重量单价',
  `v_price` double DEFAULT NULL COMMENT '体积单价',
  `base_price` double DEFAULT NULL COMMENT '起步价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
CREATE TABLE `orders` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_num` varchar(255) DEFAULT NULL COMMENT '订单号',
  `customer_name` varchar(255) DEFAULT NULL COMMENT '客户姓名',
  `dest` varchar(255) DEFAULT NULL COMMENT '目的地',
  `recipient` varchar(255) DEFAULT NULL COMMENT '收件人',
  `goods_num` double DEFAULT NULL COMMENT '件数',
  `quantity` double DEFAULT NULL COMMENT '数量 重量 或者体积',
  `insured_fee` double DEFAULT NULL COMMENT '保价费',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `extra` double DEFAULT NULL COMMENT '其他金额',
  `unit_price` double DEFAULT NULL COMMENT '单价',
  `pay_type` varchar(255) DEFAULT NULL COMMENT '支付方式',
  `total_price` double DEFAULT NULL COMMENT '总金额',
  `cost` double DEFAULT NULL COMMENT '成本',
  `profit` double DEFAULT NULL COMMENT '利润',
  `outlets` varchar(255) DEFAULT NULL COMMENT '网点',
  `price_type` varchar(255) DEFAULT NULL COMMENT '计费方式',
  `mail_date` varchar(255) DEFAULT NULL COMMENT '寄件日期',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '日期',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '生产日期',
  `base_price` double DEFAULT NULL COMMENT '起步价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;