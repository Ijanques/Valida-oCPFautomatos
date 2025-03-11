package br.edu.cefsa.ValidadorCpfAutomatos.service;

import org.springframework.stereotype.Service;

@Service
public class RgService {

    public boolean validarRG(String rg) {
        boolean temPonto = false;
        int contador = 9;
        int primeiroValidador = 0;

        // Verifica se o RG tem o tamanho esperado
        if (rg.length() != 12 && rg.length() != 9) {
            return false;
        }

        for (int i = 0; i < rg.length(); i++) {
            switch (i) {
                case 0, 1, 3, 4, 5, 7, 9 -> {
                    if (isConvertibleToInt(Character.toString(rg.charAt(i)))) {
                        primeiroValidador += (Integer.parseInt(Character.toString(rg.charAt(i))) * contador);
                        contador--;
                    } else {
                        return false;
                    }
                }
                case 2 -> {
                    if (isConvertibleToInt(Character.toString(rg.charAt(i)))) {
                        primeiroValidador += (Integer.parseInt(Character.toString(rg.charAt(i))) * contador);
                        contador--;
                    } else if (rg.charAt(i) == '.') {
                        temPonto = true;
                    } else {
                        return false;
                    }
                }
                case 6 -> {
                    if (isConvertibleToInt(Character.toString(rg.charAt(i))) && !temPonto) {
                        primeiroValidador += (Integer.parseInt(Character.toString(rg.charAt(i))) * contador);
                        contador--;
                    } else if (rg.charAt(i) == '.' && temPonto) {
                        // Continua
                    } else {
                        return false;
                    }
                }
                case 8 -> {
                    if (isConvertibleToInt(Character.toString(rg.charAt(i))) && temPonto) {
                        primeiroValidador += (Integer.parseInt(Character.toString(rg.charAt(i))) * contador);
                        contador--;
                    } else if (!temPonto) {
                        // Verifica o dígito verificador
                        int digitoVerificador = (primeiroValidador * 10) % 11;
                        if (digitoVerificador == 10) {
                            return "x".equalsIgnoreCase(Character.toString(rg.charAt(i)));
                        } else {
                            return Character.toString(rg.charAt(i)).equals(Integer.toString(digitoVerificador));
                        }
                    } else {
                        return false;
                    }
                }
                case 10 -> {
                    if (rg.charAt(i) == '-' && temPonto) {
                        // Continua
                    } else {
                        return false;
                    }
                }
                case 11 -> {
                    if (isConvertibleToInt(Character.toString(rg.charAt(i))) && temPonto) {
                        // Verifica o dígito verificador
                        int digitoVerificador = (primeiroValidador * 10) % 11;
                        if (digitoVerificador == 10) {
                            return "x".equalsIgnoreCase(Character.toString(rg.charAt(i)));
                        } else {
                            return Character.toString(rg.charAt(i)).equals(Integer.toString(digitoVerificador));
                        }
                    } else {
                        return false;
                    }
                }
                default -> {
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean isConvertibleToInt(String str) {
        try {
            if (!str.isEmpty()) {
                Integer.parseInt(str);
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}