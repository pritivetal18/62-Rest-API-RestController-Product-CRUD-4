package com.cjc.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.cjc.ProductModel.Product;

@XmlRootElement
public class PtroductXml {
	private List<Product> prodictlist;

	public List<Product> getProdictlist() {
		return prodictlist;
	}

	public void setProdictlist(List<Product> prodictlist) {
		this.prodictlist = prodictlist;
	}
	

}
