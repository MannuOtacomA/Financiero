package com.krakedev.financiero.test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestBanco {

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
        Cuenta cuenta3 = banco.crearCuenta(cliente1);  // Mismo cliente, otra cuenta
        
        // 4. Verificar que los códigos son consecutivos
        System.out.println("=== CUENTAS CREADAS ===");
        cuenta1.imprimir();
        cuenta2.imprimir();
        cuenta3.imprimir();
        
        // 5. Verificar que el último código se incrementó
        System.out.println("\nÚltimo código del banco: " + banco.getUltimoCodigo());
        // Esperado: 1003 (empezó en 1000, creó 3 cuentas: 1000, 1001, 1002)

	}

}
