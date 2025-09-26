package gt.edu.miumg.sistema_gestion_de_sesiones_de_bienestar.Backend.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Cliente {
        private Long id;
        private String nombreCompleto;
        private String identificadorUnico;
        private LocalDate fechaNacimiento;
        private String telefono;
        private String email;
        private String password;
        private LocalDateTime registradoEn;
        private boolean activo;

        public Cliente() {
            this.activo = true;
            this.registradoEn = LocalDateTime.now();
        }

        public Cliente(Long id, String nombreCompleto, String identificadorUnico,
                       LocalDate fechaNacimiento, String telefono, String email,
                       String password, LocalDateTime registradoEn, boolean activo) {
            this.id = id;
            this.nombreCompleto = nombreCompleto;
            this.identificadorUnico = identificadorUnico;
            this.fechaNacimiento = fechaNacimiento;
            this.telefono = telefono;
            this.email = email;
            this.password = password;
            this.registradoEn = registradoEn != null ? registradoEn : LocalDateTime.now();
            this.activo = activo;
        }

        public Long getId() {
            return id; }

        public void setId(Long id) {
            this.id = id; }

        public String getNombreCompleto() {
            return nombreCompleto; }

        public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

        public String getIdentificadorUnico() { return identificadorUnico; }
        public void setIdentificadorUnico(String identificadorUnico) { this.identificadorUnico = identificadorUnico; }

        public LocalDate getFechaNacimiento() { return fechaNacimiento; }
        public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

        public String getTelefono() { return telefono; }
        public void setTelefono(String telefono) { this.telefono = telefono; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }

        public LocalDateTime getRegistradoEn() { return registradoEn; }
        public void setRegistradoEn(LocalDateTime registradoEn) { this.registradoEn = registradoEn; }

        public boolean isActivo() { return activo; }
        public void setActivo(boolean activo) { this.activo = activo; }

        @Override
        public String toString() {
            return "Cliente{id=" + id +
                    ", nombreCompleto='" + nombreCompleto + '\'' +
                    ", identificadorUnico='" + identificadorUnico + '\'' +
                    ", email='" + email + '\'' +
                    ", telefono='" + telefono + '\'' +
                    ", registradoEn=" + registradoEn +
                    ", activo=" + activo +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Cliente)) return false;
            Cliente cliente = (Cliente) o;
            return Objects.equals(id, cliente.id) ||
                    (identificadorUnico != null && identificadorUnico.equals(cliente.identificadorUnico)) ||
                    (email != null && email.equals(cliente.email));
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, identificadorUnico, email);
        }
    }


