package br.com.abcode.loja.service;

import br.com.abcode.loja.client.FornecedorClient;
import br.com.abcode.loja.controller.dto.CompraDTO;
import br.com.abcode.loja.controller.dto.InfoFornecedorDTO;
import br.com.abcode.loja.controller.dto.InfoPedidoDTO;
import br.com.abcode.loja.model.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    private FornecedorClient fornecedorClient;


    public Compra realizaCompra(CompraDTO compra) {

        final String estado = compra.getEndereco().getEstado();

        InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(estado);

        InfoPedidoDTO infoPedido = fornecedorClient.realizaPedido(compra.getItens());

        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(infoPedido.getId());
        compraSalva.setTempoDePreparo(infoPedido.getTempoDePreparo());
        compraSalva.setEnderecoDestino(info.getEndereco());

        System.out.println(info.getEndereco());

        return compraSalva;
    }
}
