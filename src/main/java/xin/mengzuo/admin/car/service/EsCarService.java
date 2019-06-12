package xin.mengzuo.admin.car.service;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;

import xin.mengzuo.admin.car.config.UsedCarResult;
import xin.mengzuo.admin.car.pojo.EsCar;
import xin.mengzuo.admin.car.pojo.EsMoreCar;
import xin.mengzuo.admin.car.pojo.EsUser;


public interface EsCarService {
	
	public UsedCarResult addUser(EsUser esUser)throws IOException;
	public UsedCarResult findCarByIdCard(String idCard)throws IOException;

	public UsedCarResult addCar(EsCar esCar)throws IOException;

	public UsedCarResult addMoreCar(EsMoreCar esMoreCar)throws IOException;
    
	public UsedCarResult saleCarByCarId(String idCard,Integer status) throws IOException;
	
}
