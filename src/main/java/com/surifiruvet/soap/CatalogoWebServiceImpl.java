package com.surifiruvet.soap;

import com.surifiruvet.entity.Clinica;
import com.surifiruvet.entity.TipoCita;
import com.surifiruvet.entity.TipoMascota;
import jakarta.inject.Inject;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;
import java.util.List;

@WebService(
        endpointInterface = "com.surifiruvet.soap.CatalogoWebService",
        targetNamespace = "http://soap.surifiruvet.com/",
        serviceName = "CatalogoServiceEndpoint"
)
public class CatalogoWebServiceImpl implements CatalogoWebService {

    @Inject
    EntityManager em;

    @Override
    public List<TipoMascota> obtenerTiposMascota() {
        return em.createQuery("FROM TipoMascota", TipoMascota.class).getResultList();
    }

    @Override
    public List<TipoCita> obtenerTiposCita() {
        return em.createQuery("FROM TipoCita", TipoCita.class).getResultList();
    }

    @Override
    public List<Clinica> obtenerClinicas() {
        return em.createQuery("FROM Clinica", Clinica.class).getResultList();
    }
}
