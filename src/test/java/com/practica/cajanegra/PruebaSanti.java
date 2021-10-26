package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.notification.RunListener.ThreadSafe;

import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebaSanti {
    
    
    public static void main(String[] args){
        System.out.println("pruebas de Santiago, igor y Jaime");

	}

    private SingleLinkedListImpl<String> miLista;  
    
        @BeforeEach
	    public void setUp() {
		    this.miLista = new SingleLinkedListImpl<String>("A","B","C");
	    }
        
        @ParameterizedTest(name="Add First {0} in list")
        @ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})

        @Test
	    public void addFirst(String s) {
		    this.miLista.addFirst(s);
		    assertEquals("[" + s + ", A, B, C]", this.miLista.toString());


    }
}
