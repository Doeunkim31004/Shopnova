package com.shopnova.kr.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopnova.kr.domain.Products;
import com.shopnova.kr.service.ProductsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    // 상품 목록 페이지
    @GetMapping("/home")
    public String listProducts(Model model) {
        List<Products> products = productsService.findAllProducts();
        model.addAttribute("products", products);
        return "home"; // templates/products.html로 렌더링
    }
    
 // 전자제품 페이지
    @GetMapping("/electronics")
    public String electronicsProducts(Model model) {
    	String category = "전자제품";
        List<Products> products = productsService.findProductsByCategory("전자제품");
        System.out.println(products);
        model.addAttribute("products", products);
        return "electronics"; // templates/electronics.html
    }


    // 의류 페이지
    @GetMapping("/clothing")
    public String clothingPage(Model model) {
    	String category = "의류";
    	List<Products> products = productsService.findProductsByCategory("의류");
    	System.out.println(products);
        model.addAttribute("products", products);
        return "clothing"; // src/main/resources/static/clothing.html로 연결
    }

    // 식품 페이지
    @GetMapping("/food")
    public String foodPage(Model model) {
    	String category = "식품";
    	List<Products> products = productsService.findProductsByCategory("식품");
    	System.out.println(products);
        model.addAttribute("products", products);
        return "food"; // src/main/resources/static/food.html로 연결
    }

    // 화장품 페이지
    @GetMapping("/beauty")
    public String beautyPage(Model model) {
    	String category = "화장품";
    	List<Products> products = productsService.findProductsByCategory("화장품");
    	System.out.println(products);
        model.addAttribute("products", products);
        return "beauty"; // src/main/resources/static/beauty.html로 연결
    }

    // 스포츠 페이지
    @GetMapping("/sports")
    public String sportsPage(Model model) {
    	String category = "스포츠";
    	List<Products> products = productsService.findProductsByCategory("스포츠");
    	System.out.println(products);
        model.addAttribute("products", products);
        return "sports"; // src/main/resources/static/sports.html로 연결
    }
    
    @GetMapping("/product")
    public String getProductDetail(@RequestParam("id") Long id, Model model) {
        Products product = productsService.findProductById(id);
        if (product == null) {
            return "error/404"; // 404 페이지로 이동
        }
        model.addAttribute("product", product);
        return "product";
    }
    
    // ✅ 장바구니 페이지
    @GetMapping("/cart")
    public String viewCart(Model model) {
        List<Products> cartItems = productsService.getCartItems();
        model.addAttribute("cartItems", cartItems);
        return "cart"; // templates/cart.html
    }

    // ✅ 장바구니에 상품 추가
    @GetMapping("/cart/add")
    public String addToCart(@RequestParam("id") Long productId) {
        productsService.addToCart(productId);
        return "redirect:/cart"; // 장바구니 페이지로 이동
    }

    // ✅ 장바구니에서 상품 제거
    @GetMapping("/cart/remove")
    public String removeFromCart(@RequestParam("id") Long productId) {
        productsService.removeFromCart(productId);
        return "redirect:/cart"; // 장바구니 페이지로 이동
    }
}

