使用方法：

1.添加依赖  compile 'com.uama.utils:image-compress:1.0.2'

2.图片压缩  

根据原图路径获取压缩后的图片File

File imgFile = ImageCompressFactory.getNewFile(context,originFilePath);

得到imgFile 为压缩后的图片文件

3.获取压缩图片的缓存目录
 ImageCompressFactory.getCompressCacheDir(context)
 
 4.删除所有缓存文件
 ImageCompressFactory.clearCacheFiles(context);




