package gt.edu.miumg.sistema_gestion_de_sesiones_de_bienestar.Backend.Model;

import java.time.LocalDateTime;
import java.util.Objects;

public class AuthToken {
    private String token;
    private Long usuarioId;
    private LocalDateTime issuedAt;
    private LocalDateTime expiresAt;

    public AuthToken() {}

    public AuthToken(String token, Long usuarioId, LocalDateTime issuedAt, LocalDateTime expiresAt) {
        this.token = token;
        this.usuarioId = usuarioId;
        this.issuedAt = issuedAt;
        this.expiresAt = expiresAt;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public LocalDateTime getIssuedAt() { return issuedAt; }
    public void setIssuedAt(LocalDateTime issuedAt) { this.issuedAt = issuedAt; }

    public LocalDateTime getExpiresAt() { return expiresAt; }
    public void setExpiresAt(LocalDateTime expiresAt) { this.expiresAt = expiresAt; }

    public boolean isExpired() {
        return expiresAt != null && LocalDateTime.now().isAfter(expiresAt);
    }

    @Override
    public String toString() {
        return "AuthToken{token='[PROTECTED]', usuarioId=" + usuarioId +
                ", issuedAt=" + issuedAt + ", expiresAt=" + expiresAt + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthToken)) return false;
        AuthToken that = (AuthToken) o;
        return Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}