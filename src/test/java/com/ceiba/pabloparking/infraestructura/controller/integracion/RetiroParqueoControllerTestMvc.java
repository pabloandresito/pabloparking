package com.ceiba.pabloparking.infraestructura.controller.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.pabloparking.aplicacion.fabrica.FabricaRegistroParqueo;
import com.ceiba.pabloparking.aplicacion.manejador.ManejadorVigilanteRetirarVehiculo;
import com.ceiba.pabloparking.infraestructura.controller.RetiroParqueoController;
import com.ceiba.pabloparking.infraestructura.controller.dto.RegistroParqueoDto;
import com.ceiba.pabloparking.infraestructura.persistencia.dao.ConexionDBRegistroParqueo;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(RetiroParqueoController.class)
public class RetiroParqueoControllerTestMvc {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @MockBean
    private ConexionDBRegistroParqueo conexionDBRegistroParqueo;
    
    @MockBean
    private ManejadorVigilanteRetirarVehiculo manejadorVigilanteRetirarVehiculo;
    
    @MockBean
    private FabricaRegistroParqueo fabricaRegistroParqueo;

    @Test
    public void listVehiculosRetiradosTestMvc() throws Exception {
        this.mockMvc.perform(get("/retiro-parqueo/list")).andDo(print()).andExpect(status().isOk());
    }
    
    @Test
    public void retirarTestMvc() throws Exception {
    	
    	RegistroParqueoDto registroParqueoDto = new RegistroParqueoDto();
    	registroParqueoDto.setId(1l);
    	
        this.mockMvc.perform(post("/retiro-parqueo/retirar")
        					.contentType(MediaType.APPLICATION_JSON_UTF8)
        					.content(objectMapper.writeValueAsString(registroParqueoDto)) )
        					.andDo(print())
        					.andExpect(status().isOk());
    }
}
