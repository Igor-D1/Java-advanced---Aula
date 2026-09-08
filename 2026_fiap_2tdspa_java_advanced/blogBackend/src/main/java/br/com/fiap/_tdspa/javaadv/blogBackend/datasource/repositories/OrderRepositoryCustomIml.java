package br.com.fiap._tdspa.javaadv.blogBackend.datasource.repositories;

import br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities.Order;

import java.util.List;

public class OrderRepositoryCustomIml implements OrderRepositoryCustom {
    @Override
    public List<Order> findByTotalQuantityGreaterThanQueryDsl(Integer quantity){
        return List.of();
    }

    @Override
    public List<Order> findByTotalQuantityGreaterThanCriteria(Integer quantity) {
        return List.of();
    }
}
