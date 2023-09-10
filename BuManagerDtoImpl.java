package com.boot.aatral.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.boot.aatral.exception.*;
import com.boot.aatral.dto.BuManagerDto;
import com.boot.aatral.entity.BuManager;
import com.boot.aatral.repository.BuManagerRepo;
import com.boot.aatral.service.BuManagerService;

public class BuManagerDtoImpl implements BuManagerService{

	@Autowired
	private BuManagerRepo buManageRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BuManagerDto createBuManager(BuManagerDto buManagerDto) {
		BuManager buManager =this.dtoToBuManager(buManagerDto);
		BuManager savedUser = this.buManageRepo.save(buManager);
		return this.buManagerToDTO(savedUser);
	}

	@Override
	public BuManagerDto updateBuManager(BuManagerDto buManagerDto, String empid) {
		BuManager buManager = this.buManageRepo.findById(empid)
				.orElseThrow(()-> new ResourceNotFoundException("BuManager", "id",empid ));
		buManager.setProjectName(buManagerDto.getProjectName());
		buManager.setContactNumber(buManagerDto.getContactNumber());
		buManager.setCtcOfferDetails(buManagerDto.getCtcOfferDetails());
		buManager.setDesignation(buManagerDto.getDesignation());
		buManager.setDivision(buManagerDto.getDivision());
		buManager.setEmpid(buManagerDto.getEmpid());
		buManager.setExperienceLevel(buManagerDto.getExperienceLevel());
		buManager.setJobDescription(buManagerDto.getJobDescription());
		buManager.setProjectName(buManagerDto.getProjectName());
		buManager.setRequestorName(buManagerDto.getRequestorName());
		buManager.setResourceStartDate(buManagerDto.getResourceStartDate());
		buManager.setRrDate(buManagerDto.getRrDate());
		buManager.setWorkLocation(buManager.getWorkLocation());
		
		BuManager updatedBuManager = this.buManageRepo.save(buManager);
		BuManagerDto buManagerDto1= this.buManagerToDTO(updatedBuManager)
		return buManagerDto1;	
	}

	@Override
	public BuManagerDto getBuManagerById(String empid) {
		BuManager buManager = this.
		return null;
	}

	@Override
	public List<BuManagerDto> getAllBuManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBuManager(String empid) {
		// TODO Auto-generated method stub
		
	}
	

	public BuManager dtoToBuManager(BuManagerDto buManagerDto) {
		BuManager buManager =this.modelMapper.map(buManagerDto, BuManager.class);
		return  buManager;
	}
	public BuManagerDto buManagerToDTO(BuManager buManager) {
		BuManagerDto buManagerDto =this.modelMapper.map(buManager, BuManagerDto.class);
		return buManagerDto;
	}
	
}