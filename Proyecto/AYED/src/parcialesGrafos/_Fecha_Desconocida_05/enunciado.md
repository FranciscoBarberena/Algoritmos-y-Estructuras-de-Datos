# Ejercicio Práctico: "Logística de Emergencia"

La provincia de Buenos Aires se encuentra bajo una alerta meteorológica severa y muchas rutas están inundadas. Defensa Civil necesita enviar un camión de suministros desde una ciudad de origen hasta una ciudad de destino, gastando la **menor cantidad de combustible posible**.

El mapa de la provincia está representado por un **Grafo** donde los vértices son las ciudades y las aristas son las rutas que las conectan.

* **Ciudad (Vértice):** Se conoce su `nombre` (String) y un valor booleano `estaInundada` (que indica si es seguro pasar por ahí o no).
* **Ruta (Arista):** Se conoce el `costoCombustible` (un valor entero pesado en la arista que indica cuántos litros gasta el camión en recorrerla).

## Su misión

Implemente en Java la clase `DefensaCivil` y el método:

```java
public int calcularGastoMinimo(Graph<Ciudad> mapa, String origen, String destino)
```

## Restricciones

1. **Seguridad vial:** El camión **no puede** pasar por ciudades que estén inundadas (el origen y el destino se asumen siempre seguros y no inundados).
2. **Optimización:** Se desea calcular el **gasto de combustible mínimo** de todo el viaje (es decir, la suma de los costos de las aristas del camino óptimo).
3. **Manejo de errores:** Si no existe **ningún** camino posible y seguro entre el origen y el destino, el método debe retornar **-1**.