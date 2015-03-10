<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
        
  <meta name="title" content="Deutsche Post | PLZ-Suche" />
  <meta name="keywords" content="Postleitzahl,PLZ,Ort,Ortsteil,Stra&szlig;e,Ortssuche,Ortsteilsuche,Stra&szlig;ensuche,Gro&szlig;empf&auml;nger,Postfach,Postf&auml;cher,Postlagerausgabe,Postfachschrank,Karte,Kartografie,Kartographie,Postservices" />
  <meta name="description" content="Postleitzahlen,Postf&auml;cher,Gro&szlig;empf&auml;nger,Orte,Ortsteile und Stra&szlig;en finden,nahegelegene Postservices,Kartendarstellung,Anschriften prüfen" />
  <meta name="publisher" content="doubleSlash Net-Business GmbH" />
  <meta name="copyright" content="2010 by doubleSlash" />
  <meta name="audience" content="Alle" />
  <meta name="revisit-after" content="10 days" />
  <meta name="robots" content="INDEX,FOLLOW" />
                  
  
                     
  <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
  
  
<script type="text/javascript">
                	(function(css){
                		document.documentElement.id='js';
						var s = document.createElement("style");
						s.type = "text/css";
					  	if (s.styleSheet) s.styleSheet.cssText = css;
						else s.appendChild(document.createTextNode(css));
					    document.getElementsByTagName("head")[0].appendChild(s);
					})('.jsdisplay{display:none}.jsvisibility{visibility:hidden}')
					
					
		           </script>
<title>Deutsche Post | PLZ-Suche</title>
<link rel="shortcut icon" type="image/x-icon" href="http://www.postdirekt.de/plzserver/favicon.ico"/>
<link rel="search" type="application/opensearchdescription+xml" title="PLZ-Suche" href="http://www.postdirekt.de/plzserver/download/plzsuche-de.xml"/>
                <!--plzs_all_min.js-->
               	<!-- <script type="text/javascript" src="js/global.js"></script> 
                
                <script type="text/javascript" src="js/package-base.js"></script>
    			<script type="text/javascript" src="js/head.js"></script>
    			<script type="text/javascript" src="js/nav-local.js"></script>
    			<script type="text/javascript" src="js/foot.js"></script>
               
                <script type="text/javascript" src="js/plzsearch.js"></script>
                <script type="text/javascript" src="js/jquery.tablesorter.js"></script>
                <script type="text/javascript" src="js/jquery.tablesorter.pager.js"></script>
                <script type="text/javascript" src="js/jquery.autocomplete.js"></script>
                <script type="text/javascript" src="js/zap_lt.js"></script> --> 
                 
                
                <script type="text/javascript" src="js/plzs_all_min.js"></script>  
                
                <script type="text/javascript" src="js/jscolor/jscolor.js"></script>
                <script type="text/javascript" src="js/AC_OETags.js"></script>                           
                
    <!-- VNR und PNR übergeben, damit ein Bing-Token generiert werden kann -->
    <script type="text/javascript" src="/MapAPI-1.0/js/mapping.js?vnr=0&pnr=3" language="JavaScript1.2"></script>
    <script type="text/javascript" src="/DeutschePost_PLZ_Suche/js/extension/IExtension.js" language="JavaScript1.2"></script>
    <script type="text/javascript" src="/DeutschePost_PLZ_Suche/js/extension/ICallBack.js" language="JavaScript1.2"></script>
    <script type="text/javascript" src="/DeutschePost_PLZ_Suche/js/extension/IWOpacityControl.js" language="JavaScript1.2"></script>
    <script type="text/javascript" src="/DeutschePost_PLZ_Suche/js/extension/DPInfoBalloon.js"></script>
    <!--[if lt IE 10]>
	<script type="text/javascript" src="/DeutschePost_PLZ_Suche/js/extension/PIE.js"></script>
	<![endif]-->
    <link href="/DeutschePost_PLZ_Suche/css/map.css" type="text/css" rel="stylesheet" />
    <link href="/DeutschePost_PLZ_Suche/css/content-infolayer.css" type="text/css" rel="stylesheet" />
    
    
    <!--<script type="text/javascript" src="http://gis3.infoware.de/MapAPI-1.0/js/mapping.js?vnr=0&pnr=3" language="JavaScript1.2"></script>
    <script type="text/javascript" src="http://gis3.infoware.de/DeutschePost_PLZ_Suche/js/extension/IExtension.js" language="JavaScript1.2"></script>
    <script type="text/javascript" src="http://gis3.infoware.de/DeutschePost_PLZ_Suche/js/extension/ICallBack.js" language="JavaScript1.2"></script>
    <script type="text/javascript" src="http://gis3.infoware.de/DeutschePost_PLZ_Suche/js/extension/IWOpacityControl.js" language="JavaScript1.2"></script>
    <link href="http://gis3.infoware.de/DeutschePost_PLZ_Suche/css/map.css" type="text/css" rel="stylesheet" />-->
       


                
