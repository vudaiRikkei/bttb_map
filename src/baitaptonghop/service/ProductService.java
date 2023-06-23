package baitaptonghop.service;

import baitaptonghop.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductService implements IBaseService<Product> {

    public boolean deleteProduct (int id ,List<Product> products){
        if (findById(products, id) == null){
            return false;
        }else {
            for (Product product: products) {
                if (product.getId() == id){
                    products.remove(product);
             return  true;
                }
            }
        }
        return false;
    }
    @Override
    public Map<String, Integer> atributeWithPrd(List<Product> colors, List<Product> products) {
        return null;
    }

    @Override
    public boolean save(List<Product> products, Product product) {
        return IBaseService.super.save(products, product);
    }

    @Override
    public Product findById(List<Product> products, int id) {
        return IBaseService.super.findById(products, id);
    }

    @Override
    public boolean deleteById(List<Product> products, int id, List<Product> products2) {
        return false;
    }

    @Override
    public boolean checkProduct(Product element, List<Product> products) {
        return IBaseService.super.checkProduct(element, products);
    }

    @Override
    public Integer idAutoIncrement(List<Product> products) {
        return IBaseService.super.idAutoIncrement(products);
    }
}
