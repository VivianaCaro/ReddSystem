# ReddSystem

Requisitos de ejecución:
- Tener JVM Java 8
- Descargar archivo redd-test-data.json desde ReddSystem/resources/

Ejecutar comando en consola:
```
java -jar redd-system-test.jar redd-test-data.json
```

Ejemplo:
```
C:\Users\Vivi\Documents\ReddSystem>java -jar redd-system-test.jar redd-test-data.json
Evaluacion ReddSytem
Ingrese elemento de busqueda (Ejemplo: "sku-12"):
sku-12
Resultado TOP 10 match de elementos:
| RANKING       | ELEMENTO              | PUNTUACION    |
|       1       |       sku-17724       |        112    |
|       2       |       sku-5841        |        108    |
|       3       |       sku-11872       |        95     |
|       4       |       sku-16653       |        94     |
|       5       |       sku-7878        |        93     |
|       6       |       sku-9629        |        92     |
|       7       |       sku-5753        |        91     |
|       8       |       sku-10657       |        90     |
|       9       |       sku-9074        |        89     |
|       10      |       sku-18149       |        88     |
```
