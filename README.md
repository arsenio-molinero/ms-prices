# ms-price

Microservicio desarrollado en SpringBoot que retorna el precio de un producto en la fecha que se le indica.
Ha sido dise帽ado utilizando arquitectura Hexagonal.

## Descripci贸n del proyecto 馃搩

Tenemos una tabla con los precios de un produto. Esta tabla nos permite aplicar distintos precios 
dependiendo de un rango de fechas.

El microservicio tiene el endpoint _**/price**_ que permite consultar el precio del producto para una cadena y fecha determinada.

Para la persistencia se utiliza una base de datos **H2 en memoria**. Esta base de datos se crea en el arranque del microservicio y se destruye al pararlo.
Tras el arranque se insertan 4 registros con precios para poder realizar los distintos test.

El proyecto tiene test unitario y de integraci贸n.

Se utiliza BDD + TDD. BDD para los test de integraci贸n y TDD para los unitarios,

## Dependencias 馃搵

A continuaci贸n se listan las dependencias del proyecto. spring-boot-devtools como se comenta mas abajo, es opcional. S贸lo se utiliza para depurar.

* spring-boot-starter-web
* spring-boot-starter-data-jpa
* spring-boot-starter-test
* spring-boot-devtools _"Opcional s贸lo para depuraci贸n y desarrollo"_
* mockito-junit-jupiter
* junit
* spring-test
* lombok
* h2
* cucumber-spring
* cucumber-java
* cucumber-junit
* cucumber-junit-platform-engine
* junit-vintage-engine

## Compilaci贸n 馃洜锔?

Para compilarlo se utiliza _Apache Maven_. Se tiene que ejecutar el siguiente comando en el directorio raiz del proyecto.

> mvn package -f pom.xml

Para m谩s informaci贸n sobre la herramienta se consultar el siguiente enlace.

* [Maven](https://maven.apache.org/) - Manejador de dependencias

# Ejecuci贸n 馃殌

Para poder poner en marcha el microservicio tenemos que ejecutar el siguiente comando desde el directorio raiz del proyecto.

> java -jar target/ms-prices-0.0.1-SNAPSHOT.jar

Una vez que arranca el servicio y no se produce ning煤n error, estar谩 el endpoint disponible en el puerto 8080 del localhost.

Se puede probar con la siguiente url [http://localhost:8080/price?brand=1&product=35455&date=2020-06-14T16:00:00](http://localhost:8080/price?brand=1&product=35455&date=2020-06-14T16:00:00)
## Ejecuci贸n de los test uitarios y de integraci贸n 鈿欙笍

la ejecuci贸n se realiza mediante la herramienta _Apache Maven_. Se tiene que ejecutar el siguiente comando en el directorio raiz del proyecto.

> mvn test

Para m谩s informaci贸n sobre la herramienta se consultar el siguiente enlace.

* [Maven](https://maven.apache.org/) - Manejador de dependencias

En las pruebas Se hacen consultas para las siguientes fechas y se comprueba que el resultado es el correcto.

* Test 1: petici贸n a las 10:00 del d铆a 14 del producto 35455 para la brand 1
* Test 2: petici贸n a las 16:00 del d铆a 14 del producto 35455 para la brand 1
* Test 3: petici贸n a las 21:00 del d铆a 14 del producto 35455 para la brand 1
* Test 4: petici贸n a las 10:00 del d铆a 15 del producto 35455 para la brand 1
* Test 5: petici贸n a las 21:00 del d铆a 16 del producto 35455 para la brand 1

El resultado de los test de integraci贸n se pueden ver ne el archivo target/cucumber-reports.html

## Autor 鉁掞笍

* **Arsenio Molinero** - *Dise帽o y desarrollo* - [arsenio-molinero](https://github.com/arsenio-molinero)

## Licencia 馃搫

Este proyecto est谩 bajo la Licencia MIT - mira el archivo [LICENSE.md](LICENSE.md) para detalles