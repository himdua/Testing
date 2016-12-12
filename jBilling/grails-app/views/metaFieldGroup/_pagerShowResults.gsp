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

%{--In metafields group we need to send additional params to action to identify the type of metafields group and
 response was missing when we use generic pagerShowResultTemplate so added showResults function to render response.
--}%
<g:message code="pager.show.max.results"/>

<g:each var="max" in="${steps}">
    <g:if test="${params.max == max}">
        <span>${max}</span>
    </g:if>
    <g:else>
        <g:remoteLink onSuccess="showResults(data);" action="${action ?: 'list'}" id="${entityType}"  params="${sortableParams(params: [template:'list',partial: true, max: max,id:id, contactFieldTypes: contactFieldTypes ?: null])}" update="${update}">${max}</g:remoteLink>
    </g:else>
</g:each>

<script type="text/javascript">
    function showResults(data){
        $('#column2').html(data);
    }
</script>
