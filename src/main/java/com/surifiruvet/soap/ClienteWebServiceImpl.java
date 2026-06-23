package com.surifiruvet.soap;

import com.surifiruvet.entity.Cliente;
import jakarta.inject.Inject;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;
import java.util.List;

@WebService(
        endpointInterface = "com.surifiruvet.soap.ClienteWebService",
        targetNamespace = "http://soap.surifiruvet.com/",
        serviceName = "ClienteServiceEndpoint"
)
public class ClienteWebServiceImpl implements ClienteWebService {

    @Inject
    EntityManager em;

    @Override
    public List<Cliente> obtenerClientes() {
        return em.createQuery("FROM Cliente", Cliente.class).getResultList();
    }

    @Override
    public Cliente obtenerCliente(Long id) {
        return em.find(Cliente.class, id);
    }
}
