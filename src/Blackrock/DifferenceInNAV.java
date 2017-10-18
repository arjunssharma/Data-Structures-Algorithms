package Blackrock;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

public class DifferenceInNAV {

	private String stock;
	private int quantity;
	private int price;
	private double percentage;
	
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#.00");
		String input = "PORT:AXN,0,10;BGT,20,30;CXZ,10,30|BENCH:AXN,50,10;BGT,30,30;DFG,30,20;XYZ,0,10";
		System.out.println("Input: " + input);
		String portDetails[] = input.substring(0, input.indexOf("|")).substring(input.indexOf(":") + 1).split(";");
		String benchDetails[] = input.substring(input.indexOf("|") + 1).substring(input.indexOf(":") + 2).split(";");

		DifferenceInNAV[] port = new DifferenceInNAV[portDetails.length];
		DifferenceInNAV[] bench = new DifferenceInNAV[benchDetails.length];

		for (int i = 0; i < portDetails.length; i++) {
			port[i] = new DifferenceInNAV();
			Object array[] = portDetails[i].split(",");
			port[i].stock = (String) array[0];
			port[i].quantity = Integer.parseInt(array[1].toString());
			port[i].price = Integer.parseInt(array[2].toString());
		}

		double PortNAV = 0;
		for (int i = 0; i < portDetails.length; i++) {
			PortNAV += port[i].quantity * port[i].price;
		}
		for (int i = 0; i < portDetails.length; i++) {
			port[i].percentage = ((port[i].quantity * port[i].price) * 100) / PortNAV;
		}

		for (int i = 0; i < benchDetails.length; i++) {
			bench[i] = new DifferenceInNAV();
			Object array[] = benchDetails[i].split(",");
			bench[i].stock = (String) array[0];
			bench[i].quantity = Integer.parseInt(array[1].toString());
			bench[i].price = Integer.parseInt(array[2].toString());
		}

		double BenchNAV = 0;

		for (int i = 0; i < benchDetails.length; i++) {
			BenchNAV += bench[i].quantity * bench[i].price;
		}
		for (int i = 0; i < benchDetails.length; i++) {
			bench[i].percentage = ((bench[i].quantity * bench[i].price) * 100) / BenchNAV;
		}

		Arrays.sort(port, new Comparator<DifferenceInNAV>() {
			@Override
			public int compare(DifferenceInNAV port1, DifferenceInNAV port2) {
				return port1.stock.compareTo(port2.stock);
			}
		});

		Arrays.sort(bench, new Comparator<DifferenceInNAV>() {
			@Override
			public int compare(DifferenceInNAV bench1, DifferenceInNAV bench2) {
				return bench1.stock.compareTo(bench2.stock);
			}
		});

		// System.out.println("PORT");
		// for(int i=0;i<port.length;i++){
		// System.out.println(port[i].stock + "," + port[i].quantity + "," +
		// port[i].price + "," + port[i].percentage);
		// }
		// System.out.println("BENCH");
		// for(int j=0;j<bench.length;j++){
		// System.out.println(bench[j].stock + "," + bench[j].quantity + "," +
		// bench[j].price+ "," + bench[j].percentage);
		// }

		String result = new String();
		int i = 0, j = 0;
		for (i = 0; i < port.length; i++) {
			for (j = 0; j < bench.length; j++) {
				if (port[i].stock.equalsIgnoreCase(bench[j].stock)) {
					result += port[i].stock + ":" + df.format(port[i].percentage - bench[j].percentage) + ",";
					break;
				}
			}
		}

		for (i = 0; i < port.length; i++) {
			if (!result.contains(port[i].stock)) {
				result += port[i].stock + ":" + df.format(port[i].percentage) + ",";
				break;
			}
		}

		for (i = 0; i < bench.length; i++) {
			if (!result.contains(bench[i].stock)) {
				if (bench[i].percentage == 0) {
					result += bench[i].stock + ":" + "-0.00" + ",";
				} else {
					result += bench[i].stock + ":" + df.format(-1 * bench[i].percentage) + ",";
				}

			}
		}

		System.out.println("Output: " + result.substring(0, result.length() - 1));
	}
}