package xin.mengzuo.admin.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.mengzuo.admin.car.config.UsedCarResult;
import xin.mengzuo.admin.car.service.AdminSellApplyService;

@RestController
@RequestMapping("/admin")
public class AdminSellApplyController {
	@Autowired
	private AdminSellApplyService asell;
	/**
	 * 传入申请单状态，0 表示未处理，1 表示已处理，3未取消，4未全部 
	 * @param status
	 * @return
	 */
	@RequestMapping("/findByStatus")
	public UsedCarResult findApllyBystutas(Integer status) {
		return asell.findByStatus(status);
	}
	/**
	 * 传入申请单id 将申请单改为已处理
	 * @param id
	 * @return
	 */
	@RequestMapping("/updataApply")
	public UsedCarResult updataAplly(Integer id){
		return asell.updataApply(id);
	}
	@RequestMapping("/count")
	public UsedCarResult count(Integer count) {
		return asell.count();
	}


}