<script type="text/javascript">
         var mapLoaded = 0;
         
         
             
         var output = '';
         var org = '';
         var plzserverBasisPfad = 'http://www.postdirekt.de/plzserver';
         var defaultTextCustomerName = 'http://www.postdirekt.de/plzserver';
         var defaultTextCustomerName = 'Geben Sie einen Großempfänger ein.';
         var defaultTextCustomerCity = 'Geben Sie Postleitzahl oder Ort ein.';
         
         var pluginPlz = '';
         var pluginCity = '';
         var pluginStreet = '';
         var pluginCustomer = '';
                      
         var search_errors = new Array( 
         ['0', 'Bitte geben Sie einen Ort (mind. 2 Zeichen) ein.'],
         ['1', 'Bitte geben Sie eine Postleitzahl (mind. 2 Ziffern) ein.'],
         ['2', 'Bitte geben Sie einen Ort (mind. 2 Zeichen) ein.'],   
         ['3', 'Bitte geben Sie einen Großempfänger oder einen Ort (mind. 2 Zeichen) ein.'],   
         ['4', 'Bitte geben Sie einen Ort (mind. 2 Zeichen) ein.'],
         ['5', 'Bitte geben Sie mindestens zwei Ziffern der Postleitzahl oder zwei Zeichen des Ortes an.'], 
         ['pre', '&lt;b>Sucheingabe nicht ausreichend:&lt;/b>&lt;br />'.replace(/&lt;/gi,'<')]
         );
             
         var pages = new Array('home','search_results', 'configurator', 'plugins');    
             
         var labels = {};
         labels.hitsfor = {};
         labels.hitsfor.normal = 'Suchtreffer für';
         labels.hitsfor.cities = 'Ort zu';
         labels.hitsfor.districts = 'Ortsteil zu';
         labels.hitsfor.streets = 'Straße zu';
         labels.hitsfor.normal_pl = 'Suchtreffer für';
         labels.hitsfor.cities_pl = 'Orte zu';
         labels.hitsfor.districts_pl = 'Ortsteile zu';
         labels.hitsfor.streets_pl = 'Straßen zu';
         labels.districtof = '(Ortsteil von {city})'; 
         labels.districts = 'Ortsteile';
         labels.streets = 'Straßen';
         labels.district = 'Ortsteil';
         labels.street = 'Straße';
         labels.plz = 'PLZ';
         labels.map = 'Karte';
         labels.go = {};
         labels.go.districts = 'Ortsteile anzeigen';
         labels.go.streets = 'Straßen anzeigen';
         labels.go.map = 'Auf Karte anzeigen';
         labels.box = 'Postfächer';
         labels.customer = 'Großempfänger';
         labels.prestante = 'Postlagerausgaben';
         labels.search_sub = {};
         labels.search_sub.s0 = 'Postleitzahl zu Ort und Straße finden.';
         labels.search_sub.s1 = 'Ort zu gegebener Postleitzahl finden.';
         labels.search_sub.s2 = 'Postfächer zu Ort finden.';
         labels.search_sub.s3 = 'Großempfänger nach Name oder Ort finden.';
         labels.search_sub.s4 = 'Postlagerausgabe zu Ort finden.';
         labels.search_sub.s5 = 'Erweiterte Suche nutzen.';         
         labels.search_adv_2standard = 'Standardsuche';
         labels.search_adv_2advanced = 'Erweiterte Suche ';                  
         labels.noresultavailable = 'Leider konnte für Ihre Anfrage kein Ergebnis ermittelt werden.<br/>Bitte versuchen Sie es zu einem späteren Zeitpunkt noch einmal.';   
         labels.hint_switchToPobox = 'Automatisch zur Suche "Postfächer" gewechselt.'; 
         labels.hint_switchToTown = 'Automatisch zur Suche "Ort" gewechselt.'; 
         labels.more_cities = 'weitere Orte';   
         labels.more_streets = 'weitere Straßen';   
         labels.more_customers = 'weitere Großempfänger';   
         labels.outofdate = '(veraltet)';   
         labels.paging_next = 'Weiter';
         labels.paging_prev = 'Zurück';   
            
         var lang_current = 'de_DE';
            
         //if city/plz entered in header-searchinput               
    
            var posted_city = '';
         
         
         //gegen bg_image-flackern im IE
         try {
            document.execCommand("BackgroundImageCache", false, true);
         } catch(err) {}
                          

          /*$(document).ready(function() {                  
              plzs.init();                   
          }).unload(function(){
              GUnload();
          }); */
                              
          
      
        </script>
