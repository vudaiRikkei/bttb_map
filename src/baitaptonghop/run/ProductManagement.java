package baitaptonghop.run;

import baitaptonghop.config.Config;
import baitaptonghop.database.Data;
import baitaptonghop.model.Brand;
import baitaptonghop.model.Category;
import baitaptonghop.model.Color;
import baitaptonghop.model.Product;
import baitaptonghop.service.BrandService;
import baitaptonghop.service.CateService;
import baitaptonghop.service.ColorService;
import baitaptonghop.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    private static CateService cateService = new CateService();

    private static BrandService brandService = new BrandService();

    private static ColorService colorService = new ColorService();

    private static ProductService productService = new ProductService();

    private static List<Product> productList = Data.product_data;

    private static List<Category> categories = Data.category_data;

    private static  List<Color> colorList = Data.color;
    private static   List<Brand> brandList = Data.brand_data;

    public ProductManagement() {
        int choice;
        while (true) {
            getAllProduct();
            System.out.println("1. thêm mới");
            System.out.println("2. sửa theo id");
            System.out.println("3. xóa");
            System.out.println("4. trở về");
            choice = Config.getInteger();
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Nhập lại đi ku");
            }
        }

    }

    public void addProduct(){
       int id = productService.idAutoIncrement(productList);
        System.out.println("Nhập tên sản phẩm muốn thêm");
        String nameProduct = Config.getString();
        System.out.println("Nhập giá sản phẩm: ");
        double priceProduct = Config.getDouble();
        System.out.println("Nhập số lượng:");
        int quantityProduct = Config.getInteger();
        System.out.println("Chọn hãng theo ID: ");
        Brand brand = getBrand();
        System.out.println("Chọn màu cho sản phẩm: ");
        Color color = getColor();
        System.out.println("Chọn loại sản phẩm: ");
        Category category = getCategory();
        Product product = new Product(id,nameProduct,priceProduct,quantityProduct,brand,color,category);
        productList.add(product);
    }
    public  void editProduct(){
        System.out.println("nhập id màu muốn sửa: ");
        int id = Config.getInteger();
       Product product = productService.findById(productList,id);
        if (product == null){
            System.out.println("Không tìm thấy sản phẩm");
        }else {
            System.out.println("Nhập tên sản phẩm muốn sửa");
            String nameProduct = Config.getString();
            System.out.println("Nhập giá sản phẩm: ");
            double priceProduct = Config.getDouble();
            System.out.println("Nhập số lượng:");
            int quantityProduct = Config.getInteger();
            System.out.println("Chọn hãng theo ID: ");
            Brand brand = getBrand();
            System.out.println("Chọn màu cho sản phẩm: ");
            Color color = getColor();
            System.out.println("Chọn loại sản phẩm: ");
            Category category = getCategory();
            product.setPrdName(nameProduct);
            product.setPrice(priceProduct);
            product.setQuantity(quantityProduct);
            product.setBrand(brand);
            product.setColor(color);
            product.setCategory(category);
            productService.save(productList,product);
        }
    }
    public void deleteProduct(){
        System.out.println("Nhập ID sản phẩm muốn xóa");
        int id = Config.getInteger();
        productService.deleteProduct(id ,productList);
    }
    public Color getColor(){
        for (Color color:colorList) {
            System.out.println("ID " + color.getId() + "Name " + color.getColorName());
        }
        System.out.println("mẹ chọn id đi");
        int id = Config.getInteger();
        return colorService.findById(colorList,id);

    }

    public Brand getBrand(){
        for (Brand brand:brandList) {
            System.out.println("ID " + brand.getId() + "Name " + brand.getBrandName());
        }
        System.out.println("mẹ chọn id đi");
        int id = Config.getInteger();
    return brandService.findById(brandList,id);
    }
    public Category getCategory(){
        for (Category category:categories) {
            System.out.println("ID " + category.getId() + "Name " + category.getCategoryName());
        }
        System.out.println("mẹ chọn id đi");
        int id = Config.getInteger();
        return cateService.finbyid(id);
    }
    public void getAllProduct(){
        for (Product product : productList) {
            System.out.println("Products" + product);
        }
    }
}
