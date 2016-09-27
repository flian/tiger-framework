$(function(){
    var inputVal;
    var int01Val = "业务积分";
    var int02Val = "购货积分";
    var $_closeBtn = $(".closeBtn");
    var $_layerDiv = $("#layerDiv");
    var $_layerCont = $("#layerCont");
    var $_layerCont01 = $(".layerCont01");
    var $_layerCont02 = $(".layerCont02");
    var $_intBtn = $(".intBtn");
    var $_theBtn = $(".theBtn");
    var $_sureBtn = $(".sureBtn");

    $_closeBtn.on("click",function(){
        $_layerDiv.addClass("inHide");
        $_layerCont.addClass("inHide");
        $_layerCont01.addClass("inHide");
        $_layerCont02.addClass("inHide");
    });

    $_theBtn.on("click",function(){
        inputVal = $(".intInput").val();
        if(inputVal){
            $_layerDiv.removeClass("inHide");
            $_layerCont.removeClass("inHide");
            $_layerCont01.removeClass("inHide");
            $(".layerContText span:nth-of-type(1)").text(inputVal);
            $(".layerContText span:nth-of-type(2)").text(int01Val);
            $(".layerContText span:nth-of-type(5)").text(int02Val);
        }else{
			layer.msg('请填写积分！',{time:2000});
        }
    });

    $_intBtn.on("click",function(){
        if(int01Val == "业务积分"){
            int01Val = "购货积分";
            int02Val = "业务积分";
            $(".int01").text(int01Val);
            $(".int02").text(int02Val);
        }else{
            int01Val = "业务积分";
            int02Val = "购货积分";
            $(".int01").text(int01Val);
            $(".int02").text(int02Val);
        }
    });

    $_sureBtn.on("click",function(){
        $_layerCont01.addClass("inHide");
        $_layerCont02.removeClass("inHide");
    });
});