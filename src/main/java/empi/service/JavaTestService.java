package empi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import empi.Application;
import empi.dao.UserRepository;
import empi.models.LinkedListNode;

@Service("JavaTestService")
public class JavaTestService
{
  @Autowired
  private UserRepository userRepository;

  /**
   * /fizzBuzz --> Print fizz, Buzz or fizzBuzz.
   * 
   * @param n
   *          the number of the element to print
   * @return A list of fizz buzz print out.
   */
  public String fizzBuzz(int n)
  {
    StringBuilder retMsg = new StringBuilder();
    if (n < 0 || n > 2 * Integer.parseInt(Integer.toBinaryString(2 << 4)))
    {
      retMsg.append("Out of boundry");
      return retMsg.toString();
    }

    for (int i = 1; i < n + 1; i++)
    {
      if (i % 3 == 0 && i % 5 == 0)
      {
        retMsg.append("FizzBuzz");
        retMsg.append("<br>");
      }
      else if (i % 3 == 0)
      {
        retMsg.append("Fizz");
        retMsg.append("<br>");
      }
      else if (i % 5 == 0)
      {
        retMsg.append("Buzz");
        retMsg.append("<br>");
      }
      else
      {
        retMsg.append(i);
        retMsg.append("<br>");
      }
    }

    return retMsg.toString();
  }

  /**
   * /show Linked list --> display linked list
   * 
   * @return show the initial linked list
   */
  public String showLinkedList()
  {
    return Application.linkedList.toString();
  }

  /**
   * /removeNode --> Remove a node from linked list
   * 
   * @param x
   *          if the x is greater than any value from the linked list, remove
   *          the node
   * @return A new linked list
   */
  public String removeNode(int x)
  {
    LinkedListNode list = Application.linkedList;
    if (list == null
        || x > 2 * Integer.parseInt(Integer.toBinaryString(2 << 4)))
    {
      return "Out of Boundry";
    }

    if (list.val > x && list.next == null)
    {
      return list.toString();
    }

    LinkedListNode cur = list;
    LinkedListNode prev = null;

    while (cur != null && cur.val > x)
    {
      prev = cur;
      cur = cur.next;
    }

    if (prev != null)
    {
      prev.next = null;
    }

    if (cur == null)
    {
      Application.linkedList = null;
      return "";
    }

    LinkedListNode newHead = cur;

    while (cur.next != null)
    {
      if (cur.next.val > x)
      {
        cur.next = cur.next.next;
      }
      else
      {
        cur = cur.next;
      }
    }

    Application.linkedList = newHead;

    return newHead.toString();
  }

  /**
   * /rest Linked list --> rest linked list
   * 
   * @return show the initial linked list
   */
  public String resetLinkedList()
  {
    Application.LinkedListNodeInializer();
    return Application.linkedList.toString();
  }

}
