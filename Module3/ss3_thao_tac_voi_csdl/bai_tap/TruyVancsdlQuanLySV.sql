use quanlysinhvien;

select * from student 
where StudentName like 'h%';

select c.classid,c.classname,c.startdate from class as c
where c.StartDate like ('%M'=12);

select sub.subid,sub.subname,sub.credit from `subject` as sub
where credit >=3 and Credit<=5;

select student.studentname, subject.SubName ,mark.Mark from student
left join mark on student.StudentId = mark.StudentId
left join `subject` on mark.SubId = subject.SubId
order by mark.mark desc,student.StudentName asc;

select * from class where month(startdate) = '12';


set sql_safe_updates = 0;
update student set classid = 2 where studentname = 'hung';
set sql_safe_updates = 1;



