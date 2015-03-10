package org.strotmann.partner

import java.io.BufferedWriter;
import java.util.Map;

class SortViaMap {
	
	static main(args) {
		Map map = langMap(args[0])
		println "messages${args[0]}.properties wird sortiert"
		def List sortedKeys = map.sort()*.key
		println "Sortierung durchgeführt"
		BufferedWriter langFile = propFile (args[0])
		println "Ausgabefile erzeugt"
		sortedKeys.each { it ->
			println it
			def mapValue = map[it]
			langFile.writeLine(it+'='+mapValue)
		}
		langFile.close()
	}
	
	static Map langMap (String lang) {
		FileInputStream deStream = new FileInputStream ("grails-app/i18n/messages${lang}.properties")
		InputStreamReader deReader = new InputStreamReader(deStream, "UTF-8")
		BufferedReader de = new BufferedReader (deReader)
		Map map = [:]
		de.eachLine { String it ->
			println it
			if (it > '') {
				List itSplit = it.split('=')
				String itKey = itSplit[0]
				String itValue = itSplit[1]
				if (itValue)
					map += [(itKey) : itValue]
			}
		}
		println map[1]
		map
	}
	
	static private BufferedWriter propFile (String lang) {
		
		BufferedWriter retBuf = null;
		
		try {
			@SuppressWarnings("resource")
			FileOutputStream fileOutputStream = new FileOutputStream ("grails-app/i18n/messages${lang}.properties");
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
