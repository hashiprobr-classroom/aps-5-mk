package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConversaTest {
    public static final double DELTA = 0.01;
    private Conversa c;

    @BeforeEach
    public void setUp() {
        c = new Conversa(new Usuario("felipem@gmail.com","felipe"));
    }

    @Test
    public void subTotalVazio() {
        assertEquals(0,c.calculaSubTotal());
    }

    @Test
    public void subTotal() {
        c.adiciona(criaPrompt(6)); //39*0.12 = 6
        c.adiciona(criaPrompt(1.8)); //13*0.12 = 1.8
        c.adiciona(criaPrompt(1.32));
        assertEquals(9.12,c.calculaSubTotal(), DELTA);
    }

    @Test
    void porPostVazio() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            c.calculaSubMedia();
        });
        assertEquals("Nenhum prompt!", exception.getMessage());
    }

    @Test
    public void porPost() {
        c.adiciona(criaPrompt(6)); //39*0.12 = 6
        c.adiciona(criaPrompt(1.8)); //13*0.12 = 1.8
        c.adiciona(criaPrompt(1.32)); //12*0.12 == 1.68
        assertEquals(9.12/3,c.calculaSubMedia(), DELTA);
    }

    private Prompt criaPrompt(double preco) {
        Prompt prompt = mock(Prompt.class);
        when(prompt.calculaPreco()).thenReturn(preco);
        return prompt;
    }
}




