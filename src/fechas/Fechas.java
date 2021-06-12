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
    	
    	System.out.println(diaDelAno(2017, 12,31));  // Debe imprimir 365
    	
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

     
    public static int[] devuelveArray (int dia, int mes, int ano) {
          
    int[] arregloParaDevolver ; //= {0,0,0};
    arregloParaDevolver = new int[3];
          
    arregloParaDevolver[0] = dia+1;
    arregloParaDevolver[1] = mes+1;
    arregloParaDevolver[2] = ano+1; 
    return arregloParaDevolver;
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
    
    public static String diaSiguiente(int dia, int mes, int ano) {
    	return "2017/5/2";
    }
    
    public static String fechaFutura(int dia, int mes, int ano, int cantidadDeDias) { 
    	String fecha = "";
    	int diaActual = dia; 
    	int mesActual = mes;
    	int anoActual = ano;
    	for (int indice = 0; indice < cantidadDeDias; indice++) {
    		fecha = diaSiguiente(anoActual, mesActual, diaActual);
    		if(fecha == "invalido") {
    			return fecha; 
    		}else {
        		String [] fechaSplit = fecha.split("/");
        		anoActual = Integer.parseInt(fechaSplit[0]);
        		mesActual = Integer.parseInt(fechaSplit[1]);
        		diaActual = Integer.parseInt(fechaSplit[2]);
    		}
    	}
    	return fecha;
    }
}

