package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackBoxTest {
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


    // test ejemplo Iván
    //@DisplayName("testAddAtPos")
    @ParameterizedTest(name = "{index} => Letra={0}, Posicion={1}, Esperado={2}")
    @CsvSource(value = {
            "A:3:[A, B, A, C]",
            "Z:1:[Z, A, B, C]",
            },
            delimiter = ':')
    public void test_addAtPos(String letra, int posicion, String esperado){
        this.miLista.addAtPos(letra,posicion);
        assertEquals(esperado, this.miLista.toString());
    }
}
