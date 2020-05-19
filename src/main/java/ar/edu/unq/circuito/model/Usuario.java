package ar.edu.unq.circuito.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long referenciaId;
    private String email;
    private String nombre;
    private TipoUsuario tipoUsuario;
    @OneToOne(mappedBy="usuario")
    private Banda banda;

    public Usuario(long id, long idDeReferrencia, String email, String nombre, TipoUsuario tipoUsuario) {
        this.id = id;
        this.referenciaId = idDeReferrencia;
        this.email = email;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario() {
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getReferenciaId() {
        return referenciaId;
    }

    public void setReferenciaId(long referenciaId) {
        this.referenciaId = referenciaId;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
}
