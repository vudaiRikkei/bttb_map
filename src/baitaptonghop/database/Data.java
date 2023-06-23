package baitaptonghop.database;

import baitaptonghop.model.Brand;
import baitaptonghop.model.Category;
import baitaptonghop.model.Color;
import baitaptonghop.model.Product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Data {

    public static final List<Color> color = new ArrayList<>();

    public static final List<Category> category_data = new ArrayList<>();

    public static final List<Brand> brand_data = new ArrayList<>();

    public static final List<Product> product_data = new ArrayList<>();

    static {
        color.add(new Color(1,"xanh"));
        color.add(new Color(2,"đỏ"));
        color.add(new Color(3,"tím "));
        color.add(new Color(4,"vàng"));

        category_data.add(new Category(1, "category 1"));
        category_data.add(new Category(2, "category 2"));
        category_data.add(new Category(3, "category 3"));
        category_data.add(new Category(4, "category 4"));

        brand_data.add(new Brand(1,"Brand 1"));
        brand_data.add(new Brand(2,"Brand 2"));
        brand_data.add(new Brand(3,"Brand 3"));
        brand_data.add(new Brand(4,"Brand 4"));

    }

}
