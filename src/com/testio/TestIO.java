package com.testio;

import java.io.*;

/*
流概念：
按流的方向分类：
      1. 输入流：数据流向是数据源到程序(以InputStream、Reader结尾的流)。
      2. 输出流：数据流向是程序到目的地(以OutPutStream、Writer结尾的流)。

按处理的数据单元分类：
      1. 字节流：以字节为单位获取数据，
      命名上以Stream结尾的流一般是字节流，如FileInputStream、FileOutputStream。
      2. 字符流：以字符为单位获取数据，
      命名上以Reader/Writer结尾的流一般是字符流，如FileReader、FileWriter。

按处理对象不同分类：
      1. 节点流：可以直接从数据源或目的地读写数据，如FileInputStream、FileReader、DataInputStream等。
      2. 处理流：不直接连接到数据源或目的地，是”处理流的流”。通过对其他流的处理提高程序的性能，如BufferedInputStream、BufferedReader等。处理流也叫包装流。
      节点流处于IO操作的第一线，所有操作必须通过它们进行;处理流可以对节点流进行包装，提高性能或提高程序的灵活性。
 */
/*
Object：
    --> File
    --> InputStream:
        --> ByteArrayInputStream
        --> FileInputStream
        -- ObjectInputStream
        --> FilterInputStream:
            --> DataInputStream
            --> BufferedInputStream
    --> OutputStream:
        --> ByteArrayOutputStream
        --> FileOutputStream
        -- ObjectOutputStream
        --> FilterOutputStream:
            --> DataOutputStream  数据流 将“基本数据类型与字符串类型”作为数据源
            --> BufferedOutputStream
            --> PrintStream
    --> Reader
        --> BufferedReader
        --> InputStreamReader:  字节流与字符流之间的桥梁（文本的 读字节流，转为字符流）
            --> FileReader
    --> Writer:
        --> BufferedWriter
        --> OutputStreamWriter:
            --> FileWriter
 */
public class TestIO {
    public static void main(String[] args){

    }

}
