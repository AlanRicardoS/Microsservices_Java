package com.alan.pagamento.data.vo;

import com.alan.pagamento.entity.Venda;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendaVOTest {

    @Test
    void create() {
        Venda venda = new Venda();
        VendaVO vendaVO = new VendaVO();
        assertEquals(VendaVO.create(venda),vendaVO);
    }
}