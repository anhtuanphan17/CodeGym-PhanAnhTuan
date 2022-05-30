create database QuanLyBanHang;
use QuanLyBanHang;

create table Customer(
CustomerID int not null primary key,
CustomerName varchar(50) not null,
CustomerAge tinyint
);

create table `Order`(
OrderID int not null primary key,
CustomerID int not null,
OrderDate varchar(20) not null,
foreign key(CustomerID) references Customer(CustomerID)  
);

create table Product (
ProductID int not null primary key,
ProductName varchar(50) not null,
ProductPrice double
);

create table Orderdetail (
OrderID int not null,
ProductID int not null,
primary key(OrderID,productID),
ProductQuantity int not null,
OrderQuantity int,
foreign key (OrderID) references `Order`(OrderID),
foreign key(ProductID) references Product(ProductID)
);

