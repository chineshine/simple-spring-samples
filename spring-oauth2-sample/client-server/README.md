# client server

## 概述
本项目是用来实现 oauth 第三方登录的一个 sample,登录的第三方应用为 github

## 操作
- 生成 `github` 的 `client-id` 和 `client-secret`
```
1 点击右上角 github 账户头像 -> setting
2 左边菜单 -> Developer settings
3 左边菜单 -> OAuth Apps -> New OAuth app
4 填写必需信息,保存 至少就能在页面找到 client-id 和 client-secret 
```
- 将 `client-id` 和 `client-secret` 添加到 `application.yml` 配置文件中  
  本例中的 两个参数已失效