# network-url-sample示例代码

中文 | [English](./README.md)
## 目录

 * [简介](#简介)
 * [开发准备](#开发准备)
 * [环境要求](#环境要求)
 * [运行结果](#运行结果)
 * [授权许可](#授权许可)

## 简介
   通过华为network-url-sample示例代码，您将体验到如何使用Network Kit相关接口与后端服务器交互。

## 开发准备
   1. 检查Android Studio开发环境是否准备就绪。
   2. 打开示例项目，在您的安卓设备上运行示例代码。

## 环境要求
   1. 推荐Android SDK版本号为19或以上，JDK版本号为1.8或以上。
   2. 该版本使用了Java 8的新特性：如Lambda 表达式、静态接口方法等。该版本及以后的版本均需要为Gradle添加Java 8的编译环境约束，否则会降级至UrlConnection发请求，导致诸多请求能力会受限，Gradle添加Java 8编译配置如下：
```
   compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
   }
```
## 运行结果
   <img src="images/result.jpg" width = 30% height = 30%>

## 技术支持
如果您对HMS Core还处于评估阶段，可在[Reddit社区](https://www.reddit.com/r/HuaweiDevelopers/)获取关于HMS Core的最新讯息，并与其他开发者交流见解。

如果您对使用HMS示例代码有疑问，请尝试：
- 开发过程遇到问题上[Stack Overflow](https://stackoverflow.com/questions/tagged/huawei-mobile-services)，在[huawei-mobile-services]标签下提问，有华为研发专家在线一对一解决您的问题。
- 到[华为开发者论坛](https://developer.huawei.com/consumer/cn/forum/blockdisplay?fid=18) HMS Core板块与其他开发者进行交流。

如果您在尝试示例代码中遇到问题，请向仓库提交[issue](https://github.com/HMS-Core/hms-network-demo/issues)，也欢迎您提交[Pull Request](https://github.com/HMS-Core/hms-network-demo/pulls)。

## 授权许可
Network Kit示例代码经过[Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0)授权许可。
