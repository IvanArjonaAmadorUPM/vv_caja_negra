package com.practica.cajanegra.infoTests;

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

public class infoTests {
    private SingleLinkedListImpl<String> miLista;

    @BeforeEach
    public void setUp() {
        this.miLista = new SingleLinkedListImpl<String>("A","B","C");
    }

    @DisplayName("Test isEmpty")
    @ParameterizedTest(name = "{index} => Entrada={0}, Lista={1}, pos={2} Esperado={3}")

    @CsvSource(value = {
            "::1:true",
            ":A:1:false",
            "A:B:2:false",
    }, delimiter = ':')

    public void test_isEmpty(String entrada, String s, int pos, boolean esperado){
        if (entrada == null){
            if(s == null){
                this.miLista = new SingleLinkedListImpl<>();
                assertEquals(esperado, this.miLista.isEmpty());
            }
            else {
                this.miLista = new SingleLinkedListImpl<>(s);
                this.miLista.addAtPos(s, pos);
                assertEquals(esperado, this.miLista.isEmpty());
            }
        }
        else{
            this.miLista = new SingleLinkedListImpl<>(s);
            this.miLista.addAtPos(s, pos);
            assertEquals(esperado, this.miLista.isEmpty());
        }
    }

    @DisplayName("Test reverse")
    @ParameterizedTest(name = "{index} => Entrada={0}, Lista={1}, pos={2}, Esperado={3}")
    @CsvSource(value = {
            "::1:[]",
            ":A:1:[A]",
            "A:B:2:[B, A]",
    }, delimiter = ':')
    public void test_reverse(String entrada, String s, int pos, String esperado){
        if (null == entrada){
            if (s == null){
                this.miLista = new SingleLinkedListImpl<>();
                assertEquals(esperado, this.miLista.reverse().toString());
            }
            else{
                this.miLista = new SingleLinkedListImpl<>();
                this.miLista.addAtPos(s, pos);
                assertEquals(esperado, this.miLista.reverse().toString());
            }
        }
        else {
            this.miLista = new SingleLinkedListImpl<>(entrada);
            this.miLista.addAtPos(s, pos);
            assertEquals(esperado, this.miLista.reverse().toString());
        }
    }

    @DisplayName("Test size")
    @ParameterizedTest(name = "{index} => Entrada={0}, Lista={1}, pos={2}, Esperado={3}")
    @CsvSource(value = {
            "::1:0",
            ":A:1:1",
            "A:B:2:2",
    }, delimiter = ':')
    public void test_size(String entrada, String s, int pos, int esperado){
        if (null == entrada){
            if (s == null){
                this.miLista = new SingleLinkedListImpl<>();
                assertEquals(esperado, this.miLista.size());
            }
            else{
                this.miLista = new SingleLinkedListImpl<>();
                this.miLista.addAtPos(s, pos);
                assertEquals(esperado, this.miLista.size());
            }
        }
        else {
            this.miLista = new SingleLinkedListImpl<>(entrada);
            this.miLista.addAtPos(s, pos);
            assertEquals(esperado, this.miLista.size());
        }
    }

    @DisplayName("Test toString")
    @ParameterizedTest(name = "{index} => Entrada={0}, Lista={1}, pos={2}, Esperado={3}")
    @CsvSource(value = {
            "::1:[]",
            ":A:1:[A]",
            "A:B:2:[A, B]",
    }, delimiter = ':')
    public void test_toString(String entrada, String s, int pos, String esperado){
        if (null == entrada){
            if (s == null){
                this.miLista = new SingleLinkedListImpl<>();
                assertEquals(esperado, this.miLista.toString());
            }
            else{
                this.miLista = new SingleLinkedListImpl<>();
                this.miLista.addAtPos(s, pos);
                assertEquals(esperado, this.miLista.toString());
            }
        }
        else {
            this.miLista = new SingleLinkedListImpl<>(entrada);
            this.miLista.addAtPos(s, pos);
            assertEquals(esperado, this.miLista.toString());
        }
    }
}
