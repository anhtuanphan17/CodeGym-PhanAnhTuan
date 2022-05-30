import {Category} from "./category";

export interface Product {
  id?: number;
  productName?: string;
  price?: number;
  quantity?: number;
  color?: string;
  category?: Category;
}
