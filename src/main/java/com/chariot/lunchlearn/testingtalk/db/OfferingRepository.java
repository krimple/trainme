package com.chariot.lunchlearn.testingtalk.db;

import com.chariot.lunchlearn.testingtalk.model.Offering;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Offering.class)
public interface OfferingRepository {
}
