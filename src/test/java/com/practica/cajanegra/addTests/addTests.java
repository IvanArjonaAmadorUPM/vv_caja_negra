package com.practica.cajanegra.addTests;

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

public class addTests {
    private SingleLinkedListImpl<String> miLista;


    @BeforeEach
    public void setUp() {
        this.miLista = new SingleLinkedListImpl<String>("A","B","C");
    }

    //addFirst no pasa la prueba porque no añade la letra en el first
    @DisplayName("testAddFirst-Valida")
    @ParameterizedTest(name="Add First {0} in list")
    @ValueSource(strings= {"A", "B", "M", "Y", "Z"})
    public void test_addFirst(String s) {
        this.miLista.addFirst(s);
        assertEquals("[" + s + ", A, B, C]", this.miLista.toString());
    }


    //No pasa la prueba porque no funciona y no añade la letra en el first entonces no lanza la excepción
    @DisplayName("testAddFirst-NoValida")
    @ParameterizedTest(name="Add First {0} in list")
    @ValueSource(strings= {"@","["})
    public void test_addFirstNoValidos(String s) {
        assertThrows(IllegalArgumentException.class, () -> {
            this.miLista.addFirst(s);
        });
    }

    //addLast pasa la prueba y añade correctamente
    @DisplayName("testAddLast-Valida")
    @ParameterizedTest(name="Add Last {0} in list")
    @ValueSource(strings= {"A", "B", "M", "Y", "Z"})
    public void addLast(String s){

        this.miLista.addLast(s);
        assertEquals("[A, B, C, " + s + "]", this.miLista.toString());
    }

    //No pasa la prueba porque no salta la excepción, añade la letra al final
    @DisplayName("testAddLast-NoValida")
    @ParameterizedTest(name="Add Last {0} in list")
    @ValueSource(strings= {"@","["})
    public void test_addLastNoValidos(String s) {
        assertThrows(IllegalArgumentException.class, () -> {
            this.miLista.addLast(s);;
        });
    }

    @DisplayName("testAddAtPos-Valida")
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
            //0
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


    @DisplayName("testAddNTimes-Valida")
    @ParameterizedTest(name = "{index} => S={0}, N={1}, Esperado={2}")
    @CsvSource(value = {
            //A
            "A:0:[A, B, C, D]",
            "A:1:[A, B, C, D, A]",
            "A:2:[A, B, C, D, A, A]",
            "A:3:[A, B, C, D, A, A, A]",
            "A:4:[A, B, C, D, A, A, A, A]",
            "A:10:[A, B, C, D, A, A, A, A, A, A, A, A, A, A]",
            //B
            "B:0:[A, B, C, D]",
            "B:1:[A, B, C, D, B]",
            "B:2:[A, B, C, D, B, B]",
            "B:3:[A, B, C, D, B, B, B]",
            "B:4:[A, B, C, D, B, B, B, B]",
            "B:10:[A, B, C, D, B, B, B, B, B, B, B, B, B, B]",
            //M
            "M:0:[A, B, C, D]",
            "M:1:[A, B, C, D, M]",
            "M:2:[A, B, C, D, M, M]",
            "M:3:[A, B, C, D, M, M, M]",
            "M:4:[A, B, C, D, M, M, M, M]",
            "M:10:[A, B, C, D, M, M, M, M, M, M, M, M, M, M]",
            //Y
            "Y:0:[A, B, C, D]",
            "Y:1:[A, B, C, D, Y]",
            "Y:2:[A, B, C, D, Y, Y]",
            "Y:3:[A, B, C, D, Y, Y, Y]",
            "Y:4:[A, B, C, D, Y, Y, Y, Y]",
            "Y:10:[A, B, C, D, Y, Y, Y, Y, Y, Y, Y, Y, Y, Y]",
            //Z
            "Z:0:[A, B, C, D]",
            "Z:1:[A, B, C, D, Z]",
            "Z:2:[A, B, C, D, Z, Z]",
            "Z:3:[A, B, C, D, Z, Z, Z]",
            "Z:4:[A, B, C, D, Z, Z, Z, Z]",
            "Z:10:[A, B, C, D, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z]",
    },
            delimiter = ':')
    public void test_addNTimesValido(String letra, int veces, String esperado){
        this.miLista = new SingleLinkedListImpl<>("A","B","C","D");

        this.miLista.addNTimes(letra,veces);
        assertEquals(esperado, this.miLista.toString());
    }


    @DisplayName("testAddNTimesNoValida")
    @ParameterizedTest(name = "{index} => S={0}, N={1}, Esperado={2}")
    @CsvSource(value = {
            //@
            "@:0:",
            "@:1:",
            "@:2:",
            "@:3:",
            "@:4:",
            "@:10",
            //[
            "[:0:",
            "[:1:",
            "[:2:",
            "[:3:",
            "[:4:",
            "[:10",
            //-1
            "A:-1:",
            "B:-1:",
            "M:-1:",
            "Y:-1:",
            "Z:-1:",
            "@:-1",
            "[:-1"

    },
            delimiter = ':')
    void test_addNTimesNoValido(String letra, int veces) {
        this.miLista = new SingleLinkedListImpl<>("A","B","C","D");
        assertThrows(IllegalArgumentException.class, () -> {
            this.miLista.addNTimes(letra,veces);
        });
    }

}
