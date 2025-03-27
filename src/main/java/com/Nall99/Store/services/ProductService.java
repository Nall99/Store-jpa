package com.Nall99.Store.services;

import com.Nall99.Store.models.CategoryModel;
import com.Nall99.Store.models.ProductModel;
import com.Nall99.Store.models.SupplierModel;
import com.Nall99.Store.repositories.CategoryRepository;
import com.Nall99.Store.repositories.ProductRepository;
import com.Nall99.Store.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    public String save(ProductModel product){
        this.categoryAndSupplier(product);

        this.productRepository.save(product);
        return "Produto salvo com sucesso!";
    }

    public String delete(long id){

        Optional<ProductModel> product = this.productRepository.findById(id);
        if(product.isPresent()){
            this.productRepository.delete(product.get());
            return "Produto deletado com sucesso!";
        }else{
            return "Problema ao deletar o produto, tente novamente mais tarde";
        }
    }

    public String update(long id, ProductModel product){

        if (this.productRepository.findById(id).isPresent()){
            this.categoryAndSupplier(product);
            product.setId(id);
            this.productRepository.save(product);
            return "Produto atualizado com sucesso";
        }else{
            return "Problema ao atualizar o produto, tente novamente mais tarde";
        }
    }

    public List<ProductModel> findAll(){
        return this.productRepository.findAll();
    }

    public ProductModel findById(Long id){
        Optional<ProductModel> product = this.productRepository.findById(id);
        return product.orElse(null);
    }

    public List<ProductModel> findByCategory(long category_id){
        CategoryModel category = new CategoryModel();
        category.setId(category_id);
        return this.productRepository.findByCategory(category);
    }

    private void categoryAndSupplier(ProductModel product){
        CategoryModel categoryExist = this.categoryRepository.findByName(product.getCategory().getName());
        SupplierModel supplierExist = this.supplierRepository.findByName(product.getSupplier().getName());

        if (categoryExist != null){
            product.setCategory(categoryExist);
        }else{
            this.categoryRepository.save(product.getCategory());
        }

        if (supplierExist != null){
            product.setSupplier(supplierExist);
        }else{
            this.supplierRepository.save(product.getSupplier());
        }
    }
}
