package com.marondal.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.test.database.domain.Store;
import com.marondal.spring.test.database.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	// 가게 리스트 얻어오기 
	public List<Store> getStoreList() {
		List<Store> storeList = storeRepository.selectStoreList();
		
		return storeList;
	}

}
