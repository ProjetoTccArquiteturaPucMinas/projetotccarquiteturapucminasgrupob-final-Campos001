package com.seuprojeto.marketplace.domain.model;

import java.math.BigDecimal;

public class ResumoCarrinho {

    private BigDecimal subtotal;
    private BigDecimal desconto;
    private BigDecimal total;

    public ResumoCarrinho(BigDecimal subtotal, BigDecimal desconto) {
        this.subtotal = subtotal;
        this.desconto = desconto;
        this.total = subtotal.subtract(desconto);
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
        atualizarTotal();
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
        atualizarTotal();
    }

    public BigDecimal getTotal() {
        return total;
    }

    private void atualizarTotal() {
        if (subtotal != null && desconto != null) {
            this.total = subtotal.subtract(desconto);
        }
    }

    private void CalcularDesconto(List<Produto> produtos) {
        BigDecimal descontoTotal = new BigDecimal(0);

        for(int i = 0; i < produtos.size(); i++) {
            BigDecimal descontoPorCategoria = CalcularDescontoPorCategoria(produtos.get(i));
            descontoTotal = descontoTotal.add(descontoPorCategoria);
        }
         descontoPorCategoria.CalcularDescontoPorQuantidade(descontoPorQuantidade);
        if(descontoTotal >= 0.25){
            descontoTotal = descontoTotal
        }
        else{
            desconto = descontoTotal; 
        }
    }
    private BigDecimal CalcularDescontoPorCategoria(Produto produto) {
        return produto.getCategoriaProduto().getpercentualDesconto();
    }
    private BigDecimal CalcularDescontoPorQuantidade(List<Produto> produtos) {

        switch (produtos.size()) {
            case 0:
                return new BigDecimal(0);
            case 1:
                return new BigDecimal(0);
            case 2:
                return new BigDecimal(0.05);
            case 3:
                return new BigDecimal(0.07);
            default:
                return new BigDecimal(0.1);
        }
    }
    private void CalcularTotal(){
        if(this.desconto <= 0 || this.desconto != null && this.subtotal >= 0 || this.subtotal != null){
           this.total = this.subtotal * this.desconto;
        }
        else{
            return this.total;
        }
    }
}