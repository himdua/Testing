%{--
  JBILLING CONFIDENTIAL
  _____________________

  [2003] - [2012] Enterprise jBilling Software Ltd.
  All Rights Reserved.

  NOTICE:  All information contained herein is, and remains
  the property of Enterprise jBilling Software.
  The intellectual and technical concepts contained
  herein are proprietary to Enterprise jBilling Software
  and are protected by trade secret or copyright law.
  Dissemination of this information or reproduction of this material
  is strictly forbidden.
  --}%


<%--
  Percentage pricing form.

  @author Brian Cowdery
  @since  08-Feb-2011
--%>

<g:hiddenField name="model.${modelIndex}.id" value="${model?.id}"/>
<g:set var="planIndex" value="${planIndex ?: ''}"/>

<g:applyLayout name="form/select">
    <content tag="label"><g:message code="plan.model.type"/></content>
    <content tag="label.for">model.${modelIndex}.type</content>
    <content tag="label.title"><g:message code="price.strategy.COMMON.pricing.tooltip.message"/></content>
    <content tag="label.class">toolTipElement</content>
    <g:select name="model.${modelIndex}.type" class="model-type toolTipElement"
              title="${message(code: 'price.strategy.COMMON.pricing.tooltip.message')}"
              from="${types}"
              keys="${types*.name()}"
              valueMessagePrefix="price.strategy"
              value="${model?.type ?: type.name()}"/>

    <g:hiddenField name="model.${modelIndex}.oldType" value="${model?.type ?: type.name()}"/>

    <a onclick="openHelpDialog(${planIndex + type?.name() + modelIndex});">
        <img class="toolTipElement" title="${message(code: 'price.strategy.COMMON.pricing.help.tooltip.message')}" src="${resource(dir: 'images', file: 'question.png')}" alt="more">
    </a>
</g:applyLayout>
