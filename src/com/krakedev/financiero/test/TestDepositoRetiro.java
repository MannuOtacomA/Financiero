package com.krakedev.financiero.test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestDepositoRetiro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. Crear el banco
        Banco banco = new Banco();
        
        // 2. Crear clientes
        Cliente cliente1 = new Cliente("1712345678", "Juan", "Perez");
        Cliente cliente2 = new Cliente("1798765432", "Maria", "Lopez");
        
     // 3. Crear cuentas usando el servicio del banco
        Cuenta cuenta1 = banco.crearCuenta(cliente1);
        Cuenta cuenta2 = banco.crearCuenta(cliente2);
        
     // 5. Depositar en cuenta1
        System.out.println("\n--- DEPÓSITO DE $500 EN CUENTA 1 ---");
        boolean dep1 = banco.depositar(500, cuenta1);
        System.out.println("¿Depósito exitoso? " + dep1);
        cuenta1.imprimir();
        
     // 6. Depositar en cuenta2
        System.out.println("\n--- DEPÓSITO DE $1000 EN CUENTA 2 ---");
        boolean dep2 = banco.depositar(1000, cuenta2);
        System.out.println("¿Depósito exitoso? " + dep2);
        cuenta2.imprimir();
        
        // 7. Retiro válido de cuenta1
        System.out.println("\n--- RETIRO DE $200 DE CUENTA 1 ---");
        boolean ret1 = banco.retirar(200, cuenta1);
        System.out.println("¿Retiro exitoso? " + ret1);
        cuenta1.imprimir();
        
     // 8. Retiro que excede el saldo (debe fallar)
        System.out.println("\n--- RETIRO DE $600 DE CUENTA 1 (EXCEDE SALDO) ---");
        boolean ret2 = banco.retirar(600, cuenta1);
        System.out.println("¿Retiro exitoso? " + ret2);
        cuenta1.imprimir();
        
        // 9. Retiro con monto negativo (debe fallar)
        System.out.println("\n--- RETIRO DE -$100 DE CUENTA 2 (MONTO NEGATIVO) ---");
        boolean ret3 = banco.retirar(-100, cuenta2);
        System.out.println("¿Retiro exitoso? " + ret3);
        cuenta2.imprimir();

	}

}
