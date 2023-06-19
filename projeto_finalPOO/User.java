public class User {
    private int id;
    private String name;
    private int age;
    private String role;
    private String password;

    public User( String name, int age,String password, String role) {
       
        this.name = name;
        this.password = password;
        this.age = age;
        this.role = role;
    }

	public int getId() {
        return id;
    }
	
    public void setId(int id) {
        this.id = id;
    }

	
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String getPassword() {
        return password;
    }
    
	public void setPassword(String password) {
		this.password = password;
		
	}
}

