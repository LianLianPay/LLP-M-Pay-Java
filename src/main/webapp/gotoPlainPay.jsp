<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Pragma" content="no-cache" />  
<meta http-equiv="Expires" content="-1" />  
<meta http-equiv="Cache-Control" content="no-cache" /> 
<title>pay</title>
<style>
.box{ width:450px; height:240px; margin:0 auto; position:absolute; top:50%; left:50%; margin-top:-99px; margin-left:-225px; text-align:center;}
</style>
</head>
<body>
        <div class="box"><img src="images/jump_pic01.png" /></div>
        <form id="payBillForm" action="<%=request.getAttribute("gateway_url")%>" method="post">
        </form>
</body>
</html>
 <script language="javascript" type="text/javascript">
 window.onload=function(){
 document.getElementById("payBillForm").submit();
 }
  </script>
