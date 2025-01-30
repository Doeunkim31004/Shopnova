//package com.shopnova.kr;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.shopnova.kr.domain.Products;
//import com.shopnova.kr.domain.ProductsStatus;
//import com.shopnova.kr.service.ProductsService;
//
//import lombok.RequiredArgsConstructor;
//
//@Component
//@RequiredArgsConstructor
//public class ProductsInitData implements CommandLineRunner {
//
//    private final ProductsService productsService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // 더미 데이터 생성
//        Products product1 = new Products();
//        product1.setName("세상의 마지막 기차역");
//        product1.setPrice(12600);
//        product1.setDescription("리커버 에디션");
//        product1.setDiscountPrice(new BigDecimal("14000"));
//        product1.setShippingCost(new BigDecimal("2500"));
//        product1.setStatus(ProductsStatus.AVAILABLE);
//        product1.setCreatedAt(LocalDateTime.now());
//        product1.setUpdatedAt(LocalDateTime.now());
//        product1.setImage("https://thumbnail10.coupangcdn.com/thumbnails/remote/230x230ex/image/1025_amir_coupang_oct_80k/2041/178ae269ca53df850fd7f41f7a8a66bdc56f03e6c0e56217489cefc3a092.jpg");
//        productsService.saveProduct(product1);
//
//        Products product2 = new Products();
//        product2.setName("꽃을 보듯 너를 본다");
//        product2.setPrice(9900);
//        product2.setDescription("나태주 시집");
//        product2.setShippingCost(new BigDecimal("0"));
//        product2.setStatus(ProductsStatus.AVAILABLE);
//        product2.setCreatedAt(LocalDateTime.now());
//        product2.setUpdatedAt(LocalDateTime.now());
//        product2.setImage("https://thumbnail7.coupangcdn.com/thumbnails/remote/230x230ex/image/vendor_inventory/898e/18e61a32e19308c5ddfb484ddae622abda0d8d6293359f945ac237a3479a.jpg");
//        productsService.saveProduct(product2);
//
//        Products product3 = new Products();
//        product3.setName("행복할 거야 이래도 되나 싶을 정도로");
//        product3.setPrice(16200);
//        product3.setDescription("부크럼, 일중");
//        product3.setDiscountPrice(new BigDecimal("18000"));
//        product3.setShippingCost(new BigDecimal("0"));
//        product3.setStatus(ProductsStatus.AVAILABLE);
//        product3.setCreatedAt(LocalDateTime.now());
//        product3.setUpdatedAt(LocalDateTime.now());
//        product3.setImage("https://thumbnail8.coupangcdn.com/thumbnails/remote/230x230ex/image/retail-product-api/A00077021/266416005/285027398/main/9791162145043_L.jpg");
//        productsService.saveProduct(product3);
//
//        System.out.println("더미 데이터 추가 완료");
//    }
//}
