package tp2.ejercicio4;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;

	public int sumaElementosProfundidad(int p) {
		Queue<BinaryTree<Integer>> cola = new Queue<>();
		int tamano = 0;
		int suma = 0;
		int prof = 0;
		BinaryTree<Integer> nodoActual;
		if (this.arbol != null) {
			while ((!cola.isEmpty()) && (prof <= p)) {
				cola.enqueue(this.arbol);
				tamano = cola.size();
				if (prof == p) {
					for (int i = 0; i < tamano; i++) {
						nodoActual = cola.dequeue();
						suma += nodoActual.getData();
					}
				}
			}
		}
		return suma;
	}

	public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}

	public static void main(String[] args) {
		BinaryTree<Integer> raiz = new BinaryTree<>(10);

		BinaryTree<Integer> n2 = new BinaryTree<>(20);
		BinaryTree<Integer> n3 = new BinaryTree<>(3);
		raiz.addLeftChild(n2);
		raiz.addRightChild(n3);

		BinaryTree<Integer> n5_izq = new BinaryTree<>(5);
		BinaryTree<Integer> n4 = new BinaryTree<>(4);
		BinaryTree<Integer> n9 = new BinaryTree<>(9);
		BinaryTree<Integer> n8_der = new BinaryTree<>(80);

		n2.addLeftChild(n5_izq);
		n2.addRightChild(n4);
		n3.addLeftChild(n9);
		n3.addRightChild(n8_der);

		n5_izq.addLeftChild(new BinaryTree<>(7));
		n5_izq.addRightChild(new BinaryTree<>(8));

		n4.addLeftChild(new BinaryTree<>(5));
		n4.addRightChild(new BinaryTree<>(6));

		n9.addLeftChild(new BinaryTree<>(12));
		n9.addRightChild(new BinaryTree<>(8));

		n8_der.addLeftChild(new BinaryTree<>(2));
		n8_der.addRightChild(new BinaryTree<>(1));
		ProfundidadDeArbolBinario g = new ProfundidadDeArbolBinario(raiz);
		System.out.println(g.sumaElementosProfundidad(1));
	}

}
