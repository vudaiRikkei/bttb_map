package baitaptonghop.service;

import baitaptonghop.database.Data;
import baitaptonghop.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CateService {
    List<Category> list=   Data.category_data;

    public List<Category> getList() {
        return list;
    }
    public void save(Category newCategory){

        if(finbyid(newCategory.getId())==null){
            list.add(newCategory);
            System.out.println("thêm mới thành công");
        }else {
            for (int i = 0; i < list.size() ; i++) {
                if(newCategory.getId()==list.get(i).getId()){
                    list.set(i,newCategory);
                    System.out.println("sửa thành công");
                    break;
                }
            }
        }
    }
    public Category finbyid(int id){
        for (Category element : list) {
            if (element.getId() == id) {
                return element;
            }
        }
        return null;
    }
    public boolean delcategory(int id){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId()==id){
                list.remove(i);
                return true;
            }

        }
        return false;
    }
    public int idmax(){
        int idMax = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() > idMax) {
                idMax = list.get(i).getId();
            }
        }
        return idMax + 1;
    }
    }
