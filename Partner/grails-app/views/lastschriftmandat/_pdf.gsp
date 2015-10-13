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
				<td><b>Gabriele und Peter Strotmann</b></td>
			    <td>              </td>
			    <td>              </td>
			    <td>Tel.: 0231-803441</td>
			</tr>
			<tr>
				<td>Am Gulloh 49</td>
			    <td>              </td>
			    <td>              </td>
			    <td>              </td>
			</tr>
			<tr>
				<td>44339 Dortmund</td>
				<td> </td>
				<td> </td>
			    <td>${form?.gueltigAb}</td>
			</tr>
		</table>
		
		<p><br></br><br></br></p>

		<table>
			<tr>
				<td>${form?.mandatTypKlar}</td>
			</tr>
			<tr>
				<td>${form?.mandatsReferenz}</td>
			</tr>
		</table>
		
		<p>
		dieses ist ein Sepa Lastschriftmandat mit obigen Daten
		</p>
			
	</div>
</body>
</html>