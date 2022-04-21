<b> Practica 6: Testing de una aplicacion de Spring Boot </b>

Se nos pide añadir tests a las siguientes clases en Spring Boot:

- DNI & Telefono (Unit Tests) 
- ProcessController (E2E Tests) 

<b> Desarrollo </b>

<b> Test Telefono </b>

Realizamos un test para comprobar el formato de teléfono que se está introduciendo. 
Se realizan dos comprobaciones, la primera es para 9 dígitos sin prefijo y la segunda para 9 dígitos con prefijo. 
Para comprobar que se detectan las entradas incorrectas, se comprueba con un teléfono de pocos dígitos y formato incorrecto. 

<b> Test Dni </b>

Realizamos un test para comprobar el formato de DNI que se está introduciendo. 
La primera comprobación es para un formato de 8 números + 1 letra válida al final. 
Para comprobar que se detectan las entradas incorrectas, se comprueba con un DNI de pocos dígitos y con letras incorrectas. 

