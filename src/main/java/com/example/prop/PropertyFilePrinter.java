package com.example.prop;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;

public class PropertyFilePrinter extends PropertyFileParser {

    public PropertyFilePrinter(TokenStream input) {
        super(input);
    }
    
    @Override
    void defineProperty(Token name, Token value) {
        System.out.println(name.getText() + "=" + value.getText());
    }

}
