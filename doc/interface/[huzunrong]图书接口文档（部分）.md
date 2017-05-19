## 图书接口文档（部分）


### 目录
- [图书接口文档](#)
    - [接口列表](#)
        - [[get] /book/v1/search 搜索图书]
        - [[post] /book/v1/panic 抢购图书]
    - 



### 接口列表

#### [get] /book/v1/search


 前置条件：

 * null

 输入参数：

 名称 | 类型 | 是否必须 | 参数限制 | 描述
 --------- | ----------- | -------- | ---------- | ----------
 bookName | String | 否 | 无 | 图书名称，bookname、booksummary和bookauthor必选其一
 bookSummary | String | 否 | 无 | 图书简介，bookname、booksummary和bookauthor必选其一
 bookAuthor |String | 否 | 无 | 图书作者，bookname、booksummary和bookauthor必选其一

 输出参数:

 名称 | 类型 | 描述
 --------- | ----------- | ----------
 statusCode | int | 状态码
 message | string | 描述
 data | object | 包含数量和列表




 输出样例:

 ```
 {
     "statusCode": 200,
     "message": "success",
     "data": {
     	"count": 1,
     	"booklist": [
     		{
     			"uid": "4cdbc040657a4847b2667e31d9e2c3d9",
     			"name": "java编程思想",
     			"author": "[美] Bruce Eckel",
     			"description": "本书赢得了全球程序员的广泛赞誉",
     			"price": 108,
     			"stock": 3
     		},
     		{
     			"uid": "72297c8842604c059b05d28bfb11d10b",
     			"name": "窗边的小豆豆",
     			"author": "黑柳彻子",
     			"description": "《窗边的小豆豆》讲述了作者上小学时的一段真实的故事.",
     			"price": 20,
     			"stock": 1
     		}
     	]
     }
 }
```

#### [post] /book/v1/panic

 前置条件：

 * 用户必须已登录

 输入参数：

  名称 | 类型 | 是否必须 | 参数限制 | 描述
  --------- | ----------- | -------- | ---------- | ----------
  uid | String | 是 | 无 | 抢购用户UID
  bookUid  | String| 是 | 无 | 待抢购图书UID

  输出参数:

  名称 | 类型 | 描述
  --------- | ----------- | ----------
  statusCode | int | 状态码
  message | string | 描述
  data | object | 无




  输出样例:

  ```
  {
      "statusCode": 200,
      "message": "success",
      "data": null
  }
 ```


### 错误码
状态码 | 原因
--------- | -----------
200 | success	成功
400 | 用户请求的格式不正确
401 | 用户未授权
405 | 该http方法不被允许


