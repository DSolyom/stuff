import java.nio.*;
import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.Charset;

public class Checkout {
	
	public static void main(String[] args) {
		try {
			
			String a = "accounts          : '9.0.3',\n" +
		"\t\tandroid_core      : '9.1.2',\n" +
		"\t\tandroid_ui        : '9.2.0',\n" +
		"\t\tapplications      : '2.1.0',\n" +
		"\t\tappwidget         : '2.2.1',\n" +
		"\t\tattributes        : '3.1.2',\n" +
		"\t\tauthentication    : '7.1.2',\n" +
		"\t\tcards             : '8.1.2',\n" +
		"\t\tcommon_analytics  : '1.2.0',\n" +
		"\t\tcommon_base       : '4.2.0',\n" +
		"\t\tcommon_gcm        : '3.0.0',\n" +
		"\t\tcommon_onlinesales: '1.3.1',\n" +
		"\t\tcommon_partners   : '1.3.1',\n" +
		"\t\tcommon_products   : '3.0.3',\n" +
		"\t\tcommon_tfw        : '1.2.0',\n" +
		"\t\tcommon_tutorial   : '1.2.0',\n" +
		"\t\tcommon_vision     : '1.3.0',\n" +
		"\t\tcommon_wear       : '4.0.2',\n" +
		"\t\tcurrencies        : '8.0.1',\n" +
		"\t\tintegration       : '9.1.2',\n" +
		"\t\tmessages          : '7.1.2',\n" +
		"\t\tmobilebank_config : '1.2.1',\n" +
		"\t\tmobilebank_wear   : '10.5.0-SNAPSHOT',\n" +
		"\t\tnearestatm        : '7.0.2',\n" +
		"\t\tokcommunicator    : '5.3.0',\n" +
		"\t\tpayments          : '8.1.2',\n" +
		"\t\tpfm               : '6.0.4',\n" +
		"\t\tsettings          : '9.1.0',\n" +
		"\t\tshowcase          : '6.3.1',\n" +
		"\t\ttheme_alternative : '7.1.2',\n" +
		"\t\ttheme_default     : '7.1.2',\n" +
		"\t\ttoken_core        : '7.0.0',\n" +
		"\t\ttransactions      : '9.1.2',\n" +
		"\t\twear              : '4.0.2',";

			new File("checkout_modules.bat").delete();
			ArrayList<String> lines = new ArrayList<String>();
			
		
			String[] split = a.split("\n");
			System.out.println("" + split.length);
			for (String line : split) {
				String[] parts = line.split(":");
				parts[0] = parts[0].trim().replace("_", "-");
				
				lines.add("cd " + parts[0]);
				lines.add("git fetch");

				
				if (parts[1].contains("SNAPSHOT")) {
					lines.add("git checkout 10.x");
				} else {
					parts[1] = parts[1].trim();
					String git = parts[0] + "-" + parts[1].substring(1, parts[1].length() - 2);
					lines.add("git checkout " + git);
				}
				lines.add("cd ..");
			}
			
			lines.add("");
			
			Iterable<String> iterable = lines;
			Files.write(Paths.get("checkout_modules.bat"), iterable, Charset.forName("UTF-8"));
		} catch (Throwable e) {
		}
	}
	
}
