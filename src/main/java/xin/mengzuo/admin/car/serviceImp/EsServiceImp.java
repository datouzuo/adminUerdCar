package xin.mengzuo.admin.car.serviceImp;

import java.io.IOException;
import java.util.UUID;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.SearchResult.Hit;
import xin.mengzuo.admin.car.config.UsedCarResult;
import xin.mengzuo.admin.car.pojo.EsCar;
import xin.mengzuo.admin.car.pojo.EsMoreCar;
import xin.mengzuo.admin.car.pojo.EsUser;
import xin.mengzuo.admin.car.pojo.EsUserToEsCar;
import xin.mengzuo.admin.car.service.EsCarService;

@Service
public class EsServiceImp implements EsCarService {
    @Autowired
	private JestClient jest;
	@Override
	public UsedCarResult addUser(EsUser esUser) throws IOException {
		UUID uuid = UUID.randomUUID();
		esUser.setId(uuid.toString());
		esUser.setCarId(uuid.toString());
		Index in = new Index.Builder(esUser).index("car").type("esuser").build();
		
			jest.execute(in);
		
		return UsedCarResult.ok(uuid);
	}

	@Override
	public UsedCarResult addCar(EsCar esCar) throws IOException {
		Index in = new Index.Builder(esCar).index("escar").type("escar").build();
			jest.execute(in);
		return UsedCarResult.ok(esCar.getCarId());
	}

	@Override
	public UsedCarResult addMoreCar(EsMoreCar esMoreCar) throws IOException {
		Index in = new Index.Builder(esMoreCar).index("esmorecar").type("esmorecar").build();
	
			jest.execute(in);
	
		
		return UsedCarResult.ok();
	}

	@Override
	public UsedCarResult findCarByIdCard(String idCard) throws IOException {

		SearchSourceBuilder search = new SearchSourceBuilder();
		 BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
		 queryBuilder.must(QueryBuilders.matchQuery("idCard", idCard));
		 search.query(queryBuilder);
		 Search se = new Search.Builder(search.toString()).addIndex("car").addType("esuser").build();
		
		 SearchResult execute = jest.execute(se);
		 Hit<EsUser,Void> firstHit = execute.getFirstHit(EsUser.class);
		 EsUser source = firstHit.source;
		 
		 SearchSourceBuilder search1 = new SearchSourceBuilder();
		 BoolQueryBuilder queryBuilder1 = QueryBuilders.boolQuery();
		 queryBuilder1.must(QueryBuilders.matchQuery("carId", source.getCarId()));
		search1.query(queryBuilder1);
		 Search se1 = new Search.Builder(search1.toString()).addIndex("escar").addType("escar").build();
		 SearchResult execute1 = jest.execute(se1);
		 Hit<EsCar, Void> firstHit1 = execute1.getFirstHit(EsCar.class);
		 EsCar source2 = firstHit1.source;
		 
		 EsUserToEsCar es = new EsUserToEsCar();
		 es.setEsuser(source);
		 es.setEscar(source2);
		return UsedCarResult.ok(es);
	}

	@Override
	public UsedCarResult saleCarByCarId(String idCard,Integer status) throws IOException {
		
		SearchSourceBuilder search = new SearchSourceBuilder();
		 BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
		 queryBuilder.must(QueryBuilders.matchQuery("carId", idCard));
		 search.query(queryBuilder);
		 Search se = new Search.Builder(search.toString()).addIndex("escar").addType("escar").build();
		 try {
			SearchResult execute = jest.execute(se);
			Hit<EsCar,Void> firstHit = execute.getFirstHit(EsCar.class);
			EsCar score = firstHit.source;
			score.setStatus(status);;
			Index in = new Index.Builder(score).index("escar").type("escar").build();
			jest.execute(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UsedCarResult.ok();
	}

	@Override
	public UsedCarResult count(Integer status) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
     
	



}
