package com.surifiruvet.soap;

import com.surifiruvet.entity.Cita;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://soap.surifiruvet.com/")
public interface CitaWebService {

    @WebMethod(operationName = "ObtenerCitas")
    List<Cita> obtenerCitas();

    @WebMethod(operationName = "ObtenerCitasPorCliente")
    List<Cita> obtenerCitasPorCliente(@WebParam(name = "idCliente") Long idCliente);

    @WebMethod(operationName = "ObtenerCita")
    Cita obtenerCita(@WebParam(name = "id") Long id);
}
