package uama.com.image.compress;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import id.zelory.compressor.Compressor;

/**
 * Created by ruchao.jiang on 2017/7/5.
 */

public class ImageCompressFactory {
    /**
     *
     * 获取缓存路径
     * @param context
     * @return
     */
    public static String getCompressCacheDir(Context context){
        return context.getCacheDir().getPath()+File.separator+"compress_cache";
    }

    /**
     * 删除压缩图片
     * @param context
     */
    public static void clearCacheFiles(Context context){
        ImageCompressUtils.cleanCustomCache(getCompressCacheDir(context));
    }

    /**
     * 根据原图路径得到压缩后的文件
     * @param context
     * @param filePath
     * @return
     */
    public static File getNewFile(Context context, String filePath){
        FileOutputStream fos = null;
        Bitmap save = null;
        String newPath = "";
        File  imgFile = null;

        try{
            // 得到图片的旋转角度
            int degree = ImageCompressUtils.readPictureDegree(filePath);
            // 得到旋转后的新图片
            save = ImageCompressUtils.rotaingImageView(degree,ImageCompressUtils.getBitmap(filePath));
            String dir = context.getCacheDir().getPath()+File.separator+"compress_cache";
            File tmpFile =  new File(dir);
            if (!tmpFile.exists()) {
                tmpFile.mkdirs();
            }
            newPath = dir + File.separator + System.currentTimeMillis()+".jpg";
            fos = new FileOutputStream(newPath);
            save.compress(Bitmap.CompressFormat.JPEG, 100, fos);// 把数据写入文件

            imgFile = new Compressor(context)
                    .setMaxWidth(540)
                    .setMaxHeight(720)
                    .setQuality(80)
                    .setCompressFormat(Bitmap.CompressFormat.JPEG)
                    .setDestinationDirectoryPath(dir)
                    .compressToFile(new File(newPath));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 关闭流 并且回收图片
            try {
                if (fos != null) {
                    fos.flush();
                    fos.close();
                }

                if (!save.isRecycled()){
                    save.recycle();
                }
                System.gc();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return imgFile;
        }

    }



}
