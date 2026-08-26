package org.command.domain.usuario;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository {
    Optional<Usuario> buscarPorId(UUID userId);
    Usuario criar(Usuario usuario);
    Boolean usuarioExistePorUsername(String username);
}
