package com.surifiruvet.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement
@Getter @Setter
@Entity
@Table(name = "mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombmas")
    private String nombMas;

    // @XmlTransient — exponer solo los campos planos necesarios, evitar ciclos JAXB
    @XmlTransient
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipomas")
    private TipoMascota tipoMascotaEntity;

    @XmlTransient
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcliente")
    private Cliente clienteEntity;

    @Column(name = "apodos")
    private String apodos;

    @Column(name = "alergias")
    private String alergias;

    // Campos planos expuestos en la respuesta SOAP
    public Long getIdTipoMascota() {
        return tipoMascotaEntity != null ? tipoMascotaEntity.getId() : null;
    }

    public String getNombreTipo() {
        return tipoMascotaEntity != null ? tipoMascotaEntity.getNombre() : null;
    }

    public Long getIdCliente() {
        return clienteEntity != null ? clienteEntity.getId() : null;
    }
}
