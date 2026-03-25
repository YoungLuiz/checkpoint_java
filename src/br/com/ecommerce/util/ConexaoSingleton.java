package br.com.ecommerce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSingleton {

    private static Connection conexao;

    private ConexaoSingleton() {
    }

    public static Connection getConexao() {
        try {
            if (conexao == null || conexao.isClosed()) {

                conexao = DriverManager.getConnection(
                        "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
                        "rm560110",
                        "fiap2025"
                );

                System.out.println("Conectado ao Oracle!");
            }
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }

        return conexao;
    }
}
