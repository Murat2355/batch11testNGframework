package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        //Java ile dosya okuyabilmek icin FileInputStream kullaniyoruz
        //Ancak bunun icin okunacak dosyanin yoluna(path)ihtiyacimiz var.
        //okunacak dosya yolunu bulup String path degiskenine atiyoruz.


        String path = "src/test/java/resources/ulkeler.xlsx";
        // dosyamiz javaya aktarabilmek icin FileInputStream kullanip parametre olarak path'i giriyoruz.
        FileInputStream fileInputStream = new FileInputStream(path);
        //Excel'de data ya ulasmak icin cell(hucre)'ye ulasmamiz gerekiyor.
        //Bunun icin sirayla workbook olusturup parametre olarak fileInputStream objesini giriyoruz.
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //workbook dan sonra ilgili sayfaya gitmek icin Sheet objesini olusturuyoruz.
        Sheet sheet = workbook.getSheetAt(0);
        //Ilgili satira gitmek icin Row objesi olusturuyoruz.
        Row row = sheet.getRow(0);
        //Hucre'ye gitmek icin Cell objesi olusturuyoruz.
        Cell cell = row.getCell(0);
        //Ulastiogimiz data Cell objesi formatindayiz. yazdirmak istedigimizde yazdirabiliriz ancak manuple edemeyiz.
        //data uzerinde assert veya manipulasyon yapmak istiyorsak once datayi toString() methodu ile Stringe ceviririz.


        System.out.println(cell);

        String hucre = cell.toString();//burda string e cevirdik
        System.out.println(hucre);
    }

    @Test
    public void readExcel2() throws IOException {
        //1.satir 2. hucreyi yazdiriniz...
        String path = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
       // workbook.getSheetAt(0).getRow(1).getCell(2);
        // //1.satir 2. hucreyi yazdiriniz.
        System.out.println(workbook.getSheetAt(0).getRow(0).getCell(1));

        //bu hucreyi String degiskene atayip yazdiralim
        String birinciSatirIkinciHucre = workbook.getSheetAt(0).getRow(0).getCell(1).toString();
        System.out.println(birinciSatirIkinciHucre);

        //-2.satir 4. hucrenin afghanistanin baskenti oldugunu test ediniz.
        String ikinciSatirDorduncuHucre = workbook.getSheetAt(0).getRow(1).getCell(3).toString().toLowerCase();
        Assert.assertEquals(ikinciSatirDorduncuHucre,"kabil");

        //Satir sayisini bulunuz.
        System.out.println(workbook.getSheetAt(0).getLastRowNum());

        //Fiziki olarak kullanilan satir sayisini bulunuz.burda index degil sayma sayilari kullanilir yani 1'den baslar
        System.out.println("son satir numarasi: " + workbook.getSheetAt(1).getLastRowNum());//index 0'dan basladigi icin bir eksik yazar
        System.out.println("fiziki kullanilan satir sayisi : " + workbook.getSheetAt(1).getPhysicalNumberOfRows());

        // -ingilizce ulke isimleri ve ingilizce baskent isimlerini map olarak  kaydedelim
        //-her bir ulke icin / her satir icin
        //-0. index ulke adi 1. index baskent adi

        String ulkeAdi="";
        String baskentAdi="";
        Map<String,String> baskentler = new HashMap<>();
        for (int i = 1; i<=workbook.getSheetAt(0).getLastRowNum();i++){
            ulkeAdi = workbook.getSheetAt(0).getRow(i).getCell(0).toString();
            baskentAdi= workbook.getSheetAt(0).getRow(i).getCell(1).toString();
            baskentler.put(ulkeAdi,baskentAdi);
        }
        System.out.println(baskentler);
        // 1=Afghanistan,Kabul,Afganistan,Kabil
    }
}
