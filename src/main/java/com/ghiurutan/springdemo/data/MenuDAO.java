package com.ghiurutan.springdemo.data;

import com.ghiurutan.springdemo.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by AlexandruGh on 8/30/2017.
 */
@Repository
@Transactional
public interface MenuDAO extends JpaRepository<Menu, Integer> {
}
