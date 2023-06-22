package baitaptonghop.service;

import baitaptonghop.model.Brand;
import baitaptonghop.model.Color;
import baitaptonghop.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrandService implements IBaseService<Brand> {

    @Override
    public Map<String, Integer> atributeWithPrd(List<Brand> colors, List<Product> products) {
        Map<String, Integer> map = new HashMap<>();
        for (Brand color: colors) {
            map.put(color.getBrandName(), 0);
        }

//        for (Product product: products) {
//            String key = product.getBrand().getBrandName();
//            int value = map.get(key) + 1;
//            map.put(key, value);
//        }
        for (Map.Entry<String,Integer> entry: map.entrySet()) {
            for (Product p:products) {
                if(entry.getKey().equals(p.getBrand().getBrandName())) {
                    entry.setValue(entry.getValue() + 1);
                }
            }
        }
        return map;
    }

    @Override
    public boolean save(List<Brand> brands, Brand brand) {
        return IBaseService.super.save(brands, brand);
    }

    @Override
    public Brand findById(List<Brand> brands, int id) {
        return IBaseService.super.findById(brands, id);
    }

    @Override
    public boolean deleteById(List<Brand> brands, int id,List<Product> products) {
        return IBaseService.super.deleteById(brands, id,products);
    }

    @Override
    public Integer idAutoIncrement(List<Brand> brands) {
        return IBaseService.super.idAutoIncrement(brands);
    }
}
