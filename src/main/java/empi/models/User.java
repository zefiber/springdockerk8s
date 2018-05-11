package empi.models;

public class User
{
  public User(String name, String email)
  {
    super();
    this.name = name;
    this.email = email;
  }

  public User(Integer id)
  {
    super();
    this.id = id;
  }

  public User()
  {
    super();
  }

  @Override
  public String toString()
  {
    return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
  }

  private Integer id;
  private String name;
  private String email;

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }
}