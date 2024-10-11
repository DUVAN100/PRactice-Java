package treesstructure;

public class TreesStructure {
    static class Nodo {
        int value;
        Nodo left, right;
        public Nodo(int value) {
            this.value = value;
            left = right = null;
        }
    }
    public static void main(String[] args) {

        Nodo father = new Nodo(7);
        father.left = new Nodo(3);
        father.right = new Nodo(10);
        father.left.left = new Nodo(1);
        father.left.right = new Nodo(4);
        printTree(father, "", true);
    }

    static void printTree(Nodo nodo, String prefix, boolean isLast) {
        if (nodo != null) {
            System.out.println(prefix + (isLast ? "└── " : "├── ") + nodo.value);
            printTree(nodo.left, prefix + (isLast ? "    " : "│   "), false);
            printTree(nodo.right, prefix + (isLast ? "    " : "│   "), true);
        }
    }
}
