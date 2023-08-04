package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Compras;
import util.ConnectionFactory;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;

public class ComprasDao {


    public ComprasDao(){}
    
    public void insertCompras(Compras compras){

        String sql = "INSERT INTO compras(valor,observacoes,data,recebida) VALUES(?,?,?,?)";

        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement pst = connection.prepareStatement(sql)) {
            
            pst.setBigDecimal(1, compras.getValor());
            pst.setString(2, compras.getObservacoes());

            pst.setDate(3, java.sql.Date.valueOf(compras.getData()));
            pst.setBoolean(4, compras.getRecebida());

            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listCompras(){

        String sql = "SELECT *FROM compras";

        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery()) {
            
            
            while(rs.next()){

                Long id = rs.getLong("id");
                BigDecimal valor = rs.getBigDecimal("valor");
                String observacoes = rs.getString("observacoes");
                java.sql.Date data = rs.getDate("data");
                boolean recebida = rs.getBoolean("recebida");

                System.out.println("Id: " + id);
                System.out.println("Valor: " + valor);
                System.out.println("Observações: " + observacoes);
                System.out.println("Data: " + data);
                System.out.println("Recebida: " + recebida);

            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

        public void updateCompras(Compras compras){

            String sql = "UPDATE compras SET valor = ?, observacoes = ?, data = ?, recebida = ? " +
            "WHERE id = ? ";

            try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement pst = connection.prepareStatement(sql)) {
                
                pst.setBigDecimal(1, compras.getValor());
                pst.setString(2, compras.getObservacoes());

                pst.setDate(3, java.sql.Date.valueOf(compras.getData()));
                pst.setBoolean(4, compras.getRecebida());
                pst.setLong(5, compras.getId());

                pst.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void deleteCompras(long id){

            String sql = "DELETE FROM compras WHERE id = ?";

            try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement pst = connection.prepareStatement(sql)) {
                
                pst.setLong(1, id);
                pst.execute();
            
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

