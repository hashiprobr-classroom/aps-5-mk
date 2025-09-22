package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestPromptPago {
    private PromptPago pp;

    @BeforeEach
    public void setUp() {
        pp =new PromptPago("pergunta", 0.1);
    }

    @Test
    public void constroi() {
        assertEquals("pergunta",pp.getPergunta());
        assertNull(pp.getResposta());
    }

    @Test
    public void mudaResposta() {
        pp.setResposta("resposta");
        assertEquals("resposta",pp.getResposta());
    }

    @Test
    public void preco() {
        assertEquals(0.8,pp.calculaPreco());
    }
}
