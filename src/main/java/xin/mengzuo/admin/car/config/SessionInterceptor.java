package xin.mengzuo.admin.car.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.JedisCluster;
import xin.mengzuo.admin.car.pojo.User;




/**
 * 拦截器只有管理员有权限
 * @author 左利伟
 *
 */
public class SessionInterceptor implements HandlerInterceptor {

	@Autowired
	private JedisCluster cluster;
	//json操作
	@Autowired
	private ObjectMapper obJeson;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String tokenId = request.getParameter("tokenId");
		String value = cluster.get("tokenId:"+tokenId);
		if(value!=null&&value.equals("")) {
			User usr = obJeson.readValue(value, User.class);
			if(usr.getUsername().equals("admin")) {
			cluster.expire("tokenId:"+value, 1800);
			return true;
			}
		}
		return false;
	}
}
