# segundaFechaDosMilVeinticuatro

Ejercicio 1 (5 puntos). Defina una clase ParcialArboles con: (i) una única variable de instancia de tipo BinaryTree<Integer>, y (ii) un método público con la siguiente firma:

public BinaryTree<Integer> nuevoTree()

El método debe devolver un nuevo árbol, construido de la siguiente forma:

    - Si el árbol dado tiene hijo izquierdo, el nuevo árbol tendrá hijo izquierdo cuyo valor será la suma del valor del hijo izquierdo y el valor del padre del árbol dado.

    - Si el árbol dado no tiene hijo izquierdo, tampoco lo tendrá el nuevo.

    - Los hijos derechos del nuevo árbol son iguales que los del árbol dado.

    - Las hojas del árbol dado serán hojas en el nuevo.