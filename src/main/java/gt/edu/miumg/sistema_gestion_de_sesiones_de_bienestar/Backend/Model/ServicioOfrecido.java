package gt.edu.miumg.sistema_gestion_de_sesiones_de_bienestar.Backend.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class ServicioOfrecido {
    private Long id;
    private String nombre;
    private String descripcion;
    private int duracionMinutos;
    private BigDecimal precioBase;
    private boolean activo;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;

    public ServicioOfrecido() {
        this.activo = true;
        this.creadoEn = LocalDateTime.now();
        this.actualizadoEn = LocalDateTime.now();
    }

    public ServicioOfrecido(Long id, String nombre, String descripcion,
                            int duracionMinutos, BigDecimal precioBase,
                            boolean activo, LocalDateTime creadoEn, LocalDateTime actualizadoEn) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionMinutos = duracionMinutos;
        this.precioBase = precioBase;
        this.activo = activo;
        this.creadoEn = creadoEn != null ? creadoEn : LocalDateTime.now();
        this.actualizadoEn = actualizadoEn != null ? actualizadoEn : LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; touchUpdated(); }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; touchUpdated(); }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; touchUpdated(); }

    public int getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; touchUpdated(); }

    public BigDecimal getPrecioBase() { return precioBase; }
    public void setPrecioBase(BigDecimal precioBase) { this.precioBase = precioBase; touchUpdated(); }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; touchUpdated(); }

    public LocalDateTime getCreadoEn() { return creadoEn; }
    public void setCreadoEn(LocalDateTime creadoEn) { this.creadoEn = creadoEn; }

    public LocalDateTime getActualizadoEn() { return actualizadoEn; }
    public void setActualizadoEn(LocalDateTime actualizadoEn) { this.actualizadoEn = actualizadoEn; }

    private void touchUpdated() { this.actualizadoEn = LocalDateTime.now(); }

    @Override
    public String toString() {
        return "ServicioOfrecido{id=" + id +
                ", nombre='" + nombre + '\'' +
                ", duracion=" + duracionMinutos +
                ", precio=" + precioBase +
                ", activo=" + activo + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServicioOfrecido)) return false;
        ServicioOfrecido that = (ServicioOfrecido) o;
        return Objects.equals(id, that.id) ||
                (nombre != null && nombre.equalsIgnoreCase(that.nombre));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}