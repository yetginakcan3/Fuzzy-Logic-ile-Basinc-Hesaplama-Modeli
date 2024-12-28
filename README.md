BASINÇ HESAPLAMA MODELİ

 
1. Giriş
Fuzzy Logic (Bulansal Mantık), özellikle doğrusal olmayan ve karmaşık ilişkilerin olduğu durumlarda, geleneksel mantık yöntemlerinin yetersiz kaldığı alanlarda kullanılır. Fiziksel dünya, çoğu zaman belirsizlik ve bulanıklık içerir. Bu tür belirsizliklerin modellenmesi için klasik matematiksel yaklaşımlar yerine fuzzy logic kullanımı yaygınlaşmaktadır. Bu rapor, bir depo içindeki sıcaklık ve hacim parametrelerine dayalı olarak basınç değerini hesaplamak için kullanılan bir fuzzy logic modelinin detaylarını sunmaktadır. Model, BasincHesaplama.fcl dosyasındaki bulanık mantık kurallarına dayanmaktadır. Java programı ise bu modelin uygulama kodlarını içermektedir.
2. Fuzzy Logic Nedir?
Fuzzy logic, geleneksel "doğru" ve "yanlış" arasındaki ikili mantığın ötesine geçerek, ara değerleri de kabul eder. Bu, gerçek dünyadaki karmaşık ve belirsiz verileri modellemek için çok uygundur. Bulanık mantıkta, bir öğe belirli bir kategoriye tam olarak ait olmayabilir. Örneğin, "sıcaklık" terimi, 30°C'yi hem "orta" hem de "yüksek" kategorilerinde bulundurabilir.
3. Modelin Yapısı ve Mantığı
Model, depo içindeki sıcaklık ve hacim değerlerine göre basınç değerini hesaplamak için kullanılan bir fuzzy logic sistemini temsil eder.
Girdi Değişkenleri:
•	Sıcaklık (sicaklik): Depodaki sıcaklık (Celsius cinsinden).
•	Hacim (hacim): Depodaki hacim (m³ cinsinden).
Çıktı Değişkeni:
•	Basınç (basinc): Depodaki basınç değeri (MPa cinsinden).
Bulanıklaştırma (Fuzzification): Girdi değişkenleri olan sıcaklık ve hacim, belirli terimler altında bulanıklaştırılmıştır. Bu terimler belirli aralıklarla temsil edilmektedir:
•	Sıcaklık için "Düşük", "Orta", "Yüksek" terimleri.
•	Hacim için "Küçük", "Orta", "Büyük" terimleri.
Kurallar (Rules): Modelde 9 adet kural bulunmaktadır. Bu kurallar, sıcaklık ve hacim arasındaki ilişkiye göre basınç değerini belirler.
Çıktı Değişkeninin Bulanıklaştırılması (Defuzzification): Çıktı değişkeni olan basınç, COG (Center of Gravity) yöntemi ile bulanıklaştırılmakta ve net bir sayısal değer elde edilmektedir.
4. Girdi Değerlerinin Sınırları
Modelin giriş değerleri olan sıcaklık ve hacim, belirli bir aralıkta kabul edilebilir. Bu sınırların dışındaki değerler modelin doğruluğunu olumsuz etkileyebilir. Aşağıda, girdi değişkenlerinin kabul edilen sınırları ve bu sınırların mantıklı açıklamaları verilmiştir:
•	Sıcaklık (Sicaklik):
o	Düşük: -20°C ile 20°C arası.
o	Orta: 20°C ile 80°C arası.
o	Yüksek: 60°C ile 100°C arası.
Sıcaklık değeri, genellikle depolama ortamlarında 0°C ile 100°C arasında değişir. 0°C altındaki sıcaklıklar genellikle donma riski oluşturabilir ve modelde belirtilen sınırlarla uyumludur.
•	Hacim (Hacim):
o	Küçük: 0 m³ ile 10 m³ arası.
o	Orta: 10 m³ ile 40 m³ arası.
o	Büyük: 30 m³ ile 50 m³ arası.
Depo hacmi, depolama alanının büyüklüğüne göre değişir. Küçük hacimler, genellikle 0-10 m³ arasındadır, orta hacimler 10-40 m³ arasında yer alırken, büyük hacimler 30 m³ üzerinde kabul edilir.
5. Modelin Mantığı
Model, sıcaklık ve hacim arasındaki ilişkiye göre basınç hesaplamaktadır. Bulanık mantık kuralları, bu iki girdi arasındaki ilişkileri tanımlar ve farklı kombinasyonlara göre çıkan sonucu belirler. Örneğin:
•	Düşük sıcaklık ve Küçük hacim olduğunda, basınç "Düşük" olarak belirlenir.
•	Yüksek sıcaklık ve Büyük hacim olduğunda, basınç "Yüksek" olarak belirlenir.

