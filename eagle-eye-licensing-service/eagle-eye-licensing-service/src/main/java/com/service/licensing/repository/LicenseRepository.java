package com.service.licensing.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.service.licensing.model.License;

@Repository
public interface LicenseRepository extends CrudRepository<License,String>  {
    public Optional<List<License>> findByOrganizationId(String organizationId);
    public Optional<License> findByOrganizationIdAndLicenseId(String organizationId,String licenseId);
}
