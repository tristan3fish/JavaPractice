package com.t3f.utility;

import com.google.common.io.ByteStreams;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class ResourceReader {

    public String read(String resourcePath, Charset encoding) {
        String result = "";
        try {
            InputStream stream = this.getClass().getClassLoader().getResourceAsStream(resourcePath);
            byte[] encoded = ByteStreams.toByteArray(stream);
            result = new String(encoded, encoding);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
