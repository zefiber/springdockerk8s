
package empi.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import empi.models.User;

public class TestController extends ApplicationTests
{

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @Before
  public void setup()
  {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void testGetAllUsers() throws Exception
  {

    User user1 = new User("ze1", "ze1@gmail.com");
    user1.setId(1);
    User user2 = new User("ze2", "ze2@gmail.com");
    user2.setId(2);
    User user3 = new User("ze3", "ze3@gmail.com");
    user3.setId(3);
    StringBuilder testResult = new StringBuilder();
    testResult.append(user1.toString());
    testResult.append("\n");
    testResult.append(user2.toString());
    testResult.append("\n");
    testResult.append(user3.toString());
    testResult.append("\n");
    mockMvc.perform(get("/getAll")).andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=UTF-8"))
        .andExpect(content().string(containsString(testResult.toString())));

  }

}