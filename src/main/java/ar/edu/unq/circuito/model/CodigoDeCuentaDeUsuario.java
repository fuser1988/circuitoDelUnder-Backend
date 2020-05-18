package ar.edu.unq.circuito.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CodigoDeCuentaDeUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long usuarioId;
    private String Codigo;

    public CodigoDeCuentaDeUsuario(long idUsuario, String Codigo) {
        this.usuarioId = idUsuario;
        this.Codigo = Codigo;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUsuario() {
        return usuarioId;
    }

    public void setIdUsuario(long idUsuario) {
        this.usuarioId = idUsuario;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

}
