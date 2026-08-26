package org.command.application.usuario;

import org.command.domain.usuario.Usuario;
import org.command.domain.usuario.UsuarioRepository;

import java.util.UUID;

public class CriarUsuarioHandler {
    private final UsuarioRepository usuarioRepository;

    public CriarUsuarioHandler(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UUID handle(CriarUsuarioCommand command) {
        String username = command.username().trim();
        if (username.equals("") || username == null) {
            throw new IllegalArgumentException("Username nao pode ser vazio");
        }

        if(usuarioRepository.usuarioExistePorUsername(username)) {
            throw new RuntimeException("Usuario ja existe");
        }

        Usuario usuario = Usuario.criar(username, command.email(),
                command.senhaHash(), command.bio());

        usuarioRepository.criar(usuario);

        return usuario.getId();
    }
}
