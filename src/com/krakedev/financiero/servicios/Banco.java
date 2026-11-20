package com.krakedev.financiero.servicios;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;

public class Banco {

	private int ultimoCodigo = 1000;

	public Banco() {

	}

	public int getUltimoCodigo() {
		return ultimoCodigo;
	}

	public void setUltimoCodigo(int ultimoCodigo) {
		this.ultimoCodigo = ultimoCodigo;
	}

	public Cuenta crearCuenta(Cliente cliente) {
		String codigoStr = ultimoCodigo + ""; // convierte a string
		ultimoCodigo++;
		Cuenta cuenta = new Cuenta(codigoStr); // crea la cta
		cuenta.setPropietario(cliente); // asigna al cliente recibido

		return cuenta;
	}

	public boolean depositar(double monto, Cuenta cuenta) {
		if (monto > 0) {
			double nuevoSaldo = cuenta.getSaldoActual() + monto;
			cuenta.setSaldoActual(nuevoSaldo);
			return true;
		} else {
			return false;
		}
	}

	public boolean retirar(double monto, Cuenta cuenta) {

		if (monto > 0 && monto <= cuenta.getSaldoActual()) {
			double nuevoSaldo = cuenta.getSaldoActual() - monto;
			cuenta.setSaldoActual(nuevoSaldo);
			return true;
		} else {
			return false;
		}
	}

	public boolean transferir(Cuenta origen, Cuenta destino) {
		double monto = origen.getSaldoActual();
		if (monto > 0) {
			boolean retiro = this.retirar(monto, origen);//retira
			if (retiro) {
				boolean deposito = this.depositar(monto, destino);//deposita
				if (deposito) {
					return true;
				} else {
					this.depositar(monto, origen);//si falla se devuelve
					return false;
				}
			} else {
				return false;
			}			

		} else {
			return false;
		}

	}

}
