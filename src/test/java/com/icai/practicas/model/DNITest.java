package com.icai.practicas.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DNITest
{
    private DNI dni;

    @Test
    void testDNICorrecto(){
        dni=new DNI("12345678S");

        Assertions.assertEquals(true,dni.validar());
    }

    @Test
    void testDNIPocosDigitos(){
        dni=new DNI("1234567V");
        Assertions.assertEquals(false,dni.validar());
    }

    @Test
    void testDNIFormatoMalo()
    {
        dni=new DNI("a123456S");
        Assertions.assertEquals(false,dni.validar());

    }

    @Test
    void testDNICaracterNoValido(){
        dni=new DNI("1234567Ñ");
        Assertions.assertEquals(false,dni.validar());

    }

    @Test
    void testDNIInvalido()
    {
        dni=new DNI("00000000T");
        Assertions.assertEquals(false,dni.validar());
    }
}
