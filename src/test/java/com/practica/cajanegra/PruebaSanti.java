package com.practica.cajanegra;

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




    // tests Iván
    @DisplayName("testAddAtPosValida")
    @ParameterizedTest(name = "{index} => S={0}, P={1}, Esperado={2}")
    @CsvSource(value = {
            //@ java.lang.IllegalArgumentException
            "@:1:[@, A, B, C, D, E]",
            "@:2:[A, @, B, C, D, E]",
            "@:3:[A, B, @, C, D, E]",
            "@:4:[A, B, C, @, D, E]",
            "@:5:[A, B, C, D, @, E]",
            "@:6:[A, B, C, D, E, @]",

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


        //





}
