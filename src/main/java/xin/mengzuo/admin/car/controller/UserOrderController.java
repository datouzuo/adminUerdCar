package xin.mengzuo.admin.car.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.mengzuo.admin.car.config.UsedCarResult;
import xin.mengzuo.admin.car.service.OrderService;

@RequestMapping("/order")
@RestController
public class UserOrderController {
     @Autowired	
     private OrderService os;
	 @RequestMapping("/applyOrder")
	 public UsedCarResult applyOrder(Integer id) throws IOException{
		 return os.applyOrder(id);
	 }
	 @RequestMapping("/findByStatus")
	  public UsedCarResult findByStatus(Integer status) throws IOException{
		  return os.findByStatus(status);
	  }
	
	
}
