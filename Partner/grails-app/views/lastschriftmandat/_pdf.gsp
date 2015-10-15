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
		    margin: 1.00in;
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
  		<table style="width:100%">
			<tr>
				<td><b>${form?.glaeubiger}</b></td>
			    <td>              </td>
			    <td>              </td>
			    <td>              </td>
			</tr>
			<tr>
				<td>${form?.glaeubiger.strasseHausnummer}</td>
			    <td>              </td>
			    <td>              </td>
			    <td>              </td>
			</tr>
			<tr>
				<td>${form?.glaeubiger.plzOrt}</td>
				<td> </td>
				<td> </td>
			    <td>${form?.gueltigAbKlar}</td>
			</tr>
		</table>
		
		<p><br></br><br></br></p>

		<table>
			<tr>
				<td>Gläubiger-Identifikationsnummer ${form?.glaeubiger.glaeubigerId}</td>
			</tr>
			<tr>
				<td>Mandatsreferenz ${form?.mandatsReferenz}</td>
			</tr>
			
		</table>
		
		<p><b>Sepa Lastschriftmandat</b></p>
		
		<g:if test="${form?.mandatTyp == 1 && form?.basis}">
		<p>
			Ich ermächtige ${form?.glaeubiger}, einmalig eine Zahlung von
			meinem Konto mittels Lastschrift einzuziehen. Zugleich weise ich mein
			Kreditinstitut an, die von ${form?.glaeubiger} auf mein Konto
			gezogene Lastschrift einzulösen. 
		</p>
		</g:if>
		<g:if test="${form?.mandatTyp == 2 && form?.basis}">
		<p>
			Ich ermächtige ${form?.glaeubiger}, Zahlungen von meinem Konto mittels
			Lastschrift einzuziehen. Zugleich weise ich mein Kreditinstitut an, die von
			${form?.glaeubiger} auf mein Konto gezogenen Lastschriften einzulösen. 
		</p>
		</g:if>
		<g:if test="${form?.mandatTyp == 1 && form?.firma}">
		<p>
			Wir ermächtigen ${form?.glaeubiger}, einmalig eine Zahlung von
			unserem Konto mittels Lastschrift einzuziehen. Zugleich weisen wir unser
			Kreditinstitut an, die von ${form?.glaeubiger} auf unser Konto
			gezogene Lastschrift einzulösen. 
		</p>
		</g:if>
		<g:if test="${form?.mandatTyp == 2 && form?.firma}">
		<p>
			Wir ermächtigen ${form?.glaeubiger}, Zahlungen von unserem Konto mittels
			Lastschrift einzuziehen. Zugleich weisen wir unser Kreditinstitut an, die von
			${form?.glaeubiger} auf unser Konto gezogenen Lastschriften einzulösen. 
		</p>
		</g:if>
			
	</div>
</body>
</html>