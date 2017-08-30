package com.ghiurutan.springdemo.data;

import com.ghiurutan.springdemo.models.Cheese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by AlexandruGh on 8/29/2017.
 */
@Repository
@Transactional
public interface CheeseDAO extends CrudRepository<Cheese, Integer> {
}
