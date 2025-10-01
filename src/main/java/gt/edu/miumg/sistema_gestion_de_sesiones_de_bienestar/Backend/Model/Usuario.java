package gt.edu.miumg.sistema_gestion_de_sesiones_de_bienestar.Backend.Model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Usuario {
    private Long id;
    private String username;          // puede ser email o nombre de usuario
    private String passwordHash;      // almacenar hash en producción
    private Set<String> roles;        // e.g., "ROLE_ADMIN", "ROLE_RECEPTION", "ROLE_CLIENT"
    private int failedLoginAttempts;
    private LocalDateTime lockedUntil; // null si no está bloqueada
    private boolean activo;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;

    public Usuario() {
        this.roles = new HashSet<>();
        this.activo = true;
        this.creadoEn = LocalDateTime.now();
        this.actualizadoEn = LocalDateTime.now();
    }

    public Usuario(Long id, String username, String passwordHash, Set<String> roles,
                   int failedLoginAttempts, LocalDateTime lockedUntil, boolean activo,
                   LocalDateTime creadoEn, LocalDateTime actualizadoEn) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.roles = roles == null ? new HashSet<>() : roles;
        this.failedLoginAttempts = failedLoginAttempts;
        this.lockedUntil = lockedUntil;
        this.activo = activo;
        this.creadoEn = creadoEn != null ? creadoEn : LocalDateTime.now();
        this.actualizadoEn = actualizadoEn != null ? actualizadoEn : LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; touchUpdated(); }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; touchUpdated(); }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; touchUpdated(); }

    public Set<String> getRoles() { return roles; }
    public void setRoles(Set<String> roles) { this.roles = roles; touchUpdated(); }
    public void addRole(String role) { this.roles.add(role); touchUpdated(); }
    public void removeRole(String role) { this.roles.remove(role); touchUpdated(); }

    public int getFailedLoginAttempts() { return failedLoginAttempts; }
    public void setFailedLoginAttempts(int failedLoginAttempts) { this.failedLoginAttempts = failedLoginAttempts; touchUpdated(); }
    public void incrementFailedLoginAttempts() { this.failedLoginAttempts++; touchUpdated(); }
    public void resetFailedLoginAttempts() { this.failedLoginAttempts = 0; touchUpdated(); }

    public LocalDateTime getLockedUntil() { return lockedUntil; }
    public void setLockedUntil(LocalDateTime lockedUntil) { this.lockedUntil = lockedUntil; touchUpdated(); }
    public boolean isLocked() {
        return lockedUntil != null && LocalDateTime.now().isBefore(lockedUntil);
    }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; touchUpdated(); }

    public LocalDateTime getCreadoEn() { return creadoEn; }
    public void setCreadoEn(LocalDateTime creadoEn) { this.creadoEn = creadoEn; }

    public LocalDateTime getActualizadoEn() { return actualizadoEn; }
    public void setActualizadoEn(LocalDateTime actualizadoEn) { this.actualizadoEn = actualizadoEn; }

    private void touchUpdated() { this.actualizadoEn = LocalDateTime.now(); }

    @Override
    public String toString() {
        return "Usuario{id=" + id +
                ", username='" + username + '\'' +
                ", roles=" + roles +
                ", activo=" + activo +
                ", locked=" + isLocked() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) ||
                (username != null && username.equals(usuario.username));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}