package com.infodev.emart.emart.serviceimpl;

import com.infodev.emart.emart.model.Subcategory;
import com.infodev.emart.emart.repo.SubcategoryRepo;
import com.infodev.emart.emart.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubcategoryServiceImpl implements SubcategoryService {
    @Autowired
    private SubcategoryRepo subcategoryRepo;

    @Override
    public Subcategory saveSubcategory(Subcategory subcategory) {
        return subcategoryRepo.save(subcategory);
    }

    @Override
    public List<Subcategory> saveSubcategories(List<Subcategory> subcategories) {
        return subcategoryRepo.saveAll(subcategories);
    }

    @Override
    public List<Subcategory> getSubcategories() {
        return subcategoryRepo.findAll();
    }

    @Override
    public Subcategory getSubcategoryById(Integer id) {
        return subcategoryRepo.getOne(id);
    }

    @Override
    public Subcategory updateSubcategory(Subcategory subcategory) {
        Subcategory oldSubcategory = subcategoryRepo.getOne(subcategory.getSubCategoryId());
        oldSubcategory.setSubCategoryName(subcategory.getSubCategoryName());
        return subcategoryRepo.save(oldSubcategory);
    }

    @Override
    public void deleteSubcategoryById(Integer id) {
        subcategoryRepo.deleteById(id);
    }
}
