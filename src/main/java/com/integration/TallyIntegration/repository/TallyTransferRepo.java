/**
 * 
 */
package com.integration.TallyIntegration.repository;

import org.springframework.data.repository.CrudRepository;

import com.integration.TallyIntegration.entity.TallyTransferResponse;

/**
 * @author Aman
 *
 */
public interface TallyTransferRepo extends CrudRepository<TallyTransferResponse,Integer>{

}
