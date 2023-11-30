package org.example.unicon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.unicon.filter.FilterProfesor;
import org.openxava.annotations.Tab;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profesor")
@NamedQueries({
        @NamedQuery(name="Profesor.findByprofesor",query="select u " +
                "from Profesor u where u.cifprofesor=?1 and u.contrasenaprofesor = ?2"),
        @NamedQuery(name="Profesor.findByprofeso",query="select u from Profesor u where u.nombreprofesor like ?1" )
})
@Tab(properties = "cifprofesor, nombreprofesor, apellidoprofesor, facultadprofesor",
        baseCondition = "${cifprofesor}=?",filter= FilterProfesor.class)

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
