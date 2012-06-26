package com.chariot.lunchlearn.testingtalk.service;

import com.chariot.lunchlearn.testingtalk.model.Offering;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OfferingService {
  long countAllOfferings();

  void deleteOffering(Offering offering);

  Offering findOffering(Long id);

  List<Offering> findAllOfferings();

  List<Offering> findOfferingEntries(int firstResult, int maxResults);

  void saveOffering(Offering offering);

  Offering updateOffering(Offering offering);


}
