package com.property.application.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.property.application.model.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
   Property findByIdAndActiveTrue(Long id);
   List<Property> findByPropertyNameContainingAndActiveTrue(String propertyName);
   @Query("select p from Property p where p.active=true and (p.propertyName like ?1 and p.propertyType like ?1)")
	List<Property> findByInputSearch(String search);
}
