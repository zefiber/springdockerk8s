package empi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import empi.Application;
import empi.dao.UserRepository;
import empi.models.LinkedListNode;
import empi.models.User;

@RestController
public class MainController
{
  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  @Autowired
  private UserRepository userRepository;

  @Value("${zeSignature}")
  private String zeSignature;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  @ResponseBody
  public String index()
  {
    return "Proudly handcrafted by " + zeSignature + " ! :)";
  }

  @RequestMapping(value = "/getAll", method = RequestMethod.GET)
  @ResponseBody
  public String getAll()
  {
    StringBuilder strBuilder = new StringBuilder();
    List<User> userList = new ArrayList<User>();
    try
    {
      userList = userRepository.findAll();
    }
    catch (Exception ex)
    {
      return ex.getMessage();
    }

    for (User user : userList)
    {
      strBuilder.append(user.toString());
      strBuilder.append("\n");
    }
    return strBuilder.toString();
  }

  @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
  @ResponseBody
  public String getUserById(int id)
  {
    User user = new User();
    try
    {
      user = userRepository.findUserById(id);
    }
    catch (Exception ex)
    {
      return ex.getMessage();
    }
    return user.toString();
  }

  /**
   * /create --> Create a new user and save it in the database.
   * 
   * @param email
   *          User's email
   * @param name
   *          User's name
   * @return A string describing if the user is successfully created or not.
   */
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  @ResponseBody
  public String create(String email, String name)
  {
    User user = null;
    try
    {
      user = new User(email, name);
      userRepository.create(user);
    }
    catch (Exception ex)
    {
      return "Error creating the user: " + ex.toString();
    }
    return "User succesfully created! (id = " + user.getId() + ")";
  }

  /**
   * /delete --> Delete the user having the passed id.
   * 
   * @param id
   *          The id of the user to delete
   * @return A string describing if the user is successfully deleted or not.
   */
  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  @ResponseBody
  public String delete(int id)
  {
    User user = null;
    String retMsg = "";
    try
    {
      user = userRepository.findUserById(id);
      if (userRepository.delete(id) > 0)
      {
        retMsg = "User id:" + user.getId() + " user name:" + user.getName()
            + " successfully deleted!";
      }
      else
      {
        retMsg = "No such user id founded. ";
      }
    }
    catch (Exception ex)
    {
      return "Error deleting the user: " + ex.toString();
    }
    return retMsg;
  }

  /**
   * /fizzBuzz --> Print fizz, Buzz or fizzBuzz.
   * 
   * @param n
   *          the number of the element to print
   * @return A list of fizz buzz print out.
   */
  @RequestMapping(value = "/fizzBuzz", method = RequestMethod.GET)
  @ResponseBody
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
  @RequestMapping(value = "/showLinkedList", method = RequestMethod.GET)
  @ResponseBody
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
  @RequestMapping(value = "/removeNode", method = RequestMethod.GET)
  @ResponseBody
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
  @RequestMapping(value = "/resetLinkedList", method = RequestMethod.GET)
  @ResponseBody
  public String resetLinkedList()
  {
    Application.LinkedListNodeInializer();
    return Application.linkedList.toString();
  }
}
