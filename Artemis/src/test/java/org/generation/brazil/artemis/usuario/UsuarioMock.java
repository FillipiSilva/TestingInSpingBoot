package org.generation.brazil.artemis.usuario;

import com.github.javafaker.Faker;

public class UsuarioMock {

  public static Usuario getUsuarioMock() {

    Usuario usuario = new Usuario();

    Faker faker = new Faker();

    usuario.setNome(faker.name().firstName());
    usuario.setEmail(faker.internet().emailAddress());
    usuario.setLogin(faker.name().username());
    usuario.setSenha(faker.internet().password());

    return usuario;
  }

}
