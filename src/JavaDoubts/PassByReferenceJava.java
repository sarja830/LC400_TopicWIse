package JavaDoubts;

class PassByReferenceJava {
    class Node
    {
        Node[] child;
        boolean end;
        public Node()
        {
            child = new Node[26];
            end = false;
        }
    }
    public static void main(String[] args) {
       PassByReferenceJava a = new PassByReferenceJava();
       Node root = a.new Node();
       a.passToFunction(root);

    }
    void passToFunction(Node root)
    {
        passToFunction2(root);
    }

    void passToFunction2(Node root) {
        System.out.println(root.child[0]);
    }

}