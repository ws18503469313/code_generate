package FreeMarker template error (DEBUG mode; use RETHROW in production!):
The following has evaluated to null or missing:
==> packagePath  [in template "model.ftl" at line 1, column 11]

----
Tip: If the failing expression is known to be legally refer to something that's sometimes null or missing, either specify a default value like myOptionalVar!myDefault, or use <#if myOptionalVar??>when-present<#else>when-missing</#if>. (These only cover the last step of the expression; to cover the whole expression, use parenthesis: (myOptionalVar.foo)!myDefault, (myOptionalVar.foo)??
----

----
FTL stack trace ("~" means nesting-related):
	- Failed at: ${packagePath}  [in template "model.ftl" at line 1, column 9]
----

Java stack trace (for programmers):
----
freemarker.core.InvalidReferenceException: [... Exception message was already printed; see it above ...]
	at freemarker.core.InvalidReferenceException.getInstance(InvalidReferenceException.java:131)
	at freemarker.core.EvalUtil.coerceModelToString(EvalUtil.java:355)
	at freemarker.core.Expression.evalAndCoerceToString(Expression.java:82)
	at freemarker.core.DollarVariable.accept(DollarVariable.java:41)
	at freemarker.core.Environment.visit(Environment.java:324)
	at freemarker.core.MixedContent.accept(MixedContent.java:54)
	at freemarker.core.Environment.visit(Environment.java:324)
	at freemarker.core.Environment.process(Environment.java:302)
	at freemarker.template.Template.process(Template.java:325)
	at com.generater.utils.FreemarkerUtil.generate(FreemarkerUtil.java:111)
	at com.generater.utils.FreemarkerUtil.paramsProcess(FreemarkerUtil.java:70)
	at com.generater.Test.main(Test.java:15)
