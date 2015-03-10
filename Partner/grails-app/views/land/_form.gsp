<%@ page import="org.strotmann.partner.Land" %>



<div class="fieldcontain ${hasErrors(bean: landInstance, field: 'kfzKz', 'error')} required">
	<label for="kfzKz">
		<g:message code="land.kfzKz.label" default="Kfz Kz" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="kfzKz" required="" value="${landInstance?.kfzKz}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: landInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="land.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${landInstance?.name}"/>

</div>

