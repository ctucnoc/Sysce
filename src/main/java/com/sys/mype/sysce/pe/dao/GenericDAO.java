package com.sys.mype.sysce.pe.dao;

import java.util.List;
import com.sys.mype.sysce.pe.model.BModuleScreen;

public interface GenericDAO {
	public List<BModuleScreen> findByModuleScreenUser(String userId, String state);
}
