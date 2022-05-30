create database case_study_module_3_db_servlet;
-- drop database case_study_module_3_db_servlet;
use case_study_module_3_db_servlet;

create table `position`(
    position_id   			int auto_increment not null,
    position_name 			varchar(45),
    primary key(position_id)
);
create table education_degree(
    education_degree_id  	int auto_increment not null,
    education_degree_name 	varchar(45),
    primary key(education_degree_id)
);
create table division(
    division_id  			int auto_increment not null,
    division_name			varchar(45),
    primary key(division_id)
);
create table `role`(
    role_id 				int auto_increment not null,
    role_name 				varchar(255),
    primary key(role_id)
);
create table `user`(
    user_name 				varchar(255) not null,
    `password` 				varchar(255),
    primary key(user_name)
);
create table user_role(
    role_id 				int auto_increment not null,
    user_name 				varchar(255),
    foreign key(role_id) references `role`(role_id),
    foreign key(user_name) references `user`(user_name)
);
create table employee(
    employee_id  			int auto_increment not null,
    employee_name       	varchar(45) not null,
    employee_birthday     	date       not null,
    employee_id_card       	varchar(45) not null,
    employee_salary        double     not null,
    employee_phone 			varchar(45) not null,
    employee_email         	varchar(45),
    employee_address       	varchar(45),
    primary key(employee_id),
    position_id     		int        not null,
    education_degree_id   	int        not null,
    division_id    			int        not null,
    user_name 				varchar(255),
    foreign key(position_id)  references `position`(position_id),
    foreign key(education_degree_id) references education_degree(education_degree_id),
    foreign key(division_id) references division(division_id)
);
create table customer_type(
    customer_type_id  		int        auto_increment not null,
    customer_type_name 		varchar(45),
    primary key(customer_type_id)
);
create table customer(
    customer_id 			int auto_increment not null,

    customer_name        	varchar(45) not null,
    customer_birthday     	date       not null,
    customer_gender     	bit(1)     not null,
    customer_id_card       	varchar(45) not null,
    customer_phone 			varchar(45) not null,
    customer_email         	varchar(45),
    customer_address       	varchar(45),
	customer_type_id 		int not null,
    primary key(customer_id),
    foreign key(customer_type_id) references customer_type(customer_type_id)
);
create table rent_type(
    rent_type_id  			int        auto_increment not null,
    rent_type_name 			varchar(45),
    rent_type_cost 			double,
    primary key(rent_type_id)
);

create table service_type(
    service_type_id 		int auto_increment not null,
    service_type_name 		varchar(45),
    primary key(service_type_id)
);

-- set sql_safe_update =0;
-- drop table service_type;
-- set sql_safe_update =1; 

create table service(
    service_id           	int        auto_increment not null,
    service_name         	varchar(45) not null,
    service_area           int,
    service_cost         	double     not null,
    service_max_people   	int,
	standard_room     		varchar(45),
    description_other_convenience varchar(45),
    pool_area     			double,
    number_of_floors       int,
    rent_type_id         	int        not null,
    service_type_id      	int        not null,
    primary key(service_id),
    foreign key(rent_type_id) references rent_type(rent_type_id),
    foreign key(service_type_id) references service_type(service_type_id)
);
create table attach_service(
    attach_service_id  		int        auto_increment not null,
    attach_service_name 	varchar(45) not null,
    attach_service_cost    double     not null,
    attach_service_unit    varchar(10) not null,
    attach_service_status  varchar(45),
    primary key(attach_service_id)
);
create table contract(
    contract_id       		int     auto_increment not null,
    contract_start_date 	datetime not null,
    contract_end_date     	datetime not null,
    contract_deposit      	double  not null,
    contract_total_money 	double not null,
    employee_id      		int     not null,
    customer_id     		int     not null,
    service_id        		int     not null,
    primary key(contract_id),
    foreign key(employee_id) references employee(employee_id),
    foreign key(customer_id) references customer(customer_id),
    foreign key(service_id)   references service(service_id)
);
create table contract_detail(
    contract_detail_id 		int auto_increment not null,
    contract_id          	int not null,
    attach_service_id    	int not null,
     quantity             	int not null,
    primary key(contract_detail_id),
    foreign key(contract_id) references contract(contract_id),
    foreign key(attach_service_id) references attach_service(attach_service_id)
);

