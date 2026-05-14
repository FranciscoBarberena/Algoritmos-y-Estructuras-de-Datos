# Ejercicio 1

b. ¿Por qué **procesarMovimientos** es tan ineficiente? Tenga en cuenta que pueden existir
millones de movimientos diarios que abarquen gran parte de las cuentas bancarias.

- Porque por cada consulta, recorre y modifica a todas las cuentas que afecta según su rango desde..hasta. Formalmente, se diría que tiene un orden de O(N²), con *N* siendo el tamaño del rango de cuentas y de consultas. Como por cada elemento, recorre todo el arreglo de consultas y todo el arreglo de cuentas (en el peor caso), el resultado es N*N = N²

c. ¿En qué se diferencia procesarMovimientosOptimizado? Observe las operaciones que se
realizan para cada consulta

- A diferencia del primer algoritmo, el segundo únicamente realiza 2 modificaciones en el arreglo auxiliar (en la posición desde y en la posición hasta + 1). Luego de procesar todas las consultas, recorre el arreglo de cuentas en su totalidad **una sola vez**. Formalmente, tiene un orden O(N).