7. Defuzzification Yöntemi: COG (Center of Gravity)
Defuzzification, fuzzy logic'in çıktısını net bir sayısal değere dönüştürme işlemidir. Bu projede, COG yöntemi kullanılmıştır. COG, çıktının bulanık değeri ile ilgili tüm terimlerin ağırlıklı ortalamasını alarak kesin bir sonuç elde etmeye çalışır. COG, aşağıdaki şekilde hesaplanır:
COG=∑(μ(x)⋅x)∑μ(x)\text{COG} = \frac{\sum (\mu(x) \cdot x)}{\sum \mu(x)}COG=∑μ(x)∑(μ(x)⋅x)
Burada:
•	μ(x)\mu(x)μ(x) terimin üyelik fonksiyonudur.
•	xxx teriminin değeridir.
Bu formül, çıktı değerini belirlemek için tüm terimlerin üyelik derecelerine göre bir ağırlıklı ortalama alır.
8. Örnek Girdi ve Çıktı Hesaplaması
Örnek olarak, sıcaklık 30°C ve hacim 15 m³ verildiğinde, model şu şekilde çalışacaktır:
•	Sıcaklık 30°C olduğu için, bu değer "Orta" kategorisinde yer alır.
•	Hacim 15 m³ olduğu için, bu değer "Orta" kategorisinde yer alır.
Bu iki girdi kombinasyonuna göre, ilgili bulanık kural seti çalıştırılır ve basınç değeri hesaplanır. COG yöntemi ile sonuç, 1 MPa civarında bir değere ulaşacaktır.
9. Alternatif Durulama Yöntemlerinin Değerlendirilmesi
Modelde kullanılan durulama yöntemi COG'dur. Ancak, diğer durulama yöntemleri de test edilebilir. Aşağıda iki alternatif durulama yöntemi açıklanmıştır:
•	COG (Center of Gravity): Bu yöntem, her terim için üyelik fonksiyonlarının ağırlıklı ortalamasını alarak sonucu belirler.
•	COA (Center of Area): Bu yöntem, her terimin alanını ve üyelik derecelerini dikkate alır.
•	Mean of Maximum (MOM): Bu yöntem, maksimum üyelik değerlerine sahip olan çıktılar arasında ortalama alır.
Her bir yöntem için sonuçların karşılaştırılması ve yorumlanması önemlidir. Örneğin, COG genellikle daha hassas sonuçlar verirken, MOM daha kaba sonuçlar verebilir.
10. Sonuç ve Yorumlar
Bu proje, fuzzy logic kullanılarak basınç hesaplamayı amaçlayan bir model geliştirmektedir. Model, sıcaklık ve hacim parametrelerine dayalı olarak doğru bir şekilde basınç tahmini yapabilmektedir. COG yöntemi ile elde edilen sonuçlar, fiziksel dünyadaki gerçek değerlerle uyumludur.
Alternatif durulama yöntemleri de denendiğinde, COG'nin daha doğru ve hassas sonuçlar verdiği görülmüştür. Bu model, depolama alanlarında sıcaklık ve hacim gibi değişkenlere dayalı olarak basınç hesaplamaları yapmak için oldukça kullanışlıdır.












