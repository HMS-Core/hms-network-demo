# 华为Network Kit Sample
	
中文 | [English](./README.md)

## 简介
本项目包含华为network-url和network-filemanager的示例代码。工程目录如下：

|-- [network-url-sample](https://github.com/HMS-Core/hms-network-demo/tree/main/network-url-sample) url网络请求示例

|-- [network-filemanager-sample](https://github.com/HMS-Core/hms-network-demo/tree/main/network-filemanager-sample) 文件上传下载请求示例

## 注意事项
 1. 推荐Android SDK版本号为19或以上，JDK版本号为1.8或以上。
 2. 该版本使用了Java 8的新特性：如Lambda 表达式、静态接口方法等。该版本及以后的版本均需要为Gradle添加Java 8的编译环境约束，否则会降级至UrlConnection发请求，导致诸多请求能力会受限，Gradle添加Java 8编译配置如下：
```
   compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
   }
```

## 技术支持
如果您对HMS Core还处于评估阶段，可在[Reddit社区](https://www.reddit.com/r/HuaweiDevelopers/)获取关于HMS Core的最新讯息，并与其他开发者交流见解。

如果您对使用HMS示例代码有疑问，请尝试：
- 开发过程遇到问题上[Stack Overflow](https://stackoverflow.com/questions/tagged/huawei-mobile-services)，在[huawei-mobile-services]标签下提问，有华为研发专家在线一对一解决您的问题。
- 到[华为开发者论坛](https://developer.huawei.com/consumer/cn/forum/blockdisplay?fid=18) HMS Core板块与其他开发者进行交流。

如果您在尝试示例代码中遇到问题，请向仓库提交[issue](https://github.com/HMS-Core/hms-network-demo/issues)，也欢迎您提交[Pull Request](https://github.com/HMS-Core/hms-network-demo/pulls)。
