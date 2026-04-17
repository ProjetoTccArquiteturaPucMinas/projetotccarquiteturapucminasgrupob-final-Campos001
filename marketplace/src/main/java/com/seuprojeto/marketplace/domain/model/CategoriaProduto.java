package com.seuprojeto.marketplace.domain.model;

public enum CategoriaProduto {
    CAPINHA(0.03),
    CARREGADOR(0.05),
    FONE(0.03),
    PELICULA(0.02),
    SUPORTE(0.02);

    private final BigDecimal percentualDesconto;

    CategoriaProduto(BigDecimal percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public BigDecimal getpercentualDesconto() {
         return categoriaProduto.this.percentualDesconto;
    }   
}