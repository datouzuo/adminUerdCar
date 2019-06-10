package xin.mengzuo.admin.car.serviceImp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.mengzuo.admin.car.config.ApplStuts;
import xin.mengzuo.admin.car.config.UsedCarResult;
import xin.mengzuo.admin.car.dao.OrderDao;
import xin.mengzuo.admin.car.pojo.Order;
import xin.mengzuo.admin.car.pojo.OrderToUser;
import xin.mengzuo.admin.car.service.OrderService;

@Service
@Transactional
public class OrderServiceImp implements OrderService{
    @Autowired
	private OrderDao oDao;


	@Override
	public UsedCarResult applyOrder(Integer id) {
		Optional<Order> findById = oDao.findById(id);
		if(findById.get().getStatus()==ApplStuts.CANNEL)
			return UsedCarResult.build(400, "预约已经取消");
		
		findById.get().setStatus(ApplStuts.APPIY);
		return UsedCarResult.ok();
	}

	@Override
	public UsedCarResult findByStatus(Integer status) {
		List<Order> orders;
		if(status == 4) {
			orders = oDao.findAll();
		}else {
		 orders = oDao.findByStatus(status); 
		}
		
		for(Order order : orders) {
			OrderToUser otu = new OrderToUser();
			otu.setOrder(order);
			order.getCarId();// 利用这个id es查找卖车人信息
			
		}		
		return null;
	}

}
