<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">

                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">编辑已接订单</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">已接订单管理</li>
                        <li class="breadcrumb-item active">编辑已接订单</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">已接订单信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6 aaaaaa">
                                        <label>图纸信息</label>
                                        <div>
                                            <select id="tuzhiSelect" name="tuzhiSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>图纸标题</label>
                                        <input id="tuzhiName" name="tuzhiName" class="form-control"
                                               placeholder="图纸标题" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>图纸预览</label>
                                        <img id="tuzhiPhotoImg" src="" width="100" height="100">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>类型</label>
                                        <input id="tuzhiValue" name="tuzhiValue" class="form-control"
                                               placeholder="类型" readonly>
                                    </div>
                                    <div class="form-group col-md-6 aaaaaa">
                                        <label>图纸订单</label>
                                        <div>
                                            <select id="tuzhiOrderSelect" name="tuzhiOrderSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>订单号</label>
                                        <input id="orderNumber" name="orderNumber" class="form-control"
                                               placeholder="订单号" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>订单状态</label>
                                        <input id="orderValue" name="orderValue" class="form-control"
                                               placeholder="订单状态" readonly>
                                    </div>
                                    <div class="form-group col-md-6 aaaaaa">
                                        <label>用户</label>
                                        <div>
                                            <select id="yonghuSelect" name="yonghuSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>用户姓名</label>
                                        <input id="yonghuName" name="yonghuName" class="form-control"
                                               placeholder="用户姓名" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>性别</label>
                                        <input id="sexValue" name="sexValue" class="form-control"
                                               placeholder="性别" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>身份证号</label>
                                        <input id="yonghuIdNumber" name="yonghuIdNumber" class="form-control"
                                               placeholder="身份证号" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>手机号</label>
                                        <input id="yonghuPhone" name="yonghuPhone" class="form-control"
                                               placeholder="手机号" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>照片</label>
                                        <img id="yonghuPhotoImg" src="" width="100" height="100">
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                <input id="tuzhiOrderId" name="tuzhiOrderId" type="hidden">
                                <input id="yonghuId" name="yonghuId" type="hidden">
                                <input id="tuzhiId" name="tuzhiId" type="hidden">
                                    <div class="form-group col-md-12 mb-3">
                                        <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
                                        <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                    </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "dingdan";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
        <!-- 级联表的下拉框数组 -->
    var tuzhiOptions = [];
    var tuzhiOrderOptions = [];
    var yonghuOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
           if($("#tuzhiOrderId") !=null){
               var tuzhiOrderId = $("#tuzhiOrderId").val();
               if(tuzhiOrderId == null || tuzhiOrderId =='' || tuzhiOrderId == 'null'){
                   alert("订单信息不能为空");
                   return;
               }
           }
           if($("#yonghuId") !=null){
               var yonghuId = $("#yonghuId").val();
               if(yonghuId == null || yonghuId =='' || yonghuId == 'null'){
                   alert("用户id不能为空");
                   return;
               }
           }
           if($("#tuzhiId") !=null){
               var tuzhiId = $("#tuzhiId").val();
               if(tuzhiId == null || tuzhiId =='' || tuzhiId == 'null'){
                   alert("图纸id不能为空");
                   return;
               }
           }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            let json = JSON.stringify(data);
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                    successMes = '添加成功';
            }
            httpJson("dingdan/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('adddingdan');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        alert(successMes);
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            alert("表单未填完整或有错误");
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        <!-- 查询级联表的所有列表 -->
        function tuzhiSelect() {
            //填充下拉框选项
            http("tuzhi/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    tuzhiOptions = res.data.list;
                }
            });
        }

        function tuzhiSelectOne(id) {
            http("tuzhi/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                tuzhiShowImg();
                tuzhiShowVideo();
                tuzhiDataBind();
            }
        });
        }
        function tuzhiOrderSelect() {
            //填充下拉框选项
            http("tuzhiOrder/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    tuzhiOrderOptions = res.data.list;
                }
            });
        }

        function tuzhiOrderSelectOne(id) {
            http("tuzhiOrder/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                tuzhiOrderShowImg();
                tuzhiOrderShowVideo();
                tuzhiOrderDataBind();
            }
        });
        }
        function yonghuSelect() {
            //填充下拉框选项
            http("yonghu/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    yonghuOptions = res.data.list;
                }
            });
        }

        function yonghuSelectOne(id) {
            http("yonghu/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                yonghuShowImg();
                yonghuShowVideo();
                yonghuDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->

        function initializationtuzhiSelect() {
            var tuzhiSelect = document.getElementById('tuzhiSelect');
            if(tuzhiSelect != null && tuzhiOptions != null  && tuzhiOptions.length > 0 ) {
                for (var i = 0; i < tuzhiOptions.length; i++) {
                        tuzhiSelect.add(new Option(tuzhiOptions[i].tuzhiName, tuzhiOptions[i].id));
                }

                $("#tuzhiSelect").change(function(e) {
                        tuzhiSelectOne(e.target.value);
                });
            }

        }

        function initializationtuzhiOrderSelect() {
            var tuzhiOrderSelect = document.getElementById('tuzhiOrderSelect');
            if(tuzhiOrderSelect != null && tuzhiOrderOptions != null  && tuzhiOrderOptions.length > 0 ) {
                for (var i = 0; i < tuzhiOrderOptions.length; i++) {
                        tuzhiOrderSelect.add(new Option(tuzhiOrderOptions[i].tuzhiOrderName, tuzhiOrderOptions[i].id));
                }

                $("#tuzhiOrderSelect").change(function(e) {
                        tuzhiOrderSelectOne(e.target.value);
                });
            }

        }

        function initializationyonghuSelect() {
            var yonghuSelect = document.getElementById('yonghuSelect');
            if(yonghuSelect != null && yonghuOptions != null  && yonghuOptions.length > 0 ) {
                for (var i = 0; i < yonghuOptions.length; i++) {
                        yonghuSelect.add(new Option(yonghuOptions[i].yonghuName, yonghuOptions[i].id));
                }

                $("#yonghuSelect").change(function(e) {
                        yonghuSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->
        <!--  级联表的下拉框回显  -->
            var tuzhiSelect = document.getElementById("tuzhiSelect");
            if(tuzhiSelect != null && tuzhiOptions != null  && tuzhiOptions.length > 0 ) {
                for (var i = 0; i < tuzhiOptions.length; i++) {
                    if (tuzhiOptions[i].id == ruleForm.tuzhiId) {//下拉框value对比,如果一致就赋值汉字
                        tuzhiSelect.options[i+1].selected = true;
                        $("#tuzhiSelect" ).selectpicker('refresh');
                    }
                }
            }
            var tuzhiOrderSelect = document.getElementById("tuzhiOrderSelect");
            if(tuzhiOrderSelect != null && tuzhiOrderOptions != null  && tuzhiOrderOptions.length > 0 ) {
                for (var i = 0; i < tuzhiOrderOptions.length; i++) {
                    if (tuzhiOrderOptions[i].id == ruleForm.tuzhiOrderId) {//下拉框value对比,如果一致就赋值汉字
                        tuzhiOrderSelect.options[i+1].selected = true;
                        $("#tuzhiOrderSelect" ).selectpicker('refresh');
                    }
                }
            }
            var yonghuSelect = document.getElementById("yonghuSelect");
            if(yonghuSelect != null && yonghuOptions != null  && yonghuOptions.length > 0 ) {
                for (var i = 0; i < yonghuOptions.length; i++) {
                    if (yonghuOptions[i].id == ruleForm.yonghuId) {//下拉框value对比,如果一致就赋值汉字
                        yonghuSelect.options[i+1].selected = true;
                        $("#yonghuSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
    }
    //数字检查
        <!-- 当前表的数字检查 -->

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('adddingdan');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                tuzhiOrderId: "required",
                yonghuId: "required",
                tuzhiId: "required",
                insertTime: "required",
            },
            messages: {
                tuzhiOrderId: "订单信息不能为空",
                yonghuId: "用户id不能为空",
                tuzhiId: "图纸id不能为空",
                insertTime: "接单时间不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var adddingdan = window.sessionStorage.getItem("adddingdan");
        if (adddingdan != null && adddingdan != "" && adddingdan != "null") {
            //注册表单验证
            $(validform());
            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            var userId = window.sessionStorage.getItem('userId');
            updateId = userId;//先赋值登录用户id
            var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            if (uId != null && uId != "" && uId != "null") {
                //如果修改id不为空就赋值修改id
                updateId = uId;
            }
            window.sessionStorage.removeItem('updateId');
            http("dingdan/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 设置视频src
                    showVideo();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {
            laydate.render({
                elem: '#insertTime-input'
                ,type: 'datetime'
            });
    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        tuzhiDataBind();
        tuzhiOrderDataBind();
        yonghuDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#tuzhiOrderId").val(ruleForm.tuzhiOrderId);
        $("#yonghuId").val(ruleForm.yonghuId);
        $("#tuzhiId").val(ruleForm.tuzhiId);
        $("#insertTime-input").val(ruleForm.insertTime);

    }
    <!--  级联表的数据回显  -->
    function tuzhiDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#tuzhiId").val(ruleForm.id);

        $("#tuzhiName").val(ruleForm.tuzhiName);
        $("#tuzhiValue").val(ruleForm.tuzhiValue);
        $("#shejishiId").val(ruleForm.shejishiId);
        $("#tuzhiContent").val(ruleForm.tuzhiContent);
        $("#insertTime").val(ruleForm.insertTime);
    }

    function tuzhiOrderDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#tuzhiOrderId").val(ruleForm.id);

        $("#orderNumber").val(ruleForm.orderNumber);
        $("#tuzhiId").val(ruleForm.tuzhiId);
        $("#yonghuId").val(ruleForm.yonghuId);
        $("#orderValue").val(ruleForm.orderValue);
        $("#insertTime").val(ruleForm.insertTime);
    }

    function yonghuDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#yonghuId").val(ruleForm.id);

        $("#yonghuName").val(ruleForm.yonghuName);
        $("#sexValue").val(ruleForm.sexValue);
        $("#yonghuIdNumber").val(ruleForm.yonghuIdNumber);
        $("#yonghuPhone").val(ruleForm.yonghuPhone);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->

        <!--  级联表的图片  -->
        tuzhiShowImg();
        tuzhiOrderShowImg();
        yonghuShowImg();
    }


    <!--  级联表的图片  -->

    function tuzhiShowImg() {
        $("#tuzhiPhotoImg").attr("src",ruleForm.tuzhiPhoto);
    }


    function tuzhiOrderShowImg() {
    }


    function yonghuShowImg() {
        $("#yonghuPhotoImg").attr("src",ruleForm.yonghuPhoto);
    }



    //视频回显
    function showVideo() {
    <!--  当前表的视频  -->

    <!--  级联表的视频  -->
        tuzhiShowVideo();
        tuzhiOrderShowVideo();
        yonghuShowVideo();
    }


    <!--  级联表的视频  -->

    function tuzhiShowVideo() {
        $("#tuzhiPhotoV").attr("src",ruleForm.tuzhiPhoto);
    }

    function tuzhiOrderShowVideo() {
    }

    function yonghuShowVideo() {
        $("#yonghuPhotoV").attr("src",ruleForm.yonghuPhoto);
    }



    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            tuzhiSelect();
            tuzhiOrderSelect();
            yonghuSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            <!--  初始化级联表的下拉框  -->
            initializationtuzhiSelect();
            initializationtuzhiOrderSelect();
            initializationyonghuSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
        window.sessionStorage.removeItem('adddingdan');
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') == '管理员') {
            //$('#jifen').attr('readonly', 'readonly');
            //$('#role').attr('style', 'pointer-events: none;');
        }else{
            $(".aaaaaa").remove();
        if(window.sessionStorage.getItem('adddingdan') != null && window.sessionStorage.getItem('adddingdan') !=""){//新增查询,修改不查
            // 查询当前登录账户的信息
            var userId = window.sessionStorage.getItem('userId');
                yonghuSelectOne(userId);
        }
        }
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>