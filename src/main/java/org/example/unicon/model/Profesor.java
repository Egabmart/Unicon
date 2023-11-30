package org.example.unicon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idprofesor;

   // @OneToOne
   // @JoinColumn(name = "idusuario")
   // private Usuario idusuario;

    @Column(nullable = false)
    private String nombreprofesor;
    @Column(nullable = false)
    private String apellidoprofesor;
    @Column(nullable = false)
    private String cifprofesor;
    @Column(nullable = false)
    private String contrasenaprofesor;
    @Column(nullable = false)
    private String facultadprofesor;
}
