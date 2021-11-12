package com.practica.cajanegra;

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


public class PruebaSanti {
    
    
    public static void main(String[] args){
        System.out.println("pruebas de Santiago, igor y Jaime funciona?");

	}


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

    //getAtPos pasa la prueba y consigue bien la posición
    @DisplayName("testGetAtPos-Valida")
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

    //No pasa la prueba porque el código está mal y no lanza excepción al añadir valores fuera del rango de la lista
    @DisplayName("testGetAtPos-NoValida")
    @ParameterizedTest(name = "Add Last {0} in list")
    @ValueSource(strings= {"1","2"})    
    public void test_getAtPosNoValidos(int pos){
        this.miLista = new SingleLinkedListImpl<String>("@","]");
        assertThrows(IllegalArgumentException.class, () -> {
            this.miLista.getAtPos(pos);
        });
    }

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
    //tests Igor
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

    @DisplayName("Test removeLast")
    @ParameterizedTest(name = "{index} =>entrada={0}, Lista={1}, pos={2} Esperado={3}")
    @CsvSource(value = {
            "::1:Excepcion",
            ":A:1:A",
            "A:B:2:B",
    }, delimiter = ':')
    public void test_removeLast(String entrada, String s,int pos, String esperado){
        if(entrada == null) {
            if(s == null) {
                this.miLista = new SingleLinkedListImpl<>();
                assertThrows(EmptyCollectionException.class, () -> {
                    this.miLista.removeLast();
                });
            }
            else{
                this.miLista = new SingleLinkedListImpl<>();
                this.miLista.addAtPos(s, pos);
                try {
                    assertEquals(esperado, this.miLista.removeLast());
                } catch (EmptyCollectionException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            this.miLista = new SingleLinkedListImpl<>(entrada);
            this.miLista.addAtPos(s, pos);
            try {
                assertEquals(esperado, this.miLista.removeLast());
            } catch (EmptyCollectionException e) {
                e.printStackTrace();
            }
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



    // tests Iván
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





    //






