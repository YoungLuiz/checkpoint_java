package br.com.ecommerce.app;

import br.com.ecommerce.dao.ProdutoDAO;
import br.com.ecommerce.dao.PromocaoDAO;
import br.com.ecommerce.exception.CupomInvalidoException;
import br.com.ecommerce.model.Produto;
import br.com.ecommerce.model.Promocao;
import br.com.ecommerce.service.CupomService;

import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProdutoDAO produtoDAO = new ProdutoDAO();
        PromocaoDAO promocaoDAO = new PromocaoDAO();
        CupomService service = new CupomService(promocaoDAO);

        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Criar Cupom");
            System.out.println("4 - Aplicar Cupom");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();

                    produtoDAO.inserir(new Produto(id, nome, preco));
                    break;

                case 2:
                    List<Produto> produtos = produtoDAO.listar();
                    for (Produto p : produtos) {
                        System.out.println(p.getNome() + " - R$" + p.getPreco());
                    }
                    break;

                case 3:
                    sc.nextLine();

                    System.out.print("Código: ");
                    String codigo = sc.nextLine();

                    System.out.print("Tipo (PERCENTUAL/VALOR): ");
                    String tipo = sc.nextLine();

                    System.out.print("Valor desconto: ");
                    double valor = sc.nextDouble();

                    System.out.print("Dias validade: ");
                    int dias = sc.nextInt();

                    System.out.print("Valor mínimo: ");
                    double min = sc.nextDouble();

                    Promocao promo = new Promocao(
                            codigo,
                            tipo,
                            valor,
                            LocalDate.now().plusDays(dias),
                            true,
                            min
                    );

                    promocaoDAO.inserir(promo);
                    break;

                case 4:
                    sc.nextLine();

                    System.out.print("Código do cupom: ");
                    String cupom = sc.nextLine();

                    System.out.print("Valor da compra: ");
                    double compra = sc.nextDouble();

                    try {
                        double finalValor = service.aplicarCupom(cupom, compra);
                        System.out.println("Valor final: R$" + finalValor);
                    } catch (CupomInvalidoException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}