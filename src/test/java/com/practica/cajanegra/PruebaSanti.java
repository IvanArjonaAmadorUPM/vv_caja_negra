package com.practica.cajanegra;

import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
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
    @DisplayName("test addLast")
    @ParameterizedTest(name="Add Last {0} in list")
    @ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})

    @Test       
    public void test_addLast(String s){
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

    //removelast
    @DisplayName("test removeLast")
    //@ParameterizedTest(name = "remove Last {0} in list")
    //@ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})

    @Test
    public void test_removeLast(String s) throws EmptyCollectionException {
        this.miLista = new SingleLinkedListImpl<String>("A","B","C","C","D","A");
        /*this.miLista.removeLast(s);
        assertEquals( "[A, B, C, C, D, A", -s-"]",this.miLista.toString());*/
        this.miLista.removeLast("A");
        assertEquals("[A, B, C, C, D]", this.miLista.toString());
        this.miLista.removeLast("B");
        assertEquals("[A, C, C, D, A]", this.miLista.toString());
        this.miLista.removeLast("M");
        assertEquals("[A, B, C, C, D, A]", this.miLista.toString());
    }

    @DisplayName("Debe comprobar si esta vacio")
    @ParameterizedTest(name="Add Last {0} in list")
    @ValueSource(strings= {"A"})

    @Test
    public void isEmptyTest(){
        this.miLista = new SingleLinkedListImpl<>();
        assertEquals(true, this.miLista.isEmpty());
    }

    @Test
    public void isEmptyTest(String s){
        this.miLista = new SingleLinkedListImpl<>(s);
        assertEquals(false, this.miLista.isEmpty());
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
