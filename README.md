# 使用方法：

### 1.添加依赖  
##### 首先需要在项目的 build.gradle 文件中配置 https://jitpack.io 的 maven 库：
```allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```
##### 其次在需要引用该的 module 的 build.gradle 中添加依赖：
```
compile 'com.uama.utils:image-compress:1.0.3'

```
### 2.用法：
  1.图片压缩  
 根据原图路径获取压缩后的图片File
```
File imgFile = ImageCompressFactory.getNewFile(context,originFilePath);
```
 得到imgFile 为压缩后的图片文件

 2.获取压缩图片的缓存目录
```
 ImageCompressFactory.getCompressCacheDir(context)
 ```
4.删除所有缓存文件
 ```
 ImageCompressFactory.clearCacheFiles(context);
 ```




