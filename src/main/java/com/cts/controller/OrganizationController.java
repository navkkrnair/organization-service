package com.cts.controller;

import com.cts.model.Organization;
import com.cts.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "v1/organization")
public class OrganizationController {

    private final OrganizationService service;


    @RolesAllowed({"ADMIN", "USER"})
    @GetMapping("/{organizationId}")
    public ResponseEntity<Organization> getOrganization(@PathVariable("organizationId") Long organizationId) {
        return ResponseEntity.ok(service.findById(organizationId));
    }

    @RolesAllowed({"ADMIN", "USER"})
    @PutMapping("/{organizationId}")
    public void updateOrganization(@PathVariable("organizationId") Long id, @RequestBody Organization organization) {
        service.update(organization);
    }

    @RolesAllowed({"ADMIN", "USER"})
    @PostMapping
    public ResponseEntity<Organization> saveOrganization(@RequestBody Organization organization) {
        return ResponseEntity.ok(service.create(organization));
    }

    @RolesAllowed({"ADMIN"})
    @DeleteMapping("/{organizationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable("organizationId") Long organizationId, @RequestBody Organization organization) {
        service.delete(organization);
    }
}
