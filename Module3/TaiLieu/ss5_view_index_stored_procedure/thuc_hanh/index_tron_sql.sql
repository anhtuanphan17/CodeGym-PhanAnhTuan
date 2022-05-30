
SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.'; 
explain SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.';

alter table customers add index idx_customers (customername); 

EXPLAIN SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.'; 

alter table customers add index idx_full_name (contactFirstName, contactLastName);
EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';