<link rel="stylesheet" type="text/css" href="css/plzs_all_min.css" media="screen"/>
<!--[if lt IE 7 & gte IE 5.500]> 
<link rel="stylesheet" type="text/css" href="css/plzs_ie.css" media="screen" />
<![endif]-->
<!--[if IE]> 
<link rel="stylesheet" type="text/css" href="css/print_ie.css" media="print" />
<![endif]-->
<link rel="stylesheet" type="text/css" href="css/print.css" media="print"/>
</head>
<body id="body" lang="de">
<div class="head" role="banner">
<div class="all clearfix">
<a id="postlogo" class="head-logo" href="http://www.deutschepost.de">
<img alt="Deutsche Post" src="images/global/logo_deutschepost.png"/>
</a>
<div class="head-nav clearfix" role="navigation">
<div class="head-search" role="search">
<div>
<form id="headsuche" enctype="application/x-www-form-urlencoded" method="get" action="http://www.deutschepost.de/dpag?xmlFile=1016089">
<input value="1016089" name="xmlFile" type="hidden"/>
<input value="de_DE" name="lang" type="hidden"/>
<input value="hi" name="skin" type="hidden"/>
<input value="yes" name="check" type="hidden"/>
<input value="DP_GK" name="APP.client" type="hidden"/>
<input value="COS_Services-Test" name="APP.referrer" type="hidden"/>
<input value="nfas" name="PA.CONTEXT" type="hidden"/>
<input value="NO_SESSIONID" name="PIF.SESSIONID" type="hidden"/>
<input value="NFASInitForm" name="PIF.APP_FORM" type="hidden"/>
<input value="NFASInit" name="PIF.LAST_ACTIVITY" type="hidden"/>
<input value="Suchbegriff" class="head-input" name="APP.question" type="text"/>
<input value="" class="head-submit" title="Suchen" type="submit"/>
</form>
</div>
</div>
<ul class="inline">
<li>
<a class="nav-item " href="http://www.deutschepost.de/epostbrief" id="epostbrief">E-Postbrief</a>
</li>
<li>
<a class="nav-item " href="http://www.deutschepost.de/privatkunden" id="privatkunden">Privatkunden</a>
</li>
<li>
<a class="nav-item " href="http://www.deutschepost.de/geschaeftskunden" id="geschaeftskunden">Geschäftskunden</a>
</li>
<li>
<a class="nav-item " href="http://www.deutschepost.de/produkte" id="produkte">Produkte</a>
</li>
<li>
<a class="nav-item " href="http://www.deutschepost.de/service" id="service">Service</a>
</li>
<li>
<a class="nav-item " href="http://www.deutschepost.de/shop" id="shop">Shop</a>
</li>
</ul>
</div>
</div>
</div>
<div class="nav-local ">
<div class="all">
<a class="nav-local-site" href="http://www.postdirekt.de/plzserver/">Postleitzahlensuche</a>
</div>
</div>
<div id="semimodal" class="semimodal"> </div>
<div id="hxloader" style="display:none;">
<img src="images/global/ladekreis.gif" alt="Ergebnisse werden geladen. Bitte haben Sie einen Augenblick Geduld."/> </div>
<div id="hxloader_live" style="display:none;">
<img src="images/global/ladekreis.gif" alt="Ergebnisse werden geladen. Bitte haben Sie einen Augenblick Geduld."/> </div>
<div id="termsofuse" class="popup">
<div class="popup_top"> </div>
<div class="popup_center">
<div class="popup_content" style="overflow: hidden;">
<div class="popup_btn_close">
<a href="#" title="Schließen" onclick="plzs.other.termsofuse.hide(); return false;">Schließen</a>   <a href="#" title="Schließen" style="text-decoration:none;" onclick="plzs.other.termsofuse.hide(); return false;">
<img src="images/btn_close.png" alt="Schließen"/>
</a>
</div>
<div class="popup_header">Nutzungsbedingungen der PLZ-Suche</div>
<div class="popup_scroller">
<span style="font-weight: bold;">1. Gegenstand der Nutzung</span>
<br/>
<p style="margin: 10px 0px;">Die kostenlose PLZ-Suche von der Deutsche Post AG (nachfolgend DP AG genannt) gibt dem Nutzer die Möglichkeit, Postleitzahlen und Straßen in Deutschland in der Datenbank von Deutsche Post AG zu suchen. Die Lieferung der Daten durch DP AG erfolgt ausschließlich zur eigenen Nutzung durch den Kunden. Das Abfragevolumen ist pro Kunde und pro Tag auf 200 Abfragen begrenzt. Sofern der Kunde Unternehmer, juristische Person des öffentlichen Rechts oder öffentlich-rechtliches Sondervermögen ist, gilt das Unternehmen als Kunde, so dass bei Nutzung der Daten durch verschiedene Angehörige des Unternehmens die Einhaltung der Nutzungsgrenzen innerhalb des Unternehmens und der mit dem Unternehmen gemäß § 15 ff. Aktiengesetz verbundenen Unternehmen sicherzustellen ist. Eine über das begrenzte Abfragevolumen hinausgehende Nutzung der Daten bedarf einer Lizenzierung der Daten durch Deutsche Post Direkt GmbH, Tel. 02 28 / 182-57 111. Die Verwendung der abgerufenen Daten zur Herstellung systematischer Sammlungen in jedweder Form, insbesondere zur Zusammenstellung einer neuen Datenbank, ist untersagt. Die Weitergabe der gelieferten Daten durch den Nutzer an Dritte darf nur mit vorheriger Zustimmung von DP AG erfolgen. Dritter in diesem Sinne ist jede andere natürliche oder juristische Person, insbesondere auch Unternehmen, mit denen der Kunde im Sinne des § 15 Aktiengesetz verbunden ist. Die gewerbliche Durchführung von Adressabgleichen, Adressvermietungen, Datenanreicherungen sowie sonstiger Dienstleistungen aufgrund von Datenbeständen, die unter Nutzung der von der DP AG gelieferten Daten bereinigt wurden bedarf ebenfalls der vorherigen Zustimmung von DP AG. Verletzt der Kunde die Pflichten aus diesem Abschnitt schuldhaft, so ist die DP AG berechtigt, Schadensersatz zu verlangen.</p>
<span style="font-weight:bold">2. Weitere Hinweise</span>
<br/>
<p style="margin: 10px 0px;">Es handelt sich bei dem hier zur Verfügung stehendem kostenlosen Service um ein reines Gefälligkeitsverhältnis. Dies bedeutet, dass eine Rechtspflicht von DP AG zur Gewährung der Nutzung nicht besteht; vertragliche Ansprüche des Nutzers bestehen demgemäß nicht. Für die Richtigkeit, Vollständigkeit und Aktualität der Daten übernimmt die DP AG keine Gewähr. Die DP AG haftet, da es sich um ein Gefälligkeitsverhältnis handelt, allein auf deliktischer Grundlage, hierbei ist die Haftung von DP AG auf Vorsatz und grobe Fahrlässigkeit beschränkt. Für Schäden aus der Verletzung des Lebens, des Körpers oder der Gesundheit, die auf einer vorsätzlichen oder fahrlässigen Pflichtverletzung von DP AG oder auf einer vorsätzlichen oder fahrlässigen Pflichtverletzung eines Erfüllungsgehilfen oder eines gesetzlichen Vertreters der DP AG beruhen, haftet die DP AG allerdings unbegrenzt.</p>
<p>Stand: 01.05.2010</p>
</div>
</div>
</div>
<div class="popup_bottom"> </div>
</div>
<div id="content" class="main" role="main">
<div id="content_page" class="page">
<div id="search" class="clearfix">
<div id="frame_bt_1" class="frame_bt"> 
                                            
                    </div>
