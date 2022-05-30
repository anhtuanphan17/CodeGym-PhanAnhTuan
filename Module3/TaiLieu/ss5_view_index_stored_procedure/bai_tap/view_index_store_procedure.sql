create database  bai_tap_view_index_procedure;

create table products (
id int not null auto_increment primary key,
product_code varchar(50),
product_name varchar(50),
product_price int,
product_amount int,
product_description varchar(50),
product_status varchar(50) 

);

insert into products values
(1,'001','tivi',200,201,'samsung','san co'),
(2,'002','tu lanh',400,204,'LG','san co'),
(3,'003','may giat',500,220,'Sharp','san co'),
(4,'004','dien thoai',100,205,'iphone','het hang');

insert into products (product_code,product_name,product_price) value
('005','quat',20);

create unique index product_code_idx on products(product_code);
drop index product_code_idx on products;
create index name_and_price_idx on products(product_name,product_price);

explain select * from products where product_code=3;	

explain select * from products where product_name='tivi' or product_price = 500;

create view products_view as select * from products;

select * from products_view;

drop view products_view;

create or replace view  products_view as 
select * from products
where product_price >200;
select*from products_view;

-- tao store procedure	

DELIMITER //
create procedure getAllProductInfo()
begin
select * from products;
end//
DELIMITER ;

call  getAllProductInfo();

drop procedure  addNewProduct;
DELIMITER //
create procedure addNewProduct(in product_name varchar(50), in product_price int )
begin
insert into products(product_name,product_price) value(product_name,product_price);

end//

DELIMITER ;

call addNewProduct("may lanh",200);


DELIMITER //
create procedure editProductById(in id int, in product_name varchar(50))
begin
update products 
set products.product_name = product_name
where products.id = id;

end//
DELIMITER ;

call editProductById(2,'Tivi');

DELIMITER //
create procedure removeProductById(in id int)
begin
delete  from products 
where products.id = id;

end//
DELIMITER ;

call removeProductById(1);

