
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class ProdutosDAO {

    static boolean atualizarProduto(ProdutosDTO produto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public boolean cadastrarProduto(ProdutosDTO produto) {

        conn = new conectaDAO().connectDB();

        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";

        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());

            int rowsAffected = prep.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Produto cadastrado com sucesso!");
                return true;
            } else {
                System.out.println("Nenhum produto foi cadastrado.");
                return false;
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao cadastrar produto: " + erro.getMessage());
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        ArrayList<ProdutosDTO> listagem = new ArrayList<>();

        String sql = "SELECT * FROM produtos";

        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));

                listagem.add(produto);
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao listar produtos: " + erro.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }

        return listagem;
    }

static boolean atualizarProduto(int id, String novoStatus) {
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            conn = new conectaDAO().connectDB();

            String sql = "UPDATE produtos SET status = ? WHERE id = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, novoStatus);
            prep.setInt(2, id);

            int rowsAffected = prep.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Status do produto atualizado para: " + novoStatus);
                return true;
            } else {
                System.out.println("Nenhum produto foi atualizado.");
                return false;
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao atualizar produto: " + erro.getMessage());
            return false;
        } finally {
            try {
                if (prep != null) {
                    prep.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
public ArrayList<ProdutosDTO> listarProdutosVendidos() {
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        ArrayList<ProdutosDTO> produtosVendidos = new ArrayList<>();

        try {
            conn = new conectaDAO().connectDB();

            String sql = "SELECT * FROM produtos WHERE status = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, "Vendido");
            rs = prep.executeQuery();

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));

                produtosVendidos.add(produto);
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao listar produtos vendidos: " + erro.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (prep != null) {
                    prep.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }

        return produtosVendidos;
    }
}