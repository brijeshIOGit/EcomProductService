package com.bky.EcomProductService.repository;

import com.bky.EcomProductService.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRespository extends JpaRepository<Category, UUID> {
}
