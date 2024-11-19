package com.marondal.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.marondal.spring.test.ajax.domain.Favorite;

@Mapper
public interface FavoriteRepository {
	
	public List<Favorite> selectFavoriteList();
	
	public int insertFavorite(
			@Param("name") String name
			, @Param("url") String url);
	
	public int countByUrl(@Param("url") String url);
	
	
	// 특정 즐겨찾기 행 삭제
	// input : 삭제 대상 id
	// 기능 : delete 쿼리 수행으로 특정 행 삭제 
	// output : 실행된 행의 개수 
	public int deleteFavorite(@Param("id") int id);
	
	

}
