use quanlybanhang;

insert into customer values
(1,'Minh Quan',10),
(2,'Ngoc Oanh',20),
(3,'Hong Ha',50);


insert into `order`(orderid,CustomerID,OrderDate) values
(1,1,'2006/03/21'),
(2,2,'2006/03/15'),
(3,1,'2006/03/25');

insert into Product
values(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);

insert into orderdetail(orderid,productid,productquantity) values 
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

select orderid,orderdate,ordertotalprice from `order`;

select customer.*, product.productname from customer
join `order` on customer.customerID = `order`.customerID
join orderdetail on `order`.orderid = orderdetail.orderid
join product on product.productid = orderdetail.productid;

select customer.customerID, customer.customerName from customer
where  customer.customerID not in (select `order`.customerID from `order`);

select `order`.orderID, `order`.orderDate, sum(product.productprice * orderdetail.productquantity) as'totalprice' from `order`
join orderdetail on `order`.orderID = orderdetail.orderID
join product on orderdetail.productID = product.productID group by customerID;



