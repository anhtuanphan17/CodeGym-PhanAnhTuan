CREATE DATABASE QuanLySinhVien;
USE QuanLySinhVien;

CREATE TABLE Class
(
    ClassID   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ClassName VARCHAR(60) NOT NULL,
    StartDate DATETIME    NOT NULL,
    Status    BIT
);

CREATE TABLE Student
(
    StudentId   INT         NOT NULL PRIMARY KEY,
    StudentName VARCHAR(30) NOT NULL,
    Address     VARCHAR(50),
    Phone       VARCHAR(20),
    Status      BIT,
    ClassId     INT         NOT NULL,
    FOREIGN KEY (ClassId) REFERENCES Class (ClassID)
);

CREATE TABLE Subject
(
    SubId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubName VARCHAR(30) NOT NULL,
    Credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( Credit >= 1 ),
    Status  BIT                  DEFAULT 1
);
CREATE TABLE Mark
(
    MarkId    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubId     INT NOT NULL,
    StudentId INT NOT NULL,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    UNIQUE (SubId, StudentId),
    FOREIGN KEY (SubId) REFERENCES Subject (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
);

insert into `Class` values(1,'A1','2008-12-20',1);
insert into `Class` values(2,'A2', '2008-12-22',1);
insert into `Class` values(3,'B3', current_date,0);

insert into Student (StudentID,StudentName, Address, Phone,`Status`,ClassID)
values(1,'Hung','Ha Noi','0912113113',1,1 );
insert into Student(StudentID,StudentName,Address, `Status`,ClassID)
values(2,'Hoa','HaiPhong',1,1);
INSERT INTO Student (StudentID,StudentName, Address, Phone, Status, ClassId)
VALUES (3,'Manh', 'HCM', '0123123123', 0, 2);

insert into `subject`(subID,SubName,Credit,`Status`)
values(1,'CF',5,1),
	(2,'C',6,1),
    (3,'HDJ',5,1),
    (4,'RDBMS',10,1);


INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
	
 SELECT * FROM Student;   
 
 select * from student
 where `status` =true; 
 
 select * from `subject`
 where credit <10;
 
 select s.studentname, s.address,c.classname from Student s
 join class c on s.classID = c.classID
 where classname = 'A1';
 SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M on S.StudentId = M.StudentId join Subject Sub on M.SubId = Sub.SubId;

 select s.studentname,m.mark,sub.subname from student s 
 join mark m on m.studentid = s.studentid join `subject`sub on m.subid = sub.subid
 where sub.subname ='CF';
 
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M on S.StudentId = M.StudentId join Subject Sub on M.SubId = Sub.SubId
WHERE Sub.SubName = 'CF';