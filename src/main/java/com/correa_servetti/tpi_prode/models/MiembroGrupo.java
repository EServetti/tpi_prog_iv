package com.correa_servetti.tpi_prode.models;

import com.correa_servetti.tpi_prode.models.enums.ESTADO_INVITACION;
import com.correa_servetti.tpi_prode.models.enums.ROL_MIEMBRO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MiembroGrupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario miembro;

    @ManyToOne
    @JoinColumn(name = "grupo_id", nullable = false)
    private Grupo grupo;

    @Column(nullable = false)
    private String codigoInvitacion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ROL_MIEMBRO rol;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ESTADO_INVITACION estado;
}
