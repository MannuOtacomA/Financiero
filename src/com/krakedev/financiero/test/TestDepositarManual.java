package com.krakedev.financiero.test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestDepositarManual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Banco banco = new Banco();
        Cliente cliente = new Cliente("1712345678", "Juan", "Perez");
        Cuenta cuenta = banco.crearCuenta(cliente);

        System.out.println("=== SALDO INICIAL ===");
        cuenta.imprimir();  // Saldo: 0.0

        System.out.println("\n=== DEPOSITAR 500 ===");
        boolean r1 = banco.depositar(500, cuenta);
        System.out.println("¿Depósito exitoso? " + r1);  // true
        cuenta.imprimir();  // Saldo: 500.0

        System.out.println("\n=== DEPOSITAR 300 ===");
        boolean r2 = banco.depositar(300, cuenta);
        System.out.println("¿Depósito exitoso? " + r2);  // true
        cuenta.imprimir();  // Saldo: 800.0

        System.out.println("\n=== DEPOSITAR -100 (INVÁLIDO) ===");
        boolean r3 = banco.depositar(-100, cuenta);
        System.out.println("¿Depósito exitoso? " + r3);  // false
        cuenta.imprimir();  // Saldo: 800.0 (no cambia)

        System.out.println("\n=== DEPOSITAR 0 (INVÁLIDO) ===");
        boolean r4 = banco.depositar(0, cuenta);
        System.out.println("¿Depósito exitoso? " + r4);  // false
        cuenta.imprimir();  // Saldo: 800.0 (no cambia)

	}

}
