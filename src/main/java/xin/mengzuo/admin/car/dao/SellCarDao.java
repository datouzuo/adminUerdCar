package xin.mengzuo.admin.car.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xin.mengzuo.admin.car.pojo.Car;


public interface SellCarDao extends JpaRepository<Car, Integer> {
             List<Car> findByUserId(Integer userId);
             List<Car> findByStatus(Integer status);
             
}
