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
                    <h3 class="block-title">编辑图纸信息</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">图纸信息管理</li>
                        <li class="breadcrumb-item active">编辑图纸信息</li>
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
                        <h3 class="widget-title">图纸信息信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6 aaaaaa">
                                        <label>设计师</label>
                                        <div>
                                            <select id="shejishiSelect" name="shejishiSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>设计师姓名</label>
                                        <input id="shejishiName" name="shejishiName" class="form-control"
                                               placeholder="设计师姓名" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>性别</label>
                                        <input id="sexValue" name="sexValue" class="form-control"
                                               placeholder="性别" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>身份证号</label>
                                        <input id="shejishiIdNumber" name="shejishiIdNumber" class="form-control"
                                               placeholder="身份证号" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>手机号</label>
                                        <input id="shejishiPhone" name="shejishiPhone" class="form-control"
                                               placeholder="手机号" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>照片</label>
                                        <img id="shejishiPhotoImg" src="" width="100" height="100">
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                    <div class="form-group col-md-6">
                                        <label>图纸标题</label>
                                        <input id="tuzhiName" name="tuzhiName" class="form-control"
                                               placeholder="图纸标题">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>图纸预览</label>
                                        <img id="tuzhiPhotoImg" src="" width="100" height="100">
                                        <input name="file" type="file" id="tuzhiPhotoupload"
                                               class="form-control-file">
                                        <input name="tuzhiPhoto" id="tuzhiPhoto-input" type="hidden">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>文件</label>
                                        <input name="file" type="file" class="form-control-file" id="tuzhiFileupload">
                                        <label id="tuzhiFileName"></label>
                                        <input name="tuzhiFile" id="tuzhiFile-input" type="hidden">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>类型</label>
                                        <select id="tuzhiTypesSelect" name="tuzhiTypes" class="form-control">
                                        </select>
                                    </div>
                                <input id="shejishiId" name="shejishiId" type="hidden">
                                    <div class="form-group  col-md-6">
                                        <label>详情内容</label>
                                        <input id="tuzhiContentupload" name="file" type="file">
                                        <script id="tuzhiContentEditor" type="text/plain"
                                                style="width:100%;height:230px;"></script>
                                        <script type = "text/javascript" >
                                        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                                        //相见文档配置属于你自己的编译器
                                        var tuzhiContentUe = UE.getEditor('tuzhiContentEditor', {
                                            toolbars: [
                                                [
                                                    'undo', //撤销
                                                    'bold', //加粗
                                                    'redo', //重做
                                                    'underline', //下划线
                                                    'horizontal', //分隔线
                                                    'inserttitle', //插入标题
                                                    'cleardoc', //清空文档
                                                    'fontfamily', //字体
                                                    'fontsize', //字号
                                                    'paragraph', //段落格式
                                                    'inserttable', //插入表格
                                                    'justifyleft', //居左对齐
                                                    'justifyright', //居右对齐
                                                    'justifycenter', //居中对
                                                    'justifyjustify', //两端对齐
                                                    'forecolor', //字体颜色
                                                    'fullscreen', //全屏
                                                    'edittip ', //编辑提示
                                                    'customstyle', //自定义标题
                                                ]
                                            ]
                                        });
                                        </script>
                                        <input type="hidden" name="tuzhiContent" id="tuzhiContent-input">
                                    </div>
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

    var tableName = "tuzhi";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
    var tuzhiTypesOptions = [];
        <!-- 级联表的下拉框数组 -->
    var shejishiOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->
        $('#tuzhiPhotoupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                var photoUrl= baseUrl + 'file/download?fileName=' + data.result.file;
                document.getElementById('tuzhiPhotoImg').setAttribute('src',photoUrl);
                document.getElementById('tuzhiPhoto-input').setAttribute('value',photoUrl);
            }
        });


        $('#tuzhiFileupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                document.getElementById('tuzhiFile-input').setAttribute('value', baseUrl + 'file/download?fileName=' + data.result.file);
                document.getElementById('tuzhiFileName').innerHTML = "上传成功!";
            }
        });


        $('#tuzhiContentupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                UE.getEditor('tuzhiContentEditor').execCommand('insertHtml', '<img src=\"' + baseUrl + 'upload/' + data.result.file + '\" width=900 height=560>');
            }
        });


    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
           if($("#shejishiId") !=null){
               var shejishiId = $("#shejishiId").val();
               if(shejishiId == null || shejishiId =='' || shejishiId == 'null'){
                   alert("发布设计师不能为空");
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
            httpJson("tuzhi/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addtuzhi');
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
        function tuzhiTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=tuzhi_types", "GET", {}, (res) => {
                if(res.code == 0){
                    tuzhiTypesOptions = res.data.list;
                }
            });
        }
        <!-- 查询级联表的所有列表 -->
        function shejishiSelect() {
            //填充下拉框选项
            http("shejishi/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    shejishiOptions = res.data.list;
                }
            });
        }

        function shejishiSelectOne(id) {
            http("shejishi/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                shejishiShowImg();
                shejishiShowVideo();
                shejishiDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->
        function initializationTuzhitypesSelect(){
            var tuzhiTypesSelect = document.getElementById('tuzhiTypesSelect');
            if(tuzhiTypesSelect != null && tuzhiTypesOptions != null  && tuzhiTypesOptions.length > 0 ){
                for (var i = 0; i < tuzhiTypesOptions.length; i++) {
                    tuzhiTypesSelect.add(new Option(tuzhiTypesOptions[i].indexName,tuzhiTypesOptions[i].codeIndex));
                }
            }
        }

        function initializationshejishiSelect() {
            var shejishiSelect = document.getElementById('shejishiSelect');
            if(shejishiSelect != null && shejishiOptions != null  && shejishiOptions.length > 0 ) {
                for (var i = 0; i < shejishiOptions.length; i++) {
                        shejishiSelect.add(new Option(shejishiOptions[i].shejishiName, shejishiOptions[i].id));
                }

                $("#shejishiSelect").change(function(e) {
                        shejishiSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->

        var tuzhiTypesSelect = document.getElementById("tuzhiTypesSelect");
        if(tuzhiTypesSelect != null && tuzhiTypesOptions != null  && tuzhiTypesOptions.length > 0 ) {
            for (var i = 0; i < tuzhiTypesOptions.length; i++) {
                if (tuzhiTypesOptions[i].codeIndex == ruleForm.tuzhiTypes) {//下拉框value对比,如果一致就赋值汉字
                        tuzhiTypesSelect.options[i].selected = true;
                }
            }
        }
        <!--  级联表的下拉框回显  -->
            var shejishiSelect = document.getElementById("shejishiSelect");
            if(shejishiSelect != null && shejishiOptions != null  && shejishiOptions.length > 0 ) {
                for (var i = 0; i < shejishiOptions.length; i++) {
                    if (shejishiOptions[i].id == ruleForm.shejishiId) {//下拉框value对比,如果一致就赋值汉字
                        shejishiSelect.options[i+1].selected = true;
                        $("#shejishiSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
        if (ruleForm.tuzhiContent != null && ruleForm.tuzhiContent != 'null' && ruleForm.tuzhiContent != '' && $("#tuzhiContentupload").length>0) {

            var tuzhiContentUeditor = UE.getEditor('tuzhiContentEditor');
            tuzhiContentUeditor.ready(function () {
                var mes = '';
                if(ruleForm.tuzhiContent != null){
                    mes = ''+ ruleForm.tuzhiContent;
                    mes = mes.replace(/\n/g, "<br>");
                }
                tuzhiContentUeditor.setContent(mes);
            });
        }
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
        if($("#tuzhiContentupload").length>0) {
            var tuzhiContentEditor = UE.getEditor('tuzhiContentEditor');
            if (tuzhiContentEditor.hasContents()) {
                $('#tuzhiContent-input').attr('value', tuzhiContentEditor.getPlainTxt());
            }
        }
    }
    //数字检查
        <!-- 当前表的数字检查 -->

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addtuzhi');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                tuzhiName: "required",
                tuzhiPhoto: "required",
                tuzhiFile: "required",
                tuzhiTypes: "required",
                shejishiId: "required",
                tuzhiContent: "required",
                insertTime: "required",
            },
            messages: {
                tuzhiName: "图纸标题不能为空",
                tuzhiPhoto: "图纸预览不能为空",
                tuzhiFile: "文件不能为空",
                tuzhiTypes: "类型不能为空",
                shejishiId: "发布设计师不能为空",
                tuzhiContent: "详情内容不能为空",
                insertTime: "发布时间不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addtuzhi = window.sessionStorage.getItem("addtuzhi");
        if (addtuzhi != null && addtuzhi != "" && addtuzhi != "null") {
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
            http("tuzhi/info/" + updateId, "GET", {}, (res) => {
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
        shejishiDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#tuzhiName").val(ruleForm.tuzhiName);
        $("#shejishiId").val(ruleForm.shejishiId);
        $("#tuzhiContent").val(ruleForm.tuzhiContent);
        $("#insertTime-input").val(ruleForm.insertTime);

    }
    <!--  级联表的数据回显  -->
    function shejishiDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#shejishiId").val(ruleForm.id);

        $("#shejishiName").val(ruleForm.shejishiName);
        $("#sexValue").val(ruleForm.sexValue);
        $("#shejishiIdNumber").val(ruleForm.shejishiIdNumber);
        $("#shejishiPhone").val(ruleForm.shejishiPhone);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->
        $("#tuzhiPhotoImg").attr("src",ruleForm.tuzhiPhoto);

        <!--  级联表的图片  -->
        shejishiShowImg();
    }


    <!--  级联表的图片  -->

    function shejishiShowImg() {
        $("#shejishiPhotoImg").attr("src",ruleForm.shejishiPhoto);
    }



    //视频回显
    function showVideo() {
    <!--  当前表的视频  -->

    <!--  级联表的视频  -->
        shejishiShowVideo();
    }


    <!--  级联表的视频  -->

    function shejishiShowVideo() {
        $("#shejishiPhotoV").attr("src",ruleForm.shejishiPhoto);
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
            tuzhiTypesSelect();
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            shejishiSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            initializationTuzhitypesSelect();
            <!--  初始化级联表的下拉框  -->
            initializationshejishiSelect();

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
        window.sessionStorage.removeItem('addtuzhi');
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') == '管理员') {
            //$('#jifen').attr('readonly', 'readonly');
            //$('#role').attr('style', 'pointer-events: none;');
        }else{
            $(".aaaaaa").remove();
        if(window.sessionStorage.getItem('addtuzhi') != null && window.sessionStorage.getItem('addtuzhi') !=""){//新增查询,修改不查
            // 查询当前登录账户的信息
            var userId = window.sessionStorage.getItem('userId');
                shejishiSelectOne(userId);
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