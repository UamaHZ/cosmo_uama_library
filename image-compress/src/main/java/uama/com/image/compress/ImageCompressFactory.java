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
        File imgFile = null;
        try{
            //  imgFile = FileUtil.getNewFile(context,paths.get(i));
            // imgFile = ImageCompressFactory.getNewFile(context,paths.get(i));
//                           ImageCompressFactory.getCompressCacheDir(context);
//                           ImageCompressFactory.clearCacheFiles(context);

            String dir = context.getCacheDir().getPath()+File.separator+"compress_cache";
            File tmpFile =  new File(dir);
            if (!tmpFile.exists()) {
                tmpFile.mkdirs();
            }
            imgFile = new Compressor(context)
                    .setMaxWidth(640)
                    .setMaxHeight(480)
                    .setQuality(80)
                    .setCompressFormat(Bitmap.CompressFormat.JPEG)
                    .setDestinationDirectoryPath(dir)
                    .compressToFile(new File(filePath));
        }catch (Exception e){
            e.printStackTrace();
        }

        return imgFile;
    }



}
