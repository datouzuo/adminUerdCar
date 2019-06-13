package xin.mengzuo.admin.car.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import xin.mengzuo.admin.car.pojo.Car;



public interface SellCarDao extends JpaRepository<Car, Integer> {
             List<Car> findByUserId(Integer userId);
             List<Car> findByStatus(Integer status);
             @Query(value="SELECT `status`,COUNT(*) as count FROM car GROUP BY `status`",nativeQuery=true)
             List carCount();
}
