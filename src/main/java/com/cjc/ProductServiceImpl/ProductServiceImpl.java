package com.cjc.ProductServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.ProductModel.Product;
import com.cjc.ProductRepositiory.ProductRepositiory;
import com.cjc.ProductService.ProductService;
import com.cjc.xml.PtroductXml;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepositiory prorepo;

	@Override
	public Product addproducts(Product pro) {
		prorepo.save(pro);
		return null;
	}

	@Override
	public Product getproduct(Integer id) {
		
		if(prorepo.existsById(id)) {
		    Product getpro=prorepo.findById(id).get();
		    return getpro;
		
		}
		return null;
	}

	@Override
	public Product updateproducts(Integer id, Product pro) {
		if(prorepo.existsById(id)) {
			Product product = prorepo.findById(id).get();
			
			product.setPname(pro.getPname());
			product.setPprice(pro.getPprice());
			product.setPdate(pro.getPdate());
			
			return prorepo.save(product);
		}
		return null;
	}

	@Override
	public Product editproduct(Integer id, Product pro) {
		if(prorepo.existsById(id)) {
			Product product = prorepo.findById(id).get();
			
			if(pro.getPname()!=null) {
				
				product.setPname(pro.getPname());
			}
			if(pro.getPdate()!=null) {
				product.setPdate(pro.getPdate());
			}
			if(pro.getPprice()!=null){
				product.setPprice(pro.getPprice());
			}
			Product pr=prorepo.save(product);
			return pr;
		}
		return null;
	}

	@Override
	public List<Product> getallproducts() {
		List<Product> all = prorepo.findAll();
		return all;
	}

	@Override
	public String deleteproduct(Integer id) {

		String msg="";
		if(prorepo.existsById(id)) {
			prorepo.deleteById(id);
			msg="Delete Product Successfully..!"+id;
			return msg;
			
			
		}
		return "ID Not found"+id;
	}

	@Override
	public List<Product> getprodutsxml() {
	    List<Product> findAll = prorepo.findAll(); 
		return findAll;
	}

}
