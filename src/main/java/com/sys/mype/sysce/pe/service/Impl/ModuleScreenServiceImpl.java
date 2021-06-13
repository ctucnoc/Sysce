package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.ItemDTO;
import com.sys.mype.sysce.pe.dto.ModuleScreenDTO;
import com.sys.mype.sysce.pe.dto.NavItemDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.model.BModule;
import com.sys.mype.sysce.pe.model.BModuleScreen;
import com.sys.mype.sysce.pe.model.BScreen;
import com.sys.mype.sysce.pe.repository.ModuleRepository;
import com.sys.mype.sysce.pe.repository.ModuleScreenRepository;
import com.sys.mype.sysce.pe.repository.ScreenRepository;
import com.sys.mype.sysce.pe.service.ModuleScreenService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

@Service
@Transactional
public class ModuleScreenServiceImpl implements ModuleScreenService {

    final private ModuleScreenRepository moduleScreenRepository;
    final private ModuleRepository moduleRepository;
    final private ScreenRepository screenRepository;

    public ModuleScreenServiceImpl(ModuleScreenRepository moduleScreenRepository,ModuleRepository moduleRepository,ScreenRepository screenRepository) {
        this.moduleScreenRepository = moduleScreenRepository;
        this.moduleRepository=moduleRepository;
        this.screenRepository=screenRepository;
    }

    @Override
    public void save(ModuleScreenDTO dto) {
        BModule bModule=this.moduleRepository.findById(dto.getModuleId()).orElseThrow(()-> new SysceEntityNotFoundException("Id no encontrado'"));
        BScreen bScreen=this.screenRepository.findById(dto.getScreenId()).orElseThrow(()-> new SysceEntityNotFoundException("Id no encontrado'"));
        BModuleScreen bModuleScreen=new BModuleScreen();
        bModuleScreen.setBModule(bModule);
        bModuleScreen.setBScreen(bScreen);
        bModuleScreen.setModuleScreenStatus(SysceConstant.STATE_ACTIVE);
        this.moduleScreenRepository.save(bModuleScreen);
    }

	@Override
	public List<NavItemDTO> findByModuleScreenUser(String userId) {
		return mapToNavItem(this.moduleScreenRepository.findByModuleScreenUser(userId, SysceConstant.STATE_ACTIVE));
	}
	
	private List<NavItemDTO> mapToNavItem(List<BModuleScreen> list) {
		List<NavItemDTO> navItems=new ArrayList<>();
		List<BModule> listModule=list.stream().map((array)->array.getBModule()).collect(Collectors.toList());
		Set<BModule> modules=new HashSet<BModule>(listModule);
		modules.forEach((array)->{
			List<ItemDTO> items=new ArrayList<>();
			NavItemDTO navItem=new NavItemDTO();
			navItem.setDisplayName(array.getModuleName().toLowerCase());
			navItem.setIconName(array.getModuleIcon());
			navItem.setRoute(array.getModuleUri());
			navItem.setCode(array.getModuleCode());
			list.forEach((lis)->{
				if(array.getModuleId()==lis.getBModule().getModuleId()) {
					ItemDTO item=new ItemDTO();
					item.setDisplayName(lis.getBScreen().getScreenName().toLowerCase());
					item.setIconName(lis.getBScreen().getScreenIcon());
					item.setRoute(lis.getBModule().getModuleUri()+lis.getBScreen().getScreenUri());
					item.setCode(lis.getBScreen().getScreenCode());
					items.add(item);
				}
			});
			navItem.setChildren(items);
			navItems.add(navItem);
		});
		return navItems;
	}
}