<div id="frame_rl_1" class="frame_rl" style="padding:0px 20px 0px 20px; position:relative;">
<div id="search_mapvisual">
<a title="Neue PLZ-Suche starten" href="http://www.postdirekt.de/plzserver/">
<img src="images/sqbl.png" style="height:100%; width:100%; border:0px;" alt="Neue PLZ-Suche starten"/>
</a>
</div>
<form id="search_form" action="?" onsubmit="return false" method="get" accept-charset="utf-8">
<table>
<tr>
<td colspan="4" style="width:454px;">
<h3 class="search_ip0">Postleitzahl zur Adresse finden:</h3>
<h3 class="search_ip1" style="display:none;">Ort zur Postleitzahl finden:</h3>
<h3 class="search_ip2" style="display:none;">Postfächer finden:</h3>
<h3 class="search_ip3" style="display:none;">Großempfänger finden:</h3>
<h3 class="search_ip4" style="display:none;">Postlagerausgabe finden:</h3>
<h3 class="search_ip5" style="display:none;">Erweiterte Suche:</h3>
</td>
<td rowspan="2" valign="bottom" style="padding:17px 22px;">
<a href="#find" id="search_btn_find" class="search_btn_find" onclick="return false;">Finden
<span>
<img src="images/sqbl.png" height="17px" width="18px"/>
</span>
</a>
<br/>
<a href="#searchAdvanced" id="searchAdvanced" class="standalone_l" title="Erweiterte Suche ">Erweiterte Suche </a>
</td>
</tr>
<tr>
<td colspan="4" style="">
<div class="search_error" style="display:none;">
<div class="search_error_text"> </div>
</div>
<div class="search_ip0">
<input id="search_plz_city" class="long" value="Geben Sie einen Ort ein." name="plz_city" maxlength="100"/>
<input id="search_plz_city_clear" type="hidden" name="plz_city_clear" value="" maxlength="100"/>
<input id="search_plz_plz" type="hidden" name="plz_plz" value="" maxlength="100"/>
<input id="search_plz_district" type="hidden" name="plz_district" value="" maxlength="100"/>
</div>
<div class="search_ip0">
<input type="hidden" name="finda" value="plz"/>
<input id="search_plz_street" class="long" value="Geben Sie Straße und Hausnummer ein." name="plz_street" maxlength="100"/>
</div>
<div class="search_ip1" style="display:none;">
<input type="hidden" name="finda" value="city"/>
<input id="search_city" class="long" value="Geben Sie eine Postleitzahl ein." name="city" maxlength="100"/>
</div>
<div class="search_ip2" style="display:none;">
<input type="hidden" name="finda" value="box"/>
<input type="hidden" name="box_plz" id="search_box_plz" value=""/>
<input id="search_box" class="long" value="Geben Sie eine Postfach-Postleitzahl oder einen Ort ein." name="box" maxlength="100" onfocus="$('#search_box_plz').val('');"/>
</div>
<div class="search_ip3" style="display:none;">
<input id="search_customer_name" class="long" value="Geben Sie einen Großempfänger ein." name="customer_name" maxlength="100" onfocus="$('#search_customer_name').flushCache();"/>
</div>
<div class="search_ip3" style="display:none;">
<input type="hidden" name="finda" value="customer"/>
<input id="search_customer_city" class="long" value="Geben Sie Postleitzahl oder Ort ein." name="customer_city" maxlength="100" onfocus="$('#search_customer_city').flushCache();"/>
</div>
<div class="search_ip4" style="display:none;">
<input type="hidden" name="finda" value="prestante"/>
<input type="hidden" name="prestante_plz" id="search_prestante_plz" value=""/>
<input id="search_prestante" class="long" value="Geben Sie einen Ort ein." name="prestante" maxlength="100" onfocus="$('#search_prestante_plz').val('');"/>
</div>
<div class="search_ip5" style="display:none;">
<div style="width: 25%; float:left;">
<div style="padding-right:8px;">
<input id="search_adv_plz" name="adv_plz" value="Postleitzahl" class="long" maxlength="5" style="min-width: 100px;"/>
</div>
</div>
<div style="width: 75%; float: left;">
<div style="padding-left: 8px;">
<input id="search_adv_city" value="Geben Sie einen Ort ein." name="adv_city" class="long" maxlength="100" style="min-width: 280px;"/>
</div>
</div>
<input id="search_adv_city_clear" type="hidden" name="adv_city_clear" value="" maxlength="100"/>
<input id="search_adv_district" type="hidden" name="adv_district" value="" maxlength="100"/>
</div>
<div class="search_ip5" style="display:none; clear: both;">
<input type="hidden" name="finda" value="adv"/>
<input id="search_adv_street" class="long" value="Geben Sie Straße und Hausnummer ein." name="adv_street" maxlength="100"/>
</div>
</td>
</tr>
<tr id="search_std_radios">
<td class="search_radio pright">
<input type="radio" name="search_radio" id="search_radio_0" value="0" checked="checked"/> <label id="radio_label0" for="search_radio_0">Postleitzahl</label>
</td>
<td class="search_radio pleft pright">
<input type="radio" name="search_radio" id="search_radio_1" value="1"/> <label id="radio_label1" for="search_radio_1">Ort</label>
</td>
<td class="search_radio pleft pright">
<input type="radio" name="search_radio" id="search_radio_2" value="2"/> <label id="radio_label2" for="search_radio_2">Postfächer</label>
</td>
<td class="search_radio pleft pright">
<input type="radio" name="search_radio" id="search_radio_3" value="3"/> <label id="radio_label3" for="search_radio_3">Großempfänger</label>
</td>
<td class="search_radio pleft" style=""/>
</tr>
</table>
<div id="search_adv_txt" style="position:absolute; display:none;">Ideal für die Klärung unvollständiger oder unleserlicher Adressen.<br />Ergänzen Sie bitte die Eingabefelder mit wenigen Buchstaben oder Ziffern und finden Sie die übereinstimmenden Ergebnisse.</div>
</form>
</div>
<div id="frame_bb_1" class="frame_bb"> 
                         
                    </div>
