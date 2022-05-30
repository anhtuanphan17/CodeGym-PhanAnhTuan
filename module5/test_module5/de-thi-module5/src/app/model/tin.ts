import {DanhMuc} from './danh-muc';

export interface Tin {
  id: number;
  vungMien: number;
  daiDien: string;
  loaiBaiViet: string;
  tinhTrang: string;
  diaChi: string;
  dienTich: number;
  huong: string;
  tuaDe: string;
  noiDung: string;
  gia: number;
  ngayDang: string;
  trangThai: string;
  danhMuc: DanhMuc;

}

