package project;

import java.io.File;
// class ใช้สำหรับการทำไฟล์ให้เป็น path เพื่อเตรียมทำเป็น Tree Model
public class MyFile {

    private final File mFile;

    public MyFile(final File pFile) {
        mFile = pFile;
    }

    public boolean isDirectory() {
        return mFile.isDirectory();
    }

    public MyFile[] listFiles() {
        final File[] files = mFile.listFiles();
        if (files == null) {
            return null;
        }
        if (files.length < 1) {
            return new MyFile[0];
        }

        final MyFile[] ret = new MyFile[files.length];
        for (int i = 0; i < ret.length; i++) {
            final File f = files[i];
            ret[i] = new MyFile(f);
        }
        return ret;
    }

    public File getFile() { //ดึงไฟล์ออกมาแสดง
        return mFile;
    }

    @Override
    public String toString() { // ปริ้นชื่อไฟล์
        return mFile.getName();
    }
}