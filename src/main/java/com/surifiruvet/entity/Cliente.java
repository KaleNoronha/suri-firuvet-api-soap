package com.surifiruvet.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
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

    private String uid;
}
