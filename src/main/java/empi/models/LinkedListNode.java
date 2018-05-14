package empi.models;

public class LinkedListNode
{
  public int val;
  public LinkedListNode next;

  public LinkedListNode(int node_value)
  {
    val = node_value;
    next = null;
  }

  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    LinkedListNode current = this;
    sb.append(current.val);
    while (current.next != null)
    {
      sb.append(" => ");
      current = current.next;
      sb.append(current.val);
    }
    return sb.toString();
  }
};