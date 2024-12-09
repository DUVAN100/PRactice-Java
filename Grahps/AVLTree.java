package library;

class AVLTree<T extends Comparable<T>> {
    private class NodoAVL {
        T key;
        Object value;
        int height;
        NodoAVL left, right;

        public NodoAVL(T key, Object value) {
            this.key = key;
            this.value = value;
            this.height = 1;
        }
    }

    private NodoAVL root;

    public void insert(T key, Object value) {
        root = insertRecursive(root, key, value);
    }

    private NodoAVL insertRecursive(NodoAVL nodo, T key, Object value) {
        if (nodo == null) return new NodoAVL(key, value);

        if (key.compareTo(nodo.key) < 0) {
            nodo.left = insertRecursive(nodo.left, key, value);
        } else if (key.compareTo(nodo.key) > 0) {
            nodo.right = insertRecursive(nodo.right, key, value);
        } else {
            return nodo; 
        }

        nodo.height = 1 + Math.max(height(nodo.left), height(nodo.right));
        return balanceNode(nodo);
    }

    public Object search(T key) {
        return searchRecursive(root, key);
    }

    private Object searchRecursive(NodoAVL nodo, T key) {
        if (nodo == null || key.equals(nodo.key)) return nodo == null ? null : nodo.value;

        if (key.compareTo(nodo.key) < 0) {
            return searchRecursive(nodo.left, key);
        }
        return searchRecursive(nodo.right, key);
    }

    public void runInOrder() {
        if (root == null) {
            System.out.println("Tree is empty!!");
        } else {
            runInOrderRecursive(root);
        }
    }

    private void runInOrderRecursive(NodoAVL nodo) {
        if (nodo != null) {
            runInOrderRecursive(nodo.left);
            System.out.println(nodo.key + " -> " + nodo.value);
            runInOrderRecursive(nodo.right);
        }
    }

    private NodoAVL balanceNode(NodoAVL nodo) {
        int balance = height(nodo.left) - height(nodo.right);

        if (balance > 1) {
            if (height(nodo.left.left) >= height(nodo.left.right)) {
                return rotateRight(nodo);
            } else {
                nodo.left = rotateLeft(nodo.left);
                return rotateRight(nodo);
            }
        }

        if (balance < -1) {
            if (height(nodo.right.right) >= height(nodo.right.left)) {
                return rotateLeft(nodo);
            } else {
                nodo.right = rotateRight(nodo.right);
                return rotateLeft(nodo);
            }
        }

        return nodo;
    }

    private NodoAVL rotateRight(NodoAVL y) {
        NodoAVL x = y.left;
        NodoAVL T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    private NodoAVL rotateLeft(NodoAVL x) {
        NodoAVL y = x.right;
        NodoAVL T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    private int height(NodoAVL nodo) {
        return nodo == null ? 0 : nodo.height;
    }
}
