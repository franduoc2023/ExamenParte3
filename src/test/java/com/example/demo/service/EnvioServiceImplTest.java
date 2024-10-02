package com.example.demo.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import com.example.demo.model.Envio;
import com.example.demo.repository.EnvioRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
 
@ExtendWith(MockitoExtension.class)
public class EnvioServiceImplTest {
    @InjectMocks
    private EnvioServiceImpl envioServiceImpl;
    @Mock
    private EnvioRepository envioRepositorioMock;

    @Test 
    public void guardarEnvioTest(){
        Envio envio = new Envio();{
              envio.setName("rey");
        when(envioRepositorioMock.save(any(Envio.class))).thenReturn(envio);
        Envio resultado = envioServiceImpl.createEnvio(envio);
        assertEquals("rey", resultado.getName());

        }}

        @Test
        public void getAllEnviosTest() {
            Envio envio1 = new Envio();
            envio1.setId(1L);
            envio1.setName("Envio 1");
    
            Envio envio2 = new Envio();
            envio2.setId(2L);
            envio2.setName("Envio 2");
    
            List<Envio> envios = Arrays.asList(envio1, envio2);
            when(envioRepositorioMock.findAll()).thenReturn(envios);   
    
            List<Envio> resultado = envioServiceImpl.getAllEnvios();
    
            assertEquals(2, resultado.size());
            assertEquals("Envio 1", resultado.get(0).getName());
            assertEquals("Envio 2", resultado.get(1).getName());
    
            
        }}