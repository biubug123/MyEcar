package com.ecar.util;

/**
 * Created by huangpeiquan on 17/6/28.
 */
public class VinValidate {
    public static boolean validate(String vinStart, String vinEnd, String vin) {
        String myvin = vin;

        String s1 = vinStart.substring(9);
        System.out.println("s1"+ s1);
        String sYear = s1.substring(0,1);
        System.out.println("year"+ sYear+"  ");
        String sFactory = s1.substring(1,2);
        System.out.println("factory:  "  + sFactory+"  ");
        String sNum = s1.substring(2);
        System.out.println("sNum" + sNum+"   ");

        String e1 = vinEnd.substring(9);
        System.out.println("e1" + e1+"   ");
        String eYear = e1.substring(0,1);
        System.out.println("eYear" + eYear+"   ");
        String eFactory = e1.substring(1,2);
        System.out.println("eFactory" + eFactory+"   ");
        String eNum = e1.substring(2);
        System.out.println("eNum" + eNum+"   ");

        String m1 = myvin.substring(9);
        System.out.println("m1" + m1+"   ");
        String mYear = m1.substring(0,1);
        System.out.println("mYear" + mYear+"   ");
        String mFactory = m1.substring(1,2);
        System.out.println("mFactory" + mFactory+"   ");
        String mNum = m1.substring(2);
        System.out.println("mNum" + mNum+"   ");
        System.out.println(mFactory+"###"+sFactory);
        if((mYear.compareTo(sYear)>=0&&mYear.compareTo(eYear)<=0)&&mFactory.equals(sFactory)){
            if(Integer.parseInt(mNum)>=Integer.parseInt(sNum)&&Integer.parseInt(mNum)<=Integer.parseInt(eNum)){
                return true;
            }
        }
        return false;
    }
}
