package xin.mengzuo.admin.car.service;

import java.io.IOException;

import xin.mengzuo.admin.car.config.UsedCarResult;

public interface OrderService {
  
  UsedCarResult applyOrder(Integer id) throws IOException;
  UsedCarResult findByStatus(Integer status) throws IOException;
}
