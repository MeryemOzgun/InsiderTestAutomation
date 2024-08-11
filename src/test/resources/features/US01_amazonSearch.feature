
  Feature: US01 Kullanici amazon sayfasinda arama yapabilmeli
@deneme


    Scenario: TC01 kullanici amazonda samsung aratir
      Given kullanici amazon sayfasina gider
      Then anasayfanin acildigini dogrular
      When searchboxta "samsung" kelimesini aratir
      Then acilan sayfada aratilan samsung kelimesi icin sonuc bulundugunu dogrular
      When arama sonuclarindan ikinci sayfaya tiklar
      Then ikinci sayfada oldugunu dogrular
      When ustten besinci satir birinci sutun icerisindeki urune tiklar
      Then urun sayfasinda oldugunu dogrular
      When urunu sepete ekler
      Then sepet sayfasinda oldugunu dogrular
      When logoya tiklayip anasayfaya geri doner
      Then anasayfada oldugunu dogrular
      And sayfayi kapatir