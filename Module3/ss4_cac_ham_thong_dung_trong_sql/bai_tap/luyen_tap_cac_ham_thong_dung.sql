use quanlysinhvien;

select *, max(credit) from `subject`
group by `subject`.subid;

select `subject`.*, max(mark) from `subject`
left join mark on mark.subid  = `subject`.subid
group by `subject`.subid;

select student.*, avg(mark)from student
left join mark on student.studentid=mark.studentid
group by student.studentid
order by mark.mark desc;


