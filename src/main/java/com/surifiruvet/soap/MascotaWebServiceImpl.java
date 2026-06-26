package com.surifiruvet.soap;

import com.surifiruvet.entity.Cliente;
import com.surifiruvet.entity.Mascota;
import com.surifiruvet.entity.TipoMascota;
import jakarta.inject.Inject;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@WebService(
        endpointInterface = "com.surifiruvet.soap.MascotaWebService",
        targetNamespace = "http://soap.surifiruvet.com/",
        serviceName = "MascotaServiceEndpoint"
)
public class MascotaWebServiceImpl implements MascotaWebService {

    @Inject
    EntityManager em;

    @Override
    public List<Mascota> obtenerMascotas() {
        return em.createQuery("FROM Mascota", Mascota.class).getResultList();
    }

    @Override
    public Mascota obtenerMascota(Long id) {
        return em.find(Mascota.class, id);
    }

    @Override
    public List<Mascota> obtenerMascotasPorCliente(Long idCliente) {
        return em.createQuery("FROM Mascota m WHERE m.clienteEntity.id = :idCliente", Mascota.class)
                .setParameter("idCliente", idCliente)
                .getResultList();
    }

    @Override
    @Transactional
    public Mascota registrarMascota(String nombMas, Long idTipoMascota, Long idCliente, String apodos, String alergias) {
        Cliente cliente = em.find(Cliente.class, idCliente);
        if (cliente == null) return null;

        TipoMascota tipoMascota = em.find(TipoMascota.class, idTipoMascota);
        if (tipoMascota == null) return null;

        Mascota mascota = new Mascota();
        mascota.setNombMas(nombMas);
        mascota.setTipoMascotaEntity(tipoMascota);
        mascota.setClienteEntity(cliente);
        mascota.setApodos(apodos);
        mascota.setAlergias(alergias);
        em.persist(mascota);
        return mascota;
    }
}