<div style="height:25px; font-size:1px; line-height:1px; margin: 0px; padding:0px;"> </div>
</div>
<div id="print_header">
<img id="print_header_plzs" src="images/print_header_plzs.png" style="border:0px; float:left; display:block;" alt="Postleitzahlensuche"/>
<img id="print_header_dp" src="images/print_header_dp.png" style="border:0px; float:right; display:block;" alt="Deutsche Post"/>
</div>
<div id="home" class="clearfix">
<div id="add1" class="home_adds">
                        <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" width="270" height="115" id="270x115" align="middle">
                                <param name="movie" value="images/270x115_epostbrief.swf" />
                                <param name="quality" value="high" />
                                <param name="bgcolor" value="#ffffff" />
                                <param name="play" value="true" />
                                <param name="loop" value="true" />
                                <param name="wmode" value="transparent" />
                                <param name="scale" value="showall" />
                                <param name="menu" value="true" />
                                <param name="devicefont" value="false" />
                                <param name="salign" value="" />
                                <param name="allowScriptAccess" value="sameDomain" />
                                <!--[if !IE]>-->
                                <object type="application/x-shockwave-flash" data="images/270x115_epostbrief.swf" width="270" height="115">
                                        <param name="movie" value="270x115.swf" />
                                        <param name="quality" value="high" />
                                        <param name="bgcolor" value="#ffffff" />
                                        <param name="play" value="true" />
                                        <param name="loop" value="true" />
                                        <param name="scale" value="showall" />
                                        <param name="menu" value="true" />
                                        <param name="devicefont" value="false" />
                                        <param name="salign" value="" />
                                        <param name="allowScriptAccess" value="sameDomain" />
                                <!--<![endif]-->
                                        <a href="http://www.adobe.com/go/getflash">
                                                <img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Get Adobe Flash Player" />
                                        </a>
                                <!--[if !IE]>-->
                                </object>
                                <!--<![endif]-->
                        </object>
                        
                      </div>
