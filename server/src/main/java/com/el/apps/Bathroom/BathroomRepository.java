package com.el.apps.Bathroom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface BathroomRepository extends JpaRepository<Bathroom, Long> {
}
