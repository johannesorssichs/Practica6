package com.icai.practicas.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TelefonoTest
{
    private Telefono telefono;

    @Test
    void testTelefonoCorrecto()
    {
        telefono=new Telefono("645123789");
        Assertions.assertEquals(true,telefono.validar());
    }

    @Test
    void testTelefonoCorrecto2()
    {
        telefono=new Telefono("+34 645123789");
        Assertions.assertEquals(true,telefono.validar());
    }

    @Test
    void testTelefonoCorto() //demasiado corto
    {
        telefono=new Telefono("64512378");
        Assertions.assertEquals(false,telefono.validar());
    }

    @Test
    void testTelefonoInvalido() //con letras
    {
        telefono=new Telefono("645I23789");
        Assertions.assertEquals(false,telefono.validar());
    }
}
