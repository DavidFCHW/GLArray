import java.util.Random; //for main method testing only. Not used in the class itself.
/**
 * Created by David Omenyo on 10/11/2016.
 */
public class GLArray {

    public static int length(Node n){
        if(n.tail != null){
            return n.size + length(n.tail);
        }
        else{
            return n.size;
        }

    }

    /**
     *get() steps
     * 1.Check if index satisfies
     * 2.If not then index - node.size
     * 3.node = node.tail, go to 1
     */
    public static Integer get(Node n, int index) throws ArrayIndexOutOfBoundsException{
        if(index >= length(n)){
            throw new ArrayIndexOutOfBoundsException("Please enter a valid index.");
        }
        else if(index >= n.head.length){
            index -= n.size;
            n = n.tail;
            get(n,index);
        }
        else if(index < n.head.length) {
            return n.head[index];
        }
        return get(n,index);
    }

    /**
     * add() has three cases:
     * 1. Space in the spec. node
     * 2. No space in the spec. node but tail == null.
     * 3. No space in the spec. node but tail != null
    */
    public static void add(Node n, Integer element){
        //first case
        if(n.size < n.head.length){
            n.head[n.size] = element;
            n.size++;
        }
        //second case
        else if(n.size == n.head.length && n.tail == null){
            n.tail = new Node(n.head.length*2);
            n = n.tail;
            add(n, element);
        }
        //third case
        else if(n.size == n.head.length){
            n = n.tail;
            add(n, element);
        }
    }

    public static void main(String[] args){
        Node node = new Node(1);
        Random rand = new Random();
        for(int i = 1; i <= 5; i++){
            add(node, rand.nextInt(30));
        }
        System.out.println(node.toString());
        System.out.println("Your requested element is: " + get(node, 4));
        System.out.println("The length of GLArray is: " + length(node));
    }

    /*
    Efficiency quest\}
