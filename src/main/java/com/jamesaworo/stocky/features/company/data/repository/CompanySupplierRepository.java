package com.jamesaworo.stocky.features.company.data.repository;

import com.jamesaworo.stocky.features.company.domain.entity.CompanySupplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CompanySupplierRepository extends JpaRepository<CompanySupplier, Long>, JpaSpecificationExecutor<CompanySupplier> {
	Page<CompanySupplier> findAll(Specification<CompanySupplier> specification, Pageable pageable);

	List<CompanySupplier> findAll(Specification<CompanySupplier> specification);

	@Transactional
	@Modifying
	@Query(value = "update CompanySupplier c set c.isActiveStatus = :status where c.id = :id")
	int updateIsActiveStatus(@Param(value = "status") Boolean status, @Param(value = "id") Long id);

}
