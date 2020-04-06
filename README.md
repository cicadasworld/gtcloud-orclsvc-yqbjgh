#YQBJGH RESTFul API
[TOC]

##用户登录服务接口

###用户登录

#### 请求
- 方法: **GET**
- URL:  ```/UserLogin```
    - 用户登录:  ```/UserLogin?id=test&pwd=123456```
- 请求头：
- 请求体:
```
```

#### 响应
- 响应体
```
[
  "true",
  "登录成功!"
]
```

##公司相关服务接口

###获取整个管理公司目录

#### 请求
- 方法: **GET**
- URL:  ```/bddwml-zbgc/catalogue```
- 请求头：
- 请求体:
```
```

#### 响应
- 响应体
```
[
    {
        "nm": "000000001",
        "mc": "Beijing",
        "children": [
            {
                "nm": "01",
                "mc": "公司",
                "children": [
                    {
                        "nm": "0101",
                        "mc": "部门",
                        "children": [
                            {
                                "nm": "010101",
                                "mc": "小组",
                                "children": [],
                                "show": false
                            }
                        ],
                        "show": true
                    }
                ],
                "show": true
            }
        ]
    }
]

```

###根据自定义字段查询公司位置情况

#### 请求
- 方法: **POST**
- URL:  ```/v-camp-location/customquery```
- 请求头：
- 请求体:
```
{
      "dknm": "FID00001",
      "dkmc": "block00001",
      "campWord": "Ver",
      "campCode": "0001",
      "detailAddress": "BeijingXXXX区XXXX路XXXXXX号BeijingXXXX区XXXX路XXXXXX号BeijingXXXX区XXXX路XXXXXX号",
      "campKind": "小区",
      "adminDivision": "Beijing",
      "siteKind": "办公",
      "watersupplyMode": "市政",
      "elecsupplyMode": "市政",
      "gassupplyMode": "市政",
      "heatsupplyMode": "市政",
      "campAreaFrom": "0",
      "campAreaTo": "100000"
}
```

#### 响应
- 响应体
```
{
  "endpoint": "/v-camp-location/customquery",
  "campLocations": [
    {
      "rootMc": null,
      "bdnm": "08",
      "bdmc": "部门",
      "jlbm": null,
      "dknm": "FID00007",
      "dkmc": "block00007",
      "campWord": "Ver",
      "campCode": "0007",
      "campKind": "小区",
      "adminDivision": "Beijing",
      "detailAddress": "BeijingXXXX区XXXX路XXXXXX号BeijingXXXX区XXXX路XXXXXX号BeijingXXXX区XXXX路XXXXXX号",
      "campArea": 99352,
      "siteKind": "办公",
      "watersupplyMode": "市政",
      "elecsupplyMode": "市政",
      "gassupplyMode": "市政",
      "heatsupplyMode": "市政",
      "centerX": "116.35619592662005",
      "centerY": "39.918466018814016"
    }
  ]
}
```

###编辑办公楼点坐标

#### 请求
- 方法: **PUT**
- URL:  ```/camp-coordinate/fid/FID00027```
- 请求头：
- 请求体:
```
```

#### 响应
- 响应体
```
[
    {
        jlbm: "JL00027",
		fid: "FID00027",
		coordinateNum: 1,
		coorX: "116.038859358527",
		coorY: "39.4559019952184",
		centerX: "116.048859358527",
		centerY: "39.4509019952184"
    }
]
```

###删除办公楼点坐标

#### 请求
- 方法: **DELETE**
- URL:  ```/camp-coordinate/fid/FID00035```
- 请求头：
- 请求体:
```
```

#### 响应
- 响应体
```

```
