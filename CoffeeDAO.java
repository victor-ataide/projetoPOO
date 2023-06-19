import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CoffeeDAO {

    ConexaoFactory connect = new ConexaoFactory();
    Connection connection = connect.conectar();

    public void adicionar_Coffee(Coffee Coffee) {
        String sql = "INSERT INTO Coffee(name, description, price, creator) VALUES (?, ?, ?, ?)";

        try {

            PreparedStatement pstm = connection.prepareStatement(sql);
            // Adiciona valores
            pstm.setString(1, Coffee.getName_Coffee());
            pstm.setString(2, Coffee.getDescription());
            pstm.setDouble(3, Coffee.getPrice());
            pstm.setString(4, Coffee.getCreator());
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Coffee> getCoffee() {
        String sql = "SELECT * FROM coffee";

        List<Coffee> Coffees = new ArrayList<Coffee>();

        try {
            Statement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Coffee coffee = new Coffee(sql, sql, 0, sql);
                coffee.setId(rs.getInt("id"));
                coffee.setName_Coffee(rs.getString("name"));
                coffee.setDescription(rs.getString("description"));
                coffee.setPrice(rs.getDouble("price"));
                coffee.setCreator(rs.getString("creator"));

                Coffees.add(coffee);
            }
            rs.close();
            stm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Coffees;
    }

    public void editar_Coffee(Coffee Coffee) {
        String sql = "UPDATE Coffee SET name = ?, description = ?, price = ?, creator = ? WHERE id = ?";

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setString(1, Coffee.getName());
            pstm.setString(2, Coffee.getDescription());
            pstm.setDouble(3, Coffee.getPrice());
            pstm.setString(4, Coffee.getCreator());
            pstm.setInt(5, Coffee.getId());
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Coffee getCoffeeById(int id) {
        String sql = "SELECT * FROM Coffee WHERE id = ?";
        Coffee Coffee = null;

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Coffee = new Coffee(rs.getString("name"), rs.getString("description"), rs.getDouble("price"),
                        rs.getString("creator"));
                Coffee.setId((rs.getInt("id")));
            }

            pstm.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Coffee;
    }

    public void excluir_Coffee(Coffee Coffee) {
        String sql = "DELETE FROM Coffee WHERE id = ?";

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setInt(1, Coffee.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException var4) {
        }

    }
}
