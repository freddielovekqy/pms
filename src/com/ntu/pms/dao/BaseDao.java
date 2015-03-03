package com.ntu.pms.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface BaseDao<T, K> {

    public Boolean add(T obj);

    public Boolean delete(K id);

    public Boolean update(T obj);

    public T getById(K id);

}
