package com.test.frmw.saral.kw.scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class ClassPathScanner implements KeywordScanner {
    private static final Logger logger = LoggerFactory.getLogger(ClassPathScanner.class);

    private static final String classPath = System.getProperty("java.class.path");
    private static final String pathSeparator = System.getProperty("path.separator");

    private Set<Class> classes = new HashSet<>();
    private Class baseClassType;

    public ClassPathScanner(Class baseClassType) {
        this.baseClassType = baseClassType;
    }

    @Override
    public Set<Class> getClasses() {

        StringTokenizer st = new StringTokenizer(classPath, pathSeparator);

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (isArchive(token)) {
                try {
                    processArchive(new ZipFile(token));
                } catch (IOException e) {
                    logger.error("Error while converting to zip file -- " + token, e);
                }
            }
            else{
                processFile(new File(token),"");
            }
        }


        return classes;
    }

    private void processFile(File file,String packageName) {
        File[] childFiles = file.listFiles();

        //if there are no files to process
        if(childFiles == null ||  childFiles.length == 0)
            return;

        for(File currentFile: childFiles){

            //if current file is a directory
            if(currentFile.isDirectory()){
                processFile(currentFile,packageName+ (packageName == ""?"":File.separator) +currentFile.getName());
            }

            //process the file
            if(currentFile.getName().endsWith(".class"))
                addClass(getClassName(packageName + File.separator+ currentFile.getName()));

        }
    }

    private void processArchive(ZipFile zipFile) {
        Enumeration<? extends ZipEntry> files = zipFile.entries();

        while (files.hasMoreElements()) {
            ZipEntry child = files.nextElement();

            if (child.getName().endsWith(".class")) {
                addClass(getClassName(child.getName()));
            }

        }
    }

    private void addClass(String className) {
        try {
            Class clazz =  Class.forName(className);
            if(baseClassType.isAssignableFrom(clazz)){
                logger.info("Adding class -- " + className);
                this.classes.add(clazz);
            }
        } catch (ClassNotFoundException e) {
            logger.error("error while loading class for name - " + className);
        }
        catch (Throwable e){
            logger.error("error while loading class for name - " + className);
        }
    }

    private String getClassName(String filePath) {
        String className = filePath.replace(File.pathSeparatorChar, '.');

        className = className.replace('/', '.');

        return className.substring(0,className.lastIndexOf('.'));
    }

    private boolean isArchive(String token) {
        return token.endsWith(".jar") || token.endsWith(".zip");
    }



}
