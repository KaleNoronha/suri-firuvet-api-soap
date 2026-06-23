package com.surifiruvet.soap;

import com.surifiruvet.entity.Cliente;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://soap.surifiruvet.com/")
public interface ClienteWebService {

    @WebMethod(operationName = "ObtenerClientes")
    List<Cliente> obtenerClientes();

    @WebMethod(operationName = "ObtenerCliente")
    Cliente obtenerCliente(@WebParam(name = "id") Long id);
}
