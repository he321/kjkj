package com.bxp.kjkj.util.file;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;
import java.util.zip.*;

public class ZipUtil {

    private static byte[] _byte = new byte[1024];

    /**
     * 压缩文件或路径
     *
     * @param zip      压缩的目的地址
     * @param srcFiles 压缩的源文件
     */
    public static void zipFile(String zip, List<File> srcFiles) {
        try {
            if (zip.endsWith(".zip") || zip.endsWith(".ZIP")) {
                ZipOutputStream _zipOut = new ZipOutputStream(new FileOutputStream(new File(zip)));
                for (File _f : srcFiles) {
                    handlerFile(zip, _zipOut, _f, "");
                }
                _zipOut.close();
            } else {
                System.out.println("target file[" + zip + "] is not .zip type file");
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

    }

    /**
     * @param zip     压缩的目的地址
     * @param zipOut
     * @param srcFile 被压缩的文件信息
     * @param path    在zip中的相对路径
     * @throws IOException
     */


    private static void handlerFile(String zip, ZipOutputStream zipOut, File srcFile, String path) throws IOException {
        System.out.println(" begin to compression file[" + srcFile.getName() + "]");
        if (!"".equals(path) && !path.endsWith(File.separator)) {
            path += File.separator;

        }
        if (!srcFile.getPath().equals(zip)) {
            if (srcFile.isDirectory()) {
                File[] _files = srcFile.listFiles();
                if (_files.length == 0) {
                    zipOut.putNextEntry(new ZipEntry(path + srcFile.getName() + File.separator));
                    zipOut.closeEntry();

                } else {
                    for (File _f : _files) {
                        handlerFile(zip, zipOut, _f, path + srcFile.getName());

                    }

                }

            } else {
                InputStream _in = new FileInputStream(srcFile);
                zipOut.putNextEntry(new ZipEntry(path + srcFile.getName()));
                int len = 0;
                while ((len = _in.read(_byte)) > 0) {
                    zipOut.write(_byte, 0, len);

                }
                _in.close();
                zipOut.closeEntry();

            }

        }

    }

    /**
     * 解压缩ZIP文件，将ZIP文件里的内容解压到targetDIR目录
     */


    public static Map<String, File> upzipFile(String zipPath, String descDir) {
        return upzipFile(new File(zipPath), descDir);

    }

    /**
     * 对.zip文件进行解压缩
     *
     * @param zipFile 解压缩文件
     * @param descDir 压缩的目标地址，如：D:\\测试 或 /mnt/d/测试
     * @return
     */

    @SuppressWarnings("rawtypes")
    public static Map<String, File> upzipFile(File zipFile, String descDir) {
//        List<File> _list = new ArrayList<File>();
        Map<String, File> files = new HashMap<>();
        try {
            ZipFile _zipFile = new ZipFile(zipFile);
            for (Enumeration entries = _zipFile.entries(); entries.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                File _file = new File(descDir + File.separator + entry.getName());
                if (entry.isDirectory()) {
                    _file.mkdirs();

                } else {
                    File _parent = _file.getParentFile();
                    if (!_parent.exists()) {
                        _parent.mkdirs();

                    }

                    InputStream _in = _zipFile.getInputStream(entry);
                    OutputStream _out = new FileOutputStream(_file);
                    int len = 0;
                    while ((len = _in.read(_byte)) > 0) {
                        _out.write(_byte, 0, len);

                    }
                    _in.close();
                    _out.flush();
                    _out.close();
//                    _list.add(_file);
                    String path = _file.getPath().substring(0, _file.getPath().length() -
                    _file.getName().length());
                   files.put(path, _file);

                }

            }

        } catch (IOException e) {

        }
        return files;
    }

    /**
     * 对临时生成的文件夹和文件夹下的文件进行删除
     */


    public static void deletefile(String delpath) {
        try {
            File file = new File(delpath);
            if (!file.isDirectory()) {
                file.delete();

            } else if (file.isDirectory()) {
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File delfile = new File(delpath + File.separator + filelist[i]);
                    if (!delfile.isDirectory()) {
                        delfile.delete();

                    } else if (delfile.isDirectory()) {
                        deletefile(delpath + File.separator + filelist[i]);

                    }

                }
                file.delete();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        /**
         * 确定思路，研究计划，参考文献
         */
        Map<String, File> fileMap= upzipFile(new File("/home/bxp/Documents/doc/kjkjTest/kjkj.zip"),
                "/home/bxp/Documents/doc/kjkjTest/1");
//        deletefile("/home/bxp/Documents/doc/kjkjTest/1/2");
        for (String file: fileMap.keySet()){
            System.out.println(file);
        }
    }
}    