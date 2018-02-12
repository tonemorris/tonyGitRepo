package com.cigna.mongooplogreader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;


import com.cigna.mongooplogreader.controller.MongoOplogReaderController;
import com.cigna.mongooplogreader.service.MongoOplogReaderService;

@RunWith(MockitoJUnitRunner.class)
public class MongoOplogReaderControllerTest {
	
	@InjectMocks
	private MongoOplogReaderController mongoOplogReaderController;
	
	@Mock
	private MongoOplogReaderService mongoOplogReaderService;

	@Test
	public void shouldCopyDataToMysqlDb() {
//		Order order = new Order("price", "item", "quantity");
//        
//		//when
//        doThrow(new RuntimeException("test exception")).when(mongoOplogReaderService).copy(order);


        
	}

}
