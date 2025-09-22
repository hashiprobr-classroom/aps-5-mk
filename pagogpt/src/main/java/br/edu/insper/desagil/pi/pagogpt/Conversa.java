package br.edu.insper.desagil.pi.pagogpt;

import java.util.ArrayList;
import java.util.List;

public class Conversa {
    private Usuario usuario;
    private List<Prompt> prompts;

    public Conversa(Usuario usuario) {
        this.usuario = usuario;
        this.prompts = new ArrayList<>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void adiciona(Prompt prompt) {
        prompts.add(prompt);
    }

    public double calculaSubTotal(){
        return getSoma();
    }

    public double calculaSubMedia(){
        if (prompts.isEmpty()) {
            throw new IllegalStateException("Nenhum prompt!");
        }
        else {
            return getSoma()/prompts.size();
        }
    }

    private double getSoma() {
        double soma = 0;
        for (Prompt prompt : prompts) {
            soma += prompt.calculaPreco();
        }
        return soma;
    }
}
