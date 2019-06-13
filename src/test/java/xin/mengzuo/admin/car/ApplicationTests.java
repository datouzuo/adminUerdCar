package xin.mengzuo.admin.car;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xin.mengzuo.admin.car.dao.SellCarDao;
import xin.mengzuo.admin.car.pojo.CarCount;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private SellCarDao sell;
	@Test
	public void contextLoads() {
		
		List carCount = sell.carCount();
		List<CarCount> list = new LinkedList<CarCount>();
		 for(Object row: carCount)
		 { 
			 Object[] cells = (Object[]) row;
			 CarCount car = new CarCount();
			 car.setCount(Integer.parseInt(cells[1].toString()));
			 car.setStatus(cells[0].toString());
			 list.add(car);
			 System.err.println(cells[0]);
		 }
		
			System.out.println(carCount);
		
	}

}
