create database de_thi_module3_c09;
use de_thi_module3_c09;

create table `color`(
    color_id   			int auto_increment not null,
    color_name 			varchar(45),
    primary key(color_id)	
);

create table `category`(
    category_id   			int auto_increment not null,
    category_name 			varchar(45),
    primary key(category_id)
);

create table product(
	product_id  			int auto_increment not null,
	product_name 			varchar(100),
    price					double,
    quantity				int,
    primary key(product_id),
	color_id				int	not null,
    category_id				int not null,
   
    foreign key(color_id)  references `color`(color_id),
    foreign key(category_id) references `category`(category_id)
);

-- category 

INSERT INTO `de_thi_module3_c09`.`category` (`category_id`, `category_name`) VALUES ('1', 'Phone');
INSERT INTO `de_thi_module3_c09`.`category` (`category_id`, `category_name`) VALUES ('2', 'Tivi');
INSERT INTO `de_thi_module3_c09`.`category` (`category_id`, `category_name`) VALUES ('3', 'Tủ Lạnh');
INSERT INTO `de_thi_module3_c09`.`category` (`category_id`, `category_name`) VALUES ('4', 'Máy Giặt');

-- product 
INSERT INTO `de_thi_module3_c09`.`product` (`product_id`, `product_name`, `price`, `quantity`, `color_id`, `category_id`) VALUES ('1', 'Iphone 11', '799.0', '12', '1', '1');
INSERT INTO `de_thi_module3_c09`.`product` (`product_id`, `product_name`, `price`, `quantity`, `color_id`, `category_id`) VALUES ('2', 'Iphone 11 Pro', '1100.0', '12', '3', '1');
INSERT INTO `de_thi_module3_c09`.`product` (`product_id`, `product_name`, `price`, `quantity`, `color_id`, `category_id`) VALUES ('3', 'Iphone X', '749.0', '15', '5', '1');
INSERT INTO `de_thi_module3_c09`.`product` (`product_id`, `product_name`, `price`, `quantity`, `color_id`, `category_id`) VALUES ('4', 'Smart Tivi 55 inch', '799.0', '1', '1', '2');
INSERT INTO `de_thi_module3_c09`.`product` (`product_id`, `product_name`, `price`, `quantity`, `color_id`, `category_id`) VALUES ('5', 'Tủ Lạnh 2 Cánh Toshiba', '799.0', '30', '2', '3');
INSERT INTO `de_thi_module3_c09`.`product` (`product_id`, `product_name`, `price`, `quantity`, `color_id`, `category_id`) VALUES ('6', 'Máy Giặt Cửa Ngang SamSung', '320.0', '20', '4', '4');

SELECT * FROM product;
