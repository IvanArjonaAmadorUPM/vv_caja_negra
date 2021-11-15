package com.practica.cajanegra.posTests;

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

public class posTests {
    private SingleLinkedListImpl<String> miLista;


    @BeforeEach
    public void setUp() {
        this.miLista = new SingleLinkedListImpl<String>("A","B","C");
    }

    //getAtPos pasa la prueba y consigue bien la posición
    @DisplayName("testGetAtPos-Valida")
    @ParameterizedTest(name = "{index} => Letra={0}, Posicion={1}")
    @CsvSource(value = {
            "A:1",
            "B:2",
            "C:3",
            "D:4",
            "M:5",
            "Y:6",
            "Z:7"
    },
            delimiter = ':')
    public void test_getAtPos(String letra, int posicion){
        this.miLista = new SingleLinkedListImpl<String>("A", "B", "C","D","M", "Y", "Z");
        assertEquals(letra, this.miLista.getAtPos(posicion));
    }

    //Pasa la prueba porque el código está mal y lanza excepción al pedir valores fuera de la lista
    @DisplayName("testGetAtPos-NoValida")
    @ParameterizedTest(name = "Add Last {0} in list")
    @ValueSource(strings= {"0","6"})
    public void test_getAtPosNoValidos(int pos){
        this.miLista = new SingleLinkedListImpl<String>("A", "B", "M", "Y", "Z");
        assertThrows(IllegalArgumentException.class, () -> {
            this.miLista.getAtPos(pos);
        });
    }

    //indexOf
    //Pasa la prueba y devuelve correctamente el índice
    @DisplayName("testIndexOf-Valida")

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

    //No pasa la prueba porque el codigo está mal y permite que existan listas con valores fuera del rango por lo que no salta la excepcion
    @DisplayName("testIndexOf-NoValidaRango")
    @ParameterizedTest(name = "Add Last {0} in list")
    @ValueSource(strings= {"@","["})
    public void test_indexOfNoValidoRango(String letra){
        this.miLista = new SingleLinkedListImpl<String>("@","[");
        assertThrows(IllegalArgumentException.class, () -> {
            this.miLista.indexOf(letra);
        });
    }

    //Pasa la prueba porque salta la excepción de que el elemento buscado no está en la lista.
    @DisplayName("testIndexOf-NoValidaArgumento")
    @ParameterizedTest(name = "Add Last {0} in list")
    @ValueSource(strings= {"S"})
    public void test_indexOfNoValidoArgumento(String letra){
        this.miLista = new SingleLinkedListImpl<String>("A", "B", "M", "Y", "Z");
        assertThrows(java.util.NoSuchElementException.class, () -> {
            this.miLista.indexOf(letra);
        });
    }

    //isSublist
    @ParameterizedTest(name = "{index} => lista1=[0], posicion={1}")
    @CsvSource(value = {
            "[B, M, Y]:2",
            "[A, M, Y]:-1",
            "[]:0"
    },
            delimiter= ':')
    public void test_isSubList(String lista1, int posicion){
        this.miLista = new SingleLinkedListImpl<String>("A", "B", "M", "Y", "Z");
        SingleLinkedListImpl lista= new SingleLinkedListImpl<String>(lista1);
        assertEquals(posicion, this.miLista.isSubList(lista));
    }

    @ParameterizedTest(name = "{index} => lista1=[0], posicion={1}")
    @CsvSource(value = {
            "[A, B][B, C]: -1",
            "B:-1",
            "[@, @]:-1"
    },
            delimiter= ':')
    public void test_isSubListNoValidos(String lista1, int posicion){
        this.miLista = new SingleLinkedListImpl<String>("A", "B", "M", "Y", "Z");
        SingleLinkedListImpl lista= new SingleLinkedListImpl<String>(lista1);
        assertThrows(IllegalArgumentException.class, () -> {
            this.miLista.isSubList(lista);
        });
    }



}
