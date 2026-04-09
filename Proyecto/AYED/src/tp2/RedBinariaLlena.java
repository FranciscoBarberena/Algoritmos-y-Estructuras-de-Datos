package tp2.ejercicio4;

public class RedBinariaLlena {
	
	private BinaryTree<Integer> arbol;
	
	public int retardoReenvio() {
		int max = 0;
		if ((this.arbol != null) && (!this.arbol.isEmpty()))
			max = this.calcularMaximo(arbol);
		System.out.println(max);
		return max;
	}
	private int calcularMaximo(BinaryTree<Integer> tree) {
		if (tree.isLeaf()) {
			return tree.getData();
		}
			int hi = calcularMaximo(tree.getLeftChild());
			int hd = calcularMaximo(tree.getRightChild());
		return Math.max(hi,hd)+tree.getData();
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
	    RedBinariaLlena red = new RedBinariaLlena(raiz);
	    red.retardoReenvio();
	}
	public RedBinariaLlena(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}

}
