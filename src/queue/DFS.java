package queue;

import java.util.LinkedList;
import java.util.Stack;

class Graph {
    class Node {
        int data;
        LinkedList<Node> adj;
        boolean marked;

        Node(int data) {
            this.data = data;
            this.marked = false;
            adj = new LinkedList<>();
        }
    }

    Node[] nodes;
    Graph(int size) {
        nodes= new Node[size];
        for(int i=0; i<size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int a, int b) {
        Node n1 = nodes[a];
        Node n2 = nodes[b];
        if(!n1.adj.contains(n2)) {
            n1.adj.add(n2);
        }
        if(!n2.adj.contains(n1)) {
            n2.adj.add(n1);
        }
    }

    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        root.marked = true;

        while(!stack.isEmpty()) {
            Node r = stack.pop();
            for(Node n : r.adj) {
                if(n.marked==false) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }

    // 재귀
    void dfsR(Node r) {
        if(r==null)
            return;
        r.marked = true;

        visit(r);

        for(Node n : r.adj) {
            if(n.marked==false) {
                dfsR(n);
            }
        }
    }

    void dfsR(int index) {
        Node r = nodes[index];
        dfsR(r);
    }

    void dfsR() {
        dfsR(0);
    }

    void visit(Node node) {
        System.out.println(node.data);
    }
}

public class DFS {
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(5,6);
        g.addEdge(6,8);

        System.out.println("-----------");
        g.dfsR();

    }
}
