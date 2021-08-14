# ms-price

Microservicio desarrollado en SpringBoot que retorna el precio de un producto en la fecha que se le indica.
Ha sido diseñado utilizando arquitectura Hexagonal.

## Descripción del proyecto 📃

Tenemos una tabla con los precios de un produto. Esta tabla nos permite aplicar distintos precios 
dependiendo de un rango de fechas.

El microservicio tiene el endpoint _**/price**_ que permite consultar el precio del producto para una cadena y fecha determinada.

Para la persistencia se utiliza una base de datos **H2 en memoria**. Esta base de datos se crea en el arranque del microservicio y se destruye al pararlo.
Tras el arranque se insertan 4 registros con precios para poder realizar los distintos test.

El proyecto tiene test unitario y de integración.

Se utiliza BDD + TDD. BDD para los test de integración y TDD para los unitarios,

## Autor ✒️

* **Arsenio Molinero** - *Diseño y desarrollo* - [arsenio-molinero](https://github.com/arsenio-molinero)

## Licencia 📄

Este proyecto está bajo la Licencia MIT - mira el archivo [LICENSE.md](LICENSE.md) para detalles