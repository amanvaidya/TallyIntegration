/**
 * 
 */
package com.integration.TallyIntegration.repository;

import org.springframework.data.repository.CrudRepository;

import com.integration.TallyIntegration.entity.TallyPurchaseResponse;

/**
 * @author Aman
 *
 */
public interface TallyPurchaseRepo extends CrudRepository<TallyPurchaseResponse, Integer>{

}
