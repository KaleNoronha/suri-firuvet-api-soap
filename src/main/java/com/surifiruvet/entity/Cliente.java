package com.surifiruvet.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@XmlRootElement
@Getter @Setter
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombcli")
    private String nombCli;

    @Column(name = "apecli")
    private String apeCli;

    @Column(name = "fecnac")
    private LocalDate fecNac;

    @Column(name = "uid")
    private String uid;

    // @XmlTransient — evita serializar el objeto Rol completo y ciclos JAXB
    @XmlTransient
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idrol")
    private Rol rolEntity;

    // Campos planos expuestos en la respuesta SOAP
    public Long getIdRol() {
        return rolEntity != null ? rolEntity.getId() : 1L;
    }

    public String getRolNombre() {
        return rolEntity != null ? rolEntity.getNombre() : "usuario";
    }
}
