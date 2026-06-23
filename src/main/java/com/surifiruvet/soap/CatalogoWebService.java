package com.surifiruvet.soap;

import com.surifiruvet.entity.Clinica;
import com.surifiruvet.entity.TipoCita;
import com.surifiruvet.entity.TipoMascota;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://soap.surifiruvet.com/")
public interface CatalogoWebService {

    @WebMethod(operationName = "ObtenerTiposMascota")
    List<TipoMascota> obtenerTiposMascota();

    @WebMethod(operationName = "ObtenerTiposCita")
    List<TipoCita> obtenerTiposCita();

    @WebMethod(operationName = "ObtenerClinicas")
    List<Clinica> obtenerClinicas();
}
