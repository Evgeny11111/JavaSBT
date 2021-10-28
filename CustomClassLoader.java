import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

class CustomClassLoader extends ClassLoader {
    private final ArrayList<StringBuilder> classes;
    private final HashMap<String, Byte[]> classesToBytes = new HashMap<>();

    public CustomClassLoader(URL[] urls) throws IOException {
        classes = new ArrayList<>(urls.length);
        parseFiles(urls);
    }


    private void parseFiles(URL[] urls) throws IOException {
        for (int i = 0; i < urls.length; i++) {
            classes.add(new StringBuilder());
            BufferedInputStream in = new BufferedInputStream(urls[i].openStream());
            byte[] buffer = in.readAllBytes();
            int j = 0;
            while ((j < buffer.length) &&
                    (Character.isLetter((char) (buffer[j] - 1)) || (char) (buffer[j] - 1) == '.') &&
                    (Character.isLetter((char) (buffer[j + 1] - 1)) || (char) (buffer[j + 1] - 1) == '.')) {
                classes.get(i).append((char) (buffer[j] - 1));
                buffer[j] = (byte) (buffer[j] - 1);
                j++;
            }
            Byte[] res = new Byte[buffer.length - j];
            for (int k = j; k < buffer.length; k++) {
                res[k - j] = (byte) (buffer[k] - 1);
            }
            classesToBytes.put(classes.get(i).toString(), res);
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] res = new byte[classesToBytes.get(name).length];
        for (int i = 0; i < res.length; i++) {
            res[i] = classesToBytes.get(name)[i];
        }
        return defineClass(name, res, 0, res.length);
    }

    public ArrayList<StringBuilder> getClasses() {
        return classes;
    }
}

