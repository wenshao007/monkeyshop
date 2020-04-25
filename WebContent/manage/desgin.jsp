<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib	uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ include file="/manage/system_menu.jsp"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">作品管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="Queryservlet" method="post">
                    <table class="search-tab">
                        <tr>
                            
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords}" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="insert.jsp"><i class="icon-font"></i>新增用户</a>
                        <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
             
             
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                            <th>用户ID</th>
                            <th>用户名</th>
                            <th>用户密码</th>
                            <th>用户性别</th>
                            <th>用户出生日期</th>
                            <th>用户识别号</th>
                            <th>用户邮箱</th>
                            <th>用户手机号</th>
                            <th>用户收货地址</th>
                            <th>用户状态</th>
                            <th>用户操作</th>
                        </tr>
                     
                        <c:forEach var ="entry" items="${result}" >
                        	<tr>
                        		<td class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></td>
                            <td>${entry.USER_ID}</td>
                            <td>${entry.USER_NAME}</td>
                            <td>${entry.USER_PASSWORD}</td>
                            <td>${entry.USER_SEX}</td>
                            <td>${entry.USER_BIRTHDAY} </td>
                            <td>${entry.USER_IDENITY_COD}</td>
                            <td>${entry.USER_EMAIL}</td>
                            <td>${entry.USER_MOBILE}</td>
                            <td>${entry.USER_ADDRESS}</td>
                            <td>${entry.USER_STATUS}</td>
                             <td>
                                <a class="link-update" href="#">修改</a>
                                <a class="link-del" href="#">删除</a>
                            </td>
                        	</tr>
                        </c:forEach>
                    </table>
           
                    
                    <div class="list-page"> 
                    ${cnum} 条 ${cpage} / ${ctotal} 页
                    <a href="?cp=1${keyword}">首页</a>
                    <a href="?cp=${cpage-1==0?1:cpage-1}${keyword}">上页</a>
                    <a href="?cp=${cpage+1>ctotal?ctotal:cpage+1}${keyword}">下页</a>
                    <a href="?cp=${ctotal}${keyword}	">尾页</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>