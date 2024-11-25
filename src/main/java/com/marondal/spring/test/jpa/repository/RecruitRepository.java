package com.marondal.spring.test.jpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marondal.spring.test.jpa.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Integer> {
	
	// WHERE `companyId` = #{companyId}
	public List<Recruit> findByCompanyId(int companyId);
	
	// WHERE `position` = #{} AND `type` = #{}
	public List<Recruit> findByPositionAndType(String position, String type);
	
	// WHERE `type` = #{} OR `salary` >= #{}
	public List<Recruit> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	// WHERE `type` = #{} ORDER BY `salary` DESC LIMIT 3
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);
	
	// WHERE `region` = #{} AND `salary` BETWEEN #{} AND #{};
	public List<Recruit> findByRegionAndSalaryBetween(String regeion, int start, int end);
	
	
	@Query(value="SELECT * FROM `recruit`"
			+ " WHERE `deadline` > :deadline"
			+ " AND `salary` >= :salary"
			+ " AND `type` = :type"
			+ " ORDER BY `salary` DESC", nativeQuery=true)
	public List<Recruit> selectByNativeQuery(
			@Param("deadline") LocalDate deadline
			, @Param("salary") int salary
			, @Param("type") String type);
}
