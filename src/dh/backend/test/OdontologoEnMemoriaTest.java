package dh.backend.test;

import dh.backend.dao.impl.OdontologoDaoH2;
import dh.backend.dao.impl.OdontologoDaoMemoria;
import dh.backend.model.Odontologo;
import dh.backend.service.OdontologoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OdontologoEnMemoriaTest {
    private static OdontologoService odontologoService = new OdontologoService(new OdontologoDaoMemoria());
    @Test
    @DisplayName("Testear que un odontologo fue guardado")
    void testOdontologoGuardado(){
        Odontologo odontologo = new Odontologo(45678,"CAROLINA","ZAPATA");
        Odontologo odontologoDesdeLaMemoria = odontologoService.registrarOdontologo(odontologo);

        assertNotNull(odontologoDesdeLaMemoria);
    }
    @Test
    @DisplayName("Testear busqueda todos los odontologos")
    void testBusquedaTodos() {
        Odontologo odontologo = new Odontologo(777666,"RAUL","SUAREZ");
        odontologoService.registrarOdontologo(odontologo);
        Odontologo odontologo2 = new Odontologo(777111,"VALENTINA","LOPEZ");
        odontologoService.registrarOdontologo(odontologo2);

        List<Odontologo> odontologos = odontologoService.buscarTodos();

        assertEquals(3, odontologos.size());

    }
}