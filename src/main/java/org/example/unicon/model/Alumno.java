package org.example.unicon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.unicon.filter.FilterAlumno;
import org.openxava.annotations.Tab;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "alumnos")
@NamedQueries({
        @NamedQuery(name="Alumno.findByalumnos",query="select e " +
            "from Alumno e where e.cifalumno=?1 and e.contrasena = ?2"),
        @NamedQuery(name="Alumno.findByalumn",query="select e from Alumno e where e.nombrealumno like ?1" )
})
@Tab(properties = "cifalumno",
    baseCondition = "${cifalumno}=?",filter= FilterAlumno.class)

public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idalumno;

   //@OneToMany
   //private Usuario idusuario;

    @Column(nullable = false)
    private String nombrealumno;
    @Column(nullable = false)
    private String apellidoalumno;
    @Column(nullable = false)
    private String cifalumno;
    @Column(nullable = false)
    private String carrera;
    @Column(nullable = false)
    private String facultad;
    @Column(nullable = false)
    private String contrasena;
}
