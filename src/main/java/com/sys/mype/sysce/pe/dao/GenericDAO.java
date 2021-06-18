package com.sys.mype.sysce.pe.dao;

import java.util.List;
import java.util.Optional;

import com.sys.mype.sysce.pe.model.BModuleScreen;

public interface GenericDAO {
	public List<BModuleScreen> findByModuleScreenUser(String userId, String state);
	public Optional<String> GeneratedProductId(int subsidiaryId);
}
