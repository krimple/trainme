package com.chariot.lunchlearn.testingtalk.db;

import com.chariot.lunchlearn.testingtalk.model.Offering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OfferingRepository
    extends JpaRepository<Offering, Long>,
    JpaSpecificationExecutor<Offering> {

}
