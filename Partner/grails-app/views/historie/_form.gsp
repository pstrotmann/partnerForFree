<%@ page import="org.strotmann.partner.Historie" %>



<div class="fieldcontain ${hasErrors(bean: historieInstance, field: 'userName', 'error')} required">
	<label for="userName">
		<g:message code="historie.userName.label" default="User Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="userName" required="" value="${historieInstance?.userName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: historieInstance, field: 'gueAb', 'error')} required">
	<label for="gueAb">
		<g:message code="historie.gueAb.label" default="Gue Ab" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="gueAb" precision="day"  value="${historieInstance?.gueAb}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: historieInstance, field: 'domainName', 'error')} required">
	<label for="domainName">
		<g:message code="historie.domainName.label" default="Domain Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="domainName" required="" value="${historieInstance?.domainName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: historieInstance, field: 'domainId', 'error')} required">
	<label for="domainId">
		<g:message code="historie.domainId.label" default="Domain Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="domainId" type="number" value="${historieInstance.domainId}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: historieInstance, field: 'feldName', 'error')} ">
	<label for="feldName">
		<g:message code="historie.feldName.label" default="Feld Name" />
		
	</label>
	<g:textField name="feldName" value="${historieInstance?.feldName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: historieInstance, field: 'stringInhalt', 'error')} ">
	<label for="stringInhalt">
		<g:message code="historie.stringInhalt.label" default="String Inhalt" />
		
	</label>
	<g:textField name="stringInhalt" value="${historieInstance?.stringInhalt}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: historieInstance, field: 'charInhalt', 'error')} ">
	<label for="charInhalt">
		<g:message code="historie.charInhalt.label" default="Char Inhalt" />
		
	</label>
	<g:field name="charInhalt" type="number" value="${historieInstance.charInhalt}" />

</div>

<div class="fieldcontain ${hasErrors(bean: historieInstance, field: 'intInhalt', 'error')} ">
	<label for="intInhalt">
		<g:message code="historie.intInhalt.label" default="Int Inhalt" />
		
	</label>
	<g:field name="intInhalt" type="number" value="${historieInstance.intInhalt}" />

</div>

<div class="fieldcontain ${hasErrors(bean: historieInstance, field: 'longInhalt', 'error')} ">
	<label for="longInhalt">
		<g:message code="historie.longInhalt.label" default="Long Inhalt" />
		
	</label>
	<g:field name="longInhalt" type="number" value="${historieInstance.longInhalt}" />

</div>

<div class="fieldcontain ${hasErrors(bean: historieInstance, field: 'dateInhalt', 'error')} ">
	<label for="dateInhalt">
		<g:message code="historie.dateInhalt.label" default="Date Inhalt" />
		
	</label>
	<g:datePicker name="dateInhalt" precision="day"  value="${historieInstance?.dateInhalt}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: historieInstance, field: 'booleanInhalt', 'error')} ">
	<label for="booleanInhalt">
		<g:message code="historie.booleanInhalt.label" default="Boolean Inhalt" />
		
	</label>
	<g:checkBox name="booleanInhalt" value="${historieInstance?.booleanInhalt}" />

</div>

