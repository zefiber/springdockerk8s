package empi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import empi.dao.UserRepository;
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

}
