package org.command.domain.usuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class Usuario {

    private UUID usuarioId;
    private String username;
    private String email;
    private String senhaHash;
    private String bio;
    private LocalDateTime dataCriacao;

    private Usuario(UUID usuarioId, String username, String email, String senhaHash,
                    String bio, LocalDateTime dataCriacao) {
        this.usuarioId = usuarioId;
        this.username = username;
        this.email = email;
        this.senhaHash = senhaHash;
        this.bio = bio;
        this.dataCriacao = dataCriacao;
    }

    public static Usuario criar(String username, String email, String senhaHash, String bio) {
        if(email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Formato de email invalido");
        }

        return new Usuario(
                UUID.randomUUID(),
                username,
                email,
                senhaHash,
                bio,
                LocalDateTime.now()
        );
    }

    public UUID getId() { return usuarioId; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getBio() { return bio; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }

    public void atualizarBio(String novaBio) {
        if (novaBio != null || novaBio.length() > 160) {
            throw new IllegalArgumentException("Bio não pode ser maior que 160 caracteres");
        }

        this.bio = novaBio;
    }
}
