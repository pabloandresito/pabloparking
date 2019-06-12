package com.ceiba.pabloparking.infraestructura.controller.integracion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.pabloparking.infraestructura.controller.AppController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppControllerTest {
	
	@Autowired
	AppController appController;
	
	@Test
    public void contextLoads() {
		assertThat(appController).isNotNull();
    }
}