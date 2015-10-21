<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html [
    <!ENTITY auml "ä">
    <!ENTITY ouml "ö">
    <!ENTITY uuml "ü">
    <!ENTITY Auml "Ä">
    <!ENTITY Ouml "Ö">
    <!ENTITY Uuml "Ü">
    <!ENTITY szlig "ß">
]>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="layout" content="main"/>
	<style>
		@page {
		    /*size: 8.5in 11.65in;   width height */
		    size: 210mm 297mm;  /* width height */
		    margin-left: 1.00in;
		    margin-top: 2.50in;
		}
		body{
			font-family: "Times New Roman",Georgia,Serif;
		}
		
		.briefDatum{
			font-size: 15pt;
		}
		
	</style>
</head>
<body>
  <div class="body">
<%--  		<img src="pLogo.png"/>--%>
  		<table style="width:100%">
			<tr>
				<td><b>${form.glaeubiger}</b></td>
			    <td>              </td>
			    <td>              </td>
			    <td>              </td>
			</tr>
			<tr>
				<td>${form.glaeubiger.postfachNr?'Postfach '+form.glaeubiger.postfachNr:form.glaeubiger.strasseHausnummer}</td>
			    <td>              </td>
			    <td>              </td>
			    <td>              </td>
			</tr>
			<tr>
				<td>${form.glaeubiger.postfachNr?form.glaeubiger.postfachPlzOrt:form.glaeubiger.plzOrt}</td>
				<td> </td>
				<td> </td>
			    <td> </td>
			</tr>
		</table>
		
		<p><br></br><br></br></p>

		<table>
			<tr>
				<td>Gläubiger-Identifikationsnummer <b>${form.glaeubiger.glaeubigerId}</b></td>
			</tr>
			<tr>
				<td>Mandatsreferenz <b>${form.mandatsReferenz}</b></td>
			</tr>
			
		</table>
		
		<p><b>Sepa Lastschriftmandat</b></p>
		<hr width="100"></hr>
		
		<g:if test="${form.basis}">
			<p>
				Ich ermächtige ${form.glaeubiger}, ${form.mandatTyp == 1?'einmalig eine Zahlung':'Zahlungen'} von
				meinem Konto mittels Lastschrift einzuziehen. Zugleich weise ich mein
				Kreditinstitut an, die von ${form.glaeubiger} auf mein Konto
				${form.mandatTyp == 1?'gezogene Lastschrift':'gezogenen Lastschriften'} einzulösen. 
			</p>
			<p>
				Hinweis: Ich kann innerhalb von acht Wochen, beginnend mit dem Belastungsdatum,
				die Erstattung des belasteten Betrages verlangen. Es gelten
				dabei die mit meinem Kreditinstitut vereinbarten Bedingungen. 
			</p>
		</g:if>
		<g:else>
			<p>
				Wir ermächtigen ${form.glaeubiger}, ${form.mandatTyp == 1?'einmalig eine Zahlung':'Zahlungen'} von
				unserem Konto mittels Lastschrift einzuziehen. Zugleich weisen wir unser
				Kreditinstitut an, die von ${form.glaeubiger} auf unser Konto
				${form.mandatTyp == 1?'gezogene Lastschrift':'gezogenen Lastschriften'} einzulösen. 
			</p>
			<p>
				Hinweis: Dieses Lastschriftmandat dient nur dem Einzug von Lastschriften,
				die auf Konten von Unternehmen gezogen sind. Wir sind nicht berechtigt,
				nach der erfolgten Einlösung eine Erstattung des belasteten Betrages zu
				verlangen. Wir sind berechtigt, unser Kreditinstitut bis zum Fälligkeitstag
				anzuweisen, ${form.mandatTyp == 1?'die Lastschrift':'Lastschriften'} nicht einzulösen. 
			</p>
		</g:else>
		
		<g:if test="${form?.bankverbindung}">
		<table style="width:100%">
			<tr>
				<td>Kontoinhaber</td>
				<td>${form.bankverbindung.partner}</td>
			</tr>
			<tr>
				<td>Anschrift</td>
				<td>${form.bankverbindung.partner.hausadresse}</td>
			</tr>
			<tr>
				<td>Geldinstitut (Name und BIC)</td>
				<td>${form.bankverbindung.nameUndAdresse} ${form.bankverbindung.BIC}</td>
			</tr>
			<tr>
				<td>IBAN</td>
				<td>${form.bankverbindung.iban}</td>
			</tr>
		</table>
		</g:if>
		<g:else>
		<table style="width:100%">
			<tr>
				<td>Kontoinhaber</td>
				<td>__________________________________________</td>
			</tr>
			<tr>
				<td>Anschrift</td>
				<td>__________________________________________</td>
			</tr>
			<tr>
				<td>Geldinstitut (Name und BIC)</td>
				<td>________________________________ _ _ _ _ _ _ _ _|_ _ _</td>
			</tr>
			<tr>
				<td>IBAN</td>
				<td>DE_ _|_ _ _ _|_ _ _ _|_ _ _ _|_ _ _ _|_ _</td>
			</tr>
		</table>
		</g:else>
		<p></p>
		<table style="width:100%">	
			<tr>
				<td>___________________________________</td>
				<td>___________________________________</td>
			</tr>
			<tr>
				<td>Ort, Datum</td>
				<td>Unterschift Kontoinhaber</td>
			</tr>
		</table>
		
		<g:if test="${form.abweichenderSchuldner}">
		<p>
			Dieses SEPA-Lastschriftmandat gilt für die Vereinbarung mit ${form.abweichenderSchuldner}
		</p>
		</g:if>
			
	</div>
</body>
</html>