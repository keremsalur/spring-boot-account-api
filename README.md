# Account Api
Bu api Java Spring Boot ile geliştirilmiştir.

Bu api veritabanında müşteriler olduğunu varsayarak bu müşteriler için hesap oluşturur ve bu hesaba başlangıç için belirtilen miktarda bir para transferi işlemi gerçekleştirir.

Api da in-memory veritabanı olarak H2 kullanılmıştır.

Api isteklerinin test edilmesi için projeye Open API eklenmiştir.

Tablolar arası ilişki aşağıdaki gibidir:

![Table Relation](/assets/accountTableRelation.png "Api table relation.")

1. Api test etmek için AccountApplication sınıfında run metodunu override ederek bir test müşterisi oluşturulur.

![Test Customer](/assets/1.png "Test customer.")

2. Api ayağa kaldırılarak [Open API Swagger index sayfası](http://localhost:8080/swagger-ui/index.html#/account-controller/createAccount) açılır.

3. Açılan sayfada account apiye istek yapılarak kullanılır.

Örnek olarak:

1. Müşterinin id bilgisini alın

![Test Customer Id](/assets/2.png "Test customer id.")

2. [Open API Swagger index sayfasını](http://localhost:8080/swagger-ui/index.html#/account-controller/createAccount) açın.

3. Mevcut müşteri idsini kullanarak post isteği ile müşteriye bir account oluşturun. Initial Money alanı ilede açılan hesaba para transferi gerçekleştirilebilir.

![Create Account](/assets/3.png "Create account.")

Oluşturulan hesap post isteğinden 200 kodu ile geri döndürülür.

![Response Account Post Request](/assets/4.png "Response account post request.")

4. Eğer post isteğinde veritabanında olmayan müşteri idsi gönderilirse api 404 hatası ile geri döner.
   
![Customer Not Found Id](/assets/5.png "Customer not found id.")

![Customer Not Found](/assets/10.png "Customer not found.")

5. Eğer post isteği geçersiz parametreler ile gönderilirse api 400 bad request ile döner.

![Bad Request](/assets/6.png "Bad request")

![Bad Request Response](/assets/7.png "Bad request response.")

6. Api customer ile istenirse id bilgisi verilen müşteri bilgileri get isteği ile alınabilir.

![GET Request](/assets/8.png "GET request")

![GET Request Response](/assets/9.png "GET request response.")





