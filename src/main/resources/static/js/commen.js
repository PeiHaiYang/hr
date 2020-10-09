$(function () {
    /*进行将字符串的类型转化为json字符串*/
    function serializeObject(obj) {
        var resultes = {};
        var params = obj.serializeArray();
        //循环数组将数组元素添加到对象里边
        $.each(params,function (index,value) {
            resultes[value.name] = value.value;
        });
        //返回一个对象
        return resultes;
    }
    function formartDate() {
        var date = new Date();
        // 2018-4-3 21:30:23
        var arr = [date.getFullYear() + "-",
            date.getMonth() + 1 + "-",
            date.getDate() + " ",
            date.getHours() + ":",
            date.getMinutes() + ":",
            date.getSeconds()];
        return arr.join("");

    }
});
