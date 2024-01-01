// Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock

import java.util.LinkedList;

class Main {
    public static void main(String[] args) {
        
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("This");
        linkedList.add("is");
        linkedList.add("an");
        linkedList.add("example");
        linkedList.add("of");
        linkedList.add("LinkedList");
        
        System.out.println("The total items into linked list are: " + linkedList);
        
        // iterating linked list element and getting using get() method.
        for(int i=0; i<linkedList.size(); i++) {
            System.out.println(linkedList.get(1));
        }
        
        // removing items from linked list
        linkedList.remove(2);
        linkedList.remove(String.valueOf("of"));
        System.out.println("The total items after removing one items from linked list are: " + linkedList);

    }
}
