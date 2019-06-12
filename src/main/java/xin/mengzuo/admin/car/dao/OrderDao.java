package xin.mengzuo.admin.car.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xin.mengzuo.admin.car.pojo.Userorder;


public interface OrderDao extends JpaRepository<Userorder, Integer>{
 List<Userorder> findByUserId(Integer userId);
 List<Userorder> findByStatus(Integer status);
}
