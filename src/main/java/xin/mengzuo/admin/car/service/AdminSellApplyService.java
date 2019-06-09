package xin.mengzuo.admin.car.service;

import xin.mengzuo.admin.car.config.UsedCarResult;

public interface AdminSellApplyService {

	UsedCarResult findAll();
	UsedCarResult findByStatus(Integer status);
    UsedCarResult updataApply(Integer id);
}
