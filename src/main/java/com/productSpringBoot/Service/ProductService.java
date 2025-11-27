package com.productSpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.productSpringBoot.Entity.ProductInfo;
import com.productSpringBoot.Exception.DataAlreadyExistsException;
import com.productSpringBoot.Exception.NoDataFoundException;
import com.productSpringBoot.Exception.NoNullDataException;
import com.productSpringBoot.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository prodRe;

	// Retrieve All Data From DataBase...
	public List<ProductInfo> list() {
		List<ProductInfo> listProduct = prodRe.findAll();
		if (listProduct.isEmpty() || listProduct == null){
			throw new NoDataFoundException(601, "NO DATA FOUND");
		}
		return listProduct;
	}

	// Save All Data To DataBase...
	public ProductInfo saveData(ProductInfo product) {
		if (prodRe.existsByprodID(product.getProdID())) {
			throw new DataAlreadyExistsException(602, "Data Is Already Exists!!");
		} else if (product.getProdID() == 0 || product.getProdName().isEmpty() || product.getProdPrice() == 0
				|| product.getProdQty() == 0) {
			throw new NoNullDataException(603, "You Cannot Put Null Field");
		}
		return prodRe.save(product);
	}

	// Delete Data From DataBase..
	public void deleteData(int ID) {
		prodRe.deleteById(ID);
	}

	// Update Data From DataBase...
	public ProductInfo update(int ID) {
		return prodRe.findById(ID).get();
	}

	// Search Data from DataBase...
	public List<ProductInfo> search(String keyword) {
		if (keyword != null) {
			return prodRe.search(keyword);
		} else {
			return prodRe.findAll();
		}

	}
}
