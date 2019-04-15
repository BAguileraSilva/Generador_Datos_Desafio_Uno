# Desafio Previred Api Rest - Nivel 3 sin Swagger

Este proyecto recibe desde la Api Periodos una serie de fechas incompletas, las cuales son procesadas y se responde enviando las fechas faltantes.

Primero se debe descargar la api que envia datos, y para esto las instrucciones son:

# Compilar y ejecutar el proyecto ApiPeridos

Para copilar el proyecto se requiere Java y Maven instalado.
Ingresar al directorio *ApiPeriodos* ejecutar el siguiente comando *maven*

```bash
mvn package
```

Luego de compilar el proyecto ingresar al directorio *target* ejecutar el siguiente comando *java*

```bash
java -jar .\api-periodos-1.0.0.jar
```
*Nota*:
Debe estar disponible el puerto *8080* en el PC donde se ejecute esta API.

Luego se debe realizar los mismos pasos para inicializar la api que procesa las fechas y responde con los faltantes.

Ingresar al directorio *ApiFaltantesSwagger* ejecutar el siguiente comando *maven*

```bash
mvn package
```

Luego de compilar el proyecto ingresar al directorio *target* ejecutar el siguiente comando *java*

```bash
java -jar .\api-periodos-1.0.0.jar
```
*Nota*:
Debe estar disponible el puerto *8091* en el PC donde se ejecute esta API.


La documentación swagger del API que envia (una vez que se levanta el API) queda disponible en

http://127.0.0.1:8080/periodos/swagger-ui.html#/





Para consumir el servicio se debe invocar la siguiente URL


http://localhost:8091/periodosFaltantes



*id*: identificador
*fechaCreacion*: Fecha de inicio de la secuencia
*fechaFin*: Fecha de fin de la secuencia
*fechas*: Lista de fechas que están en el rango de la fecha que se encuentra en “fechaCreacion” hasta la fecha “fechaFin”
*fechasFaltantes*: Listado de Fechas que no se encuentran en la lista de "fechas" y estan en el rango de creacion y fin


Ejemplo.
```json
{
    "id": 6,
    "fechaCreacion": "1968-08-01",
    "fechaFin": "1969-10-01",
    "fechas": [
      "1969-03-01",
      "1969-05-01",
      "1969-09-01"],
	"fechasFaltantes": [
      "1968-09-01",
	  "1968-10-01",
	  "1968-11-01",
	  "1969-01-01",
	  "1969-02-01",
	  "1969-04-01",
	  "1969-06-01",
	  "1969-07-01",
	  "1969-08-01"]
}
```
*Nota*:
El formato de las fechas es yyyy-MM-dd
El servicio entrega 1 periodos, el periodo contiene una fecha inicial una fecha final y una lista fechas.

# Detalle de los sistemas

Swagger Codegen 2.3.1 (OpenApi 2.0)
Java 8
Spring-Boot 1.5.11.RELEASE
Maven 3
