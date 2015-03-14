<%@ page import="org.strotmann.mail.EmailAnhang" %>



<div class="fieldcontain ${hasErrors(bean: emailAnhangInstance, field: 'dateiname', 'error')} required">
	
	<g:uploadForm action="upload" id="flash.email.id">
		<input type="file" name="file" />
    	<g:submitButton name="create" class="save" value="${message(code: 'default.button.anhang.label', default: 'Anhängen')}" />
	</g:uploadForm>
	
</div>

<div class="fieldcontain ${hasErrors(bean: emailAnhangInstance, field: 'eMail', 'error')} required">
	<g:if test="${session.email}">
		<g:select id="eMail" name="eMail.id" from="${session.email}" optionKey="id" required="" value="${emailAnhangInstance?.eMail?.id}" class="many-to-one"/>
	</g:if>
	<g:else>
		<g:select id="eMail" name="eMail.id" from="${org.strotmann.mail.Email.list()}" optionKey="id" required="" value="${emailAnhangInstance?.eMail?.id}" class="many-to-one"/>
	</g:else>
</div>

