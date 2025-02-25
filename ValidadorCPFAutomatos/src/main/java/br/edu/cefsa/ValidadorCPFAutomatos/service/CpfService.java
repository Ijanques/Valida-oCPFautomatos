/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.ValidadorCPFAutomatos.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author evand
 */
@Service
public class CpfService {

    public boolean validarCpf(String cpf) {
        boolean temPonto = false;
        int contador = 10;
        int primeiroValidador = 0;
        int segundoValidador = 0;
        for (int i = 0; i < cpf.length(); i = i + 1) {
            switch (i) {
                case 0 -> {
                    if (isConvertibleToInt(Character.toString(cpf.charAt(i))) == true) {
                        primeiroValidador = primeiroValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * contador);
                        segundoValidador = segundoValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * (contador + 1));
                        contador--;
                        break;
                    } else {
                        return false;
                    }
                }
                case 1 -> {
                    if (isConvertibleToInt(Character.toString(cpf.charAt(i))) == true) {
                        primeiroValidador = primeiroValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * contador);
                        segundoValidador = segundoValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * (contador + 1));
                        contador--;
                        break;
                    } else {
                        return false;
                    }
                }
                case 2 -> {
                    if (isConvertibleToInt(Character.toString(cpf.charAt(i))) == true) {
                        primeiroValidador = primeiroValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * contador);
                        segundoValidador = segundoValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * (contador + 1));
                        contador--;
                        break;
                    } else {
                        return false;
                    }
                }
                case 3 -> {
                    if (isConvertibleToInt(Character.toString(cpf.charAt(i))) == true) {
                        primeiroValidador = primeiroValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * contador);
                        segundoValidador = segundoValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * (contador + 1));
                        contador--;
                        break;
                    } else if (cpf.charAt(i) == '.') {
                        temPonto = true;
                        break;
                    } else {
                        return false;
                    }
                }
                case 4 -> {
                    if (isConvertibleToInt(Character.toString(cpf.charAt(i))) == true) {
                        primeiroValidador = primeiroValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * contador);
                        segundoValidador = segundoValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * (contador + 1));
                        contador--;
                        break;
                    } else {
                        return false;
                    }
                }
                case 5 -> {
                    if (isConvertibleToInt(Character.toString(cpf.charAt(i))) == true) {
                        primeiroValidador = primeiroValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * contador);
                        segundoValidador = segundoValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * (contador + 1));
                        contador--;
                        break;
                    } else {
                        return false;
                    }
                }
                case 6 -> {
                    if (isConvertibleToInt(Character.toString(cpf.charAt(i))) == true) {
                        primeiroValidador = primeiroValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * contador);
                        segundoValidador = segundoValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * (contador + 1));
                        contador--;
                        break;
                    } else {
                        return false;
                    }
                }
                case 7 -> {
                    if (isConvertibleToInt(Character.toString(cpf.charAt(i))) == true && temPonto == false) {
                        primeiroValidador = primeiroValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * contador);
                        segundoValidador = segundoValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * (contador + 1));
                        contador--;
                        break;
                    } else if (cpf.charAt(i) == '.' && temPonto == true) {
                        temPonto = true;
                        break;
                    } else {
                        return false;
                    }
                }
                case 8 -> {
                    if (isConvertibleToInt(Character.toString(cpf.charAt(i))) == true) {
                        primeiroValidador = primeiroValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * contador);
                        segundoValidador = segundoValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * (contador + 1));
                        contador--;
                        break;
                    } else {
                        return false;
                    }
                }
                case 9 -> {
                    if (isConvertibleToInt(Character.toString(cpf.charAt(i))) == true && temPonto == true) {
                        primeiroValidador = primeiroValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * contador);
                        segundoValidador = segundoValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * (contador + 1));
                        contador--;
                        break;
                    } else if (isConvertibleToInt(Character.toString(cpf.charAt(i))) == true && temPonto == false) {
                        if (Integer.parseInt(Character.toString(cpf.charAt(i))) == ((primeiroValidador * 10) % 11 == 10 ? 0 : (primeiroValidador * 10) % 11)) {
                            segundoValidador = segundoValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * (contador + 1));
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                case 10 -> {
                    if (isConvertibleToInt(Character.toString(cpf.charAt(i))) == true && temPonto == true) {
                        primeiroValidador = primeiroValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * contador);
                        segundoValidador = segundoValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * (contador + 1));
                        contador--;
                        break;
                    } else if (isConvertibleToInt(Character.toString(cpf.charAt(i))) == true && temPonto == false) {
                        return Integer.parseInt(Character.toString(cpf.charAt(i))) == ((segundoValidador * 10) % 11 == 10 ? 0 : (segundoValidador * 10) % 11);
                    } else {
                        return false;
                    }
                }

                case 11 -> {
                    if (cpf.charAt(i) == '-' && temPonto == true) {
                        temPonto = true;
                    } else {
                        return false;
                    }
                }
                case 12 -> {
                    if (isConvertibleToInt(Character.toString(cpf.charAt(i))) == true && temPonto == true) {
                        if (Integer.parseInt(Character.toString(cpf.charAt(i))) == ((primeiroValidador * 10) % 11 == 10 ? 0 : (primeiroValidador * 10) % 11)) {
                            segundoValidador = segundoValidador + (Integer.parseInt(Character.toString(cpf.charAt(i))) * (contador + 1));
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                case 13 -> {
                    if (isConvertibleToInt(Character.toString(cpf.charAt(i))) == true && temPonto == true) {
                        return Integer.parseInt(Character.toString(cpf.charAt(i))) == ((segundoValidador * 10) % 11 == 10 ? 0 : (segundoValidador * 10) % 11);
                    } else {
                        return false;
                    }
                }
                case 14 -> {
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean isConvertibleToInt(String str) {
        try {
            if (str != "") {
                Integer.parseInt(str);
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
