package com.cjc.ProductService;

import java.util.List;

import com.cjc.ProductModel.Product;

public interface ProductService {
	
	Product addproducts(Product pro);
	Product getproduct( Integer id);
	Product updateproducts(Integer id, Product pro);
	Product editproduct(Integer id, Product pro);
	List<Product> getallproducts();
	List<Product> getprodutsxml();
	String deleteproduct(Integer id);

}
