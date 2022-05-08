package utils;

import entidades.*;

public class Datos {

	public static final Controlado[] CONTROLADOS = { new Controlado(1, 0, 15, 5), new Controlado(2, 15, 20, 7),
			new Controlado(3, 20, 45, 14), new Controlado(1, 15, 15, 5), new Controlado(1, 10, 20, 8),
			new Controlado(3, 25, 45, 12) };

	public static final Flota[] FLOTAS = { new Flota(1652330, "Galway"), new Flota(2326808, "Cork"),
			new Flota(3121458, "Limerick"), new Flota(1778646, "Avis"), new Flota(3344368, "Sixt"),
			new Flota(3872435, "Jocar") };

	public static final Informe[] INFORMES = { new Informe("bueno", 2002, 01234, 43210),
			new Informe("malo", 2003, 01334, 43230), new Informe("bueno", 2004, 01356, 43232),
			new Informe("bueno", 2001, 01224, 46710), new Informe("malo", 2005, 01344, 43280),
			new Informe("bueno", 2004, 01256, 43222),

	};

	public static final Jornada[] JORNADAS = { new Jornada("12345R", '1'), new Jornada("54321Q", '2'),
			new Jornada("54567H", '1'), new Jornada("10945P", '1'), new Jornada("56621L", '2'),
			new Jornada("52367D", '1'),

	};
	
	
	public static final NoControlado[] NOCONTROLADOS1 = {
			new NoControlado(1, 10.0),
			new NoControlado(2, 5.0),
			new NoControlado(3, 10.0),
		};
	
	
	public static final Nomina[] NOMINAS = {
			new Nomina("48534387-D", 1020.34, 12435676),
			new Nomina("23453325-L", 999.70, 84834576),
			new Nomina("52836787-F",1100.00, 12435676),
            new Nomina("24548735-D",1250.00, 12345678),
            new Nomina("78977943-K",1100.00, 12435976),
            new Nomina("33324886-M",1250.00, 12345678),
            
	};
            

	public static final Lote[] LOTES = { new Lote(231), new Lote(712), new Lote(978), new Lote(212), new Lote(733),
			new Lote(999), };

	public static final NoControlado[] NOCONTROLADOS = { new NoControlado(1, 10.0), new NoControlado(2, 5.0),
			new NoControlado(3, 5.0), new NoControlado(1, 10.0), new NoControlado(3, 10.0),
			new NoControlado(3, 10.0), };

	

	

	public static final OCabina[] OCABINAS = {

			new OCabina("87534878-D", "Pablo", "Alvarez", "Avenida Manuel Llaneza 33205", "908786543", false),
			new OCabina("48534387-D", "Tomas", "Garcia", "Plaza Seis de Agosto 33206", "623451876", true),
			new OCabina("26587798-Q", "Jesus", "Luz", "Avenida Costa 33201", "645345897", true),
			new OCabina("24448238-C", "Begonna", "Frexes", "Avenida La Camocha 33391", "656195695", false),
			new OCabina("33872317-F", "Maria", "Benavente", "Carretera AS-248 33392", "618333241", false),
			new OCabina("23453325-L", "Natalia", "Dominguez", "Avenida Pablo Iglesias 33205", "633112490", true),

	};

	public static final OCarretera[] OCARRETERAS = {
			new OCarretera("53478977-K", "Carlos", "Fernandez", "C/ Naranjo de Bulnes 33211", "985345478", true),
			new OCarretera("23428905-H", "Carla", "Sanchez", "Avenida Schultz 33208", "658348934", false),
			new OCarretera("46578388-H", "Olga", "Vega", "C/ Rio de Oro 33209", "754884374", true),
			new OCarretera("33324886-M", "Luciano", "Guerrero", "Barrio Pescadores 33212", "644888812", true),
			new OCarretera("24448435-S", "Isabel", "Horreo", "Bateria 33201", "648272391", false),
			new OCarretera("25356785-L", "Sergio", "Ramos", "Benito Conde 33210", "625358765", true), };

