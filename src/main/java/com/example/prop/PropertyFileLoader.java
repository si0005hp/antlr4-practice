package com.example.prop;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;

public class PropertyFileLoader extends PropertyFileParser {

    Map<String, String> props = new HashMap<>();
    
    public PropertyFileLoader(TokenStream input) {
        super(input);
    }

    @Override
    void defineProperty(Token name, Token value) {
        props.put(name.getText(), value.getText());
    }
}
