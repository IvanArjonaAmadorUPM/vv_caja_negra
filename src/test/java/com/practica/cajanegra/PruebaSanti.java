package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.notification.RunListener.ThreadSafe;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebaSanti {
    
    
    public static void main(String[] args){
        System.out.println("pruebas de Santiago");

	}

    private SingleLinkedListImpl<String> miLista;  
    
        @BeforeEach
	    public void setUp() {
		    this.miLista = new SingleLinkedListImpl<String>("A","B","C");
	    }

        @Test

        @ParameterizedTest(name="Add First {0} in list")
        @ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})

	    public void addFirst(String s) {
		    this.miLista.addFirst(s);
		    assertEquals("[" + s + ", A, B, C]", this.miLista.toString());


    }
}
