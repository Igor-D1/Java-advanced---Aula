package br.com.fiap._tdspa.javaadv.blogBackend.datasource.repositories;

import br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities.Order;

import java.util.List;

public interface OrderRepositoryCustom {
    List<Order> findByTotalQuantityGreaterThanQueryDsl(Integer quantity);
    List<Order> findByTotalQuantityGreaterThanCriteria(Integer quantity);
}
