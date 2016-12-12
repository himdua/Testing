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

<html>
<head>
    <meta name="layout" content="configuration" />
</head>
<body>
    <content tag="menu.item">rating units</content>

    <content tag="column1">

    <g:render template="units" />
    </content>

    <content tag="column2">
        <g:if test="${selected}">
            <g:render template="show" model="[ selected: selected ]"/>
        </g:if>
        <g:elseif test="${ratingUnitWS}">
            <g:render template="edit" model="[ ratingUnitWS: ratingUnitWS]"/>
        </g:elseif>
    </content>
</body>
</html>