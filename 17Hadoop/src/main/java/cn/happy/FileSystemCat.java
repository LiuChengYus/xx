package cn.happy;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class HDFSMkDir
{
    public static void main( String[] args ) throws IOException {
      //1.创建配置文件
        Configuration config=new Configuration();
        //2.形成FileSyste, 唯一包括的选择
        FileSystem fs=FileSystem.get(config);
        fs.mkdirs(new Path("/mines"));
    }
}
