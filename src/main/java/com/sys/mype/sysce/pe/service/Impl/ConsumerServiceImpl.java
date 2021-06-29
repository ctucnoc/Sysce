package com.sys.mype.sysce.pe.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.ConsumerDTO;
import com.sys.mype.sysce.pe.dto.GenericDTO;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.request.ConsumerRequestDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericClientException;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericServerException;
import com.sys.mype.sysce.pe.model.BConsumer;
import com.sys.mype.sysce.pe.model.BSubsidiary;
import com.sys.mype.sysce.pe.repository.ConsumerRepository;
import com.sys.mype.sysce.pe.repository.SubsidiaryRepository;
import com.sys.mype.sysce.pe.service.ConsumerService;
import com.sys.mype.sysce.pe.util.SysceResources;
import com.sys.mype.sysce.pe.util.Util;

@Service
@Transactional
public class ConsumerServiceImpl implements ConsumerService {

	final ConsumerRepository consumerRepository;
	final SubsidiaryRepository subsidiaryRepository;
	final Util util;

	public ConsumerServiceImpl(ConsumerRepository consumerRepository, SubsidiaryRepository subsidiaryRepository,Util util) {
		this.consumerRepository = consumerRepository;
		this.subsidiaryRepository = subsidiaryRepository;
		this.util=util;
	}

	@Override
	public HrefEntityDTO save(ConsumerRequestDTO dto) {
		if(this.consumerRepository.existsByFullNameAndStatus(dto.getName(), dto.getLastName(), SysceConstant.STATE_ACTIVE))
			throw new SysceGenericClientException("exists consumer", HttpStatus.BAD_REQUEST);
		if(!util.validateEmail(dto.getMail()))
			throw new SysceGenericClientException("mail no valid", HttpStatus.BAD_REQUEST);
		BSubsidiary bSubsidiary = this.subsidiaryRepository.findById(dto.getSubsidiaryId())
				.orElseThrow(() -> new SysceEntityNotFoundException("not found subsidiary"));
		String genericValueId=this.consumerRepository.GeneratedConsumerId(bSubsidiary.getSubsidiaryId()).orElseThrow(()->new SysceGenericServerException("error generating id"));
		BConsumer bConsumer = new BConsumer();
		bConsumer.setBSubsidiary(bSubsidiary);
		bConsumer.setConsumerId(genericValueId);
		bConsumer.setConsumerAmountVisit(SysceConstant.CANT_VISIT_INITIAL);
		bConsumer.setConsumerBirthday(dto.getBirthday());
		bConsumer.setConsumerName(dto.getName());
		bConsumer.setConsumerLastName(dto.getLastName());
		bConsumer.setConsumerMail(dto.getMail());
		bConsumer.setConsumerCell(dto.getCell());
		bConsumer.setConsumerDirection(dto.getDirection());
		bConsumer.setConsumerStatus(SysceConstant.STATE_ACTIVE);
		return Util.createHrefFromResource(this.consumerRepository.save(bConsumer).getConsumerId(), SysceResources.CONSUMER);
	}

	@Override
	public HrefEntityDTO update(ConsumerRequestDTO dto, String id) {
		BConsumer bConsumer = this.consumerRepository.findByConsumerIdAndConsumerStatus(id, SysceConstant.STATE_ACTIVE)
				.orElseThrow(() -> new SysceEntityNotFoundException("not found consumer"));
		BSubsidiary bSubsidiary = this.subsidiaryRepository.findById(dto.getSubsidiaryId())
				.orElseThrow(() -> new SysceEntityNotFoundException("not found subsidiary"));
		bConsumer.setConsumerBirthday(dto.getBirthday());
		bConsumer.setConsumerCell(dto.getCell());
		bConsumer.setConsumerDirection(dto.getDirection());
		bConsumer.setConsumerLastName(dto.getLastName());
		bConsumer.setConsumerMail(dto.getMail());
		bConsumer.setConsumerName(dto.getName());
		bConsumer.setBSubsidiary(bSubsidiary);
		this.consumerRepository.save(bConsumer);
		return Util.createHrefFromResource(bConsumer.getConsumerId(), SysceResources.CONSUMER);
	}

	@Override
	public HrefEntityDTO delete(String id) {
		BConsumer bConsumer = this.consumerRepository.findByConsumerIdAndConsumerStatus(id, SysceConstant.STATE_ACTIVE)
				.orElseThrow(() -> new SysceEntityNotFoundException("not found consumer"));
		bConsumer.setConsumerStatus(SysceConstant.STATE_ACTIVE);
		this.consumerRepository.save(bConsumer);
		return Util.createHrefFromResource(bConsumer.getConsumerId(), SysceResources.CONSUMER);
	}

	@Override
	public ConsumerDTO findById(String id) {
		BConsumer bConsumer = this.consumerRepository.findByConsumerIdAndConsumerStatus(id, SysceConstant.STATE_ACTIVE)
				.orElseThrow(() -> new SysceEntityNotFoundException("not found consumer"));
		ConsumerDTO dto = new ConsumerDTO();
		GenericDTO genericDTO = new GenericDTO();
		dto.setCell(bConsumer.getConsumerCell());
		dto.setDirection(bConsumer.getConsumerDirection());
		dto.setId(bConsumer.getConsumerId());
		dto.setLastName(bConsumer.getConsumerLastName());
		dto.setName(bConsumer.getConsumerName());
		dto.setMail(bConsumer.getConsumerMail());
		genericDTO.setId(bConsumer.getBSubsidiary().getSubsidiaryId());
		genericDTO.setDescription(bConsumer.getBSubsidiary().getSubsidiaryName());
		dto.setSubsidiary(genericDTO);
		return dto;
	}

	@Override
	public List<ConsumerDTO> findByDescription(String key_word) {
		List<ConsumerDTO> consumers = new ArrayList<>();
		this.consumerRepository.findConsumerByKeyWord(key_word).stream().forEach((bConsumer) -> {
			ConsumerDTO dto = new ConsumerDTO();
			GenericDTO genericDTO = new GenericDTO();
			dto.setCell(bConsumer.getConsumerCell());
			dto.setDirection(bConsumer.getConsumerDirection());
			dto.setId(bConsumer.getConsumerId());
			dto.setLastName(bConsumer.getConsumerLastName());
			dto.setName(bConsumer.getConsumerName());
			dto.setMail(bConsumer.getConsumerMail());
			genericDTO.setId(bConsumer.getBSubsidiary().getSubsidiaryId());
			genericDTO.setDescription(bConsumer.getBSubsidiary().getSubsidiaryName());
			dto.setSubsidiary(genericDTO);
			consumers.add(dto);
		});
		return consumers;
	}

}
