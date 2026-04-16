package electrodomesticos;

public class Main {

	public static void main(String[] args) {
		Electrodomestico[] arrayElectrodomesticos = new Electrodomestico[10];
		double electrodomestico = 0, lavadora = 0, television = 0, total = 0;
		
		arrayElectrodomesticos[0] = new Lavadora();
		arrayElectrodomesticos[1] = new Television();
		arrayElectrodomesticos[2] = new Lavadora(200, 100);
		arrayElectrodomesticos[3] = new Television(200, 26);
		arrayElectrodomesticos[4] = new Lavadora(32, "azul", 'A', 200, 66);
		arrayElectrodomesticos[5] = new Television(48, true, "negro", 'B', 200, 5);
		arrayElectrodomesticos[6] = new Electrodomestico();
		arrayElectrodomesticos[7] = new Electrodomestico(200, 6);
		arrayElectrodomesticos[8] = new Electrodomestico("gris", 'E', 200, 66);
		arrayElectrodomesticos[9] = new Television(100, true, "azuld", 'l', 200, 50);
		
		for (Electrodomestico e: arrayElectrodomesticos) {
			if (e instanceof Television) {
				System.out.println("Television: ");
				Television tv = (Television)e;
				System.out.println(tv.getColor());
				System.out.println(tv.getConsumoEnergetico());
				System.out.println(tv.getPeso());
				System.out.println(tv.isSintonizadorTDT());
				System.out.println(tv.getResolucion());
				System.out.println(tv.getPrecioBase());
				System.out.println("__________________");
				System.out.println(tv.precioFinal());
				System.out.println("__________________\n");
				television += tv.precioFinal();
				total += tv.precioFinal();
			}
			
			else if (e instanceof Lavadora) {
				Lavadora lv = (Lavadora)e;
				System.out.println("Lavadora: ");
				System.out.println(lv.getColor());
				System.out.println(lv.getConsumoEnergetico());
				System.out.println(lv.getPeso());
				System.out.println(lv.getCarga());
				System.out.println(lv.getPrecioBase());
				System.out.println("__________________");
				System.out.println(lv.precioFinal());
				System.out.println("__________________\n");
				lavadora += lv.precioFinal();
				total += lv.precioFinal();
			}
			
			else {
				System.out.println("Electrodomestico: ");
				System.out.println(e.getColor());
				System.out.println(e.getConsumoEnergetico());
				System.out.println(e.getPeso());
				System.out.println(e.getPrecioBase());
				System.out.println("__________________");
				System.out.println(e.precioFinal());
				System.out.println("__________________\n");
				electrodomestico += e.precioFinal();
				total += e.precioFinal();
			}
		}
		System.out.printf("La suma del precio de todos los electrodomesticos es: %.2f %n Electrodomestico: %.2f %n Lavadora: %.2f %n Television: %.2f",total, electrodomestico, lavadora, television);

	}

}
