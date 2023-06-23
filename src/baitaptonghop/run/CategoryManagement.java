package baitaptonghop.run;

import baitaptonghop.config.Config;
import baitaptonghop.database.Data;
import baitaptonghop.model.Brand;
import baitaptonghop.model.Category;
import baitaptonghop.model.Product;
import baitaptonghop.service.CateService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryManagement {

     CateService cateService = new CateService();

     List<Category> categories = Data.category_data;

     List<Product> products = Data.product_data;

    public CategoryManagement() {
        int choice;
        while (true) {
            hienthi();
            System.out.println("1. thêm mới");
            System.out.println("2. sửa theo id");
            System.out.println("3. xóa");
            System.out.println("4. trở về");
            System.out.println("5. hienthi");
            choice = Config.getInteger();
            switch (choice) {
                case 1:
                    themmoi();
                    break;
                case 2:
                    sua();
                    break;
                case 3:
                    xoa();
                    break;
                case 4:
                    return;
            }
        }
    }

    Map<Category, Integer> productInCategory(List<Category> categories, List<Product> products){
        Map<Category, Integer> map = new HashMap<>();
        for (Category cate: categories) {
            map.put(cate, 0);
        }
        for (Map.Entry<Category,Integer> entry: map.entrySet()) {
            for (Product p:products) {
                if(entry.getKey().getId() == p.getId()) {
                    entry.setValue(entry.getValue() + 1);
                }
            }
        }
        return map;
    }

    public void hienthi() {
        Map<Category, Integer> productInCategory = productInCategory( categories, products);
        List<Category> listcate = cateService.getList();
        for (Category c : productInCategory.keySet()) {
            System.out.println(c + " " + productInCategory.get(c));
        }
    }

    public void themmoi() {
        List<Category> listcate = cateService.getList();
        Category newcate = new Category();
        System.out.println("nhập vào tên category");
        newcate.setCategoryName(Config.getString());
        newcate.setId(cateService.idmax());
        cateService.save(newcate);
    }

    public void sua() {
        List<Category> listcate = cateService.getList();
        Category newcate = new Category();
        for (Category c : listcate
        ) {
            System.out.println(c);
        }
        System.out.println("nhap vao id cate muon sua");
        int id = Config.getInteger();
        if (cateService.finbyid(id) == null) {
            System.out.println("không tồn tại cate gury ban muon sửa");
            return;
        } else {
            System.out.println("nhập vào tên category");
            newcate.setCategoryName(Config.getString());
            newcate.setId(id);
            cateService.save(newcate);
        }
    }

    public void xoa() {
        System.out.println("nhap vao id can xoa");
        int id = Config.getInteger();
        if (cateService.delcategory(id)) {
            System.out.println("xóa thanh cong");
        } else {
            System.out.println("xoa that bai");
        }
    }
}