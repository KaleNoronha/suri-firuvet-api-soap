package com.surifiruvet.soap;

import com.surifiruvet.entity.Cita;
import jakarta.inject.Inject;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;
import java.util.List;

@WebService(
        endpointInterface = "com.surifiruvet.soap.CitaWebService",
        targetNamespace = "http://soap.surifiruvet.com/",
        serviceName = "CitaServiceEndpoint"
)
public class CitaWebServiceImpl implements CitaWebService {

    @Inject
    EntityManager em;

    @Override
    public List<Cita> obtenerCitas() {
        return em.createQuery("FROM Cita", Cita.class).getResultList();
    }

    @Override
    public List<Cita> obtenerCitasPorCliente(Long idCliente) {
        return em.createQuery("FROM Cita c WHERE c.cliente.id = :idCliente", Cita.class)
                .setParameter("idCliente", idCliente)
                .getResultList();
    }

    @Override
    public Cita obtenerCita(Long id) {
        return em.find(Cita.class, id);
    }
}
