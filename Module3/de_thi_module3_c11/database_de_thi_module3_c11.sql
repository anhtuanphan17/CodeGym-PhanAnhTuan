create database de_thi_module3_c11;
use  de_thi_module3_c11;

create table hoc_sinh ( 
hoc_sinh_id   			int auto_increment not null,
ma_hoc_sinh 			varchar(45),
ten_hoc_sinh			varchar(100),
lop_hoc_sinh			varchar(100),
    primary key(hoc_sinh_id)	
);

create table sach ( 
sach_id   			int auto_increment not null,
ma_sach 			varchar(45),
ten_sach			varchar(100),
tac_gia			varchar(100),
mo_ta			varchar(100),
so_luong			int,
    primary key(sach_id)	
);

create table the_muon_sach ( 
the_muon_sach_id   			int auto_increment not null,
ma_muon_sach 			varchar(45),
sach_id			int not null,
hoc_sinh_id    int not null,
trang_thai    boolean,
ngay_muon			varchar(100),
ngay_tra			varchar(100),
    primary key(the_muon_sach_id),	
	foreign key(sach_id)  references sach(sach_id),
    foreign key(hoc_sinh_id) references hoc_sinh (hoc_sinh_id)
);

-- hoc sinh 
INSERT INTO `de_thi_module3_c11`.`hoc_sinh` (`hoc_sinh_id`, `ma_hoc_sinh`, `ten_hoc_sinh`, `lop_hoc_sinh`) VALUES ('1', 'MS-001', 'Nguyen Van A', 'C11');
INSERT INTO `de_thi_module3_c11`.`hoc_sinh` (`hoc_sinh_id`, `ma_hoc_sinh`, `ten_hoc_sinh`, `lop_hoc_sinh`) VALUES ('2', 'MS-002', 'Ngyen Van B', 'C12');
INSERT INTO `de_thi_module3_c11`.`hoc_sinh` (`hoc_sinh_id`, `ma_hoc_sinh`, `ten_hoc_sinh`, `lop_hoc_sinh`) VALUES ('3', 'Ms-003', 'Tran Van C', 'C13');


-- sach
INSERT INTO `de_thi_module3_c11`.`sach` (`sach_id`, `ma_sach`, `ten_sach`, `tac_gia`, `mo_ta`, `so_luong`) VALUES ('1', 'S-001', 'So Do', 'Vu Trong Phung', 'Xuan Toc Do', '10');
INSERT INTO `de_thi_module3_c11`.`sach` (`sach_id`, `ma_sach`, `ten_sach`, `tac_gia`, `mo_ta`, `so_luong`) VALUES ('2', 'S-002', 'Truyen Kieu', 'Nguyen Du', 'Thuy Kieu', '15');


-- the muon sach

INSERT INTO `de_thi_module3_c11`.`the_muon_sach` (`the_muon_sach_id`, `ma_muon_sach`, `sach_id`, `hoc_sinh_id`, `trang_thai`, `ngay_muon`, `ngay_tra`) VALUES ('1', 'MS-001', '1', '1', '1', '2020/10/10', '2020/11/10');
INSERT INTO `de_thi_module3_c11`.`the_muon_sach` (`the_muon_sach_id`, `ma_muon_sach`, `sach_id`, `hoc_sinh_id`, `trang_thai`, `ngay_muon`, `ngay_tra`) VALUES ('2', 'MS-002', '2', '1', '0', '2020/05/10', '2020/06/10');
INSERT INTO `de_thi_module3_c11`.`the_muon_sach` (`the_muon_sach_id`, `ma_muon_sach`, `sach_id`, `hoc_sinh_id`, `trang_thai`, `ngay_muon`, `ngay_tra`) VALUES ('3', 'MS-003', '2', '2', '0', '2020/05/10', '2020/05/12');


SELECT * FROM sach;


