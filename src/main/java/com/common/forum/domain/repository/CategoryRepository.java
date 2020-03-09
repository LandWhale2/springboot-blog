package com.common.forum.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.common.forum.domain.entity.Category;



public interface CategoryRepository extends JpaRepository<Category, Long> {
}
