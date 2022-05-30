create database QuanLyDonHang;
use QuanLyDonHang;

create table NhaCC(
MaNCC int not null primary key,
tenNCC varchar(50),
DiaChi varchar(50)

);
create table SDT(
MaNCC int not null primary key,
SDT varchar(50),
foreign key(MaNCC) references NhaCC(MaNCC)
);

create table DonDH(
soDH int not null primary key,
ngayDH date,
MaNCC int,
foreign key (MaNCC) references NhaCC(MaNCC)
);

create table VatTu(
MaVTu int not null primary key,
tenVTu varchar(50)

);

create table ChiTietDH(
SoDH int not null,
MaVTu int not null,
primary key(soDH,MaVTu),
foreign key(SoDH) references DonDH(SoDH),
foreign key(MaVTu) references VatTu(MaVTu)
);

create table PhieuXuat(
SoPX int not null primary key,
NgayXuat date

);

create table ChiTietPhieuXuat(
SoPX int not null,
MaVTu int not null,
DGXuat int not null,
SLXuat int not null,
primary key(SoPX,MaVTu),
foreign key(SoPX) references PhieuXuat(SoPX),
foreign key(MaVTu) references VatTu(MaVTu)
);

create table PhieuNhap(
SoPN int not null primary key,
NgayNhap date not null

);

create table ChiTietPhieuNhap(
SoPN int not null,
MaVTu int not null,
DGNhap int not null,
SLNhap int not null,
primary key(SoPN,MaVTu),
foreign key(SoPN) references PhieuNhap(SoPN),
foreign key(MaVTu) references VatTu(MaVTu)

);