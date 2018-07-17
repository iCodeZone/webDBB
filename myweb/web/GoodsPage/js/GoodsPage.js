

$(document).ready(function(){            //个人信息点击事件
    $(".pict").click(function(){
    	var gno=$(this).attr("name");
        location.href="../purchase/One_good.jsp?gno="+gno;
  });
});