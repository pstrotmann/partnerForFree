package org.strotmann.partner

import java.io.BufferedWriter;

class EnEn {
	static main(args) {
		
		BufferedReader enProps = propEnFile ()
		int anzRead = 0
		BufferedWriter props = propFile ()
		int anzWrite = 0
		
		enProps.eachLine {String it ->
			anzRead++
			if (it.substring(0,2) != '->') {
				anzWrite++
				props.writeLine(it)
			}
		}
		enProps.close()
		println "${anzRead} Sätze von messages_enwrk.properties gelesen"
		props.close()
		println "${anzWrite} Sätze auf messages.properties geschrieben"
	}
	
	static private BufferedReader propEnFile () {
		FileInputStream deStream = new FileInputStream ("grails-app/i18n/messages_enwrk.properties")
		InputStreamReader deReader = new InputStreamReader(deStream, "UTF-8")
		new BufferedReader (deReader)
	}
	
	static private BufferedWriter propFile () {
		
		BufferedWriter retBuf = null;
		
		try {
			@SuppressWarnings("resource")
			FileOutputStream fileOutputStream = new FileOutputStream ("grails-app/i18n/messages_en.properties");
			OutputStreamWriter outpuStreamWriter = null;
			try {
				outpuStreamWriter = new OutputStreamWriter (fileOutputStream, "UTF-8");
			} catch (UnsupportedEncodingException ex) {
				System.out.println("Encoding nicht gefunden");
			}
			retBuf = new BufferedWriter(outpuStreamWriter);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		return retBuf;
	}
}
