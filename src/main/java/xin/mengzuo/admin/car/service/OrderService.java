package xin.mengzuo.admin.car.service;

import xin.mengzuo.admin.car.config.UsedCarResult;

public interface OrderService {
  
  UsedCarResult applyOrder(Integer id);
  UsedCarResult findByStatus(Integer status);
}
