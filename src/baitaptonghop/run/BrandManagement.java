package baitaptonghop.run;

import baitaptonghop.config.Config;
import baitaptonghop.database.Data;
import baitaptonghop.model.Brand;
import baitaptonghop.model.Color;
import baitaptonghop.model.Product;
import baitaptonghop.service.BrandService;
import baitaptonghop.service.ColorService;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class BrandManagement {
    private List<Brand> brandList = Data.brand_data;

    private BrandService brandService = new BrandService();

    private List<Product> products = Data.product_data;

    public BrandManagement() {
        int choice;
        while (true){
            show();
            System.out.println("1. thêm mới");
            System.out.println("2. sửa theo id");
            System.out.println("3. xóa");
            System.out.println("4. trở về");
            choice = Config.getInteger();
            switch (choice){
                case 1: createColor();
                    break;
                case 2: edit();
                    break;
                case 3: delete();
                    break;
                case 4:
                    return;
            }
        }
    }

     void createColor(){
        System.out.println("nhập brand: ");
        String color = Config.getString();
        Brand color1 = new Brand(color);
        boolean check = brandService.save(brandList, color1);
        if (check){
            System.out.println("lưu thành công");
        }else System.out.println("lưu thất bại");
    }

     void edit(){
        System.out.println("nhập id brand muốn sửa: ");
        int id = Config.getInteger();
        Brand color = brandService.findById(brandList, id);
        if (color == null){
            System.out.println("không tìm thấy brand này ");
        }else {
            System.out.println("nhaafp tên brand mới: ");
            String colorStr = Config.getString();
            color.setBrandName(colorStr);
            brandService.save(brandList, color);
        }
    }

     void delete(){
        System.out.println("nhập id brand muốn xóa: ");
        int id = Config.getInteger();
        boolean check = brandService.deleteById(brandList,id,products);
        if (check){
            System.out.println(" xóa thành công");
        }else System.out.println("xóa thất bại");
    }

     void show(){
        Map<String, Integer> map = brandService.atributeWithPrd(brandList, Data.product_data);
        Set<String> strings = map.keySet();
        for (String str: strings) {
            System.out.println(str + ": " + map.get(str) + " sản phẩm");
        }
    }
}
