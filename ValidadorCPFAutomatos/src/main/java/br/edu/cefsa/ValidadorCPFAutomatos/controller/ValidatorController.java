package br.edu.cefsa.ValidadorCPFAutomatos.controller;

import br.edu.cefsa.ValidadorCPFAutomatos.service.CpfService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Certifique-se de que a anotação @Controller está presente
public class ValidatorController {

    private final CpfService cpfService;

    public ValidatorController(CpfService cpfService) {
        this.cpfService = cpfService;
    }

    @GetMapping("/")
    public String index() {
        return "index"; // Retorna o template index.html
    }

    @PostMapping("/validar-cpf") // Certifique-se de que o caminho está correto
    public String validarCpf(@RequestParam("cpf") String cpf, Model model) {
        boolean isValid = cpfService.validarCpf(cpf);
        String resultado = isValid ? "CPF válido!" : "CPF inválido!";
        model.addAttribute("resultado", resultado);
        return "index"; // Retorna o template index.html com o resultado
    }
}