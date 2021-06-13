package com.sys.mype.sysce.pe.service.Impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.SubsidiaryInitDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityUnprocessableException;
import com.sys.mype.sysce.pe.repository.UserSubsidiaryRepository;
import com.sys.mype.sysce.pe.service.UserSubsidiaryService;

@Service
public class UserSubsidiaryServiceImpl implements UserSubsidiaryService {

	final UserSubsidiaryRepository userSubsidiaryRepository;

	public UserSubsidiaryServiceImpl(UserSubsidiaryRepository userSubsidiaryRepository) {
		super();
		this.userSubsidiaryRepository = userSubsidiaryRepository;
	}

	@Override
	public List<SubsidiaryInitDTO> findByUserSubsidiary(String userId, String ruc) {
		if(!existsByUserAndRuc(userId, ruc))
			throw new SysceEntityUnprocessableException("user is not linked to this company");
		List<SubsidiaryInitDTO> list = this.userSubsidiaryRepository
				.findByUserSubsidiary(userId, SysceConstant.STATE_ACTIVE).stream()
				.map((bean) -> new SubsidiaryInitDTO(bean.getBSubsidiary().getSubsidiaryId(),
						bean.getBSubsidiary().getSubsidiaryName()))
				.collect(Collectors.toList());
		if (list.size() == 0 || list == null)
			throw new SysceEntityUnprocessableException("the user is not assigned to a company");
		return list;
	}
	
	private boolean existsByUserAndRuc(String userId,String ruc) {
		return this.userSubsidiaryRepository.existsByUserAndRuc(userId, ruc, SysceConstant.STATE_ACTIVE);
	}

}
