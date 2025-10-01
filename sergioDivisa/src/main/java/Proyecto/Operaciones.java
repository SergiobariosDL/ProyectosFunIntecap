/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author Precision
 */
public class Operaciones {
    
    private double valor, resultado;
    private int divisa, divisafinal;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getDivisa(int divisa1) {
        return divisa;
    }

    public void setDivisa(int divisa) {
        this.divisa = divisa;
    }

    public int getDivisafinal(int divisafinal1) {
        return divisafinal;
    }

    public void setDivisafinal(int divisafinal) {
        this.divisafinal = divisafinal;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    
    
    //constructor

    public Operaciones() {
    }
    
    // Ejemplo de Constantes de Tasa de Cambio
private static final double Q_TO_USD = 7.54;  // Cuántos Quetzales hay en 1 Dólar
private static final double P_TO_USD = 18.32; // Cuántos Pesos hay en 1 Dólar
private static final double USD_TO_EUR = 0.85; // Cuántos Euros hay en 1 Dólar
    
    //operaciones
 public double convertir(){
    
    // 1. Caso: Misma divisa (0 a 0, 1 a 1, 2 a 2, 3 a 3)
    if (divisa == divisafinal){
        resultado = valor;
    }
    
    // --- CONVERSIONES DESDE QUETZALES (0) ---
    // 2. Caso: Quetzales (0) a Pesos (1)
    else if (divisa == 0 && divisafinal == 1){
        // Usando tu tasa inicial para Q -> P
        resultado = valor * 2.39; 
    } 
    // 3. Caso: Quetzales (0) a Dólares (2)
    else if (divisa == 0 && divisafinal == 2){
        resultado = valor / Q_TO_USD; 
    } 
    // 4. Caso: Quetzales (0) a Euros (3)
    else if (divisa == 0 && divisafinal == 3){
        // Convertir Q -> USD, luego USD -> EUR
        resultado = (valor / Q_TO_USD) * USD_TO_EUR; 
    } 
    
    // --- CONVERSIONES DESDE PESOS (1) ---
    // 5. Caso: Pesos (1) a Quetzales (0)
    else if (divisa == 1 && divisafinal == 0){
        // Usando tu tasa inicial para P -> Q
        resultado = valor / 2.39; 
    } 
    // 6. Caso: Pesos (1) a Dólares (2)
    else if (divisa == 1 && divisafinal == 2){
        resultado = valor / P_TO_USD; 
    } 
    // 7. Caso: Pesos (1) a Euros (3)
    else if (divisa == 1 && divisafinal == 3){
        // Convertir P -> USD, luego USD -> EUR
        resultado = (valor / P_TO_USD) * USD_TO_EUR;
    } 
    
    // --- CONVERSIONES DESDE DÓLARES (2) ---
    // 8. Caso: Dólares (2) a Quetzales (0)
    else if (divisa == 2 && divisafinal == 0){
        resultado = valor * Q_TO_USD; 
    } 
    // 9. Caso: Dólares (2) a Pesos (1)
    else if (divisa == 2 && divisafinal == 1){
        resultado = valor * P_TO_USD; 
    } 
    // 10. Caso: Dólares (2) a Euros (3)
    else if (divisa == 2 && divisafinal == 3){
        resultado = valor * USD_TO_EUR; 
    } 
    
    // --- CONVERSIONES DESDE EUROS (3) ---
    // 11. Caso: Euros (3) a Quetzales (0)
    else if (divisa == 3 && divisafinal == 0){
        // Convertir EUR -> USD, luego USD -> Q
        resultado = (valor / USD_TO_EUR) * Q_TO_USD;
    } 
    // 12. Caso: Euros (3) a Pesos (1)
    else if (divisa == 3 && divisafinal == 1){
        // Convertir EUR -> USD, luego USD -> P
        resultado = (valor / USD_TO_EUR) * P_TO_USD;
    } 
    // 13. Caso: Euros (3) a Dólares (2)
    else if (divisa == 3 && divisafinal == 2){
        resultado = valor / USD_TO_EUR; 
    } 
    
    // 14. Caso: Conversión no reconocida (nunca debería ocurrir con la lógica anterior)
    else {
        resultado = 0.0;
    }
    
    return resultado;
}}