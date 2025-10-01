package gt.edu.miumg.sistema_gestion_de_sesiones_de_bienestar.Backend.Model;

import java.time.LocalDateTime;
import java.util.Objects;

public class CitaSesion {
    private Long id;
    private Long clienteId;
    private Long servicioId;
    private String nombreServicio;
    private String nombreProfesional;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private EstadoCita estado;
    private String notas;
    private LocalDateTime canceladaEn;
    private String motivoCancelacion;
    private boolean gestionada;
    private String gestionadaPor; // nombre o ID del usuario que la gestionó
    private LocalDateTime gestionadaEn;
    private boolean visibleEnHistorial;
    private LocalDateTime completadaEn;




    public enum EstadoCita {
        PENDIENTE, CONFIRMADA, CANCELADA, COMPLETADA
    }

    public CitaSesion() {
        this.estado = EstadoCita.PENDIENTE;
    }

    public CitaSesion(Long id, Long clienteId, Long servicioId, String nombreServicio,
                      String nombreProfesional, LocalDateTime fechaHoraInicio,
                      LocalDateTime fechaHoraFin, EstadoCita estado, String notas, LocalDateTime canceladaEn,
                      String motivoCancelacion, boolean gestionada, String gestionadaPor, LocalDateTime gestionadaEn,
                      boolean visibleEnHistorial, LocalDateTime completadaEn) {
        this.id = id;
        this.clienteId = clienteId;
        this.servicioId = servicioId;
        this.nombreServicio = nombreServicio;
        this.nombreProfesional = nombreProfesional;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.estado = estado != null ? estado : EstadoCita.PENDIENTE;
        this.notas = notas;
        this.canceladaEn = canceladaEn;
        this.motivoCancelacion = motivoCancelacion;
        this.gestionada = gestionada;
        this.gestionadaPor = gestionadaPor;
        this.gestionadaEn = gestionadaEn;
        this.visibleEnHistorial = visibleEnHistorial;
        this.completadaEn = completadaEn;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public Long getServicioId() { return servicioId; }
    public void setServicioId(Long servicioId) { this.servicioId = servicioId; }

    public String getNombreServicio() { return nombreServicio; }
    public void setNombreServicio(String nombreServicio) { this.nombreServicio = nombreServicio; }

    public String getNombreProfesional() { return nombreProfesional; }
    public void setNombreProfesional(String nombreProfesional) { this.nombreProfesional = nombreProfesional; }

    public LocalDateTime getFechaHoraInicio() { return fechaHoraInicio; }
    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) { this.fechaHoraInicio = fechaHoraInicio; }

    public LocalDateTime getFechaHoraFin() { return fechaHoraFin; }
    public void setFechaHoraFin(LocalDateTime fechaHoraFin) { this.fechaHoraFin = fechaHoraFin; }

    public EstadoCita getEstado() { return estado; }
    public void setEstado(EstadoCita estado) { this.estado = estado; }

    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }

    public LocalDateTime getCanceladaEn() { return canceladaEn; }
    public void setCanceladaEn(LocalDateTime canceladaEn) { this.canceladaEn = canceladaEn; }

    public String getMotivoCancelacion() { return motivoCancelacion; }
    public void setMotivoCancelacion(String motivoCancelacion) { this.motivoCancelacion = motivoCancelacion; }

    public boolean isGestionada() { return gestionada; }
    public void setGestionada(boolean gestionada) { this.gestionada = gestionada; }

    public String getGestionadaPor() { return gestionadaPor; }
    public void setGestionadaPor(String gestionadaPor) { this.gestionadaPor = gestionadaPor; }

    public LocalDateTime getGestionadaEn() { return gestionadaEn; }
    public void setGestionadaEn(LocalDateTime gestionadaEn) { this.gestionadaEn = gestionadaEn; }

    public boolean isVisibleEnHistorial() { return visibleEnHistorial; }
    public void setVisibleEnHistorial(boolean visibleEnHistorial) { this.visibleEnHistorial = visibleEnHistorial; }

    public LocalDateTime getCompletadaEn() { return completadaEn; }
    public void setCompletadaEn(LocalDateTime completadaEn) { this.completadaEn = completadaEn; }





    public void cancelar(String motivo) {
        this.estado = EstadoCita.CANCELADA;
        this.canceladaEn = LocalDateTime.now();
        this.motivoCancelacion = motivo;
    }

    public void gestionar(String usuarioGestor) {
        this.gestionada = true;
        this.gestionadaPor = usuarioGestor;
        this.gestionadaEn = LocalDateTime.now();
    }

    public void marcarComoCompletada() {
        this.estado = EstadoCita.COMPLETADA;
        this.completadaEn = LocalDateTime.now();
        this.visibleEnHistorial = true;
    }



    @Override
    public String toString() {
        return "CitaSesion{id=" + id +
                ", clienteId=" + clienteId +
                ", servicioId=" + servicioId +
                ", nombreServicio='" + nombreServicio + '\'' +
                ", profesional='" + nombreProfesional + '\'' +
                ", inicio=" + fechaHoraInicio +
                ", fin=" + fechaHoraFin +
                ", estado=" + estado +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CitaSesion)) return false;
        CitaSesion that = (CitaSesion) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}