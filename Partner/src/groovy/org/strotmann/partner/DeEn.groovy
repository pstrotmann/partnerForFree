package org.strotmann.partner

class DeEn {
	static main(args) {
		Map deMap = langMap('_de')
		Map eMap = langMap('_en')
		Map enMap = [:]
		enMap += eMap
		
		int anzNeu = 0
		deMap.each {String key, String value ->
			if (!enMap[key]) {
				enMap += [('->'+key):value]
				anzNeu++
			}
		}
		println "neu zu übersetzen:${anzNeu}"
		BufferedWriter enFile = propFile ()
		enMap.each { key,value ->
			enFile.writeLine(key+'='+value)
		}
		enFile.close()
	}
	
	static Map langMap (String lang) {
		FileInputStream deStream = new FileInputStream ("grails-app/i18n/messages${lang}.properties")
		InputStreamReader deReader = new InputStreamReader(deStream, "UTF-8")
		BufferedReader de = new BufferedReader (deReader)
		Map map = [:]
		de.eachLine { String it ->
			if (it > '') {
				List itSplit = it.split('=')
				String itKey = itSplit[0]
				String itValue = itSplit[1]
				if (itValue)
					map += [(itKey) : itValue]
			}
		}
	}
	
	static private BufferedWriter propFile () {
		
		BufferedWriter retBuf = null;
		
		try {
			@SuppressWarnings("resource")
			FileOutputStream fileOutputStream = new FileOutputStream ("grails-app/i18n/messages_enwrk.properties");
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
