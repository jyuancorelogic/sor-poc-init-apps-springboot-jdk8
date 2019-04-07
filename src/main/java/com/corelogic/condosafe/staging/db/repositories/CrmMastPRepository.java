package com.corelogic.condosafe.staging.db.repositories;

import com.corelogic.condosafe.staging.db.dto.PersonDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrmMastPRepository extends CrudRepository<PersonDTO, Long> {

}
