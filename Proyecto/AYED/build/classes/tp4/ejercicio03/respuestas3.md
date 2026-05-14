# Ejercicio 2

En la documentación de la clase ArrayList que se encuentra en el siguiente link
https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
Se encuentran las siguientes afirmaciones
-  "The size, isEmpty, get, set, iterator, and listIterator operations run in constant time.”
- “All of the other operations run in linear time (roughly speaking)”

Explique con sus palabras por qué cree que algunas operaciones se ejecutan en tiempo constante y
otras en tiempo lineal

- **Rta:** Porque algunas operaciones como la búsqueda desordenada por valor (indexOf(valor)) requieren, en el peor caso, recorrer todos los elementos del arreglo para realizarse. En cambio, una operación como size simplemente accede a la variable de instancia 'size' y la devuelve. Lo mismo con isEmpty, devuelve size == 0.