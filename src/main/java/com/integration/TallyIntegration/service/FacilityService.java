/**
 * 
 */
package com.integration.TallyIntegration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integration.TallyIntegration.entity.FacilityEntity;
import com.integration.TallyIntegration.repository.FacilityRepository;

/**
 * @author Aman
 *
 */
@Service
public class FacilityService {
	@Autowired
	private FacilityRepository facilityRepository;
	
	
	public List<FacilityEntity> getAllFac(){
		List<FacilityEntity> facilityEntity = new ArrayList<>();
		facilityRepository.findAll().forEach(facilityEntity::add);
		return facilityEntity;
	}
	
	public List<FacilityEntity> findMyBranch(){
		return facilityRepository.findMyBranch();
	}
}
