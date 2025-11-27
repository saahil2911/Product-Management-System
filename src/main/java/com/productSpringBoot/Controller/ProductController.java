package com.productSpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.productSpringBoot.Entity.ProductInfo;
import com.productSpringBoot.Service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService prodSe;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	// Retrieve All Data From DataBase...
	@GetMapping("/list")
	public String showList(Model model, @Param("keyword") String keyword) {
		List<ProductInfo> listProduct = prodSe.search(keyword);
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("keyword", keyword);
		return "list";
	}

	// Save Entity Class Object To Add Form..
	@GetMapping("/add")
	public String saveObject(Model model) {
		model.addAttribute("product", new ProductInfo());
		return "add";
	}

	// Retrieve All Data To DataBase...
	@PostMapping("/list")
	public String saveData(ProductInfo product) {
		prodSe.saveData(product);
		return "redirect:/list";
	}

	// Delete Data From DataBase
	@GetMapping("/delete/{ID}")
	public String deleteData(@PathVariable(name = "ID") int ID) {
		prodSe.deleteData(ID);
		return "redirect:/list";
	}

	// Update Data From Database...
	@GetMapping("/update/{ID}")
	public ModelAndView updateData(@PathVariable(name = "ID") int ID) {
		ModelAndView mav = new ModelAndView("update");
		ProductInfo productUpdate = prodSe.update(ID);
		mav.addObject("productUpdate", productUpdate);
		return mav;
	}
}
