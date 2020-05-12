import { ProductInOrder } from "./ProductInOrder";

export class ProductInfo {
    productId: string;
    productName: string;
    productPrice: number;
    productStock: number;
    productDescription: string;
    productIcon: string;
    productStatus: number; // 0: onsale 1: offsale
    categoryType: number;
    createTime: string;
    updateTime: string;


    constructor(productInOrder?: ProductInOrder) {
        if (productInOrder) {
            this.productId = productInOrder.productId;
            this.productName = productInOrder.productName;
            this.productPrice = productInOrder.productPrice;
            this.productStock = productInOrder.productStock;
            this.productDescription = productInOrder.productDescription;
            this.productIcon = productInOrder.productIcon;
            this.categoryType = productInOrder.categoryType;
            this.productStatus = 0;
        } else {
            this.productId = 'B0002';
            this.productName = 'iPhone SE';
            this.productPrice = 3799.00;
            this.productStock = 100;
            this.productDescription = 'Apple iPhone SE Pro 64GB';
            this.productIcon = 'https://img13.360buyimg.com/n7/jfs/t1/88934/29/18809/159677/5e973b24E90fcddfc/bb5874532c7633ab.jpg';
            this.categoryType = 0;
            this.productStatus = 0;
        }
    }
}

