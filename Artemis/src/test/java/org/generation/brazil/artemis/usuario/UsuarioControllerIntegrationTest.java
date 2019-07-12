package org.generation.brazil.artemis.usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.commons.lang3.RandomStringUtils;
import org.generation.brazil.artemis.ArtemisApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ArtemisApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsuarioControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl(String path) {
        return "http://localhost:" + port + "/api/v1" + path;
    }


/*    // Métodos para tornar
    public String generateNomeRamdom() {
        return RandomStringUtils.randomAlphabetic(100);
    }

    public String generateEmailRamdom() {
        return RandomStringUtils.randomAlphabetic(10) + "@" + RandomStringUtils.randomAlphabetic(10) + ".com";
    }

    public String generateLoginSenhaRamdom() {
        return RandomStringUtils.randomAlphanumeric(100);
    }*/


    @Test
    public void save(){

        Usuario usuario = UsuarioMock.getUsuarioMock();

        // Chamada da API
        ResponseEntity<Usuario> postResponse = testRestTemplate.postForEntity(getRootUrl("/usuarios"), usuario, Usuario.class);

        assertNotNull(postResponse);
        assertEquals(201, postResponse.getStatusCodeValue());

    }



}
