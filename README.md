# Sistema de Produtos e Cupons

Projeto desenvolvido em *Java com integração ao Oracle Database*, com o objetivo de gerenciar produtos e aplicar cupons de desconto via terminal.

---

## Funcionalidades

-  Cadastrar produtos  
-  Listar produtos  
-  Criar cupons de desconto  
-  Aplicar cupom em produtos  
-  Tratamento de erros (cupom inválido, duplicidade, conexão)

---

## Tecnologias Utilizadas

- *Java*
- *Oracle Database*
- *JDBC*
- *IntelliJ IDEA*

---

## Arquitetura do Projeto

Estrutura organizada por responsabilidade:

```bash
src/
└── cp/
    ├── model/
    │   ├── Produto.java
    │   └── Promocao.java
    │
    ├── dao/
    │   ├── ProdutoDAO.java
    │   └── PromocaoDAO.java
    │
    ├── service/
    │   └── CupomService.java
    │
    ├── exception/
    │   └── CupomInvalidoException.java
    │
    ├── util/
    │   └── ConexaoSingleton.java
    │
    └── app/
        └── Main.java
