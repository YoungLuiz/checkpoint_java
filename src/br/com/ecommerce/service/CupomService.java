package br.com.ecommerce.service;

import br.com.ecommerce.exception.CupomInvalidoException;
import br.com.ecommerce.dao.PromocaoDAO;
import br.com.ecommerce.model.Promocao;

public class CupomService {

    private PromocaoDAO promocaoDAO;

    public CupomService(PromocaoDAO promocaoDAO) {
        this.promocaoDAO = promocaoDAO;
    }

    public double aplicarCupom(String codigo, double valorCompra) throws CupomInvalidoException {

        Promocao promo = promocaoDAO.buscarTESTE(codigo);

        if (promo == null) {
            throw new CupomInvalidoException("Cupom não encontrado");
        }

        if (!promo.isAtivo()) {
            throw new CupomInvalidoException("Cupom inativo");
        }

        if (valorCompra < promo.getValorMinimo()) {
            throw new CupomInvalidoException("Valor mínimo não atingido");
        }

        if (promo.getTipoDesconto().equalsIgnoreCase("PERCENTUAL")) {
            return valorCompra - (valorCompra * promo.getValorDesconto() / 100);
        } else {
            return valorCompra - promo.getValorDesconto();
        }
    }
}