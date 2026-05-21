package VentaModel;

import java.sql.Timestamp;

public class Partido {

    private int id;
    private String equipoLocal;
    private String equipoVisitante;
    private Timestamp fecha;
    private String estadio;
    private String fase;   
    private String estado; 

    public Partido() {
        id = 0;
        equipoLocal = "";
        equipoVisitante = "";
        fecha = null;
        estadio = "";
        fase = "GRUPOS";
        estado = "DISPONIBLE";
    }

    public Partido(int id, String equipoLocal, String equipoVisitante,
                   Timestamp fecha, String estadio, String fase, String estado) {
        this.id = id;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.estadio = estadio;
        this.fase = fase;
        this.estado = estado;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEquipoLocal() { return equipoLocal; }
    public void setEquipoLocal(String equipoLocal) { this.equipoLocal = equipoLocal; }

    public String getEquipoVisitante() { return equipoVisitante; }
    public void setEquipoVisitante(String equipoVisitante) { this.equipoVisitante = equipoVisitante; }

    public Timestamp getFecha() { return fecha; }
    public void setFecha(Timestamp fecha) { this.fecha = fecha; }

    public String getEstadio() { return estadio; }
    public void setEstadio(String estadio) { this.estadio = estadio; }

    public String getFase() { return fase; }
    public void setFase(String fase) { this.fase = fase; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "[" + fase + "]  " + equipoLocal + "  vs  " + equipoVisitante;
    }
}
