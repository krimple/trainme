package com.chariot.lunchlearn.testingtalk.service;


import com.chariot.lunchlearn.testingtalk.db.OfferingRepository;
import com.chariot.lunchlearn.testingtalk.model.Offering;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class OfferingServiceImpl implements OfferingService {

  @Autowired
  private OfferingRepository offeringRepository;

  @Override
  public long countAllOfferings() {
    return offeringRepository.count();
  }

  @Override
  public void deleteOffering(Offering offering) {
    offeringRepository.delete(offering);
  }

  @Override
  public Offering findOffering(Long id) {
    return offeringRepository.findOne(id);
  }

  @Override
  public List<Offering> findAllOfferings() {
    return offeringRepository.findAll();
  }

  @Override
  public List<Offering> findOfferingEntries(int firstResult, int maxResults) {
    return offeringRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
  }

  @Override
  public void saveOffering(Offering offering) {
    offeringRepository.save(offering);
  }

  @Override
  public Offering updateOffering(Offering offering) {
    return offeringRepository.save(offering);
  }

  @Override
  public boolean courseExistsOnDate(Long courseId, Date proposedDate) {
    return false;  //To change body of implemented methods use File | Settings | File Templates.
  }
}
