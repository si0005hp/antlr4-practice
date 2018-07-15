package com.example.prop;

import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.example.java.JavaLexer;

public class PropertyFileMain {
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if (args.length > 0)
            inputFile = args[0];
        InputStream is = System.in;
        if (inputFile != null) {
            is = PropertyFileMain.class.getClassLoader().getResourceAsStream(inputFile);
        }
        ANTLRInputStream input = new ANTLRInputStream(is);
        PropertyFileLexer lexer = new PropertyFileLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        PropertyFilePrinter p = new PropertyFilePrinter(tokens);
        p.file();
    }
}
