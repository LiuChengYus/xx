package com.accp.v.service.vehicle.client.api;
import com.accp.v.service.vehicle.core.model.Dictionary;
import com.accp.v.service.vehicle.core.model.Modelmanagement;
import com.accp.v.service.vehicle.core.util.PageUtil;

import java.util.List;

public interface ModelManagementService {



	/**
	 *All data
	 * @return
	 * @throws Exception
	 */
    public List<Modelmanagement> getModelmanagementAll() throws Exception;

	/**
	 * 分页
	 */
	public PageUtil getModelmanagementPageUtil(int pageIndex, int pageSize, String... args);




}
