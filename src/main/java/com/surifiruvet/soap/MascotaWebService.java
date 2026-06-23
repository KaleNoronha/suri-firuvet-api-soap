package com.surifiruvet.soap;

import com.surifiruvet.entity.Mascota;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://soap.surifiruvet.com/")
public interface MascotaWebService {

    @WebMethod(operationName = "ObtenerMascotas")
    List<Mascota> obtenerMascotas();

    @WebMethod(operationName = "ObtenerMascota")
    Mascota obtenerMascota(@WebParam(name = "id") Long id);

    @WebMethod(operationName = "ObtenerMascotasPorCliente")
    List<Mascota> obtenerMascotasPorCliente(@WebParam(name = "idCliente") Long idCliente);

    @WebMethod(operationName = "RegistrarMascota")
    Mascota registrarMascota(
            @WebParam(name = "nombMas") String nombMas,
            @WebParam(name = "idTipoMascota") Long idTipoMascota,
            @WebParam(name = "idCliente") Long idCliente,
            @WebParam(name = "apodos") String apodos,
            @WebParam(name = "alergias") String alergias
    );
}
