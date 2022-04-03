# Practica 6: Testing de una aplicacion de Spring Boot

## Objetivo de la práctica

Dado un desarrollo de Spring Boot, es necesario anhadir tests a las siguientes clases:

- DNI & Telefono (Unit Tests) (Cada clase tiene un metodo y varias casuisticas para probar)
- ProcessController (E2E Tests) (2 endpoints)

#Desarrollo 

##TelefonoTest
Se han realizado test para comprobar el formato del telefono que se introduzca. 
En primer lugar, dos comprobaciones de formatos correctos, uno de nueve digitos y otro de nueve digitos con prefijo.
Para las entradas incorrectas, se ha comprobado una con un telefono de pocos digitos(ocho) y una con un formato incorrecto (con una letra intercalada).

##DNITest
Se han realizado test para comprobar el formato del DNI que se introduzca.
En primer lugar, una comprobacion de formato correcto, con ocho numeros y una letra valida.
Para las entradas incorrectas, se ha comprobado una con un DNI de pocos digitos (siete numeros y una letra), una con un formato incorrecto (con una letra en el inicio), una con el caracter invalido (la Ñ) y , por ultimo, una con el formato incorrecto con las combinaciones restringidas.

##ProcessControllerTest
En esta clase se han hecho comprobaciones para el POST y otros dos para la version legacy en los que se introducen los datos del usuario y se confirma el resultado de dichos datos.