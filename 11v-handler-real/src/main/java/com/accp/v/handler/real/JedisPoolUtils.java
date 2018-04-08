package com.accp.v.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;




import org.apache.log4j.Logger;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class JedisPoolUtils {

	private static Logger logger = Logger.getLogger(JedisPool.class);

	private JedisCluster jedisCluster;

	private Properties props;

	private JedisPool jedisPool;

	private Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();

	/**
	 * 初始化操作
	 */
	public void init() {
		if (props == null) {
			throw new IllegalArgumentException("参数错误,不能为空!");
		}
		String hostStr = props.getProperty("hostAndPort");
		if (null == hostStr || "".equals(hostStr))
			throw new IllegalArgumentException("参数错误,检查hostAndPort属性");
		parseHostAndPort(hostStr);
		int size = jedisClusterNodes.size();
		if (size < 1)
			throw new IllegalArgumentException("参数错误,检查hostAndPort属性");
		if (jedisClusterNodes.size() == 1) {
			Iterator<HostAndPort> iterator = jedisClusterNodes.iterator();
			HostAndPort hAndPort = iterator.next();
			jedisPool = new JedisPool(hAndPort.getHost(), hAndPort.getPort());
		} else {
			jedisCluster = new JedisCluster(jedisClusterNodes);
		}
	}

	/**
	 * 获得redisCluster对象
	 * 
	 */
	public JedisCluster getCluster() {
		return jedisCluster;
	}

	/**
	 * 获得jedis对象
	 * 
	 */
	public Jedis getJedis() {
		return jedisPool.getResource();
	}

	public void returnJedis(Jedis jedis) {
		jedisPool.returnResource(jedis);
	}

	public void returnJedisCluster(JedisCluster jedisCluster) {
		//try {
		//	jedisCluster.close();
		//} catch (IOException e) {
		//	logger.error("jedisCluster.close() error!");
		//}
	}

	/**
	 * 解析配置
	 * 
	 */
	public void parseHostAndPort(String hostAndPortStr) {
		String[] clusterArray = hostAndPortStr.split(",");
		for (String hostPortString : clusterArray) {
			String hostPort[] = hostPortString.split(":");
			jedisClusterNodes.add(new HostAndPort(hostPort[0], Integer
					.parseInt(hostPort[1])));
		}
	}

	/**
	 *
	 * @return the props
	 */

	public Properties getProps() {
		return props;
	}

	/**
	 *
	 * @param props
	 *            the props to set
	 */
	public void setProps(Properties props) {
		this.props = props;
	}
}
