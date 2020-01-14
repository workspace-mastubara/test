set names utf8;
set foreign_key_checks=0;

drop database if exists latte;
create database if not exists latte;

use latte;

create table user_info(
id int primary key not null auto_increment comment 				"ID",
user_id varchar(16) unique not null comment 					"ユーザーID",
password varchar(16) not null comment 							"パスワード",
family_name varchar(32) comment 								"姓",
first_name varchar(32) comment 									"名",
family_name_kana varchar(32) comment 							"姓かな",
first_name_kana varchar(32) comment 							"名かな",
sex tinyint default 0 comment 									"性別",
email varchar(32) comment 										"メールアドレス",
status tinyint default 0 comment 								"ステータス",
logined tinyint not null default 0 comment 						"ログインフラグ",
regist_date datetime comment									"登録日時",
update_date datetime comment 									"更新日時"
)
default charset=utf8
comment="会員情報テーブル"
;

create table product_info(
id int primary key not null auto_increment comment 				"ID",
product_id int unique not null comment 							"商品ID",
product_name varchar(100) unique not null comment 				"商品名",
product_name_kana varchar(100) unique not null comment 			"商品名かな",
product_description varchar(255) comment 						"商品詳細",
category_id int not null comment 								"カテゴリID",
price int not null comment 										"値段",
image_file_path varchar(100) comment							"画像ファイルパス",
image_file_name varchar(50) comment 							"画像ファイル名",
release_date datetime comment 									"発売年月",
release_company varchar(50) comment 							"発売会社",
status tinyint default 1 comment 								"ステータス",
regist_date datetime comment									"登録日時",
update_date datetime comment 									"更新日時",
foreign key(category_id) references m_category(category_id)
)
default charset=utf8
comment="商品情報テーブル";

create table cart_info(
id int primary key not null auto_increment comment 				"ID",
user_id varchar(16) not null comment 							"ユーザーID",
product_id int not null comment 								"商品ID",
product_count int not null comment 								"個数",
regist_date datetime  not null comment							"登録日時",
update_date datetime comment 									"更新日時",
foreign key(product_id) references product_info(product_id)
)
default charset=utf8
comment="カート情報テーブル"
;

create table purchase_history_info(
id int primary key not null auto_increment comment 				"ID",
user_id varchar(16) not null comment 							"ユーザーID",
product_id int not null comment 								"商品ID",
product_count int not null comment 								"個数",
price int not null comment 										"値段",
destination_id int not null comment 							"宛先情報ID",
regist_date datetime  not null comment							"登録日時",
update_date datetime comment 									"更新日時",
foreign key(user_id) references user_info(user_id),
foreign key(product_id) references product_info(product_id)
)
default charset=utf8
comment="購入履歴情報テーブル"
;

create table destination_info(
id int primary key not null auto_increment comment 				"ID",
user_id varchar(16) not null comment 							"ユーザーID",
family_name varchar(32) not null comment 						"姓",
first_name varchar(32) not null comment 						"名",
family_name_kana varchar(32) not null comment 					"姓かな",
first_name_kana varchar(32) not null comment 					"名かな",
email varchar(32) comment										"メールアドレス",
tel_number varchar(13) comment 									"電話番号",
user_address varchar(50) not null comment 						"住所",
regist_date datetime  not null comment							"登録日時",
update_date datetime comment 									"更新日時",
foreign key(user_id) references user_info(user_id)
)
default charset=utf8
comment="宛先情報テーブル"
;

create table m_category(
id int primary key not null auto_increment comment 				"ID",
category_id int not null unique comment 						"カテゴリID",
category_name varchar(20) not null unique comment 				"カテゴリ名",
category_description varchar(100) comment 						"カテゴリ詳細",
regist_date datetime comment									"登録日時",
update_date datetime comment 									"更新日時"
)
default charset=utf8
comment="カテゴリマスタテーブル"
;


insert into user_info(user_id,password) values("guest","guest"),
												("guest1","guest1"),
												("guest2","guest2"),
												("guest3","guest3"),
												("guest4","guest4"),
												("guest5","guest5"),
												("guest6","guest6"),
												("guest7","guest7"),
												("guest8","guest8"),
												("guest9","guest9"),
												("guest10","guest10"),
												("guest11","guest11"),
												("guest12","guest12");


insert into product_info(product_id, product_name, product_name_kana, product_description, category_id, price)
	values(1,"少年漫画","しょうねんまんが","少年漫画です",0,100),
			(2,"少女漫画","しょうじょまんが","少女漫画です",0,100),
			(3,"小説","しょうせつ","小説です",0,100),
			(4,"雑誌","ざっし","雑誌です",0,100),
			(5,"参考書","さんこうしょ","参考書です",0,100),
			(6,"冷蔵庫","れいぞうこ","冷蔵庫です",1,100),
			(7,"洗濯機","せんたくき","洗濯機です",1,100),
			(8,"ドライヤー","どらいやー","ドライヤーです",1,100),
			(9,"電子レンジ","でんしれんじ","電子レンジです",1,100),
			(10,"掃除機","そうじき","掃除機です",1,100),
			(11,"ロボ","ろぼ","ロボットです",2,100),
			(12,"人形","にんぎょう","人形です",2,100),
			(13,"つみき","つみき","つみきです",2,100),
			(14,"ゲーム","ゲーム","ゲームです",2,100),
			(15,"エアガン","えあがん","エアガンです",2,100),
			(16,"JPOP","JPOP","JPOPです",3,100),
			(17,"HipHop","HipHop","HipHopです",3,100),
			(18,"クラシック","くらしっく","クラシックです",3,100),
			(19,"アニソン","あにそん","アニソンです",3,100),
			(20,"演歌","えんか","演歌です",3,100);


insert into m_category(category_id,category_name,category_description)
	values(0,"本","本カテゴリー"),
			(1,"家電","家電カテゴリー"),
			(2,"おもちゃ","おもちゃカテゴリー"),
			(3,"CD","CDカテゴリー");