package com.cts.service.impl;

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

    @Override
    public Organization findById(Long organizationId) {
        Optional<Organization> opt = repository.findById(organizationId);
        return (opt.isPresent()) ? opt.get() : null;
    }

    @Override
    public Organization create(Organization organization) {
        return repository.save(organization);
    }

    @Override
    public void update(Organization organization) {
        repository.save(organization);
    }

    @Override
    public void delete(Organization organization) {
        repository.deleteById(organization.getId());
    }
}
