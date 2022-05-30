
DELIMITER //

CREATE PROCEDURE findAllCustomers()

BEGIN

  SELECT * FROM customers;

END //

DELIMITER ;

call findAllCustomers();


DELIMITER //

DROP PROCEDURE IF EXISTS `findAllCustomers`//

CREATE PROCEDURE findAllCustomers()

BEGIN

SELECT * FROM customers where customerNumber = 175;

END //
DELIMITER ;


DELIMITER //
drop procedure Setcounter;
CREATE PROCEDURE SetCounter(INOUT counter INT,IN inc INT)

BEGIN
	set counter = 5;
    SET counter = counter+inc;

END//
DELIMITER ;


SET @counter =2;
call Setcounter (@counter,1); 
-- call Setcounter (@counter,1);
select @counter;


