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
import com.ceiba.pabloparking.aplicacion.manejador.ManejadorVigilanteRegistrarVehiculo;
import com.ceiba.pabloparking.dominio.TipoVehiculo;
import com.ceiba.pabloparking.infraestructura.controller.RegistroParqueoController;
import com.ceiba.pabloparking.infraestructura.controller.dto.RegistroParqueoDto;
import com.ceiba.pabloparking.infraestructura.persistencia.dao.ConexionDBRegistroParqueo;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(RegistroParqueoController.class)
public class RegistroParqueoControllerTestMvc {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @MockBean
    private ConexionDBRegistroParqueo conexionDBRegistroParqueo;
    
    @MockBean
    private ManejadorVigilanteRegistrarVehiculo manejadorVigilanteRegistrarVehiculo;
    
    @MockBean
    private FabricaRegistroParqueo fabricaRegistroParqueo;

    @Test
    public void listVehiculosTestMvc() throws Exception {
        this.mockMvc.perform(get("/registro-parqueo/list-vehiculos")).andDo(print()).andExpect(status().isOk());
    }
    
    @Test
    public void ingresarTestMvc() throws Exception {
    	
    	RegistroParqueoDto registroParqueoDto = new RegistroParqueoDto();
    	registroParqueoDto.setPlaca("GHB383");
    	registroParqueoDto.setTipoVehiculo(TipoVehiculo.CARRO.getIdTipoVehiculo());
    	
        this.mockMvc.perform(post("/registro-parqueo/ingresar")
        					.contentType(MediaType.APPLICATION_JSON_UTF8)
        					.content(objectMapper.writeValueAsString(registroParqueoDto)) )
        					.andDo(print())
        					.andExpect(status().isCreated());
    }
}
