package org.command.application.usuario;

public record CriarUsuarioCommand (String username, String email,
                                   String senhaHash, String bio) {}
