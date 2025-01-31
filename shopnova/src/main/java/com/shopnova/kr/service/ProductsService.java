package com.shopnova.kr.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopnova.kr.domain.Products;
import com.shopnova.kr.domain.ProductsStatus;
import com.shopnova.kr.repository.ProductsRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductsService {

    private final ProductsRepository productsRepository;

    // 상품 저장
    public Long saveProduct(Products product) {
        productsRepository.save(product);
        return product.getId();
    }

    // 특정 상품 조회
    @Transactional(readOnly = true)
    public Products findProductById(Long id) {
        return productsRepository.findOne(id);
    }

    // 전체 상품 조회
    @Transactional(readOnly = true)
    public List<Products> findAllProducts() {
        return productsRepository.findAll();
    }

    // 이름으로 상품 검색
    @Transactional(readOnly = true)
    public List<Products> findProductsByName(String name) {
        return productsRepository.findByName(name);
    }

    // 상태별 상품 검색
    @Transactional(readOnly = true)
    public List<Products> findProductsByStatus(ProductsStatus status) {
        return productsRepository.findByStatus(status);
    }

    // 페이징 처리된 상품 조회
    @Transactional(readOnly = true)
    public List<Products> findProductsWithPaging(int offset, int limit) {
        return productsRepository.findAllWithPaging(offset, limit);
    }

    // 가격 정렬된 상품 조회
    @Transactional(readOnly = true)
    public List<Products> findProductsSortedByPrice(boolean ascending) {
        return productsRepository.findAllSortedByPrice(ascending);
    }

    // 상품 삭제
    public void deleteProduct(Long id) {
        Products product = productsRepository.findOne(id);
        if (product != null) {
            productsRepository.delete(product);
        } else {
            throw new IllegalArgumentException("Product with ID " + id + " not found");
        }
    }
    
    // 카테고리별 상품 조회
    public List<Products> findProductsByCategory(String category) {
        List<Products> products = productsRepository.findByCategory(category);
        System.out.println("조회된 상품: " + products); // 디버깅
        return products;
    }


    // 상품 수정
    public Products updateProduct(Long id, Products updatedProduct) {
        Products existingProduct = productsRepository.findOne(id);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setDiscountPrice(updatedProduct.getDiscountPrice());
            existingProduct.setShippingCost(updatedProduct.getShippingCost());
            existingProduct.setStatus(updatedProduct.getStatus());
            return productsRepository.update(existingProduct);
        } else {
            throw new IllegalArgumentException("Product with ID " + id + " not found");
        }
    }
    
 // ✅ 장바구니 상품 조회
    public List<Products> getCartItems() {
        return productsRepository.getCartItems();
    }

    // ✅ 특정 상품을 장바구니에 추가
    public void addToCart(Long productId) {
        Products product = productsRepository.findOne(productId);
        if (product != null) {
            product.setInCart(true);
            productsRepository.update(product);
        }
    }

    // ✅ 특정 상품을 장바구니에서 제거
    public void removeFromCart(Long productId) {
        Products product = productsRepository.findOne(productId);
        if (product != null) {
            product.setInCart(false);
            productsRepository.update(product);
        }
    }
}
