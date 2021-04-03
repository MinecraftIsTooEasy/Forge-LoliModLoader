package net.xiaoyu233.fml.util;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PackageLoader {
    /**
     * 以文件的形式来获取包下的所有Class
     *
     * @param packageName
     * @param packagePath
     */
    public static List<Class<?>> findClassByDirectory(String packageName, String packagePath,ClassLoader classLoader,Class<? extends Annotation> targetAnnotation) {
        // 获取此包的目录 建立一个File
        File dir = new File(packagePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return new ArrayList<>(0);
        }

        File[] dirs = dir.listFiles();
        List<Class<?>> classes = new ArrayList<>();
        // 循环所有文件
        for (File file : dirs) {
            // 如果是目录 则继续扫描
            if (file.isDirectory()) {
                classes.addAll(findClassByDirectory(packageName + "." + file.getName(),
                        file.getAbsolutePath(),classLoader,targetAnnotation));
            }
            else if (file.getName().endsWith(".class")) {
                // 如果是java类文件，去掉后面的.class 只留下类名
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                    classes.add(classLoader.loadClass(packageName + '.' + className));
                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        return classes;
    }

    public static List<Class<?>> findClassInJar(String packageName, URL url,ClassLoader classLoader,Class<? extends Annotation> targetAnnotation) {
        List<Class<?>> classes = new ArrayList<>();

        String packageDirName = packageName.replace('.', '/');
        // 定义一个JarFile
        JarFile jar;
        try {
            // 获取jar
            jar = ((JarURLConnection) url.openConnection()).getJarFile();
            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                // 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
                JarEntry entry = entries.nextElement();
                if (entry.isDirectory()) {
                    continue;
                }

                String name = entry.getName();
                if (name.charAt(0) == '/') {
                    // 获取后面的字符串
                    name = name.substring(1);
                }

                // 如果前半部分和定义的包名相同
                if (name.startsWith(packageDirName) && name.endsWith(".class")) {
                    // 去掉后面的".class"
                    String className = name.substring(0, name.length() - 6).replace('/', '.');
                    try {
                        // 添加到classes
                        if (targetAnnotation != null){
                            ClassReader reader = new ClassReader(jar.getInputStream(entry));
                            ClassNode classNode = new ClassNode();
                            reader.accept(classNode,0);
                            classNode.accept(new ClassVisitor(Opcodes.ASM8){});
                            List<AnnotationNode> visibleAnnotations = classNode.invisibleAnnotations;
                            if (visibleAnnotations != null && !visibleAnnotations.isEmpty()){
                                for (AnnotationNode visibleAnnotation : visibleAnnotations) {
                                    if (visibleAnnotation.desc.equals(Type.getDescriptor(targetAnnotation))) {
                                        classes.add(classLoader.loadClass(className));
                                        break;
                                    }
                                }
                            }
                        }else {
                            classes.add(classLoader.loadClass(className));
                        }
                    }
                    catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }

    public static List<Class<?>> getClasses(String packageName, ClassLoader classLoader, Class<? extends Annotation> targetAnnotation) {

        // 第一个class类的集合
        List<Class<?>> classes = new ArrayList<>();
        // 获取包的名字 并进行替换
        String packageDirName = packageName.replace('.', '/');
        // 定义一个枚举的集合 并进行循环来处理这个目录下的things
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            // 循环迭代下去
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                // 得到协议的名称
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    // 获取包的物理路径
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    // 以文件的方式扫描整个包下的文件 并添加到集合中
                    classes.addAll(findClassByDirectory(packageName, filePath,classLoader,targetAnnotation));
                }
                else if ("jar".equals(protocol)) {
                    classes.addAll(findClassInJar(packageName, url,classLoader,targetAnnotation));
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }

}