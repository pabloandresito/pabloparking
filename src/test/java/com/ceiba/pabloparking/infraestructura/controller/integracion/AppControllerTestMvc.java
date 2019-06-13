package com.ceiba.pabloparking.infraestructura.controller.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.pabloparking.aplicacion.fabrica.FabricaRegistroParqueo;
import com.ceiba.pabloparking.infraestructura.controller.AppController;
import com.ceiba.pabloparking.infraestructura.persistencia.dao.ConexionDBRegistroParqueo;

@RunWith(SpringRunner.class)
@WebMvcTest(AppController.class)
public class AppControllerTestMvc {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private ConexionDBRegistroParqueo conexionDBRegistroParqueo;
    
    @MockBean
    private FabricaRegistroParqueo fabricaRegistroParqueo;

    @Test
    public void contextLoadsMvc() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
    }
}
