import java.util.Arrays;
/**
 * Created by David Omenyo on 10/11/2016.
 */
public class Node {
    public int size; //indicating the number of elements that are in use.
    public Integer[] head;
    public Node tail;

    public Node(int length){
        head = new Integer[length];
        size = 0;
    }

    public String toString(){

        if(tail == null) {
            return Arrays.deepToString(head);
        }
        else {
            return Arrays.deepToString(head) + tail.toString();
        }
    }
}