-- customer type

INSERT INTO `case_study_module_3_db_servlet`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('1', 'Diamond');
INSERT INTO `case_study_module_3_db_servlet`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('2', 'Platinium');
INSERT INTO `case_study_module_3_db_servlet`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('3', 'Gold');
INSERT INTO `case_study_module_3_db_servlet`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('4', 'Silver');
INSERT INTO `case_study_module_3_db_servlet`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('5', 'Member');

-- customer

INSERT INTO `case_study_module_3_db_servlet`.`customer` (`customer_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES (1, 'Nguyễn Thị Hào', '1970-11-07', b'0', '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng', 5);
INSERT INTO `case_study_module_3_db_servlet`.`customer` (`customer_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES (2, 'Phạm Xuân Diệu', '1992-08-08', b'1', '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị', 3);
INSERT INTO `case_study_module_3_db_servlet`.`customer` (`customer_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES (3, 'Trương Đình Nghệ', '1990-02-27', b'1', '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh', 1);
INSERT INTO `case_study_module_3_db_servlet`.`customer` (`customer_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES (4, 'Dương Văn Quan', '1981-07-08', b'1', '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng', 1);
INSERT INTO `case_study_module_3_db_servlet`.`customer` (`customer_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES (5, 'Hoàng Trần Nhi Nhi', '1995-12-09', b'0', '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai', 4);
INSERT INTO `case_study_module_3_db_servlet`.`customer` (`customer_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES (6, 'Tôn Nữ Mộc Châu', '2005-12-06', b'0', '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng', 4);
INSERT INTO `case_study_module_3_db_servlet`.`customer` (`customer_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES (7, 'Nguyễn Mỹ Kim', '1984-04-08', b'0', '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh', 1);
INSERT INTO `case_study_module_3_db_servlet`.`customer` (`customer_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES (8, 'Nguyễn Thị Hào', '1999-04-08', b'0', '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum', 3);
INSERT INTO `case_study_module_3_db_servlet`.`customer` (`customer_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES (9, 'Trần Đại Danh', '1994-07-01', b'1', '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi', 1);
INSERT INTO `case_study_module_3_db_servlet`.`customer` (`customer_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES (10, 'Nguyễn Tâm Đắc', '1989-07-01', b'1', '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng', 2);

-- position  
INSERT INTO `case_study_module_3_db_servlet`.`position` (`position_id`, `position_name`) VALUES ('1', 'Quản Lý');
INSERT INTO `case_study_module_3_db_servlet`.`position` (`position_id`, `position_name`) VALUES ('2', 'Nhân Viên');

-- education background
INSERT INTO `case_study_module_3_db_servlet`.`education_degree` (`education_degree_id`, `education_degree_name`) VALUES ('1', 'Trung Cấp');
INSERT INTO `case_study_module_3_db_servlet`.`education_degree` (`education_degree_id`, `education_degree_name`) VALUES ('2', 'Cao Đẳng');
INSERT INTO `case_study_module_3_db_servlet`.`education_degree` (`education_degree_id`, `education_degree_name`) VALUES ('3', 'Đại Học');
INSERT INTO `case_study_module_3_db_servlet`.`education_degree` (`education_degree_id`, `education_degree_name`) VALUES ('4', 'Sau Đại Học');

-- division 

INSERT INTO `case_study_module_3_db_servlet`.`division` (`division_id`, `division_name`) VALUES ('1', 'Sale-Marketing');
INSERT INTO `case_study_module_3_db_servlet`.`division` (`division_id`, `division_name`) VALUES ('2', 'Hành chính');
INSERT INTO `case_study_module_3_db_servlet`.`division` (`division_id`, `division_name`) VALUES ('3', 'Phục vụ');
INSERT INTO `case_study_module_3_db_servlet`.`division` (`division_id`, `division_name`) VALUES ('4', 'Quản lý');

-- trigger username
DELIMITER //
CREATE TRIGGER after_user_name before insert on employee for each row 
BEGIN 
INSERT INTO `user`
SET user_name = new.employee_email, `password` = '123123';
END //
DELIMITER ;

-- employee
insert into employee(employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id)
values ('Nguyễn Văn An', '1970-11-07', '456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', 1, 3, 1),
       ('Lê Văn Bình', '1997-04-09', '654231234', 7000000, '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2),
       ('Hồ Thị Yến', '1995-12-12', '999231723', 14000000, '0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2),
       ('Võ Công Toản', '1980-04-04', '123231365', 17000000, '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4),
       ('Nguyễn Bỉnh Phát', '1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1),
       ('Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3),
       ('Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2),
       ('Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, '0642123111','donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4),
       ('Tòng Hoang', '1982-09-03', '256781231', 6000000, '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4),
       ('Nguyễn Công Đạo', '1994-01-08', '755434343', 8000000, '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2);


-- trigger username
DELIMITER //
CREATE TRIGGER after_user_name before insert on employee for each row 
BEGIN 
INSERT INTO `user`
SET user_name = new.employee_email, `password` = '123123';
END //
DELIMITER ;


-- rent type
INSERT INTO `case_study_module_3_db_servlet`.`rent_type` (`rent_type_id`, `rent_type_name`) VALUES ('1', 'year');
INSERT INTO `case_study_module_3_db_servlet`.`rent_type` (`rent_type_id`, `rent_type_name`) VALUES ('2', 'month');
INSERT INTO `case_study_module_3_db_servlet`.`rent_type` (`rent_type_id`, `rent_type_name`)VALUES ('3', 'day');
INSERT INTO `case_study_module_3_db_servlet`.`rent_type` (`rent_type_id`, `rent_type_name`) VALUES ('4', 'hour');

-- service type
INSERT INTO `case_study_module_3_db_servlet`.`service_type` (`service_type_id`, `service_type_name`) VALUES ('1', 'Villa');
INSERT INTO `case_study_module_3_db_servlet`.`service_type` (`service_type_id`, `service_type_name`) VALUES ('2', 'House');
INSERT INTO `case_study_module_3_db_servlet`.`service_type` (`service_type_id`, `service_type_name`) VALUES ('3', 'Room');

-- service

INSERT INTO `case_study_module_3_db_servlet`.`service` (`service_id`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`, `rent_type_id`, `service_type_id`) VALUES (1, 'Villa Beach Front', 25000, 10000000, 10, 'vip', 'Có hồ bơi', 500, 4, '3', '1');
INSERT INTO `case_study_module_3_db_servlet`.`service` (`service_id`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`, `rent_type_id`, `service_type_id`) VALUES (2, 'House Princess 01', 14000, 5000000, 7, 'vip', 'Có thêm bếp nướng', null, 3, '2', '2');
INSERT INTO `case_study_module_3_db_servlet`.`service` (`service_id`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`, `rent_type_id`, `service_type_id`) VALUES (3, 'Room Twin 01', 5000, 1000000, 2, 'normal', 'Có tivi', null, null, '4', '3');
INSERT INTO `case_study_module_3_db_servlet`.`service` (`service_id`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`, `rent_type_id`, `service_type_id`) VALUES (4, 'Villa No Beach Front', 22000, 9000000, 8, 'normal', 'Có hồ bơi', 300, 3, '3', '1');
INSERT INTO `case_study_module_3_db_servlet`.`service` (`service_id`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`, `rent_type_id`, `service_type_id`) VALUES (5, 'House Princess 02', 10000, 4000000, 5, 'normal', 'Có thêm bếp nướng', null,2, '3', '2');
INSERT INTO `case_study_module_3_db_servlet`.`service` (`service_id`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`, `rent_type_id`, `service_type_id`) VALUES (6, 'Room Twin 02', 3000, 900000, 2, 'normal', 'Có tivi', null, null, '4', '3');




SELECT * FROM employee WHERE employee_name LIKE concat( "%","An","%");
SELECT * FROM customer WHERE customer_name LIKE concat("%","Pham","%");
SELECT * FROM product WHERE price LIKE concat("%",?,"%");
