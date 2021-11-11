package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.runner.notification.RunListener.ThreadSafe;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebaSanti {
    
    
    public static void main(String[] args){
        System.out.println("pruebas de Santiago, igor y Jaime funciona?");


	}


    private SingleLinkedListImpl<String> miLista;  

    //addFirst
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

    //addLast
    @ParameterizedTest(name="Add Last {0} in list")
    @ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})

    @Test       
    public void addLast(String s){  
        this.miLista.addLast(s);
        assertEquals("[A, B, C, " + s + "]", this.miLista.toString());
    }        

    //getAtPos
    @Test
    //@ValueSource(ints = {1,2, num})
    public void getAtPos(int pos){
        //this.miLista.getAtPos(3);
        assertEquals("C", this.miLista.getAtPos(3));
    }

    //test isEmpty
    @DisplayName("Debe comprobar que si esta vacio")
    @ParameterizedTest(name = "{index} => vacio={0}")
    @EmptySource
    @NullSource
    @ValueSource(strings = {""})
    public void test_isEmpty1(String s){
        this.miLista = new SingleLinkedListImpl<>(s);
        assertEquals(true, this.miLista.isEmpty());
    }
    @DisplayName("Debe comprobar que no esta vacio")
    @ParameterizedTest(name = "{index} => Lista={0}, Esperado={1}")
    @CsvSource(value = {
            "A:false",
            "[A,B]:false",
                        }, delimiter = ':')

    public void test_isEmpty(String s, boolean esperado){
        this.miLista = new SingleLinkedListImpl<>(s);
        assertEquals(esperado, this.miLista.isEmpty());
    }





    // test ejemplo Iván
    @DisplayName("testAddAtPos")
    @ParameterizedTest(name = "{index} => Letra={0}, Posicion={1}, Esperado={2}")
    @CsvSource(value = {
            "A:3:[A, B, A, C]",
            "B:2:[A, B, B, C]",
            "M:8:[A, B, C, M]",
            "Y:8:[A, B, C, Y]",
            "Z:1:[Z, A, B, C]"
    },
            delimiter = ':')
    public void test_addAtPos(String letra, int posicion, String esperado){
        this.miLista = new SingleLinkedListImpl<String>("A","B","C","D");
        this.miLista.addAtPos(letra,posicion);
        assertEquals(esperado, this.miLista.toString());
    }
        //





}
