package fechas;
//
import java.io.IOException;

class Fechas {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // 

    	System.out.println("Programa principal");
    	
    	System.out.println(fechaFutura(10, 12,2021, 10));  // Debe imprimir 365
    	
    	System.out.println(esFechaValida(2003,2,28)); //Debe imprimir true
    	
        }
    //}
 
    public static boolean esFechaValida(final int year, final int month, final int dayOfMonth){
      
    int[] DAYS_IN_MONTH = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    int FEBRUARY = 2;
      
    if((dayOfMonth >= 1 && dayOfMonth <= 31) && (month >= 1 && month <= 12) && (year >= 1582)){
      
      if((esAnoBisiesto(year) && (month == FEBRUARY) && (dayOfMonth == 29))  
        || (dayOfMonth <= DAYS_IN_MONTH[month])){
        
        return true; 
      
      }else{
        return false;
      }
      
    }else{
      return false;
    }
    }
    
    public static int diaDelAno(int year, int month, int dayOfMonth) {
        int totalDays = validarDiasDeMes(month, dayOfMonth,year);
        if (totalDays != -1 && totalDays != -2) {
            totalDays = validarAno(year);
            if (totalDays != -3) {                
                int daysPerMonthArray[]
                        = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
                totalDays = dayOfMonth;
                for (int i = 1; i < month; i++) {
                    totalDays += daysPerMonthArray[i-1];
                }
                
                if(esAnoBisiesto(year) && month > 2) {
                  totalDays++;
                }
            }
        }
        return totalDays;
    }
       
   public static int validarDiasDeMes(int month, int dayOfMonth, int year) {
        int isNotCorrect = validarMes(month);
        if (isNotCorrect > -1) {
            switch (month) {
                case 2://febraury days in month: 28
                    if (dayOfMonth < 1 || dayOfMonth > 28) {
                        if(!esAnoBisiesto(year)){
                          isNotCorrect = -2;
                        }
                    }
                    if (dayOfMonth < 1 || dayOfMonth > 29) {
                        if(esAnoBisiesto(year)){
                          isNotCorrect = -2;
                        }
                    }
                    break;
                case 1:   
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12://months with 31 days
                    if (dayOfMonth < 1 || dayOfMonth > 31) {
                        isNotCorrect = -2;
                    }
                    break;
                default://month with 30 days
                    if (dayOfMonth < 1 || dayOfMonth > 30) {
                          isNotCorrect = -2;
                    }
                    break;
            }
        }
        return isNotCorrect; 
    }
      
    public static int validarMes(int pmonth) {
        int month = pmonth;
        if (month > 12 || month < 1) {   
            month = -1;//month not correct
        }
        return month;
    }
    
    public static int validarAno(int pyear) {
        int yeay = pyear;
        if (yeay < 1582) {
            yeay = -3;//year not correct
        }
        return yeay;
    }
    
    public static boolean esAnoBisiesto(int pyear){
        boolean isLeap = false;
        if (validarAno(pyear) > -3) {        
              if ((pyear % 400 == 0) | (pyear % 4 == 0 & pyear % 100 != 0)) {
                  isLeap = true;
              } 
             }  
        return isLeap;
    }
    
    public static String diaSiguiente(int dia, int mes, int anno) {
    	if (esFechaValida(anno,mes,dia)) {
    		String newFecha;
    		int newDia=dia,newMes=mes,newAnno=anno;
    		switch(mes) {
    			case 1:
    			case 3:
    			case 5:
    			case 7:
    			case 8:
    			case 10:
    			case 11:
    			case 12: // los meses de 31 dias
    				if (mes < 12) {
    					if (dia < 31) {
    						newDia = dia + 1;
    					} else {
    						newDia = 1;
    						newMes = mes + 1;
    					}
    				} else { // si es diciembre
    					if (dia < 31) {
    						newDia = dia + 1;
    					} else { // es año nuevo
    						newDia = 1;
    						newMes = 1;
    						newAnno = anno + 1;
    					}
    				}
    			case 2: // si es febrero
    				if (esAnoBisiesto(anno)) {
    					if (dia < 29) {
    						newDia = dia + 1;
    					} else { // es 29 de febrero
    						newDia = 1;
    						newMes = 3;
    					}
    				} else { // si no es bisiesto
    					if (dia < 28) {
    						newDia = dia + 1;
    					} else { // es 28 de febrero
    						newDia = 1;
    						newMes = 3;
    					}
    				}
    			default: // los meses de 30 días
    				if (dia < 30) {
						newDia = dia + 1;
					} else {
						newDia = 1;
						newMes = mes + 1;
					}
    		}
    		newFecha = Integer.toString(newDia) + "/" + Integer.toString(newMes) + "/" + Integer.toString(newAnno);
    		return newFecha;
    	} else { // es una fecha inválida
    		return "invalido";
    	}
    }
    public static String fechaFutura(int dia, int mes, int ano, int cantidadDeDias) { 
    	String fecha = "";
    	int diaActual = dia; 
    	int mesActual = mes;
    	int anoActual = ano;
    		fecha = diaSiguiente(diaActual, mesActual, anoActual);
    	for (int indice = 1; indice < cantidadDeDias; indice++) {
    		if(fecha == "invalido") {
    			return fecha; 
    		}else {
        		String [] fechaSplit = fecha.split("/");
        		anoActual = Integer.parseInt(fechaSplit[2]);
        		mesActual = Integer.parseInt(fechaSplit[1]);
        		diaActual = Integer.parseInt(fechaSplit[0]);
        		fecha = diaSiguiente(diaActual, mesActual, anoActual);
    		}
    	}
    	return fecha;
    }
}

