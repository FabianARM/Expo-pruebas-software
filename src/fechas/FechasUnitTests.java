package fechas;
//
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FechasUnitTests {

    @ParameterizedTest
    @CsvSource({"2017,12,31,365", "2017,1,2,2", "2017,5,2,122","2020,12,31,366","2020,1,1,1"})
    public void pruebaDiaDelAno(int anno, int mes, int dia, int resultado) {    
      assertEquals (Fechas.diaDelAno(anno,mes,dia),resultado);  

    }
    
    @ParameterizedTest
    @CsvSource({"2003,2,28","2020,9,1","2020,1,23","1582,9,23","2020,5,31","2020,3,30","2020,2,29","2020,2,28"})
    public void pruebaFechaValida(int anno, int mes, int dia) {
        assertEquals(Fechas.esFechaValida(anno, mes, dia),true);
    }
    
    
    @ParameterizedTest
    @CsvSource({"1600"})
    public void pruebaEsAnnoBisiestoValido(int anno) {
        assertEquals(Fechas.esAnoBisiesto(anno), true);
    }
    
    @ParameterizedTest
    @CsvSource({"1500"})
    public void pruebaEsAnnoBisiestoInvalido(int anno) {
        assertEquals(Fechas.esAnoBisiesto(anno), false);
    }

    @ParameterizedTest
    @CsvSource({"2020,9,32","2020,13,23","1581,9,23","2020,5,32","2020,4,31","2020,2,30","2019,2,29","2017,7,35","2003,2,0","2003,0,28"})
    public void pruebaFechaInvalida(int anno, int mes, int dia) {
        // ANO, MES y DIA MES
        assertEquals(Fechas.esFechaValida(anno, mes, dia), false);

    }
    
    @ParameterizedTest
    @CsvSource({"2,0,2020,-2","2,30,2020,-2","2,30,2019,-2","2,29,2019,-2","3,0,2020,-2","3,32,2020,-2","4,0,2020,-2","4,31,2020,-2","4,31,2020,-2","-1,31,2020,-1"})
    public void pruebaValidarDiasDeMesInvalido(int mes, int dia, int anno, int resultado) {
    	assertEquals(Fechas.validarDiasDeMes(mes, dia, anno), resultado);
    }
    
    @ParameterizedTest
    @CsvSource({"2,17,2020,2","4,17,2020,4"})
    public void pruebaValidarDiasDeMesValido(int mes, int dia, int anno,int resultado) {
    	assertEquals(Fechas.validarDiasDeMes(mes, dia, anno), resultado);
    	
    }
    
    @ParameterizedTest
    @CsvSource({"5"})
    public void  pruebaValidarMesValido(int mes) {
        assertEquals(Fechas.validarMes(mes), mes);
    }

    @ParameterizedTest
    @CsvSource({"2017,7,35"})
    public void pruebaValidarMesInvalido() {
        int MES_INVALIDO = 13;
         assertNotEquals(Fechas.validarMes(MES_INVALIDO), MES_INVALIDO);
         int MES_INVALIDO_2 = 0; 
         assertNotEquals(Fechas.validarMes(MES_INVALIDO_2), MES_INVALIDO_2);
    }

    @ParameterizedTest
    @CsvSource({"2020"})
    public void pruebaValidarAnnoValido(int anno) {
        assertEquals(Fechas.validarAno(anno), anno);
    }
    @ParameterizedTest
    @CsvSource({"15"})
    public void pruebaValidarAnnoInvalido(int anno) {
        assertNotEquals(Fechas.validarAno(anno), anno);
    }
    
    @ParameterizedTest
    @CsvSource({"2020,30,2,-1", "2020,2,30,-2", "1581,3,30,-3"})
    public void pruebaDiaDelAnoInvalido(int anno, int mes, int dia, int resultado) {
        assertEquals(Fechas.diaDelAno(anno, mes, dia), resultado);
    }
    
    @ParameterizedTest
    @CsvSource({"2020,3,1,2020/3/2","2020,3,31,2020/4/1","2020,12,1,2020/12/2","2020,12,31,2021/1/1","2020,2,28,2020/2/29","2020,2,29,2020/3/1","2019,2,27,2019/2/28","2019,2,28,2019/3/1","2019,4,29,2019/4/30","2019,4,30,2019/5/1"})
    public void pruebaDiaSiguienteValido(int anno, int mes, int dia, String resultadoEsperado) {
        assertEquals(Fechas.diaSiguiente(anno, mes, dia),resultadoEsperado);
    }
    
    @ParameterizedTest
    @CsvSource({"2019,2,29"})
    public void pruebaDiaSiguienteInvalido(int anno, int mes, int dia) {
    	String DIA_SIGUIENTE_INVALIDO = "invalido";
    	assertEquals(Fechas.diaSiguiente(anno, mes, dia),DIA_SIGUIENTE_INVALIDO);
    }
    
    @ParameterizedTest
    @CsvSource({"2017,12,31,10,2018/1/10","20,20,20,10,invalido"})
    public void pruebaFechaFutura(int anno, int mes, int dia, int diasAPasar, String resultado) {
    	assertEquals(Fechas.fechaFutura(anno, mes, dia,diasAPasar),resultado);
    }
 }
  
