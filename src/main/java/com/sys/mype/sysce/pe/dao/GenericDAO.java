package com.sys.mype.sysce.pe.dao;

import java.util.List;
import java.util.Optional;

import com.sys.mype.sysce.pe.model.BConsumer;
import com.sys.mype.sysce.pe.model.BModuleScreen;

public interface GenericDAO {
	public List<BModuleScreen> findByModuleScreenUser(String userId, String state);
	public Optional<String> GeneratedProductId(int subCategory);
	public Optional<String> GeneratedConsumerId(int subsidiaryId);
	public Optional<String> GeneratedOrderId(int subsidiaryId);
	public Optional<String> GeneratedOrderDetailId(int subsidiaryId);
	public List<BConsumer> findConsumerByKeyWord(String key_word);
}
