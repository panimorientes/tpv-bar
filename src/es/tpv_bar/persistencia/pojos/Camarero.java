
 package es.tpv_bar.persistencia.pojos;
// Generated 13-abr-2012 9:10:04 by Hibernate Tools 3.2.1.GA

import java.util.HashSet;
import java.util.Set; 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Camarero generated by hbm2java
 */
@Entity
@Table(name="Camarero"
    ,catalog="mydb"
)
public class Camarero  implements java.io.Serializable {


     private Integer idCamarero;
     private String nombre;
     private String apellidos;
     private Integer telefono;
     private Set<Cabezera> cabezeras = new HashSet<Cabezera>(0);

    public Camarero() {
    }

    public Camarero(String nombre, String apellidos, Integer telefono, Set<Cabezera> cabezeras) {
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.telefono = telefono;
       this.cabezeras = cabezeras;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="IdCamarero", unique=true, nullable=false)
    public Integer getIdCamarero() {
        return this.idCamarero;
    }
    
    public void setIdCamarero(Integer idCamarero) {
        this.idCamarero = idCamarero;
    }
    
    @Column(name="Nombre", length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Column(name="Apellidos", length=100)
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    @Column(name="Telefono")
    public Integer getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="camarero")
    public Set<Cabezera> getCabezeras() {
        return this.cabezeras;
    }
    
    public void setCabezeras(Set<Cabezera> cabezeras) {
        this.cabezeras = cabezeras;
    }




}


