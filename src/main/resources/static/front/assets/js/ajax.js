$(function () {

    /*提交建议的*/
    const submitVal = $("#mysuggestion");
    const subbtn = $(".main-btn");

    subbtn.click(function (ev) {

        ev.preventDefault();

    });

    /*注册全局的搜索按钮*/
     const searchName= $("#search-name");
     const searchVal = searchName.val();
     const searchBtn = $("#search-btn");



    searchBtn.click(function (ev) {

        const searchForm = $(".search-form >form");

        searchForm.attr("action","/search");

        searchForm.attr("method","post");

        searchForm.submit();

        ev.preventDefault();
    });

   $("#orderbyPrice").change(function () {
       var $orderByBrand = $("#orderByBrand option:selected").val();
       console.log($orderByBrand);
       var $orderbyPrice= $("#orderbyPrice option:selected").val();
       console.log($orderbyPrice);

        if ($("#orderByBrand option:selected").val()!=1){
            $.ajax({
                url: '/oderBy',//url地址
                type: 'get',//发送方式
                data: 'orderByPrice='+ $orderbyPrice +'&orderByBrand='+$orderByBrand,
                success: function () {
                    window.location.href='/oderBy?orderByBrand='+$orderByBrand +'&orderByPrice='+$orderbyPrice
                }
            });
        }else {
            $.ajax({
                url: '/oderBy',//url地址
                type: 'get',//发送方式
                data: 'orderByPrice='+ $orderbyPrice +'&orderByBrand='+$orderByBrand,
                success: function () {
                    window.location.href='/oderBy?orderByBrand=' +'&orderByPrice='+$orderbyPrice
                }
            });
        }


   });
    $("#orderByBrand").change(function () {
        var $orderbyPrice = $("#orderbyPrice option:selected").val();
        console.log($orderbyPrice);
        var $orderByBrand = $("#orderByBrand option:selected").val();
        console.log($orderByBrand);
        if ($("#orderbyPrice option:selected").val()!=1){

            $.ajax({
                url: '/oderBy',
                type: 'get',
                data: 'orderByBrand='+$orderByBrand +'&orderByPrice='+$orderbyPrice,
                success: function () {

                   window.location.href='/oderBy?orderByBrand='+$orderByBrand +'&orderByPrice='+$orderbyPrice
                }
            });
        }else {
            $.ajax({
                url: '/oderBy',//url地址
                type: 'get',//发送方式
                data: 'orderByPrice='+ $orderbyPrice +'&orderByBrand='+$orderByBrand,
                success: function () {
                    window.location.href='/oderBy?orderByBrand='+$orderByBrand +'&orderByPrice='
                }
            });
        }

    });



    var $commodityNum = $("#commodityNum").val();

    var $commodityid =$("#commodityid").val();

    $(".product-details-weight ul li p").click(function () {

        $(this).siblings("p").css({
            color:'black'
        });
        $(this).css({
            color:'blue'
        });
        $commodityNum = $(this).text();
    });

    $("#addShoppingCar").click(function () {

        $.ajax({
            url:'/addShoppingCar',
            type:'get',
            data:'num='+$commodityNum+'&sid='+$commodityid,
            success:function (map) {
                if (map!=null) {
                    window.location.href='./templates/shoppingcart.html'
                }
                else {
                    alert("购物车加购失败");
                }
            }
        });


        return false;
    })



});