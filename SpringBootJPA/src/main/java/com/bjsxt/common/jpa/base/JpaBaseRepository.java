package com.bjsxt.common.jpa.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;


@NoRepositoryBean
public interface JpaBaseRepository<T,ID extends Serializable> extends PagingAndSortingRepository<T,ID>,JpaRepository<T, ID> {

    int count(Specification<T> specification);
    
    Page<T> findAll(Specification<T> specification, Pageable pageable);
    
    List<T> findAll(Specification<T> specification);
    
}
