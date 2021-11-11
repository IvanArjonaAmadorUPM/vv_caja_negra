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

import static org.junit.Assert.assertThrows;
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
        
    @DisplayName("testAddFirst")
    @ParameterizedTest(name="Add First {0} in list")
    @ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})
	public void test_addFirst(String s) {
	    this.miLista.addFirst(s);
    		assertEquals("[" + s + ", A, B, C]", this.miLista.toString());
    }    

    //addLast
    @ParameterizedTest(name="Add Last {0} in list")
    @ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})      
    public void addLast(String s){  
        this.miLista.addLast(s);
        assertEquals("[A, B, C, " + s + "]", this.miLista.toString());
    }        

    //getAtPos
    @ParameterizedTest(name = "{index} => Letra={0}, Posicion={1}")
    @CsvSource(value = {
            "A:1",
            "B:2",
            "M:3",
            "Y:4",
            "Z:5"
    },
            delimiter = ':')
    public void test_getAtPos(String letra, int posicion){
        this.miLista = new SingleLinkedListImpl<String>("A", "B", "M", "Y", "Z");
        assertEquals(letra, this.miLista.getAtPos(posicion));
    }


    @ParameterizedTest(name = "{index} => Letra={0}, Posicion={1}")
    @CsvSource(value = {
                "A:1",
                "B:2",
                "M:3",
                "Y:4",
                "Z:5"
        },
                delimiter = ':')
    public void test_indexOf(String letra, int posicion){
        this.miLista = new SingleLinkedListImpl<String>("A", "B", "M", "Y", "Z");
        assertEquals(posicion, this.miLista.indexOf(letra));
    }

    
    @ParameterizedTest(name = "{index} => Letra={0}, Posicion={1}")
    @CsvSource(value = {
            "A:1",
            "B:2",
            "M:3",
            "Y:4",
            "Z:5"
    },
            delimiter = ':')
            
    public void test_indexOfMalos(String letra, int posicion){
        this.miLista = new SingleLinkedListImpl<String>("A", "B", "M", "Y", "Z");
        assertThrowsException();
    }

    void assertThrowsException() {
        String str = null;
        assertThrows(IllegalArgumentException.class, () -> {
          Integer.valueOf(str);
        });
    }
    //test isEmpty
    @DisplayName("Debe comprobar que si esta vacio")
    @ParameterizedTest(name = "{index} => vacio={0}")
    @EmptySource
    @NullSource
    @ValueSource(strings = {""})
    public void test_isEmpty1(String s) {
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

    // tests Iván
    @DisplayName("testAddAtPosValida")
    @ParameterizedTest(name = "{index} => S={0}, P={1}, Esperado={2}")
    @CsvSource(value = {
            //A
            "A:1:[A, A, B, C, D, E]",
            "A:2:[A, A, B, C, D, E]",
            "A:3:[A, B, A, C, D, E]",
            "A:4:[A, B, C, A, D, E]",
            "A:5:[A, B, C, D, A, E]",
            "A:6:[A, B, C, D, E, A]",
            //B
            "B:1:[B, A, B, C, D, E]",
            "B:2:[A, B, B, C, D, E]",
            "B:3:[A, B, B, C, D, E]",
            "B:4:[A, B, C, B, D, E]",
            "B:5:[A, B, C, D, B, E]",
            "B:6:[A, B, C, D, E, B]",
            //M
            "M:1:[M, A, B, C, D, E]",
            "M:2:[A, M, B, C, D, E]",
            "M:3:[A, B, M, C, D, E]",
            "M:4:[A, B, C, M, D, E]",
            "M:5:[A, B, C, D, M, E]",
            "M:6:[A, B, C, D, E, M]",
            //Y
            "Y:1:[Y, A, B, C, D, E]",
            "Y:2:[A, Y, B, C, D, E]",
            "Y:3:[A, B, Y, C, D, E]",
            "Y:4:[A, B, C, Y, D, E]",
            "Y:5:[A, B, C, D, Y, E]",
            "Y:6:[A, B, C, D, E, Y]",
            //Z
            "Z:1:[Z, A, B, C, D, E]",
            "Z:2:[A, Z, B, C, D, E]",
            "Z:3:[A, B, Z, C, D, E]",
            "Z:4:[A, B, C, Z, D, E]",
            "Z:5:[A, B, C, D, Z, E]",
            "Z:6:[A, B, C, D, E, Z]",
    },
            delimiter = ':')
    public void test_addAtPosValido(String letra, int posicion, String esperado){
        this.miLista = new SingleLinkedListImpl<>("A","B","C","D","E");
        this.miLista.addAtPos(letra,posicion);
        assertEquals(esperado, this.miLista.toString());
    }

    @DisplayName("testAddAtPosNoValida")
    @ParameterizedTest(name = "{index} => S={0}, P={1}, Esperado={2}")
    @CsvSource(value = {
            //@
            "@:1:",
            "@:2:",
            "@:3:",
            "@:4:",
            "@:5:",
            "@:6",
            //[
            "[:1:",
            "[:2:",
            "[:3:",
            "[:4:",
            "[:5:",
            "[:6",
            //@
            "A:0:",
            "B:0:",
            "M:0:",
            "Y:0:",
            "Z:0:",
            "@:0",
            "[:0"

            },
                delimiter = ':')
    void test_addAtPosNoValido(String letra, int posicion) {
        this.miLista = new SingleLinkedListImpl<>("A","B","C","D","E");
        assertThrows(IllegalArgumentException.class, () -> {
            this.miLista.addAtPos(letra,posicion);
        });
    }



    //





}
