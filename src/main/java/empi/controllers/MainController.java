package empi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import empi.service.JavaTestService;
import empi.service.UserService;

@RestController
public class MainController
{
  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  @Autowired
  private UserService userService;

  @Autowired
  private JavaTestService javaTestService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index()
  {
    return userService.getSignature();
  }

  @RequestMapping(value = "/getAll", method = RequestMethod.GET)
  public String getAll()
  {
    return userService.getAll();
  }

  @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
  public String getUserById(int id)
  {
    return userService.getUserById(id);
  }

  @RequestMapping(value = "/create", method = RequestMethod.GET)
  public String create(String email, String name)
  {
    return userService.create(email, name);
  }

  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public String delete(int id)
  {
    return userService.delete(id);
  }

  @RequestMapping(value = "/fizzBuzz", method = RequestMethod.GET)
  public String fizzBuzz(int n)
  {
    return javaTestService.fizzBuzz(n);
  }

  @RequestMapping(value = "/showLinkedList", method = RequestMethod.GET)
  public String showLinkedList()
  {
    return javaTestService.showLinkedList();
  }

  @RequestMapping(value = "/removeNode", method = RequestMethod.GET)
  public String removeNode(int x)
  {
    return javaTestService.removeNode(x);
  }

  @RequestMapping(value = "/resetLinkedList", method = RequestMethod.GET)
  public String resetLinkedList()
  {
    return javaTestService.resetLinkedList();
  }
}
