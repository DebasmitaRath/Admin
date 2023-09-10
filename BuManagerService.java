package com.boot.aatral.Services;

import java.util.List;
import com.boot.aatral.dto.BuManagerDto;


public interface BuManagerService {

	
    BuManagerDto createBuManager(BuManagerDto buManagerDto);
	
    BuManagerDto updateBuManager(BuManagerDto buManagerDto,String request_resource_id);
	
    BuManagerDto getBuManagerById(String request_resource_id);
	
    List<BuManagerDto> getAllBuManager();
	
    void deleteBuManager(String request_resource_id);
}