<div id="add2" class="home_adds">
                           <div class="add_text">PLZ&nbsp;+&nbsp;Stra&szlig;en&nbsp;<br/>auf&nbsp;CD-ROM</div>
                           <div>
                              <a class="advert_link" target="_blank" title="Zur DATAFACTORY" href="http://www.deutschepost.de/de/d/deutsche-post-direkt/datafactory.html">Zur DATAFACTORY</a>
                           </div>
                        </div>
<div id="add3" class="home_adds">
                            <div class="add_text">Adressen<br/>aktualisieren</div>
                            <div>
                               <a class="advert_link" target="_blank" title="Zur ADDRESSFACTORY" href="http://www.deutschepost.de/dpag?xmlFile=1015">Zur ADDRESSFACTORY</a>
                            </div>
                        </div>
<div id="add4" class="home_adds">
                           <div class="add_text">PLZ<br/>&Auml;nderungen</div>
                           <div>
                              <a class="advert_link" target="_blank"  title="Alle Infos" href="http://www.deutschepost.de/de/d/deutsche-post-direkt/datafactory/download_postleitdaten.html" >Alle Infos</a>
                           </div>
                           </div>
</div>
<div id="configurator" class="clearfix" style="display:none">
<div class="frame_bt"> </div>
<div class="frame_rl clearfix content_padding">
<div id="search_mapvisual2">
<a title="Neue PLZ-Suche starten" href="http://www.postdirekt.de/plzserver/">
<img src="images/sqbl.png" style="height:100%; width:100%; border:0px;" alt="Neue PLZ-Suche starten"/>
</a>
</div>
<h3>PLZ-Suche für Ihre Homepage</h3>
                        Binden Sie die PLZ-Suche <span style="font-weight:bold;">in nur 3 Schritten</span> als Mini-Applikation auf Ihrer Homepage ein.
                        <div style="padding:15px 0px 15px 0px;">
<ol>
<li>Passen Sie das Layout nach ihren Wünschen mit Hilfe des Konfigurators an.</li>
<li>Kopieren Sie das erzeugte JavaScript-Snippet.</li>
<li>Fügen Sie es in den HTML-Quellcode Ihrer Webseite an beliebiger Stelle zwischen den &lt;body&gt;-Tags ein.</li>
</ol>
</div>
<span style="font-weight:bold;">Fertig!</span> Jetzt ist die PLZ-Suche auf auf ihrer Homepage zu finden!
                    </div>
<div class="frame_bb"> </div>
<div style="height:24px; font-size:1px; line-height:1px; margin: 0px; padding:0px;"> </div>
<div class="frame_bt"> </div>
<div class="frame_rl clearfix content_padding">
<h3>Konfigurator für die PLZ-MiniApp</h3>
<div style="width:450px; float:left; background-color:transparent; padding-top:10px;">
<ol>
<li>Verändern Sie die Parameter nach Ihren Wünschen
                                und überprüfen Sie das Resultat in der Live-Vorschau.
                                    <div style="padding:20px 0px 20px 20px;">
<form id="cfg" method="get" target="plzsifr" action="http://www.postdirekt.de/plzserver/PlzSearchServlet">
<table style="width:250px;">
<tr>
<td class="ma_header">Maße</td>
<td> </td>
</tr>
<tr>
<td>Breite <span class="ma_smaller">(200-350px)</span>
</td>
<td class="ma_alr">
<input name="w" id="w" type="text" class="mc" value="275" maxlength="3"/>
</td>
</tr>
<tr>
<td>Höhe <span class="ma_smaller">(315-450px)</span>
</td>
<td class="ma_alr">
<input name="h" id="h" type="text" class="mc" value="335" maxlength="3"/>
</td>
</tr>
<tr>
<td>Rahmendicke <span class="ma_smaller">(0-5px)</span>
</td>
<td class="ma_alr">
<input name="fr" id="fr" type="text" class="mc" value="1" maxlength="1"/>
</td>
</tr>
<tr>
<td class="ma_header">Farben</td>
<td> </td>
</tr>
<tr>
<td>Rahmenfarbe</td>
<td class="ma_alr">
<input name="frc" id="frc" type="text" class="mc" value="000000" maxlength="7"/>
</td>
</tr>
<tr>
<td>Hintergrundfarbe</td>
<td class="ma_alr">
<input name="bg" id="bg" type="text" class="mc" value="F8F8F8" maxlength="7"/>
</td>
</tr>
<tr>
<td>Sucheingabefeld</td>
<td class="ma_alr">
<input name="hl2" id="hl2" type="text" class="mc" value="A5A5A5" maxlength="7"/>
</td>
</tr>
<tr>
<td>Schriftfarbe</td>
<td class="ma_alr">
<input name="fc" id="fc" type="text" class="mc" value="000000" maxlength="7"/>
</td>
</tr>
<tr>
<td>Linkfarbe</td>
<td class="ma_alr">
<input name="lc" id="lc" type="text" class="mc" value="000000" maxlength="7"/>
</td>
</tr>
<tr>
<td class="ma_header">Schrift</td>
<td> </td>
</tr>
<tr>
<td>Schriftart</td>
<td class="ma_alr">
<select name="ff" id="ff" class="mc">
<option selected="selected">Arial</option>
<option>Tahoma</option>
<option>Verdana</option>
</select>
</td>
</tr>
<tr>
<td>Schriftgröße<br/>
<span class="ma_smaller">der Ergebnisliste</span>
</td>
<td class="ma_alr">
<select name="fs" id="fs" class="mc">
<option>10</option>
<option selected="selected">11</option>
<option>12</option>
<option>13</option>
<option>14</option>
</select>
</td>
</tr>
</table>
<input name="lnc" id="lnc" type="hidden" maxlength="7"/>
<input name="hdc" id="hdc" type="hidden" maxlength="7"/>
<input name="app" value="miniapp" type="hidden" readonly="readonly"/>
<input name="edit" value="true" type="hidden" readonly="readonly"/>
</form>
</div>
</li>
<li>Kopieren Sie den generierten Code und binden 
                                    Sie ihn in den HTML-Code Ihrer Webseite ein.
                                    <div style="padding:20px 0px 20px 20px; margin:0px;">
