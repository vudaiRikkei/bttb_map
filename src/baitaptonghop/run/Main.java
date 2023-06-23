package baitaptonghop.run;

import baitaptonghop.config.Config;

public class Main {
    public static void main(String[] args) {

      int choice ;
        while (true){
            System.out.println("===================MENU===================");
            System.out.println("1. Quản lý sản phẩm: ");
            System.out.println("2. Quản lý mau`: ");
            System.out.println("3. Quản lý hãng: ");
            System.out.println("4. Quản lý loại sản phẩm: ");
            System.out.println("5: Exit: ");
            System.out.println("CHỌN 1 - 5 ĐI KU");
            choice = Config.getInteger();
            switch (choice){
                case 1:
                   new ProductManagement();
                   break;
                case 2:
                    new ColorManagement();
                    break;
                case 3:
                    new BrandManagement();
                    break;
                case 4:
                    new CategoryManagement();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Nhập lại đi ku");

            }
        }
    }
}
