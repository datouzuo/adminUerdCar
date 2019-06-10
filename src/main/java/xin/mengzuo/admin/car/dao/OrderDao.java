package xin.mengzuo.admin.car.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xin.mengzuo.admin.car.pojo.Order;


public interface OrderDao extends JpaRepository<Order, Integer>{
 List<Order> findByUserId(Integer userId);
 List<Order> findByStatus(Integer status);
}
