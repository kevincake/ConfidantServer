# -*- coding: utf-8 -*-
import os
import shutil

FOLDER_PATH = "E:/ConfidantServer/src/main/java/com/springapp/mvc/entities/";


def writeSeriliable2File(filePath, fileName):
    f = open(filePath, "rb+");
    flist = f.readlines()

    for (index, char) in enumerate(flist):
        line_str = str(flist[index])
        if (line_str.find("class") != -1 and line_str.find("Serializable")==-1):
            flist[1] = "import java.io.Serializable;" + flist[1]
            flist[index] = "public class " + fileName.split(".")[0] + " implements Serializable {"
            print flist[index]
    f.close()
    f = open(filePath, "w")
    f.writelines(flist)
    f.close()


def beginWrite(folderPath):
    if not os.path.isdir(folderPath):
        return
    for filename in os.listdir(folderPath):
        writeSeriliable2File(folderPath + filename, filename);
        print filename


if __name__ == '__main__':
    beginWrite(FOLDER_PATH);
