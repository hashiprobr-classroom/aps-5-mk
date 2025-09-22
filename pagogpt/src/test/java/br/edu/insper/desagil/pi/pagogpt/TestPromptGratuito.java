package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPromptGratuito {
    private PromptGratuito pg;

    @BeforeEach
    public void setUp() {
        pg = new PromptGratuito(10,"pergunta ");
    }

    @Test
    public void precoCurto() {
        assertEquals(0,pg.calculaPreco());
    }

    @Test
    public void precoLongo() {
        pg = new PromptGratuito(10,"pergunta longa");
        assertEquals(14,pg.calculaPreco());
    }
}
