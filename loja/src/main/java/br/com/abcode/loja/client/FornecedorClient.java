package br.com.abcode.loja.client;

import br.com.abcode.loja.controller.dto.InfoFornecedorDTO;
import br.com.abcode.loja.controller.dto.InfoPedidoDTO;
import br.com.abcode.loja.controller.dto.ItemDaCompraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{estado}")
    InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

    @RequestMapping(method= RequestMethod.POST, value="/pedido")
    InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens);
}
