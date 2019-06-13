package xin.mengzuo.admin.car.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.mengzuo.admin.car.config.UsedCarResult;
import xin.mengzuo.admin.car.pojo.EsCar;
import xin.mengzuo.admin.car.pojo.EsMoreCar;
import xin.mengzuo.admin.car.pojo.EsUser;
import xin.mengzuo.admin.car.service.EsCarService;


@RestController
@RequestMapping("/add")
public class EsCarController {
	@Autowired
	private EsCarService addcar;
     @RequestMapping("/addUser")
	public UsedCarResult addUser(EsUser esUser) throws IOException {
	
		return addcar.addUser(esUser);
	}
@RequestMapping("/addCar")
	public UsedCarResult addCar(EsCar esCar) throws IOException {

	TimeZone zone = TimeZone.getTimeZone("Asia/Shanghai");
	Calendar cal = Calendar.getInstance(zone);
	SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	esCar.setCard_time(sim.format(cal.getTime()));
	esCar.setStatus(0);
	return addcar.addCar(esCar);
	}
@RequestMapping("/addMoreCar")
	public UsedCarResult addMoreCar(EsMoreCar esMoreCar) throws IOException {
	return addcar.addMoreCar(esMoreCar);
	}


@RequestMapping("/findCarByIdCard")
public UsedCarResult findCarByIdCar(String idCard) throws IOException {
	
	
	return addcar.findCarByIdCard(idCard);
}
@RequestMapping("/saleCarByCarId")
public UsedCarResult saleCarByCarId(String carId,Integer status) throws IOException {
	
	
	return addcar.saleCarByCarId(carId, status);
}


}
