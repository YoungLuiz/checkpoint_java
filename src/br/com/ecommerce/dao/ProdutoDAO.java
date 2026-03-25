package br.com.ecommerce.dao;

import br.com.ecommerce.util.ConexaoSingleton;
import br.com.ecommerce.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void inserir(Produto produto) {
        String sql = "INSERT INTO PRODUTO (ID, NOME, PRECO) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoSingleton.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPreco());

            stmt.executeUpdate();
            System.out.println("Produto inserido!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM PRODUTO";

        try (Connection conn = ConexaoSingleton.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto p = new Produto(
                        rs.getInt("ID"),
                        rs.getString("NOME"),
                        rs.getDouble("PRECO")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }
}
