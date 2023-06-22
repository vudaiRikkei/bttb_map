package baitaptonghop.service;

import baitaptonghop.model.Color;
import baitaptonghop.model.Product;

import java.util.*;

public class ColorService implements IBaseService<Color> {
    @Override
    public Map<String, Integer> atributeWithPrd(List<Color> colors, List<Product> products) {
        Map<String, Integer> map = new HashMap<>();
        for (Color color: colors) {
            map.put(color.getColorName(), 0);
        }

//        for (Product product: products) {
//            String key = product.getColor().getColorName();
//            int value = map.get(key) + 1;
//            map.put(key, value);
//        }
        for (Map.Entry<String,Integer> entry: map.entrySet()) {
            for (Product p:products) {
                if(entry.getKey().equals(p.getColor().getColorName())) {
                    entry.setValue(entry.getValue() + 1);
                }
            }
        }
        return map;
    }

    @Override
    public boolean save(List<Color> colors, Color color) {
        return IBaseService.super.save(colors, color);
    }

    @Override
    public Color findById(List<Color> colors, int id) {
        return IBaseService.super.findById(colors, id);
    }

    @Override
    public boolean deleteById(List<Color> colors, int id,List<Product> products) {
        return IBaseService.super.deleteById(colors, id,products);
    }

    @Override
    public Integer idAutoIncrement(List<Color> colors) {
        return IBaseService.super.idAutoIncrement(colors);
    }
}
