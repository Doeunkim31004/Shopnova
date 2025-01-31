package com.shopnova.kr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopnova.kr.domain.Products;
import com.shopnova.kr.domain.ProductsStatus;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductsRepository{
	
	private final EntityManager em;
	
	// 저장
	public void save(Products products) {
		em.persist(products);
	}
	
	// 단건 조회
	public Products findOne(Long id) {
		return em.find(Products.class, id);
	}
	
	// 모든 상품 조회
	public List<Products> findAll() {
		return em.createQuery("select p from Products p", Products.class)
				.getResultList();
	}
	
	// 이름으로 검색
	public List<Products> findByName(String name) {
		return em.createQuery("select p from Products p where p.name = :name", Products.class)
				.setParameter("name", name)
				.getResultList();
	}
	
	// 삭제
	public void delete(Products products) {
		em.remove(products); // 수정된 부분
	}
	
	// 업데이트 (명시적)
	public Products update(Products updatedProducts) {
		return em.merge(updatedProducts);
	}
	
	// 페이징 처리
	public List<Products> findAllWithPaging(int offset, int limit) {
		return em.createQuery("select p from Products p", Products.class)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.getResultList();
	}
	
	// 상태로 검색
	public List<Products> findByStatus(ProductsStatus status) {
		return em.createQuery("select p from Products p where p.status = :status", Products.class)
				.setParameter("status", status)
				.getResultList();
	}
	
	// 가격 정렬
	public List<Products> findAllSortedByPrice(boolean ascending) {
		String order = ascending ? "ASC" : "DESC";
		return em.createQuery("select p from Products p order by p.price " + order, Products.class)
				.getResultList();
	}
	
	//상품 데이터 조회 메서드
	public List<Products> findByCategory(String category) {
	    List<Products> products = em.createQuery("SELECT p FROM Products p WHERE p.category = :category", Products.class)
	                                .setParameter("category", category)
	                                .getResultList();
	    System.out.println("Repository 결과: " + products); // 디버깅
	    return products;
	}
	public List<Products> getCartItems() {
        return em.createQuery("SELECT p FROM Products p WHERE p.inCart = true", Products.class)
                 .getResultList();
    }

}