<form action="javascript: return false;">
<textarea id="cfg_src" style="width:375px; height:75px; padding:0px; margin:0px;" cols="30" rows="10">
<!-- -->
</textarea>
</form>
</div>
</li>
</ol>
</div>
<div style="float:left; background-color:transparent;  padding-top:25px; margin-left:25px;">
<div id="plzsdiv" style="padding:0px; margin:0px; height: 335px; width: 275px; border:1px solid #000000">
<iframe id="plzsifr" name="plzsifr" src="blank.html" style="width:100%; height:100%;" marginwidth="0" marginheight="0" scrolling="no" frameborder="0">
<!-- -->
</iframe>
<!-- -->
</div>
</div>
</div>
<div class="frame_bb"> </div>
</div>
<div id="plugins" class="clearfix" style="display:none">
<div class="frame_bt"> </div>
<div class="frame_rl clearfix content_padding">
<div id="search_mapvisual3">
<a title="Neue PLZ-Suche starten" href="http://www.postdirekt.de/plzserver/">
<img src="images/sqbl.png" style="height:100%; width:100%; border:0px;" alt="Neue PLZ-Suche starten"/>
</a>
</div>
<h3>PLZ-Suche Browser-Plugin</h3>
<p>Wenn Sie häufig Anfragen an die PLZ-Suche stellen, können Sie diese jetzt direkt in die Suchleiste Ihres Browsers einbinden. <br/>(Folgende Browser werden unterstützt: FireFox ab Version 2, Internet Explorer ab Version 7)</p>
<h4>So funktioniert's:</h4>
<p>Aktivieren Sie die Funktion durch einen Klick auf den Button "Plugin hinzufügen".<br/>Danach sind es nur noch zwei Schritte bis zur gesuchten Postleitzahl:</p>
<ol>
<li>PLZ-Suche in der Suchleiste Ihres Browsers auswählen.</li>
<li>Ortsnamen in das Suchfeld eingeben und die PLZ-Suche öffnet sich sofort mit dem Suchergebnis.</li>
</ol>
<a href="#" id="btn_addplugin" class="btn_addplugin" onclick="plzs.other.addEngine('plzsuche-de'); return false;">
<img src="images/sqbl.png" alt=""/>
</a>
</div>
<div class="frame_bb"> </div>
</div>
<div id="search_results" class="clearfix" style="display:none">
<div id="ctabs">
<a href="#" onclick="return false;" id="ct_list" class="ctab ct_list">
<img src="images/sqbl.png" class="ct0_img" alt=""/>
</a>
<a href="#" onclick="return false;" id="ct_map" class="ctab ct_map_na" style="">
<img src="images/sqbl.png" class="ct1_img" alt=""/>
</a>
</div>
<div id="tcontent">
<div id="frame_bt_2" class="frame_bt"> 
                                            
                    </div>
<div id="frame_rl_2" class="frame_rl clearfix">
<div id="tab_content_list" class="content_padding" style="z-index:20; display: none;">
<div id="search_hint" style="display:none;">Dies ist ein Hinweis!</div>
<div id="search_tables" style="width: 100%;">
<div id="ltable_div" style="float:left; display:block;" class="clearfix">
<div class="ltable_top">
<span id="ltable_info" class="info"> </span>
<span id="ltable_pager" class="pager">
<span class="pagedisplay"> </span>
</span>
</div>
<table id="ltable" class="ltable">
<tr>
<td> </td>
</tr>
</table>
<div class="ltable_bottom">
<span id="ltable_pager2" class="pager">
<span class="pagedisplay"> </span>
</span>
</div>
</div>
<div id="dtable_div" style="float:left; display:none;" class="clearfix">
<a href="javascript:plzs.tables.switchToTable('ltable')" class="link_back">
<span>zurück</span>
</a>
<div class="ltable_top" style="padding-top:10px;">
<span id="dtable_info" class="info"> </span>
<span id="dtable_pager" class="pager">
<span class="pagedisplay"> </span>
</span>
</div>
<table id="dtable" class="ltable">
<tr>
<td> </td>
</tr>
</table>
<div class="ltable_bottom">
<span id="dtable_pager2" class="pager">
<span class="pagedisplay"> </span>
</span>
</div>
</div>
<div id="stable_div" style="float:left; display:none;" class="clearfix">
<a href="javascript:plzs.tables.switchToTable(plzs.tables.lastTable)" class="link_back">
<span>zurück</span>
</a>
<div class="ltable_top" style="padding-top:10px;">
<span id="stable_info" class="info"> </span>
<span id="stable_pager" class="pager">
<span class="pagedisplay"> </span>
</span>
</div>
<table id="stable" class="ltable">
<tr>
<td> </td>
</tr>
</table>
<div class="ltable_bottom">
<span id="stable_pager2" class="pager">
<span class="pagedisplay"> </span>
</span>
</div>
</div>
</div>
<div id="div_print_link">
<a href="#" onclick="window.print(); return false;">Ausdrucken</a>
<a href="#" onclick="window.print(); return false;">
<img src="images/ausdrucken.gif" alt="Ausdrucken" title="Ausdrucken"/>
</a>
</div>
</div>
<div id="tab_content_map" class="content_padding" style="z-index:30; display:none;"><div id="i_map" style="height: 450px; width: 930px;"></div>
<div id="map_printtext"> </div>
</div>
</div>
<div id="frame_bb_2" class="frame_bb"> 
                             
                        </div>
