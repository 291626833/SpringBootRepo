package com.roger.hadoop.hadoopDo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

import cn.myframe.utils.HdfsUtils;
import org.apache.hadoop.fs.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        
//    	System.out.println( "Hello World!" );
//        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
//        //InputStream in = new URL("hdfs://10.0.0.37:9000/hello.txt").openStream();
//        InputStream in = new URL("hdfs://10.0.0.37:9000/user/root/input/core-site.xml").openStream();
//        IOUtils.copyBytes(in, System.out,4096, true);
        
        FileSystem fileSystem =HdfsUtils.getFileSystem("hdfs://10.0.0.37:9000");
        boolean success = fileSystem.mkdirs(new Path("/javaTest"));

        System.out.println(success);
        
        //把win下的文件上传到HDFS上
        //在hdfs上创建一个文件
        FSDataOutputStream out = fileSystem.create(new Path("/test.data"), true);
        //选中本地文件
        FileInputStream fis = new FileInputStream("e:/test.txt");
        //把fis中的文件拷贝到out中，缓冲区大小为4096，上传后关闭管道
        IOUtils.copyBytes(fis, out, 4096, true);
        
        
    }
}
