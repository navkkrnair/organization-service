package com.cts.service.impl;

import com.cts.events.Action;
import com.cts.events.SimpleSourceBean;
import com.cts.model.Organization;
import com.cts.repository.OrganizationRepository;
import com.cts.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository repository;
    private final SimpleSourceBean simpleSourceBean;

    @Override
    public Organization findById(Long organizationId) {
        Optional<Organization> opt = repository.findById(organizationId);
        return (opt.isPresent()) ? opt.get() : null;
    }

    @Override
    public Organization create(Organization organization) {
        Organization org = repository.save(organization);
        simpleSourceBean.publishOrganizationChange(Action.CREATED, org.getId());
        return org;
    }

    @Override
    public void update(Organization organization) {
        Organization org = repository.save(organization);
        simpleSourceBean.publishOrganizationChange(Action.UPDATED, org.getId());

    }

    @Override
    public void delete(Long organizationId) {
        repository.deleteById(organizationId);
        simpleSourceBean.publishOrganizationChange(Action.DELETED, organizationId);
    }
}
