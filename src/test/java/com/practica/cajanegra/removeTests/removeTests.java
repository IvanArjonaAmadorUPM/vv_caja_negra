package com.practica.cajanegra.removeTests;

import com.cajanegra.AbstractSingleLinkedListImpl;

import com.cajanegra.EmptyCollectionException;
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

public class removeTests {
    private SingleLinkedListImpl<String> miLista;


    @BeforeEach
    public void setUp() {
        this.miLista = new SingleLinkedListImpl<String>("A","B","C");
    }

    @ParameterizedTest(name = "{index} => letra={0}, esperado={1}")
    @CsvSource(value = {
            "A:[A, B, B, Y, M, Y, Z]",
            "B:[A, B, A, Y, M, Y, Z]",
            "M:[A, B, B, A, Y, Y, Z]",
            "Y:[A, B, B, A, Y, M, Z]",
            "Z:[A, B, B, A, Y, M, Y]"
    },
            delimiter = ':')

    public void test_removeLast(String letra, String esperado) throws EmptyCollectionException {
        this.miLista = new SingleLinkedListImpl<String>("A", "B", "B","A", "Y", "M", "Y", "Z");
        this.miLista.removeLast(letra);
        assertEquals(esperado, this.miLista.toString());
    }
    @ParameterizedTest(name = "{index} => letra={0}, esperado={1}")
    @CsvSource(value = {
            "@:",
            "[:"
    },
            delimiter = ':')

    public void test_removeLastNoValido(String letra, String esperado) throws EmptyCollectionException {
        this.miLista = new SingleLinkedListImpl<String>("A", "B", "B","A", "Y", "M", "Y", "Z");
        assertThrows(IllegalArgumentException.class, () -> {
            this.miLista.removeLast(letra);
        });
    }

    @DisplayName("Test removeLast Invalidos")
    @ParameterizedTest(name = "{index} =>entrada={0}, Lista={1}, pos={2} Esperado={3}")
    @CsvSource(value = {
            "::1:Excepcion"
    }, delimiter = ':')
    public void test_removeLastInvalido(String entrada, String s,int pos, String esperado){
        this.miLista = new SingleLinkedListImpl<>();
        assertThrows(EmptyCollectionException.class, () -> {
            this.miLista.removeLast();
        });
    }
    @DisplayName("Test removeLast Validos")
    @ParameterizedTest(name = "{index} =>entrada={0}, Lista={1}, pos={2} Esperado={3}")
    @CsvSource(value = {
            ":A:1:A",
            "A:B:2:B",
    }, delimiter = ':')
    public void test_removeLastValido(String entrada, String s,int pos, String esperado) throws EmptyCollectionException{
        if(entrada == null) {
            this.miLista = new SingleLinkedListImpl<>();
            this.miLista.addAtPos(s, pos);
            assertEquals(esperado, this.miLista.removeLast());
        }
        else{
            this.miLista = new SingleLinkedListImpl<>(entrada);
            this.miLista.addAtPos(s, pos);
            assertEquals(esperado, this.miLista.removeLast());
        }
    }


}
