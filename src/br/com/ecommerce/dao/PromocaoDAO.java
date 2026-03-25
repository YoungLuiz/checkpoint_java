package br.com.ecommerce.dao;

import br.com.ecommerce.util.ConexaoSingleton;
import br.com.ecommerce.model.Promocao;

import java.sql.*;

public class PromocaoDAO {

    public void inserir(Promocao p) {
        String sql = "INSERT INTO PROMOCAO VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoSingleton.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getCodigoCupom());
            stmt.setString(2, p.getTipoDesconto());
            stmt.setDouble(3, p.getValorDesconto());
            stmt.setDate(4, Date.valueOf(p.getDataValidade()));
            stmt.setInt(5, p.isAtivo() ? 1 : 0);
            stmt.setDouble(6, p.getValorMinimo());

            stmt.executeUpdate();
            System.out.println("Cupom criado!");

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Promocao buscarTESTE(String codigo) {
        String sql = "SELECT * FROM PROMOCAO WHERE CODIGO = ?";

        try (Connection conn = ConexaoSingleton.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Promocao(
                        rs.getString("CODIGO"),
                        rs.getString("TIPO_DESCONTO"),
                        rs.getDouble("VALOR_DESCONTO"),
                        rs.getDate("DATA_VALIDADE").toLocalDate(),
                        rs.getInt("ATIVO") == 1,
                        rs.getDouble("VALOR_MINIMO")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return null;
    }
}