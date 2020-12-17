package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;


public class D15_FilePath extends TestBase {

    @Test
    public void test(){

        System.out.println(System.getProperty("user.dir"));
        // icinde oldugumuz klasorun yolunu (path) verir

        String anaPath = System.getProperty("user.home");
        // hangi bilgisayarda isek o bilgisayarin ana path'ini verir
        //C:\Users\Casper

        String masaustuPath = anaPath + "\\Desktop";
        System.out.println("desktop yolu : " + masaustuPath);

        }
    @Test
    public void isExist(){
        //C:\Users\Casper\Desktop\FLOWER.jpg
        //1.adim bilgisayarimizin home path'ini buluyoruz
        String homePath=System.getProperty("user.home");
        System.out.println(homePath);

        // 2.adim home Path'in devamina dosya yolunu olusturacak sekilde ek yapiyoruz
        // ONEMLI : dosya adindan sonra uzantinin da yazilmasi gerekir

        String filePath = homePath+ "\\Desktop\\FLOWER.jpg";
        // masaustunde FLOWER.jpg dosyasinin var oldugunu test edin

        boolean dosyaVarMi = Files.exists(Paths.get(filePath));
        System.out.println(dosyaVarMi);//true
    }
}
