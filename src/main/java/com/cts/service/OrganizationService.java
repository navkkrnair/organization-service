package com.cts.service;

import com.cts.model.Organization;

public interface OrganizationService {
    Organization findById(Long organizationId);

    Organization create(Organization organization);

    void update(Organization organization);

    void delete(Organization organization);
}
