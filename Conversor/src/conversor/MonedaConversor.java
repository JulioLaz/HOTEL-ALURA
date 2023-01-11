package conversor;

public class MonedaConversor{

private double moneda;
	
	public double getMoneda() {
		return moneda;
	}
	public void setMoneda(double moneda) {
		this.moneda = moneda;
	}
	
	public double pesosArgAEuro() {
		return 0.0051*this.moneda;
	}
	public double euroAPesosArg() {
		return 193.65*this.moneda;
	}
	public double pesosArgADolar() {
		return 0.0055*this.moneda;
	}
	public double dolarAPesosArg() {
		return 181.81*this.moneda;
	}
	public double dolarAEuro() {
		return 0.94*this.moneda;
	}
	public double euroADolar() {
		return 1.07*this.moneda;
	}
	
	public double Menu_conversion(int option) {
		double result =0;
		switch (option) {
		case 1: 
			result = this.pesosArgAEuro();
		break;
		case 2: 
			result = this.euroAPesosArg();
		break;
		case 3: 
			result = this.pesosArgADolar();
		break;
		case 4: 
			result = this.dolarAPesosArg();
		break;
		case 5: 
			result = this.dolarAEuro();
		break;
		case 6: {
			result = this.euroADolar();
		}
		}
		return result;
	}
}
