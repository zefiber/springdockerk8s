package empi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import empi.models.LinkedListNode;

@SpringBootApplication
public class Application
{

  public static LinkedListNode linkedList;

  public static void main(String[] args)
  {
    Application.LinkedListNodeInializer();
    SpringApplication.run(Application.class, args);
  }

  public static void LinkedListNodeInializer()
  {
    LinkedListNode node1 = _insert_node_into_singlylinkedlist(null, null, 5);
    LinkedListNode node2 = _insert_node_into_singlylinkedlist(node1, node1, 1);
    LinkedListNode node3 = _insert_node_into_singlylinkedlist(node1, node2, 2);
    LinkedListNode node4 = _insert_node_into_singlylinkedlist(node1, node3, 3);
    LinkedListNode node5 = _insert_node_into_singlylinkedlist(node1, node4, 4);
    LinkedListNode node6 = _insert_node_into_singlylinkedlist(node1, node5, 5);
    LinkedListNode node7 = _insert_node_into_singlylinkedlist(node1, node6, 3);
    linkedList = node1;
  }

  public static LinkedListNode _insert_node_into_singlylinkedlist(
      LinkedListNode head, LinkedListNode tail, int val)
  {
    if (head == null)
    {
      head = new LinkedListNode(val);
      tail = head;
    }
    else
    {
      tail.next = new LinkedListNode(val);
      tail = tail.next;
    }
    return tail;
  }

}