</div>
<div id="wbox" class="display_none clearfix" style="margin: 19px 0 0 0;">
<div class="frame_bt"> </div>
<div style="padding: 0px 20px 0px 20px;" class="frame_rl">
<h3>Sendung vorbereiten und einliefern</h3><a href="http://standorte.deutschepost.de/Standortsuche" target="_blank" class="clb clb1"><img src="images/sqbl.png" alt="Standorte suchen"/></a>
                            <a id = "banner007" href="https://www.efiliale.de/" target="_blank" class="clb clb2"><img src="images/sqbl.png" alt="Briefmarken kaufen"/></a>
                            <a href="http://www.deutschepost.de/dpag?xmlFile=link1016051_5020" target="_blank" class="clb clb3"><img src="images/sqbl.png" alt="Infopost-Manager"/></a>
                            <a href="http://www.prospektservice.de" target="_blank" class="clb clb4"><img src="images/sqbl.png" alt="Prospektservice"/></a>
                            </div>
<div class="frame_bb"> </div>
</div>
</div>
<div id="print_footer">
<div id="print_footer_text">http://www.postdirekt.de/plzserver,  Ausdruck vom 30.10.2014</div>
</div>
<div id="lbox" class="display_none"/>
</div>
</div>
<div class="foot clearfix" role="contentinfo">
<div class="all">
<div class="foot-content clearfix">
<div class="foot-area-1">
<ul class="linklist inline clearfix">
<li>
<a href="#Nutzungsbedingungen" onclick="plzs.other.termsofuse.show(); return false;">Nutzungsbedingungen</a>
</li>
<li>
<a id="link_ma" href="#">PLZ-Suche für Ihre Homepage</a>
</li>
<li>
<a id="link_bp" href="#">PLZ Browser <abbr title="Erweiterung">Plugin</abbr>
</a>
</li>
<li>
<a href="http://www.deutschepost.de/dpag/multiapps?xmlFile=1011404">E-Mail-Kontakt</a>
</li>
</ul>
</div>
<div class="foot-area-2">
<a class="standalone" href="PlzSearchServlet?lang=en_GB" title="English version">English version</a>
</div>
</div>
<div class="foot-sub clearfix">
<div class="foot-area-1">
<p class="foot-copyright">© 2010 Deutsche Post AG</p>
<ul class="inline clearfix">
<li>
<a id="foot-nav-ueberdp" href="http://www.deutschepost.de/dpag?xmlFile=1015282">Über die Deutsche Post</a>
</li>
<li>
<a id="foot-nav-impressum" href="http://www.deutschepost.de/dpag?xmlFile=30521">Impressum</a>
</li>
<li>
<a id="foot-nav-datenschutz" href="http://www.deutschepost.de/dpag?xmlFile=35369">Datenschutz</a>
</li>
<li class="last">
<a id="foot-nav-rechtliche-hinweise" href="http://www.deutschepost.de/dpag?xmlFile=1015345">Rechtliche Hinweise</a>
</li>
</ul>
</div>
<div class="foot-area-2">
<a class="foot-logo" id="foot-logo" href="http://www.dp-dhl.com/de" target="_blank">
<img alt="Deutsche Post DHL - Die Post- und Logistikgruppe" src="images/global/logo_konzern.png"/>
</a>
<ul class="inline clearfix">
<li>
<a id="foot-nav-konzern" href="http://www.dp-dhl.de" target="_blank">Konzern</a>
</li>
<li>
<a id="foot-nav-karriere" href="http://www.dp-dhl-karriere.de" target="_blank">Karriere</a>
</li>
<li>
<a id="foot-nav-presse" href="http://www.dp-dhl.de/presse" target="_blank">Presse</a>
</li>
<li class="last">
<a id="foot-nav-investoren" href="http://investors.dp-dhl.de" target="_blank">Investoren</a>
</li>
</ul>
</div>
</div>
</div>
</div>
</body>
</html> 