<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/manage/system_menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>新增用户</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/jscss/admin/design/">作品管理</a><span class="crumb-step">&gt;</span><span>新增作品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="Userservlet" method="post" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody><tr>
                            <th width="120"><i class="require-red">*</i>用户名-：</th>
                            <td>
                                <input class="common-text required" id="USER_NAME" name="USER_NAME" size="50" type="text">
                            </td>
                        </tr>
                            <tr>
                                <th><i class="require-red">*</i>用户密码：</th>
                                <td>
                                    <input class="common-text required" id="USER_PASSWORD" name="USER_PASSWORD" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th>性别：</th>
                                <td>
									<select name="USER_SEX">
										<option value="0">男</option>
										<option value="1">女</option>
									</select>
								</td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>用户生日：</th>
                                <td><input name="USER_BIRTHDAY" id="USER_BIRTHDAY" type="text"><!--<input type="submit" onclick="submitForm('/jscss/admin/design/upload')" value="上传图片"/>--></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>用户邮箱：</th>
                                <td><input type="text" id="USER_EMAIL" name="USER_EMAIL"/></td>
							<tr>
                                <th><i class="require-red">*</i>用户联系方式：</th>
                                <td><input type="text" id="USER_MOBILE" name="USER_MOBILE"/></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>用户地址：</th>
                                <td><input type="text" id="USER_ADDRESS" name="USER_ADDRESS"/></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>