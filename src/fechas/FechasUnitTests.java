package fechas;
//
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FechasUnitTests {

    @Test
    public void pruebaDiaDelAno() {    
      assertEquals (Fechas.diaDelAno(2017,12,31),365);  
      assertEquals (Fechas.diaDelAno(2017,1,2),2);
      assertEquals (Fechas.diaDelAno(2017,5,2),122);
      assertEquals (Fechas.diaDelAno(2020,12,31),366);
      assertEquals(Fechas.diaDelAno(2020, 1, 1), 1);
    }
 
    @Test
    public void pruebaFechaValida() {
      assertEquals(Fechas.esFechaValida(2017,7,35),false);
      assertEquals(Fechas.esFechaValida(2003,2,28),true);
      assertEquals(Fechas.esFechaValida(2003,2,0),false);
      assertEquals(Fechas.esFechaValida(2003,0,28),false);
      assertEquals(Fechas.esFechaValida(2020,9,1),true);
      assertEquals(Fechas.esFechaValida(2020,1,23),true);
      assertEquals(Fechas.esFechaValida(1582,9,23),true);
      assertEquals(Fechas.esFechaValida(2020,5,31),true);
      assertEquals(Fechas.esFechaValida(2020,3,30),true);
      assertEquals(Fechas.esFechaValida(2020,2,29),true);
      assertEquals(Fechas.esFechaValida(2020,2,28),true);
    }
    
    @ParameterizedTest
    @CsvSource({"2003,2,28","2020,9,1","2020,1,23","1582,9,23","2020,5,31","2020,3,30","2020,2,29","2020,2,28"})
    public void pruebaFechaValida(int anno, int mes, int dia) {
        assertEquals(Fechas.esFechaValida(anno, mes, dia),true);
    }
    
    @ParameterizedTest
    @CsvSource({"2017,7,35","2003,2,0","2003,0,28"})
    public void pruebaFechaInvalida(int anno, int mes, int dia) {
        assertEquals(Fechas.esFechaValida(anno, mes, dia),false);
    }
    
    @Test 
    public void pruebaEsAnnoBisiestoValido() {
        int ANNO_BISIESTO_1 = 1600; 
        assertEquals(Fechas.esAnoBisiesto(ANNO_BISIESTO_1), true);
    }

    @Test
    public void pruebaFechaInvalida() {
        // ANO, MES y DIA MES
        assertEquals(Fechas.esFechaValida(2020, 9, 32), false);
        assertEquals(Fechas.esFechaValida(2020, 13, 23), false);
        assertEquals(Fechas.esFechaValida(1581, 9, 23), false);
        assertEquals(Fechas.esFechaValida(2020, 5, 32), false);
        assertEquals(Fechas.esFechaValida(2020, 4, 31), false);
        assertEquals(Fechas.esFechaValida(2020, 2, 30), false);
        assertEquals(Fechas.esFechaValida(2019, 2, 29), false);

    }
    
    @Test
    public void pruebaValidarDiasDeMesInvalido() {
    	assertEquals(Fechas.validarDiasDeMes(2, 0, 2020), -2);
    	assertEquals(Fechas.validarDiasDeMes(2, 30, 2020), -2);
    	assertEquals(Fechas.validarDiasDeMes(2, 30, 2019), -2);
    	assertEquals(Fechas.validarDiasDeMes(2, 29, 2019), -2);
    	assertEquals(Fechas.validarDiasDeMes(3, 0, 2020), -2);
    	assertEquals(Fechas.validarDiasDeMes(3, 32, 2020), -2);
    	assertEquals(Fechas.validarDiasDeMes(4, 0, 2020), -2);
    	assertEquals(Fechas.validarDiasDeMes(4, 31, 2020), -2);
    	assertEquals(Fechas.validarDiasDeMes(-1, 31, 2020), -1);
    }
    
    @Test
    public void pruebaValidarDiasDeMesValido() {
    	assertEquals(Fechas.validarDiasDeMes(2, 17, 2020), 2);
    	assertEquals(Fechas.validarDiasDeMes(4, 17, 2020), 4);
    }
    
    @Test
    public void  pruebaValidarMesValido() {
        int MES_VALIDO = 5; 
        assertEquals(Fechas.validarMes(MES_VALIDO), MES_VALIDO);
    }

    @Test 
    public void pruebaValidarMesInvalido() {
        int MES_INVALIDO = 13;
         assertNotEquals(Fechas.validarMes(MES_INVALIDO), MES_INVALIDO);
         int MES_INVALIDO_2 = 0; 
         assertNotEquals(Fechas.validarMes(MES_INVALIDO_2), MES_INVALIDO_2);
    }

    @Test 
    public void pruebaValidarAnnoValido() {
        int ANNO_VALIDO = 2020; 
        assertEquals(Fechas.validarAno(ANNO_VALIDO), ANNO_VALIDO);
    }
    @Test 
    public void pruebaValidarAnnoInvalido() {
        int ANNO_INVALIDO = 15; 
        assertNotEquals(Fechas.validarAno(ANNO_INVALIDO), ANNO_INVALIDO);
    }

    @Test 
    public void pruebaValidarDevuelveArray() {
        int DIA = 10; 
        int MONTH = 01; 
        int YEAR = 1998; 
        int[] ARREGLO_FECHA = {DIA+1, MONTH+1, YEAR+1}; 
        assertArrayEquals(Fechas.devuelveArray(DIA, MONTH, YEAR), ARREGLO_FECHA);
    }
  
    @Test 
    public void pruebaEsAnnoBisiestoInvalido() {
        int ANO_INVALIDO = 1500; 
        assertEquals(Fechas.esAnoBisiesto(ANO_INVALIDO), false);
    }
    
    @Test
    public void pruebaDiaDelAnoInvalido() {

        assertEquals(Fechas.diaDelAno(2020, 30, 2), -1);

        assertEquals(Fechas.diaDelAno(2020, 2, 30), -2);

        assertEquals(Fechas.diaDelAno(1581, 3, 30), -3);


    }
    
 }
  
