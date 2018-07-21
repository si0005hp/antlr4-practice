package com.example.actions.tools;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Calc {
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if (args.length > 0)
            inputFile = args[0];
        InputStream is = System.in;
        if (inputFile != null) {
            is = new FileInputStream(inputFile);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String expr = br.readLine();
        int line = 1;

        ExprParser parser = new ExprParser(null);
        parser.setBuildParseTree(false);

        while (expr != null) {
            ANTLRInputStream input = new ANTLRInputStream(expr + "\n");
            ExprLexer lexer = new ExprLexer(input);
            lexer.setLine(line);
            lexer.setCharPositionInLine(0);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser.setInputStream(tokens);
            parser.stat();
            expr = br.readLine();
            line++;
        }
    }
}
