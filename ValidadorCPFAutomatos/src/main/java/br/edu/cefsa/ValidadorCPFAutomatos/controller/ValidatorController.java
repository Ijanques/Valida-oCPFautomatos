package br.edu.cefsa.ValidadorCPFAutomatos.controller;

import br.edu.cefsa.ValidadorCPFAutomatos.service.CpfService;
import br.edu.cefsa.ValidadorCpfAutomatos.service.RgService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ValidatorController {

    private final CpfService cpfService;
    private final RgService rgService;

    public ValidatorController(CpfService cpfService, RgService rgService) {
        this.cpfService = cpfService;
        this.rgService = rgService;
    }

    @GetMapping("/")
    public String index() {
        return "index"; // Retorna o template index.html
    }

    @PostMapping("/validar-documento")
    public String validarDocumento(
            @RequestParam("tipo_documento") String tipoDocumento, // Recebe o tipo de documento (cpf ou rg)
            @RequestParam("documento") String documento, // Recebe o número do documento
            Model model) {

        boolean isValid = false;
        String resultado;

        // Verifica o tipo de documento e chama o serviço correspondente
        if (tipoDocumento.equals("cpf")) {
            isValid = cpfService.validarCpf(documento); // Valida CPF
            resultado = isValid ? "CPF válido!" : "CPF inválido!";
        } else if (tipoDocumento.equals("rg")) {
            isValid = rgService.validarRG(documento); // Valida RG
            resultado = isValid ? "RG válido!" : "RG inválido!";
        } else {
            resultado = "Tipo de documento inválido!";
        }

        // Adiciona o resultado e o documento ao modelo para exibição na página
        model.addAttribute("resultado", resultado);
        model.addAttribute("documento", documento);
        model.addAttribute("tipoDocumento", tipoDocumento); // Passa o tipo de documento de volta para a view

        return "index"; // Retorna o template index.html com o resultado
    }
}