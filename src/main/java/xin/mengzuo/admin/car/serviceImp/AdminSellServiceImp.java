package xin.mengzuo.admin.car.serviceImp;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xin.mengzuo.admin.car.config.ApplStuts;
import xin.mengzuo.admin.car.config.UsedCarResult;
import xin.mengzuo.admin.car.dao.SellCarDao;
import xin.mengzuo.admin.car.pojo.Car;
import xin.mengzuo.admin.car.pojo.CarCount;
import xin.mengzuo.admin.car.service.AdminSellApplyService;
@Service
@Transactional
public class AdminSellServiceImp implements AdminSellApplyService{
    @Autowired
	private SellCarDao scd;
	@Override
	public UsedCarResult findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsedCarResult findByStatus(Integer status) {
		List<Car> list = null;
		if(status==4) {
			 list = scd.findAll();
			
		}else {
		list = scd.findByStatus(status);
		}
		return UsedCarResult.ok(list);
	}

	@Override
	public UsedCarResult updataApply(Integer id) {
		Optional<Car> findById = scd.findById(id);
		if(findById.get().getStatus()==3)
			return UsedCarResult.build(400, "该申请已取消，请刷新获取最新动态");
		
		findById.get().setStatus(ApplStuts.APPIY);
		return UsedCarResult.ok();
	}

	@Override
	public UsedCarResult collectCar(String carId, Integer usrId) {
		
		return null;
	}

	@Override
	public UsedCarResult count() {
		List carCount = scd.carCount();
		List<CarCount> list = new LinkedList<CarCount>();
		 for(Object row: carCount)
		 { 
			 Object[] cells = (Object[]) row;
			 CarCount car = new CarCount();
			 car.setCount(Integer.parseInt(cells[1].toString()));
			 car.setStatus(cells[0].toString());
			 list.add(car);
		 }
		return UsedCarResult.ok(list);
	}
	
	

}
