package chapter1.part3.exercise43;

import chapter1.part3.MyQueue;

import java.io.File;

public class DirectoryContentPrinter {

    public static void print(String path) {
        File fileOrDir = new File(path);
        MyQueue<String> content = new MyQueue<>();

        getContent(fileOrDir, content, "");

        for (String aContent : content) {
            System.out.println(aContent);
        }
    }

    private static void getContent(File fileOrDir, MyQueue<String> content, String indent) {
        final String localIndent = "\t";
        File[] contentFilesOrDirs = fileOrDir.listFiles();
        if (contentFilesOrDirs == null || contentFilesOrDirs.length == 0) {
            return;
        }
        for (File contentFileOrDir : contentFilesOrDirs) {
            content.enqueue(indent + contentFileOrDir.getName());
            getContent(contentFileOrDir, content, indent + localIndent);
        }
    }
}
