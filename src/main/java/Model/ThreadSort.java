/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author basile
 */
public class ThreadSort extends Thread{
    private SeriesSort ss;
    private SortingMethod method;
    

    public ThreadSort(SeriesSort ss, SortingMethod method) {
        this.ss = ss;
        this.method = method;
        
    }
    
    @Override
    public void run() {
        Integer[] array = ss.getAvailableInteger();
        while(array!=null){
            int nombreOperation = 0;
            LocalDateTime now = LocalDateTime.now();
            long start = System.currentTimeMillis();
            switch(method){
                case BUBBLE:
                    nombreOperation = Sort.bubbleSort(array);
                    ss.addNombreOperation(nombreOperation);
                    break;
                case MERGE:
                    nombreOperation = Sort.mergeSort(array, array.length);
                    ss.addNombreOperation(nombreOperation);
                    break;
                default:
                    throw new AssertionError(method.name());
            }
            long end = System.currentTimeMillis();
            long seconds= (end-start);
            
       
            List<Object> infoThread = List.of(Thread.activeCount(), ConvertMilliSecondsToFormattedDate(start), ConvertMilliSecondsToFormattedDate(end), seconds); 
            List<Object> infoTable = List.of(method, array.length, nombreOperation, seconds, infoThread);
            ss.change(infoTable);
            array = ss.getAvailableInteger();
        }
    }

    public static String ConvertMilliSecondsToFormattedDate(long milliSeconds){
        Date currentDate = new Date(milliSeconds);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss.SSS");
        sdf.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        return sdf.format(currentDate);
    }
    
    

}