	public static final OOficina[] OOFICINAS = {

			new OOficina("78977943-K","Jesica", "Leiva", "Avenida Pablo Iglesias 33205","985765979", true),
			new OOficina("42356655-A", "Andrea","Martinez"," C/ Alvarez Garaya 33206", "985349196", false),
			new OOficina("62349889-R","Patricio", "MuÃƒÂ±oz","C/ Uria 33202","677678890",false),
            new OOficina("24548735-D" , "Manuel", "Montes" , "C/Guatemala 33213" , "634263829", true),
            new OOficina("52836787-F", "Luisa", "Freije", "C/Tadeo Llanera 33390", "633113490" , true),
            new OOficina("24348328-C", "Felix", "Ruibarbo", "C/Perez Ayala 33392", "643123498" , false),
			
	};
	
	//
	
	public static final Pago[] PAGOS  = {
			new Pago(2221, 'e'),
			new Pago(2138, 'e'),
			new Pago(8931, 't'),

			new OOficina("78977943-K", "Jessica", "Leiva", "Avenida Pablo Iglesias 33205", "985765979", true),
			new OOficina("42356655-A", "Andrea", "Martinez", " C/ Ã�lvarez Garaya 33206", "985349196", false),
			new OOficina("62349889-R", "Patricio", "Munnoz", "C/ Uria 33202", "677678890", false),
			new OOficina("56765798-T", "Kristina", "Contreras", "C/ Leopoldo Alas 33207", "985248186", true),
			new OOficina("42370162-Q", "Alejandra", "Frexes", "Avenida La Costa 33204", "677675239", false),
			new OOficina("53290782-Q", "Yolanda", "Avila", " Avenida Portugal 33207", "675456234", false),


	
	
	public static final Peaje[] PEAJES  = {
			new Peaje(12345,65437,10,'f'),
			new Peaje(57849,97067,11,'t'),
			new Peaje(68947,67895,10,'r'),
	};
	
	
	public static final Problema[] PROBLEMAS  = {
			new Problema("pagotarjeta", "Yolanda", 8790, 4753, "123456123"),
			new Problema("rechazotarjeta", "Constanza", 3943, 1256, "456789987"),

	public static final Pago[] PAGOS1 = { new Pago(2221, 'e'), new Pago(2138, 'e'), new Pago(8931, 't'),
			new Pago(2112, 't'), new Pago(2138, 'e'), new Pago(5647, 't'), };

	public static final Peaje[] PEAJES = { new Peaje(12345, 65437, 10, '1'), new Peaje(57849, 97067, 11, '2'),
			new Peaje(68947, 67895, 10, '2'), new Peaje(78756, 65997, 10, '1'), new Peaje(67565, 55467, 11, '2'),
			new Peaje(15674, 99876, 10, '2'), };

	public static final Problema[] PROBLEMAS = { new Problema("pagotarjeta", "Yolanda", 8790, 4753, "123456123"),
			new Problema("rechazotarjeta", "constanza", 3943, 1256, "456789987"),

			new Problema("no funciona tarjeta", "kristina", 2398, 7583, "567765432"),
			new Problema("rechazotarjeta", "Luis", 3450, 4673, "123457623"),
			new Problema("rechazotarjeta", "Eric", 3223, 9856, "4561212677"),
			new Problema("no funciona tarjeta", "Pablo", 1128, 7543, "3684657782"), };

	public static final Vehiculo[] VEHICULOS = { new Vehiculo("Hyundai Tucson", "8256-HYN", false),
			new Vehiculo("Jeep Wrangler", "2002-CVL", true), new Vehiculo("Chevrolet Suburban", "9800-TJV", false),
			new Vehiculo("Skoda Fabia", "2123-GJL", false), new Vehiculo("Skoda Octavia", "2422-JFK", true),
			new Vehiculo("Renault Clio", "1154-KKK", false), };
	}

	// cambio

	
