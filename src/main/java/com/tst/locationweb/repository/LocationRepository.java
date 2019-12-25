package com.tst.locationweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tst.locationweb.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
