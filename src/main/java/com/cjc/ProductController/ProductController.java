package com.cjc.ProductController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.ProductModel.Product;
import com.cjc.ProductService.ProductService;
import com.cjc.xml.PtroductXml;

@RestController
public class ProductController {
	@Autowired
	private ProductService proser;
	
	@PostMapping(value = "/addproduct", produces = {"application/xml", "application/json"}, consumes = {"application/xml", "application/json"})
	public Product addproduct(@RequestBody Product pr) {
		Product addproducts = proser.addproducts(pr);
		return addproducts;
	}
	
	@GetMapping(value = "/getallproducts", produces = { "application/json"}, consumes = {"application/json"})
	public List<Product> getallproduct() {
		
		List<Product> getallproducts = proser.getallproducts();
		return getallproducts;
		
	}
	@GetMapping(value = "/getproductxml", produces = {"application/xml","application/json"}, consumes = {"application/xml","application/json"})
	public PtroductXml getxmlproduct(){
		List<Product> getprodutsxml = proser.getprodutsxml();
		PtroductXml px=new PtroductXml();
		px.setProdictlist(getprodutsxml);
		return px;
	}
	
	@GetMapping(value = "/getproduct/{id}", produces = {"application/xml", "application/json"}, consumes = {"application/xml", "application/json"})
	public Product getsingalproduct(@PathVariable int id ) {
		
		Product getproduct = proser.getproduct(id);
		return getproduct;
	}
	
	@PutMapping(value = "/updateproduct/{id}", produces = {"application/xml", "application/json"}, consumes = {"application/xml", "application/json"})
	public Product updateproduct(@PathVariable int id, @RequestBody Product pro) {
		
		Product updateproduct = proser.updateproducts(id, pro);
		return updateproduct;
	}
	
	@PatchMapping(value = "/editproduct/{id}", consumes = {"application/xml", "application/json"}, produces = {"application/xml", "application/json"})
	public Product editproduct(@PathVariable int id, @RequestBody Product pro) {
		Product editproduct = proser.editproduct(id, pro);
		return editproduct;
	}
	
	@DeleteMapping(value = "/deleteproduct/{id}")
	public String deleteproduct(@PathVariable int id) {
		return proser.deleteproduct(id);
		
	}


}
