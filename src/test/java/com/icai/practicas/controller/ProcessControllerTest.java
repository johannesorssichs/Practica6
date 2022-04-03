package com.icai.practicas.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.BDDAssertions.then;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProcessControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void given_app_when_login_using_right_credencials_then_ok() {

        //Given
        String address = "http://localhost:"+port+"/api/v1/process-step1";
        ProcessController.DataRequest dataPrueba = new ProcessController.DataRequest("Porter Robinson", "02364298J", "987654321");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(dataPrueba, headers);

        //when
        ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

        //then
        then(result.getBody()).isEqualTo("{\"result\":\"OK\"}");
    }

    @Test
    public void given_app_when_login_using_bad_credentials_then_ko() {

        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1";
        //test1: telefono incorrecto
        ProcessController.DataRequest dataPrueba = new ProcessController.DataRequest("Porter Robinson", "02364298J", "987654ABC");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(dataPrueba, headers);

        //when
        ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

        //then
        then(result.getBody()).isEqualTo("{\"result\":\"KO\"}");

        //test 2
        //Given
        address = "http://localhost:" + port + "/api/v1/process-step1";
        //prueba 2: dni incorrecto
        dataPrueba = new ProcessController.DataRequest("Porter Robinson", "00000000T", "987654321");
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        request = new HttpEntity<>(dataPrueba, headers);

        //when
        result = this.restTemplate.postForEntity(address, request, String.class);

        //then
        then(result.getBody()).isEqualTo("{\"result\":\"KO\"}");
    }

    @Test
    public void given_app_when_login_using_right_credentials_then_ok_legacy() {
        //given
        String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
        MultiValueMap<String, String> datos = new LinkedMultiValueMap<>();
        datos.add("fullName", "Sofia Barquero");
        datos.add("dni", "12345678J");
        datos.add("telefono", "987654321");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(datos, headers);

        //when
        ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

        //then
        then(result.getBody()).contains("Muchas gracias por enviar los datos");
    }

    @Test
    public void given_app_when_login_using_bad_credentials_then_ko_legacy() {
        //given
        String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
        MultiValueMap<String, String> datos = new LinkedMultiValueMap<>();
        datos.add("fullName", "Sofia Barquero");
        datos.add("dni", "12345678Ñ"); //NO VALIDO
        datos.add("telefono", "987654321");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(datos, headers);

        //when
        ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

        //then
        then(result.getBody()).contains("Hemos tenido un problema con su solicitud");
    }
}

