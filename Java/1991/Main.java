import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 1991 트리순회
 * 
 * 전위 순회(preorder traversal), 
 * 중위 순회(inorder traversal), 
 * 후위 순회(postorder traversal)
 * 
 * 별도의 Node 클래스사용이 더 낫다. 모듈화 
*/
class Node {
    char data;
    Node left;
    Node right;

    public Node(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    static Node root; 
    static Map<Character, Node> nodes = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int N = Integer.parseInt(br.readLine()); 

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            char parentData = st.nextToken().charAt(0);
            char leftData = st.nextToken().charAt(0); 
            char rightData = st.nextToken().charAt(0); 

            Node parentNode = nodes.getOrDefault(parentData, new Node(parentData)); 
            nodes.put(parentData, parentNode);

            if(i == 0){
                root = parentNode; 
            }

            if(leftData != '.') {
                Node leftNode = nodes.getOrDefault(leftData, new Node(leftData));
                nodes.put(leftData, leftNode);
                parentNode.left = leftNode; 
            }

            if(rightData != '.') {
                Node rightNode = nodes.getOrDefault(rightData, new Node(rightData));
                nodes.put(rightData, rightNode); 
                parentNode.right = rightNode; 
            }
        }

        //순회
        preorder(root); 
        System.out.println();

        inorder(root); 
        System.out.println();

        postorder(root); 
        System.out.println();

        br.close(); 
    }
    
    //전위
    public static void preorder(Node node) {
        if(node == null) {
            return; 
        }
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);


    }

    //중위
    public static void inorder(Node node) {
        if(node == null) {
            return; 
        }
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);


    }


    //후위 l -> r -> I
    public static void postorder(Node node) {
        if(node == null) {
            return; 
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);

    }
}
