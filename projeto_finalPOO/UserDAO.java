import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	ConexaoFactory connect = new ConexaoFactory();
	Connection connection = connect.conectar();
	
	public void insere_User(User user){
	    String sql = "INSERT INTO user (name,age,role,password) VALUES (?,?,?,?)";
	    
	    try {
	    	PreparedStatement pstmt = this.connection.prepareStatement(sql);
	    	pstmt.setString(1, user.getName());
	    	pstmt.setInt(2, user.getAge());
	    	pstmt.setString(3, user.getRole());
	    	pstmt.setString(4, user.getPassword());
	    	pstmt.execute();
	    	pstmt.close();
	   }catch(Exception e) {
	    	e.printStackTrace();
	   }
	 }
	 public List<User>  getUser(){
		 String sql = "SELECT * FROM user";

		 List<User> users = new ArrayList<User>();
				try {
					Statement stm = connection.createStatement();
					ResultSet rs = stm.executeQuery(sql);
					while(rs.next()){
								 User user = new User(sql, 0, sql, sql);
								 user.setId(rs.getInt("id"));
					             user.setName(rs.getString("name")); 
					             user.setAge(rs.getInt("age"));
					             user.setRole(rs.getString("role"));
					             user.setPassword(rs.getString("password"));
					             users.add(user);
					} 
			rs.close(); 
			stm.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	  
   	public void editar_user(User user) {
    String sql = "UPDATE user SET name = ?, age = ?, role = ?, password = ? WHERE id = ?";

    try {
        PreparedStatement pstm = this.connection.prepareStatement(sql);
        pstm.setString(1, user.getName());
        pstm.setInt(2, user.getAge());
        pstm.setString(3, user.getRole());
        pstm.setString(4, user.getPassword());
        pstm.setInt(5, user.getId());
        pstm.execute();
        pstm.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
   	
    public User getUserById(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        User user = null;

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                user = new User(rs.getString("name"), rs.getInt("age"), rs.getString("role"),
                        rs.getString("password"));
                user.setId(rs.getInt("id"));
            }

            pstm.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
    
    public void excluir_usuario(User usuario) {
        String sql = "DELETE FROM usuario WHERE id = ?";

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setInt(1, usuario.getId());
            pstm.execute();
            pstm.close();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }
   	
}