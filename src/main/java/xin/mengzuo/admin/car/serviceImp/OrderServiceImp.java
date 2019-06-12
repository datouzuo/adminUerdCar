package xin.mengzuo.admin.car.serviceImp;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.SearchResult.Hit;
import xin.mengzuo.admin.car.config.ApplStuts;
import xin.mengzuo.admin.car.config.UsedCarResult;
import xin.mengzuo.admin.car.dao.OrderDao;
import xin.mengzuo.admin.car.pojo.EsUser;
import xin.mengzuo.admin.car.pojo.Userorder;
import xin.mengzuo.admin.car.pojo.OrderToUser;
import xin.mengzuo.admin.car.service.OrderService;

@Service
@Transactional
public class OrderServiceImp implements OrderService{
    @Autowired
	private OrderDao oDao;
    @Autowired
   	private JestClient jest;

	@Override
	public UsedCarResult applyOrder(Integer id) {
		Optional<Userorder> findById = oDao.findById(id);
		if(findById.get().getStatus()==ApplStuts.CANNEL)
			return UsedCarResult.build(400, "预约已经取消");
		
		findById.get().setStatus(ApplStuts.APPIY);
		return UsedCarResult.ok();
	}

	@Override
	public UsedCarResult findByStatus(Integer status) throws IOException {
		List<Userorder> orders;
		if(status == 4) {
			orders = oDao.findAll();
		}else {
		 orders = oDao.findByStatus(status); 
		}
		List<OrderToUser> list2= new LinkedList<OrderToUser>();
		for(Userorder order : orders) {
			OrderToUser otu = new OrderToUser();
			otu.setOrder(order);
			// 利用这个id es查找卖车人信息
			SearchSourceBuilder search = new SearchSourceBuilder();
			 BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
			 queryBuilder.must(QueryBuilders.matchQuery("carId", order.getCarId()));
			 search.query(queryBuilder);
			 Search se = new Search.Builder(search.toString()).addIndex("car").addType("esuser").build();
			 SearchResult execute = jest.execute(se);
			 Hit<EsUser,Void> firstHit = execute.getFirstHit(EsUser.class);
			 EsUser source = firstHit.source;
			 otu.setEsu(source);
			 list2.add(otu);
			
		}		
		return UsedCarResult.ok(list2);
	}

}
