package com.hantsylabs.example.conference.jpa;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hantsylabs.example.conference.model.Conference;

@Repository
public interface ConferenceRepository extends ConferenceRepositoryCustom, JpaRepository<Conference, Long>,
		JpaSpecificationExecutor<Conference>, 
		QueryDslPredicateExecutor<Conference>  {

	Conference findBySlug(String id);

	@Query("from Conference where name=?")
	public List<Conference> searchByConferenceName(String name);

	@Query("from Conference where name=:name")
	public List<Conference> searchByNamedConferenceName(@Param("name") String name);

	@Query
	public List<Conference> searchByMyNamedQuery(String name);

	public List<Conference> findByAddressCountry(String country);
	
	public List<Conference> findByDescriptionLike(String desc);

}
