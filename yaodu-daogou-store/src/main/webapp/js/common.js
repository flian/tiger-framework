// JavaScript Document

$(document).ready(function(){
	
	//tags 
	jQuery.jqtab = function(tabtit,tab_conbox,shijian) {
		$(tab_conbox).find(".cont").hide();
		$(tabtit).find("li:first").addClass("active").show(); 
		$(tab_conbox).find(".cont:first").show();
	
		$(tabtit).find("li").bind(shijian,function(){
		  $(this).addClass("active").siblings("li").removeClass("active"); 
			var activeindex = $(tabtit).find("li").index(this);
			$(tab_conbox).children(".cont").eq(activeindex).show().siblings().hide();
			return false;
		});
	
	};
	$.jqtab(".tags",".shown","click");
	
	//outLayer 
	$(".closed").click(function () {
		var winName=$(this).attr("data");
		$("#"+winName+",."+winName).hide();
	});	
	$(".showWin").click(function () {
		var winName=$(this).attr("data");
		$("#"+winName).fadeIn();
	});
	$(".like").click(function () {
		if($(this).find("i").attr("class")=="icon"){
			layer.msg('已点赞！',{time:1000});
			$(this).find("i").addClass("liked");
		}
		else{
			layer.msg('已经点过赞了！',{time:2000});
		}
	});	
	//
	$(".addCollect").click(function () {
		layer.msg('该礼品已加入收藏夹！',{time:2000});
	});	
	
	//
	$(".isDelete").click(function () {
		layer.confirm('是否确定删除该礼品？', {
			btn: ['确定','取消'] //按钮
		}, function(){
			layer.msg('已经删除该礼品', {icon:1,time:2000});
		});
	});
	
	$(".AddNumber").each(function() {
		var cNumber=$(this).parent().attr("id");
		$(this).unbind('click').click(function () {
			var i=parseInt($(this).parent().find("input").val());
			if(i>=200){
				layer.tips('数量超过最大值，请重新输入！','#'+cNumber,{tips:[1,"#FF9901"],time: 1000});
			}else{
				i++;
				$(this).parent().find("input").val(i);
			}
		});   
	});
	
	$(".reduceNumber").each(function() {
		var cNumber=$(this).parent().attr("id")
		$(this).unbind('click').click(function () {
			var i=parseInt($(this).parent().find("input").val());
			i--;
			if(i<1){
				layer.tips('数量必须大于等于1，请重新输入！','#'+cNumber,{tips:[1,"#FF9901"],time:2000});
			}else{				
				$(this).parent().find("input").val(i);
			}
		});   
	});

	
	$(".myUsed").click(function () {
		var tipsCont=$(this).attr("data");
		var tipsID=$(this).attr("id");
		layer.tips(tipsCont,'#'+tipsID);
		//alert(tipsID);
	});	
	//hover Css
	$(".productList .item").hover(function () {
    	$(this).addClass("active");
	}, function () {
		$(this).removeClass("active");
	});
	
	$(".addressRight .fonts").click(function () {
		$(this).parent().find(".subList").show();
	});
	
	$(".addressLeft").hover(function () {
		$(this).find(".subList").show();
	}, function () {
		$(this).find(".subList").hide();
	});
	
	$(".ticketList li").hover(function () {
		$(this).find(".ticket").addClass("active");
	}, function () {
		$(this).find(".ticket").removeClass("active");
	});
	
	$(".surveyList li").hover(function () {
		$(this).addClass("active");
	}, function () {
		$(this).removeClass("active");
	});
	
	//
	$(".radioItem").change(
		function() {
		var $selectedvalue = $("input[name='delivery']:checked").val();
		//alert($selectedvalue);
		if ($selectedvalue == 1) {
			$(this).parent().find("#stores").show();
			$(this).parent().find("#serviceCenter").hide();
		}
		else {
			$(this).parent().find("#stores").hide();
			$(this).parent().find("#serviceCenter").show();
		}
	});
	
	$(".collectList .item").hover(function () {
		$(this).find(".delete").show();
	},function () {
		$(this).find(".delete").hide();
	});
	
	//zjd
	var $_egg = $(".egg");
    var $_layerDiv = $("#layerDiv");
    var $_layerDiv02 = $("#layerDiv02");
    var $_toClose = $(".closeLayer,.toClose");

    $_egg.on("click",function(){
        $_layerDiv.removeClass("inHide");
        $_layerDiv02.removeClass("inHide");
    });

    $_toClose.on("click",function(){
        $_layerDiv.addClass("inHide");
        $_layerDiv02.addClass("inHide");
    });
});